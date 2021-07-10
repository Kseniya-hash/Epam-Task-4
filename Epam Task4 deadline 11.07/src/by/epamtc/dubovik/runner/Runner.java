package by.epamtc.dubovik.runner;

import by.epamtc.dubovik.entity.*;
import by.epamtc.dubovik.service.*;
import by.epamtc.dubovik.service.comparator.*;
import by.epamtc.dubovik.service.filtercondition.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Runner {
	
	public static void main(String[] args) {
		String menu = "Выберите опцию \n"
				+ "1. Загрузить полный список самолетов \n"
				+ "2. Посмотреть текущий список самолетов \n"
				+ "3. Сортировать самолеты по одному параметру\n"
				+ "4. Сортировать самолеты по двум параметрам\n"
				+ "5. Фильтровать самолеты \n"
				+ "6. Найти общую грузоподъемность \n"
				+ "7. Найти общую вместительность";
		String sortMenu = "Выберите параметр для сортировки\n"
				+ "1. Модель\n"
				+ "2. Размер\n"
				+ "3. Скорость\n"
				+ "4. Потребление топлива\n"
				+ "5. Высота полета\n"
				+ "6. Дальность полета";
		
		HashMap<Integer, Comparator> sortOptions = new HashMap<>();
		sortOptions.put(1, new ModelComparator());
		sortOptions.put(2, new SizeComparator());
		sortOptions.put(3, new SpeedComparator());
		sortOptions.put(4, new FuelConsumptionComparator());
		sortOptions.put(5, new FlightAltitudeComparator());
		sortOptions.put(6, new FlightRangeComparator());
		
		String filterMenu = "Выберите параметр для фильтрации\n"
				+ "1. Длина самолета\n"
				+ "2. Высота самолета\n"
				+ "3. Размах крыльев\n"
				+ "4. Скорость\n"
				+ "5. Потребление топлива\n"
				+ "6. Высота полета\n"
				+ "7. Дальность полета";
		
		HashMap<Integer, FilterCondition> filterConditions = new HashMap<>();
		filterConditions.put(1, new ByPlaneLength());
		filterConditions.put(2, new ByPlaneHigh());
		filterConditions.put(3, new ByWingspan());
		filterConditions.put(4, new BySpeed());
		filterConditions.put(5, new ByFuelConsumption());
		filterConditions.put(6, new ByFlightAltitude());
		filterConditions.put(7, new ByFlightRange());
		
		List<Plane> currentPlaneList = null;
		Readable read = new Readable();
		PlaneListServiceImpl planeService = new PlaneListServiceImpl();
		while(true) {
			System.out.println(menu);
			int currentOption = ReadFromConsole.readInt();
			HashMap<Integer, Option> options = new HashMap<>();
			
			options.put(1, new Option() {
				public List<Plane> run(List<Plane> planeList) {
					try {
						planeList = planeService.getPlaneList();
						System.out.println("Список всех самолетов");
						System.out.println(read.receiveString(planeList));
					} catch (DataNotFoundException e) {
						System.out.println("Данные не найдены");
					}
					
					return planeList;
				}
			});
			
			options.put(2, new Option() {
				public List<Plane> run(List<Plane> planeList){
					if(planeList != null) {
						System.out.println(read.receiveString(planeList));
					} else {
						System.out.println("Список пустой");
					}
					return planeList;
				}
			});
				
			options.put(3, new Option() {
				public List<Plane> run(List<Plane> planeList) {
					System.out.println(sortMenu);
					int sortOption = ReadFromConsole.readInt();
					if(sortOptions.containsKey(sortOption)) {
						Comparator compareBy = sortOptions.get(sortOption);
						Service.sort(planeList, compareBy);
						System.out.println(read.receiveString(planeList));
					}
					return planeList;
				}
			});
			
			options.put(4, new Option() {
				public List<Plane> run(List<Plane> planeList) {
					System.out.println(sortMenu);
					System.out.println("Первый параметр:");
					int firstOption = ReadFromConsole.readInt();
					System.out.println("Второй параметр:");
					int secondOption = ReadFromConsole.readInt();
					if(sortOptions.containsKey(firstOption) && sortOptions.containsKey(secondOption)) {
						Comparator firstCompareBy = sortOptions.get(firstOption);
						Comparator secondCompareBy = sortOptions.get(secondOption);
						Service.sort(planeList, firstCompareBy, secondCompareBy);
						System.out.println(read.receiveString(planeList));
					}
					return planeList;
				}
			});
				
			options.put(5, new Option() {
				public List<Plane> run(List<Plane> planeList){
					System.out.println(filterMenu);
					int filterOption = ReadFromConsole.readInt();
					if(filterConditions.containsKey(filterOption)) {
						System.out.println("От:");
						double lowerBorder = ReadFromConsole.readDouble();
						System.out.println("До:");
						double higherBorder = ReadFromConsole.readDouble();
						planeList = Service.filter(planeList, lowerBorder, higherBorder, filterConditions.get(filterOption));
						System.out.println(read.receiveString(planeList));
					}
					return planeList;
				}
			});
				
			options.put(6, new Option() {
				public List<Plane> run(List<Plane> planeList)
				{
					System.out.println(Service.findCarryingCapacity(planeList));
					return planeList;
				}
			});
				
			options.put(7, new Option() {
				public List<Plane> run(List<Plane> planeList)
				{
					System.out.println(Service.findVolume(planeList));
					return planeList;
				}
			});
				
			currentPlaneList = options.get(currentOption).run(currentPlaneList);
		}
	}
}

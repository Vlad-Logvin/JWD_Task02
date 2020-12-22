package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Laptop.OS;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.TabletPC.Color;
import by.tc.task01.entity.VacuumCleaner.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.store.ConcreteStore;
import by.tc.task01.service.store.Store;

public class ApplianceDAOImpl implements ApplianceDAO {
	public static final String _EQUAL = "=";
	public static final String _COMMA = ",";
	public static final String _COLON = ":";
	public static final String _SPACE = " ";
	public static final String _DOUBLE_SPACE = "  ";
	public static final String _HYPHEN = "-";
	public static final String _EMPTINESS = "";

	public List<Appliance> find(Criteria criteria) throws IOException {

		ApplianceReader applianceReader = new ApplianceReader();
		List<String> applianceData = applianceReader.takeAll();

		ApplianceSearchFilter aps = new ApplianceSearchFilter(applianceData);
		List<String> filtredApplianceData = aps.filter(criteria);

		ApplianceBuilder appBuilder = new ApplianceBuilder(new ConcreteStore());
		List<Appliance> appliances = appBuilder.build(new ApplianceDataParser(filtredApplianceData));

		return appliances;
	}

	// you may add your own code here

}

class ApplianceReader {

	private static final String _APPLIANCE_DB_FILEPATH = "D:\\Java\\Java epam\\programs\\jwd-task01-template_v2\\src\\main\\java\\by\\tc\\task01\\dao\\impl\\appliances_db.txt";

	public List<String> takeAll() throws IOException {
		FileReader fileReader = new FileReader(_APPLIANCE_DB_FILEPATH);
				//new FileReader("D:\\Java\\Java epam\\programs\\jwd-task01-template_v2\\src\\main\\java\\by\\tc\\task01\\dao\\impl\\appliances_db.txt");
				//new FileReader("Objects.requireNonNull(getClass().getClassLoader().getResourse("appliances_db.txt")).getFile());
				//не получилось у меня пройти мимо src
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> fileAppliance = new ArrayList<>();
		while (bufferedReader.ready()) {
			fileAppliance.add(getReadyInformation(bufferedReader.readLine()));
		}
		return fileAppliance;
	}

	private String getReadyInformation(String info) {
		if (info.equals(ApplianceDAOImpl._EMPTINESS)) {
			return null;
		}
		info = info.replace(ApplianceDAOImpl._EQUAL, ApplianceDAOImpl._SPACE);
		info = info.replace(ApplianceDAOImpl._COMMA, ApplianceDAOImpl._EMPTINESS);
		info = info.replace(ApplianceDAOImpl._COLON, ApplianceDAOImpl._EMPTINESS);
		info = info.replace(ApplianceDAOImpl._DOUBLE_SPACE, ApplianceDAOImpl._SPACE);
		return info;
	}

}

class ApplianceSearchFilter {

	List<String> applianceData = new ArrayList<>();

	public ApplianceSearchFilter(List<String> applianceData) {
		this.applianceData = applianceData;
	}

	public List<String> filter(Criteria criteria) {
		List<String> filtredApplianceData = new ArrayList<>();
		for (int i = 0; i < applianceData.size(); i++) {
			if (applianceData.get(i) != null) {
				if (isFitsToCriteria(applianceData.get(i).split(ApplianceDAOImpl._SPACE), criteria)) {
					filtredApplianceData.add(applianceData.get(i));
				}
			}
		}
		return filtredApplianceData;
	}

	private boolean isFitsToCriteria(String[] splitApplianceInfo, Criteria criteria) {
		String appliance = criteria.getGroupSearchName();
		Map<String, Object> criteriaMap = criteria.getCriteriaMap();
		boolean isSuit = true;
		if (appliance.equals(splitApplianceInfo[0])) {
			for (int j = 1; j < splitApplianceInfo.length; j += 2) {
				if (criteriaMap.get(splitApplianceInfo[j]) != null
						&& !splitApplianceInfo[j + 1].equals(criteriaMap.get(splitApplianceInfo[j]).toString())) {
					isSuit = false;
				}
			}
		} else {
			isSuit = false;
		}
		return isSuit;
	}

}

class ApplianceBuilder {
	Store store;

	public ApplianceBuilder(Store store) {
		this.store = store;
	}

	public List<Appliance> build(ApplianceDataParser applianceDataParser) {
		return store.order(applianceDataParser.getApplianceNameList(), applianceDataParser.getApplianceFieldsList());
	}

}

class ApplianceDataParser {

	private List<Map<String, Object>> applianceFields = new ArrayList<Map<String, Object>>();
	private List<String> applianceName = new ArrayList<>();

	public List<String> getApplianceNameList() {
		return applianceName;
	}

	public List<Map<String, Object>> getApplianceFieldsList() {
		return applianceFields;
	}

	public ApplianceDataParser(List<String> filtredApplianceData) throws NumberFormatException {
		for (int i = 0; i < filtredApplianceData.size(); i++) {
			String[] splitApplianceInfo = filtredApplianceData.get(i).split(ApplianceDAOImpl._SPACE);
			switch (splitApplianceInfo[0]) {
			case Laptop._LAPTOP:
				applianceName.add(Laptop._LAPTOP);
				applianceFields.add(new HashMap<String, Object>());
				applianceFields.get(i).put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(),
						Double.parseDouble(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.Laptop.OS.toString(), OS.valueOf(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.Laptop.MEMORY_ROM.toString(),
						Integer.parseInt(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(),
						Integer.parseInt(splitApplianceInfo[6]));
				applianceFields.get(i).put(SearchCriteria.Laptop.CPU.toString(),
						Double.parseDouble(splitApplianceInfo[8]));
				applianceFields.get(i).put(SearchCriteria.Laptop.DISPLAY_INCHS.toString(),
						Integer.parseInt(splitApplianceInfo[10]));
				break;
			case Oven._OVEN:
				applianceName.add(Oven._OVEN);
				applianceFields.add(new HashMap<String, Object>());
				applianceFields.get(i).put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(),
						Integer.parseInt(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.Oven.WEIGHT.toString(),
						Double.parseDouble(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.Oven.CAPACITY.toString(),
						Double.parseDouble(splitApplianceInfo[6]));
				applianceFields.get(i).put(SearchCriteria.Oven.DEPTH.toString(),
						Double.parseDouble(splitApplianceInfo[8]));
				applianceFields.get(i).put(SearchCriteria.Oven.HEIGHT.toString(),
						Double.parseDouble(splitApplianceInfo[10]));
				applianceFields.get(i).put(SearchCriteria.Oven.WIDTH.toString(),
						Double.parseDouble(splitApplianceInfo[12]));
				break;
			case Refrigerator._REFRIGERATOR:
				applianceName.add(Refrigerator._REFRIGERATOR);
				applianceFields.add(new HashMap<String, Object>());
				applianceFields.get(i).put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(),
						Integer.parseInt(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.Refrigerator.WEIGHT.toString(),
						Double.parseDouble(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(),
						Double.parseDouble(splitApplianceInfo[6]));
				applianceFields.get(i).put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(),
						Double.parseDouble(splitApplianceInfo[8]));
				applianceFields.get(i).put(SearchCriteria.Refrigerator.HEIGHT.toString(),
						Double.parseDouble(splitApplianceInfo[10]));
				applianceFields.get(i).put(SearchCriteria.Refrigerator.WIDTH.toString(),
						Double.parseDouble(splitApplianceInfo[12]));
				break;
			case Speakers._SPEAKERS:
				applianceName.add(Speakers._SPEAKERS);
				applianceFields.add(new HashMap<String, Object>());
				String[] frequencyRange = splitApplianceInfo[6].split("-");
				applianceFields.get(i).put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(),
						Integer.parseInt(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(),
						Integer.parseInt(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), (new Double[] {
						Double.parseDouble(frequencyRange[0]), Double.parseDouble(frequencyRange[1]) }));
				applianceFields.get(i).put(SearchCriteria.Speakers.CORD_LENGTH.toString(),
						Integer.parseInt(splitApplianceInfo[8]));
				break;
			case TabletPC._TABLET_PC:
				applianceName.add(TabletPC._TABLET_PC);
				applianceFields.add(new HashMap<String, Object>());
				applianceFields.get(i).put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(),
						Integer.parseInt(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(),
						Integer.parseInt(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.TabletPC.MEMORY_ROM.toString(),
						Integer.parseInt(splitApplianceInfo[6]));
				applianceFields.get(i).put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(),
						Integer.parseInt(splitApplianceInfo[8]));
				applianceFields.get(i).put(SearchCriteria.TabletPC.COLOR.toString(),
						Color.valueOf(splitApplianceInfo[10]));
				break;
			case VacuumCleaner._VACUUM_CLEANER:
				applianceName.add(VacuumCleaner._VACUUM_CLEANER);
				applianceFields.add(new HashMap<String, Object>());
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(),
						Integer.parseInt(splitApplianceInfo[2]));
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(),
						FilterType.valueOf(splitApplianceInfo[4]));
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(),
						BagType.valueOf(splitApplianceInfo[6]));
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(),
						WandType.valueOf(splitApplianceInfo[8]));
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(),
						Integer.parseInt(splitApplianceInfo[10]));
				applianceFields.get(i).put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(),
						Double.parseDouble(splitApplianceInfo[12]));
				break;
			}
		}
	}

}

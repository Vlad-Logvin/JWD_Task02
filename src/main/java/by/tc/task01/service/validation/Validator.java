package by.tc.task01.service.validation;

import java.util.Map;

import by.tc.task01.dao.impl.ApplianceDAOImpl;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

public class Validator {
	private static final double _MIN_DOUBLE_VALUE = 0.0;
	private static final int _MIN_INTEGER_VALUE = 0;
	private static final double _DOUBLE_100 = 100.0;
	private static final int _INTEGER_100 = 100;
	private static final double _DOUBLE_1000 = 1000.0;
	private static final int _INTEGER_10000 = 10000;
	private static final double _DOUBLE_10000 = 10000.0;
	private static final int _INTEGER_100000 = 100000;
	private static final double _DOUBLE_2000 = 2000.0;
	private static final int _INTEGER_17 = 17;
	private static final int _INTEGER_10 = 10;
	private static final int _INTEGER_20 = 20;
	private static final int _INTEGER_24000 = 24000;
	private static final double _DOUBLE_39_72 = 39.72;
	private static final double _DOUBLE_10 = 10;
	private static final double _DOUBLE_500 = 500;

	public static boolean criteriaValidator(Criteria criteria) {
		switch (criteria.getGroupSearchName()) {
		case "Laptop":
			return isCorrectLaptopData(criteria.getCriteriaMap());
		case "Oven":
			return isCorrectOvenData(criteria.getCriteriaMap());
		case "Refrigerator":
			return isCorrectRefrigeratorData(criteria.getCriteriaMap());
		case "Speakers":
			return isCorrectSpeakersData(criteria.getCriteriaMap());
		case "TabletPC":
			return isCorrectTabletPCData(criteria.getCriteriaMap());
		case "VacuumCleaner":
			return isCorrectVacuumCleanerData(criteria.getCriteriaMap());
		default:
			return false;
		}
	}

	private static boolean isCorrectVacuumCleanerData(Map<String, Object> criteriaMap) {
		if (criteriaMap.containsKey(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
			if (Double
					.parseDouble(criteriaMap.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())
							.toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(criteriaMap.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())
							.toString()) < _DOUBLE_100) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())
							.toString()) < _INTEGER_10000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())
							.toString()) < _INTEGER_10000) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrectTabletPCData(Map<String, Object> criteriaMap) {
		if (criteriaMap.containsKey(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())
							.toString()) < _INTEGER_10000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())
							.toString()) < _INTEGER_10) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())
							.toString()) < _INTEGER_100) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.TabletPC.MEMORY_ROM.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.TabletPC.MEMORY_ROM.toString())
							.toString()) < _INTEGER_24000) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrectSpeakersData(Map<String, Object> criteriaMap) {
		if (criteriaMap.containsKey(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())
							.toString()) < _INTEGER_100) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
			String[] boundaries = criteriaMap.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()).toString()
					.split(ApplianceDAOImpl._HYPHEN);
			if (Double.parseDouble(boundaries[0]) > _MIN_DOUBLE_VALUE && Double.parseDouble(boundaries[0]) < _DOUBLE_10
					&& Double.parseDouble(boundaries[1]) > _MIN_DOUBLE_VALUE
					&& Double.parseDouble(boundaries[1]) < _DOUBLE_10
					&& Double.parseDouble(boundaries[0]) < Double.parseDouble(boundaries[1])) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())
							.toString()) < _INTEGER_10) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(
							criteriaMap.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString()) < _INTEGER_20) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrectRefrigeratorData(Map<String, Object> criteriaMap) {

		if (criteriaMap.containsKey(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
			if (Double
					.parseDouble(criteriaMap.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())
							.toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(criteriaMap.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())
							.toString()) < _DOUBLE_500) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
			if (Double
					.parseDouble(criteriaMap.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())
							.toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(criteriaMap.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())
							.toString()) < _DOUBLE_100) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Refrigerator.HEIGHT.toString())) {
			if (Double.parseDouble(
					criteriaMap.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString()) < _DOUBLE_2000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
			if (Integer
					.parseInt(criteriaMap.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())
							.toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())
							.toString()) < _INTEGER_10000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Refrigerator.WEIGHT.toString())) {
			if (Double.parseDouble(
					criteriaMap.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString()) < _DOUBLE_2000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Refrigerator.WIDTH.toString())) {
			if (Double.parseDouble(
					criteriaMap.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString()) < _DOUBLE_2000) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrectOvenData(Map<String, Object> criteriaMap) {

		if (criteriaMap.containsKey(SearchCriteria.Oven.CAPACITY.toString())) {
			if (Double.parseDouble(
					criteriaMap.get(SearchCriteria.Oven.CAPACITY.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Oven.CAPACITY.toString()).toString()) < _DOUBLE_100) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Oven.DEPTH.toString())) {
			if (Double.parseDouble(criteriaMap.get(SearchCriteria.Oven.DEPTH.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Oven.DEPTH.toString()).toString()) < _DOUBLE_1000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Oven.HEIGHT.toString())) {
			if (Double
					.parseDouble(criteriaMap.get(SearchCriteria.Oven.HEIGHT.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Oven.HEIGHT.toString()).toString()) < _DOUBLE_1000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())
							.toString()) < _INTEGER_10000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Oven.WEIGHT.toString())) {
			if (Double
					.parseDouble(criteriaMap.get(SearchCriteria.Oven.WEIGHT.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Oven.WEIGHT.toString()).toString()) < _DOUBLE_1000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Oven.WIDTH.toString())) {
			if (Double.parseDouble(criteriaMap.get(SearchCriteria.Oven.WIDTH.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Oven.WIDTH.toString()).toString()) < _DOUBLE_1000) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrectLaptopData(Map<String, Object> criteriaMap) {

		if (criteriaMap.containsKey(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())) {
			if (Double.parseDouble(
					criteriaMap.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(criteriaMap.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())
							.toString()) < _DOUBLE_10000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Laptop.MEMORY_ROM.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(
							criteriaMap.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString()) < _INTEGER_24000) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Laptop.CPU.toString())) {
			if (Double.parseDouble(criteriaMap.get(SearchCriteria.Laptop.CPU.toString()).toString()) > _MIN_DOUBLE_VALUE
					|| Double.parseDouble(
							criteriaMap.get(SearchCriteria.Laptop.CPU.toString()).toString()) < _DOUBLE_39_72) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Laptop.DISPLAY_INCHS.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(
							criteriaMap.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()).toString()) < _INTEGER_17) {
				return true;
			}
		} else if (criteriaMap.containsKey(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())) {
			if (Integer.parseInt(
					criteriaMap.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()).toString()) > _MIN_INTEGER_VALUE
					|| Integer.parseInt(criteriaMap.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())
							.toString()) < _INTEGER_100000) {
				return true;
			}
		}
		return false;
	}

}

//you may add your own new classes
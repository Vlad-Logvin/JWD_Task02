package by.tc.task01.service.store;

import java.util.Map;

import by.tc.task01.entity.*;
import by.tc.task01.entity.Laptop.OS;
import by.tc.task01.entity.TabletPC.Color;
import by.tc.task01.entity.VacuumCleaner.*;
import by.tc.task01.entity.criteria.SearchCriteria;

public class ConcreteStore extends Store {

	@Override
	protected Appliance build(String type, Map<String, Object> requirements) {
		switch (type) {
		case Laptop._LAPTOP:
			return new Laptop(
					(double) requirements.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()),
					(OS) requirements.get(SearchCriteria.Laptop.OS.toString()),
					(int) requirements.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()),
					(int) requirements.get(SearchCriteria.Laptop.MEMORY_ROM.toString()),
					(double) requirements.get(SearchCriteria.Laptop.CPU.toString()),
					(int) requirements.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()));
		case Oven._OVEN:
			return new Oven(
					(int) requirements.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()),
					(double) requirements.get(SearchCriteria.Oven.WEIGHT.toString()),
					(double) requirements.get(SearchCriteria.Oven.CAPACITY.toString()),
					(double) requirements.get(SearchCriteria.Oven.DEPTH.toString()),
					(double) requirements.get(SearchCriteria.Oven.HEIGHT.toString()),
					(double) requirements.get(SearchCriteria.Oven.WIDTH.toString()));
		case Refrigerator._REFRIGERATOR:
			return new Refrigerator(
					(int) requirements.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()),
					(double) requirements.get(SearchCriteria.Refrigerator.WEIGHT.toString()),
					(double) requirements.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()),
					(double) requirements.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()),
					(double) requirements.get(SearchCriteria.Refrigerator.HEIGHT.toString()),
					(double) requirements.get(SearchCriteria.Refrigerator.WIDTH.toString()));
		case Speakers._SPEAKERS:
			return new Speakers(
					(int) requirements.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()),
					(int) requirements.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()),
					(Double[]) requirements.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()),
					(int) requirements.get(SearchCriteria.Speakers.CORD_LENGTH.toString()));
		case TabletPC._TABLET_PC:
			return new TabletPC(
					(int) requirements.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()),
					(int) requirements.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()),
					(int) requirements.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()),
					(int) requirements.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()),
					(Color) requirements.get(SearchCriteria.TabletPC.COLOR.toString()));
		case VacuumCleaner._VACUUM_CLEANER:
			return new VacuumCleaner(
					(int) requirements.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()),
					(FilterType) requirements.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()),
					(BagType) requirements.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString()),
					(WandType) requirements.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()),
					(int) requirements.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()),
					(double) requirements.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()));
		default:
			return null;
		}
	}
}

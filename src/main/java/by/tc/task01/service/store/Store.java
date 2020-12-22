package by.tc.task01.service.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.tc.task01.entity.Appliance;

public abstract class Store {
	public List<Appliance> order(List<String> type, List<Map<String, Object>> requirements) {
		List<Appliance> appliances = new ArrayList<>();
		for (int i = 0; i < type.size(); i++) {
			appliances.add(build(type.get(i), requirements.get(i)));
		}
		return appliances;
	}

	protected abstract Appliance build(String type, Map<String, Object> requirements);
}

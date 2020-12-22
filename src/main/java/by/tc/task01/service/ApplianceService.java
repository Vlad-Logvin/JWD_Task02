package by.tc.task01.service;

import java.io.IOException;
import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public interface ApplianceService {

	List<Appliance> find(Criteria criteria) throws IOException;

}

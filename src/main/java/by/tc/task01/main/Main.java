package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());// "Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 33);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaSpeakers = new Criteria(Speakers.class.getSimpleName());
		criteriaSpeakers.add(Speakers.FREQUENCY_RANGE.toString(), "0-5");
		//criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		appliance = service.find(criteriaSpeakers);// find(Object...obj)

		PrintApplianceInfo.print(appliance);

	}

}

package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	private static final String _SEARCH_ENDED = "Search ended";
	private static final String _NOT_FOUNDED = "Not founded";

	public static void print(List<Appliance> appliance) {
		if (appliance != null) {
			for (int i = 0; i < appliance.size(); i++) {
				System.out.println(appliance.get(i).toString());
			}
			System.out.println(_SEARCH_ENDED);
			System.out.println();
		} else {
			System.out.println(_NOT_FOUNDED);
		}
	}

	// you may add your own code here

}

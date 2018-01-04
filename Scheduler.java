package sched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abhayabasnet
 */
public class Scheduler extends Employee {

	// not sure which one to use yet
	ArrayList<Employee> empList = new ArrayList<Employee>();
	Map<Employee, String> empMap = new HashMap<>();

	// map for each hour of the day and who is working at that time
	// probably will have to use a 24 hour clock, seeing as same number
	// could clash
	// could also use separate maps for am and pm
	Map<Integer, ArrayList<Employee>> wrkMap = new HashMap<>();

	// get employees that are available between given hours
	Employee getEmps(int from, int to) {

		return null;
	}

	// assign employee to given hours
	// make sure to check for unavailable
	void assignEmp(Employee e, int from, int to) {

	}

	// show which employees are working at given hours
	// probably will have to make a map with hours as keys
	// and employees as the values
	String showWorking(int from, int to, String f, String t) {

		if (f.equals(t)) {
			// if the two given times are both in the AM
			if (f.equals("AM")) {
				// arraylist of arraylist of employees
				// populated with lists of employees working at each given hour
				// since its in the morning, we can just use 0-12 for time
				ArrayList<ArrayList<Employee>> amWrk = new ArrayList<>();

				for (int i = from; i < to + 1; i++) {
					amWrk.add(wrkMap.get(i));
				}
				ArrayList<String> names = new ArrayList<>();

				for (int j = 0; j < amWrk.size(); j++) {
					for (int k = 0; k < amWrk.get(j).size(); k++) {
						if (!names.contains(amWrk.get(j).get(k).getName())) {
							names.add(amWrk.get(j).get(k).getName());
						}
					}
				}
				String nameStr = String.join(", ", names);
				return "The people working rom" + from + " am to " + to + " am are " + nameStr;

				// if the given two times are both in the PM
			} else if (f.equals("PM")) {
				ArrayList<ArrayList<Employee>> pmWrk = new ArrayList<>();
				// 24 hour clock so add 12 to each value to account for that
				for (int i = from + 12; i < to + 12 + 1; i++) {
					pmWrk.add(wrkMap.get(i));
				}

				ArrayList<String> names = new ArrayList<>();
				for (int j = 0; j < pmWrk.size(); j++) {
					for (int k = 0; k < pmWrk.get(j).size(); k++) {
						if (!names.contains(pmWrk.get(j).get(k).getName())) {
							names.add(pmWrk.get(j).get(k).getName());
						}
					}
				}
				String nameStr = String.join(", ", names);
				return "The people working rom" + from + " pm to " + to + " pm are " + nameStr;

			}
			// if the given times are not both am/pm, and are one and the other
			// eg. 9 am to 5 pm
		} else {
			
		}

		return null;
	}

}

package sched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abhayabasnet
 */
public class Scheduler extends Employee {

	// not sure which one to use yet
	// with the check avail function we can use a list, much easier

	ArrayList<Employee> empList = new ArrayList<Employee>();
	Map<Employee, String> empMap = new HashMap<>();

	// map for each hour of the day and who is working at that time
	// probably will have to use a 24 hour clock, seeing as same number
	// could clash
	// could also use separate maps for am and pm
	Map<Integer, ArrayList<Employee>> wrkMap = new HashMap<>();

	// get employees that are available between given hours
	ArrayList<Employee> getEmps(int from, int to, String day, String f, String t) {
		ArrayList<Employee> av = new ArrayList<>();
		for (int i = 0; i < empList.size(); i++) {
			if (checkAvail(empList.get(i), from, f, to, t, day) == true) {
				av.add(empList.get(i));
			}
		}
		return av;
	}

	// boolean function to check if specific employee is available
	// at a certain time
	protected boolean checkAvail(Employee e, int from, String f, int to, String t, String day) {
		if (f.equals(t)) {
			if (!e.availSame.containsKey(day)) {
				return false;
			} else if (e.availSame.containsKey(day)) {
				if (e.availSame.get(day).containsKey(f)) {
					int fr = e.availSame.get(day).get(f).get(0);
					int tro = e.availSame.get(day).get(f).get(1);

					if ((from == fr) && (to == tro)) {
						return true;
					}
				}
			} else if (e.avail.containsKey(day)) {
				int fr = e.avail.get(day).get(f);
				int tro = e.avail.get(day).get(to);

				if ((to == tro) && (from == fr)) {
					return true;
				}
			}
		}
		return false;
	}

	// assign employee to given hours
	// make sure to check for unavailable
	void assignEmp(Employee e, int from, String f, int to, String t, String day) {
		// check if the employee is available
		// if not, possible error message, nothing for now
		if (checkAvail(e, from, f, to, t, day) == true) {
			// if both f and t are the same, (AM to AM or PM to PM)
			if (f.equals(t)) {
				if (f.equals("AM")) {
					for (int i = from; i < to + 1; i++) {
						if (wrkMap.containsKey(i)) {
							wrkMap.get(i).add(e);
						} else {
							ArrayList<Employee> emps = new ArrayList<>();
							emps.add(e);
							wrkMap.put(i, emps);
						}
					}
				} else if (f.equals("PM")) {
					for (int i = from + 12; i < to + 12 + 1; i++) {
						if (wrkMap.containsKey(i)) {
							wrkMap.get(i).add(e);
						} else {
							ArrayList<Employee> emps = new ArrayList<>();
							emps.add(e);
							wrkMap.put(i, emps);
						}
					}
				}
			} else {
				// if times go between am/pm
				if (f.equals("AM") && (t.equals("PM"))) {
					for (int i = from; i < to + 12 + 2; i++) {
						if (wrkMap.containsKey(i)) {
							wrkMap.get(i).add(e);
						} else {
							ArrayList<Employee> emps = new ArrayList<>();
							emps.add(e);
							wrkMap.put(i, emps);
						}
					}
				} else if (f.equals("PM") && (t.equals("AM"))) {
					for (int i = from + 12; i < to; i--) {
						if (wrkMap.containsKey(i)) {
							wrkMap.get(i).add(e);
						} else {
							ArrayList<Employee> emps = new ArrayList<>();
							emps.add(e);
							wrkMap.put(i, emps);
						}
					}
				}
			}
			// employee not available
		} else {

		}

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
			if (f.equals("AM") && t.equals("PM")) {
				ArrayList<ArrayList<Employee>> wrk = new ArrayList<>();

				for (int i = from; i < to + 12 + 1; i++) {
					wrk.add(wrkMap.get(i));
				}

				ArrayList<String> names = new ArrayList<>();

				for (int j = from; j < to + 12 + 1; j++) {
					for (int k = 0; k < wrk.get(j).size(); k++) {
						if (!names.contains(wrk.get(j).get(k).getName())) {
							names.add(wrk.get(j).get(k).getName());
						}
					}
				}
				String nameStr = String.join(", ", names);
				return "The people working rom" + from + f + " to " + to + t + " are " + nameStr;
			} else {
				// this would only be relevant in night shift companies
				// going from pm >> am
				if (f.equals("PM") && t.equals("AM")) {
					ArrayList<ArrayList<Employee>> wrk = new ArrayList<>();

					for (int i = to + 12 + 1; i < from; i--) {
						wrk.add(wrkMap.get(i));
					}

					ArrayList<String> names = new ArrayList<>();

					for (int j = from; j < to + 12 + 1; j++) {
						for (int k = 0; k < wrk.get(j).size(); k++) {
							if (!names.contains(wrk.get(j).get(k).getName())) {
								names.add(wrk.get(j).get(k).getName());
							}
						}
					}
					String nameStr = String.join(", ", names);
					return "The people working rom" + from + f + " to " + to + t + " are " + nameStr;
				}
			}
		}
		return null;
	}
}
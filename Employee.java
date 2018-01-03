package sched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//name, total hours, availability, phone number

public class Employee {
	String name;
	int totalHours;
	String phone;
	// Map<String, int[]> avail = new HashMap<>();
	Map<String, Map<String, Integer>> avail = new HashMap<>();
	Map<String, Map<String, ArrayList<Integer>>> availSame = new HashMap<>();

	// static {
	// avail = new HashMap<String, String>(){{
	// put("Monday", "Not entered");
	// put("Tuesday", "Not entered");
	// put("Wednesday", "Not entered");
	// put("Thursday", "Not entered");
	// put("Friday", "Not entered");
	// put("Saturday", "Not entered");
	// put("Sunday", "Not entered");
	//
	// }};
	// }

	// sets name of the employee
	void setName(String name) {
		this.name = name;
	}

	// return name of employee
	String getName() {
		return this.name;
	}

	// sets the phone number of employee
	void setPhone(String number) {
		this.phone = number;
	}

	// get phone number of the employee
	String getPhone() {
		return this.phone;
	}

	// set the availability of the employee
	// takes in two integers, to and from availabilities
	void setAvail(String day, int from, String f, int to, String t) {

		if (!f.equals(t)) {
			Map<String, Integer> hours = new HashMap<>();
			if (this.avail.containsKey(day)) {
				if (hours.containsKey(f)) {
					hours.replace(f, from);
					hours.replace(t, to);
				} else {
					hours.put(f, from);
					hours.put(t, to);
				}
				this.avail.replace(day, hours);
			} else {
				if (hours.containsKey(f)) {
					hours.replace(f, from);
					hours.replace(t, to);
				} else {
					hours.put(f, from);
					hours.put(t, to);
				}
				this.avail.put(day, hours);
			}
			// if a person is working hours in the morning
			// essentially if f == t (AM == AM)
			// cant use a key value pair b/c it will just replace
			// find another way
		} else {
			Map<String, ArrayList<Integer>> hours = new HashMap<>();

			if (this.avail.containsKey(day)) {

				ArrayList<Integer> hr = new ArrayList<>();
				// adds in order, from and to, to arraylist
				// hr.get(0) == from
				// hr.get(1) == to
				hr.add(from);
				hr.add(to);
				hours.replace(f, hr);

				this.availSame.put(day, hours);
			} else {
				ArrayList<Integer> hr = new ArrayList<>();
				hr.add(from);
				hr.add(to);
				hours.put(f, hr);

				this.availSame.put(day, hours);
			}
		}
	}

	// get availability for specified day from map
	// concatenates the to and from values from the hours entered
	// if both are 0, returns not avail
	// if key doesn't exist, not entered
	String getAvail(String day) {

		if (this.avail.containsKey(day)) {
			// gets map of hrs, am/pm from day
			Map<String, Integer> hours = this.avail.get(day);

			// gets map of what hours avail + am/pm
			ArrayList<String> hourss = new ArrayList<String>(hours.keySet());

			return hours.get(hourss.get(0)) + hourss.get(0) + " to " + hours.get(hourss.get(1)) + hourss.get(1);
		} else if (this.availSame.containsKey(day)) {

			// map of hrs, am/pm from day
			Map<String, ArrayList<Integer>> hours = this.availSame.get(day);
			ArrayList<String> time = new ArrayList<String>(hours.keySet());

			// gets the key set from each
			ArrayList<Integer> hourss = new ArrayList<Integer>();
			hourss = hours.get(time.get(0));

			return hourss.get(0) + time.get(0) + " to " + hourss.get(1) + time.get(0);
		} else {
			return "Not available";
		}
	}
}

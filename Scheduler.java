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
	ArrayList<Employee> showWorking(int from, int to) {

		return null;
	}

}

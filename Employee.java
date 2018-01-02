package sched;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//name, total hours, availability, phone number

public class Employee {
	String name;
	int totalHours;
	String phone;
	//Map<String, int[]> avail = new HashMap<>();
	Map<String, Map<Integer, String>> avail = new HashMap<>();
	
//	static {
//		avail = new HashMap<String, String>(){{
//			put("Monday", "Not entered");
//			put("Tuesday", "Not entered");
//			put("Wednesday", "Not entered");
//			put("Thursday", "Not entered");
//			put("Friday", "Not entered");
//			put("Saturday", "Not entered");
//			put("Sunday", "Not entered");
//			
//		}};
		
//}
	//sets name of the employee
	void setName(String name){
		this.name = name;
	}
	
	//return name of employee
	String getName(){
		return this.name;
	}
	
	//sets the phone number of employee
	void setPhone(String number){
		this.phone = number;
	}
	
	//get phone number of the employee
	String getPhone(){
		return this.phone;
	}

	//set the availability of the employee
	//takes in two integers, to and from availabilities 
	void setAvail(String day, int from, String f,  int to, String t){
		
		Map<Integer, String> hours = new HashMap<>();
		
		if(this.avail.containsKey(day)){
			if(hours.containsKey(from)){
				hours.replace(from, f);
				hours.replace(to, t);
			} else {
				hours.put(from, f);
				hours.put(to, t);
			}
			this.avail.replace(day,hours);	
		}else {
			if(hours.containsKey(from)){
				hours.replace(from, f);
				hours.replace(to, t);
			} else {
				hours.put(from, f);
				hours.put(to, t);
			}
			this.avail.put(day, hours);
		}
	}
	
	//get availability for specified day from map
	//concatenates the to and from values from the hours entered
	//if both are 0, returns not avail
	//if key doesn't exist, not entered
	String getAvail(String day){
		
		if(this.avail.containsKey(day)){
			//gets map of hrs, am/pm from day
			Map<Integer, String> hours = this.avail.get(day);
			
			//gets map of what hours avail + am/pm
			ArrayList<Integer> hourss = new ArrayList<Integer>(hours.keySet()); 
			
			return hourss.get(0) + hours.get(hourss.get(0)) + " to " + hourss.get(1) + hours.get(hourss.get(1));
			
			
		} else {
			return "Not available";
		}
	}
}




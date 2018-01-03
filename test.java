package sched;

public class test {

	public static void main(String[] args) {
		Employee e = new Employee();
		Employee f = new Employee();
		
		
		e.setName("Max");
		e.setPhone("333-333-3333");
		e.setAvail("Monday", 4, "AM", 4, "AM");
		e.setAvail("Saturday", 9 ,"PM", 9, "AM");
		
		
		f.setName("John");
		f.setPhone("444-444-4444");
		f.setAvail("Monday", 5, "AM", 9, "PM");
		
		
		System.out.println("Name: " + e.getName());
		System.out.println("Phone: " + e.getPhone());
		System.out.println("Monday: " + e.getAvail("Monday"));
		System.out.println("Tuesday: " +e.getAvail("Tuesday"));
		System.out.println("Wednesday: " +e.getAvail("Wednesday"));
		System.out.println("Thursday: " +e.getAvail("Thursday"));
		System.out.println("Friday: " +e.getAvail("Friday"));
		System.out.println("Saturday: " +e.getAvail("Saturday"));
		System.out.println("Sunday: " +e.getAvail("Sunday"));
		
		System.out.println();
		
		System.out.println("Name: " + f.getName());
		System.out.println("Phone: " + f.getPhone());
		System.out.println("Monday: " + f.getAvail("Monday"));
		System.out.println("Tuesday: " + f.getAvail("Tuesday"));
		

	}

}

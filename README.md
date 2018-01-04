# javaSched
Simple java scheduler to make scheduling easier 
NOTE: Program building in progress, INCOMPLETE

As of now the employee class holds the name and number of each employee, and the availability.  There are two maps for availbility in order to account for hours with the same AM/PM values.  AM/PM values are used as keys in the availability maps in order to avoid problem #1 (see below). 


Problems (and somewhat of a checklist): 
1. (1-1-18)The key value map corresponds to the time ( ie. 4 am and 4 pm, 4==4) therefore replacing the value for 4 regardless of am/pm, ultimately causes an out of bounds exception (Solved, 1-2-18)
2.(1-3-18) A time class could be a possible solution to a lot of the confusing problems at the moment. Might/might not implement for now, but could see it as being useful for scaling up the application. Not in the forseeable future. 
3.(1-3-18) Updated the scheduler to display employees working within a certain time constraint, using a 24 hr time for that.  Have to write function to account for different time markers (am vs. pm). 

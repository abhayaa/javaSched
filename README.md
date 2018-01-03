# javaSched
Simple java scheduler to make scheduling easier 
NOTE: Program building in progress, INCOMPLETE

As of now the employee class holds the name and number of each employee, and the availability.  There are two maps for availbility in order to account for hours with the same AM/PM values.  AM/PM values are used as keys in the availability maps in order to avoid problem #1 (see below). 


Problems: 
1. The key value map corresponds to the time ( ie. 4 am and 4 pm, 4==4) therefore replacing the value for 4 regardless of am/pm, ultimately causes an out of bounds exception (Solved, 1-2-18)

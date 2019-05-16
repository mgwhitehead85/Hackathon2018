package courseComparer;
import java.util.*;
import java.io.File;

public class MasterParser 
{
	
	public static ArrayList<Course> getMaster()
	{
	ArrayList<Course> masterList = new ArrayList<Course>();
	File inFile = new File("masterCopy.txt");
	Scanner scan = new Scanner(inFile);
	String ID = "";
	String title = "";
	String desc = "";
	double minCred = 0;
	double maxCred = 0;
	
	while(scan.hasNext()) 
	{
		ID = scan.nextLine();
		title = scan.nextLine();
		desc = scan.nextLine();
		minCred = scan.nextDouble();
		maxCred = scan.nextDouble();
		
		assert ID.length() == 7 : "Course ID not valid in master.txt";
		
		if(maxCred < 0)
		{
			masterList.add(new Course(ID, title,desc,minCred,minCred));
		}
		else
		{
			masterList.add(new Course(ID, title,desc,minCred,maxCred));
		}
	}
	return masterList;
	
	}

}

import java.util.*;
import java.io.*;

public class checkWebsight 
{
	public String generateURL(String courseCode) 
	{
		String letters = courseCode.substring(0, 2);
		String numbers = courseCode.substring(4, 6);
		String url = "https://erpdnssb.cccs.edu/PRODCCCS/ccns_pub_controller.p_command_processor?pi_search_type=SB_COURSE&pi_subj_code="+letters+"&pi_crse_numb="+numbers+"&pi_archive_date=&pi_course_status=A&pi_term_code=201920");
		return url;
	}
	
	public static void compareCourses(ArrayList<Course> courses)
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter( new File("badCourses.txt")));
		
		for(int i = 0; i < courses.length(); i++)
		{
			try
			{
			if(!courses.get(i).isEqual(scrubDoc(generateURL(courses.get(i).getID()))));
			{
				writer.append(courses.get(i).toString());
				writer.newLine();
			}
			
			}
			catch(IOException e)
			{
				writer.append("URL Doesn't Exist: " + courses.get(i).getID());
				writer.newLine();
			}
			
		}
		
	}
	
	
	
}



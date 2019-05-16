import java.util.*;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.jsoup.*;
import java.io.*;

public class checkWebsight 
{
	public static String generateURL(String courseCode) 
	{
		String letters = courseCode.substring(0, 2);
		String numbers = courseCode.substring(4, 6);
		String url = ("https://erpdnssb.cccs.edu/PRODCCCS/ccns_pub_controller.p_command_processor?pi_search_type=SB_COURSE&pi_subj_code="+letters+"&pi_crse_numb="+numbers+"&pi_archive_date=&pi_course_status=A&pi_term_code=201920");
		return url;
	}
	

	
	
	public static void compareCourses(ArrayList<Course> courses) throws IOException
	{
		System.out.println(courses.get(0));
		BufferedWriter writer = new BufferedWriter(new FileWriter( new File("badCourses.txt")));
		
		for(int i = 0; i < courses.size(); i++)
		{
			try
			{
			if(!courses.get(i).isEqual(scrubDoc(generateURL(courses.get(i).getCourseId()))));
			{
				System.out.println(courses.get(i).toString());
				writer.append(courses.get(i).toString());
				writer.newLine();
			}
			
			}
			catch(IOException e)
			{
				writer.append("URL Doesn't Exist: " + courses.get(i).getCourseId());
				writer.newLine();
			}
			
		}
		
	}
	
	public static Course scrubDoc(String url) throws IOException
	{
		Course thisCourse = null; 
		org.jsoup.nodes.Document doc =  Jsoup.connect(url).get();
		//String myString = doc.text();

//		String courseTitle = myString.substring(myString.indexOf("Title:")+7, myString.indexOf("Long Title:"));
//		double maxCredits;
//		if(myString.charAt(myString.indexOf("Max Credit")+12)>47 && myString.charAt(myString.indexOf("Max Credit")+12) <58) {
//			maxCredits = Double.parseDouble(myString.substring(myString.indexOf("Max Credit:") + 11, myString.indexOf("Max Credit")+15));
//		} else maxCredits = 0;
//		System.out.println(maxCredits);
//		
		thisCourse = stringToCourse(doc.text());
		//System.out.println(thisCourse.toString());
		
		return thisCourse;
	}
	
	public static Course stringToCourse(String myString) {
		String courseTitle, courseID, courseDesc;
		double minCredits, maxCredits;
		
		courseID = myString.substring(myString.indexOf("Course:")+8, myString.indexOf("Course:")+15);
		courseTitle = myString.substring(myString.indexOf("Title:")+7, myString.indexOf("Long Title:"));
		courseDesc = myString.substring(myString.indexOf("Description:")+12, myString.indexOf("Min Credit:"));
		minCredits = Double.parseDouble(myString.substring(myString.indexOf("Min Credit:") + 11, myString.indexOf("Max Credit:")));
		
		if(myString.charAt(myString.indexOf("Max Credit")+12)>47) {
			maxCredits = Double.parseDouble(myString.substring(myString.indexOf("Max Credit:") + 11, myString.indexOf("Max Credit")+15));
		} else maxCredits = 0;
		
		Course myCourse = new Course(courseTitle, courseID, courseDesc, minCredits, maxCredits);
		
		
		return myCourse;
	}
	
	
	
	
}



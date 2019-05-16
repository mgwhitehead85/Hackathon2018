import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ParsePage 
{
	public static Course scrubDoc(String url) throws IOException
	{
		Course thisCourse = null; 
		Document doc =  Jsoup.connect(url).get();
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

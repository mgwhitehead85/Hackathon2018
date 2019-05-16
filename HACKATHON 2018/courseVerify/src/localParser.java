import java.util.Scanner;
import java.io.IOException;
import java.util.*;
public class localParser {
	public static java.io.File inFile;
	public static java.io.File outFile;
	public int maxCourses = 1000; 
	
	
	private static Boolean docStart = false; 
	private static String tempId = "";
	private static String tempTitle = "";
	private static String tempDesc = "";
	private static Double tempHours = 0.0;
	private static Double tempCredits = 0.0;
	private static Course tempCourse;
	private static String tempString; 
	public static int total = 0;
	
	public static Scanner catalog;
	
	//public static Scanner catalog;
	
	public ArrayList<Course> Run() throws IOException
	{
		ArrayList<Course> cor = new ArrayList<Course>();
		inFile = new java.io.File ( "catalog.txt" ); // brings in file
		if ( !inFile.exists ( ) ) 			// kills program if there's no file
		{
			System.out.println ( "File not found" );
			System.exit ( -1 );
		}

		catalog = new Scanner ( inFile ); 	// buffers file into a scanner
		if ( !catalog.hasNext ( ) ) 		// kills program if file is empty
		{
			System.out.println ( "File is empty" );
			System.exit ( -1 );
		}
	
		tempId = this.docStart(); 			// removes header and grabs first course ID
		
		do 
		{
			lineParser(catalog);  
			System.out.println(this.tempId + " " + this.tempTitle + " " + this.tempDesc + " " + this.tempCredits);
			tempCourse = new Course(this.tempId, this.tempTitle, this.tempDesc, this.tempCredits); 
			System.out.println(tempCourse.toString());
			cor.add(tempCourse);
		} while(this.catalog.hasNext());
		
		
		
		// doc start
		// reading in lines
		// grab a course
		// makes sure course information is in order
		// spits out everything that was discarded into a log file
		
		return cor;
	}
	
		// this 
	public void lineParser(Scanner catalog)
	{
		
		this.tempString = this.catalog.nextLine();	
		this.tempString = this.tempString.trim();		
		boolean flag = false;

		if(!tempString.isEmpty())		// skip empty lines
		{								
				if(checkCourse(tempString))
				{
					if (this.docStart)   // Course ID is finished once
					{
						// we already have course ID
						this.docStart = false; 
					}
					else if (checkCourse(tempString))
					{
						this.tempId = idFinder(tempString);
					}
					this.tempCredits = (double) creditFinder(tempString);
					this.tempTitle = titleFinder(tempString);
					if( this.tempCredits == 0)
					{
						System.out.println("tempcredits is null");
					}
					while (catalog.hasNextLine() && !flag)
					{
						
						this.tempString = catalog.nextLine();
						tempString = tempString.trim();
						if (tempString != "")
						{
							flag = true;
						}
						else this.tempDesc = tempString;
							
					}
					flag = false;
					
				}

		}
	}
	
	public Scanner passCatalog()
	{
		
		return this.catalog;
	}

	public String docStart()
	{
		String tempString = "";
		boolean flag = false; 
		this.docStart = true; 
		while (!flag)
			if(idFinder(tempString) != null)
			{
				if(this.passCatalog().hasNext())
				{
				tempString = passCatalog().nextLine();
				}
				else
					flag = true;
			}
			else if ( tempString != null)
			{
				flag = true;
				return tempString; 	
			}
			else
			{
				System.out.println("Error on docStart method");
				
			}
		
		return null; 
				
	}
	 
	public  boolean checkCourse (String line) {
		if (line.length() >= 9) {
			String id = line.substring(0, 9);
			boolean idCheck = id.matches("\\p{Upper}\\p{Upper}\\p{Upper}\\s\\d\\d\\d\\s\\p{Punct}");
		
			if (idCheck == true) {
				return true;
			}
			
			else {
				return false;
			}		
		}
		
		else {
			return false;
		}
	}
	
	public  String idFinder (String line) {
		if (checkCourse(line) == true) {
			String id = line.substring(0, 7);
			return id.trim();
		}
			
		else {
			return "";
		}
	}
	
	public  String titleFinder (String line) {
		String title = "";
		int start = 	line.indexOf("-") + 1;
		int finish = line.indexOf("(");
		
		if (finish > 0) {
			title = line.substring(start, finish);
			return title.trim();
		}
		
		else if (finish < 0) {
			title = line.substring(start, line.length());
			line = this.catalog.nextLine();
			start = 0;
			finish = line.indexOf("(");
			title = title + line.substring(start, finish);
			return title.trim();
		}
		
		return title;
	}
	
	public  int creditFinder (String line) {
		String credit = "";
		int start = line.indexOf("(") + 1;
		int finish = line.indexOf(")");
		
		if (checkCourse(line) == true) {
			credit = line.substring(start, finish);
			return Integer.getInteger(credit);
		}
		
		else {
			return -1;
		}
	}
	
	

	
} // class


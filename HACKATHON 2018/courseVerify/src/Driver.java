
import java.util.*;
import java.io.*;

public class Driver 
{

	public static void main(String[] args)
	{
		localParser loc = new localParser();
		try {
			checkWebsight.compareCourses(loc.Run());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}

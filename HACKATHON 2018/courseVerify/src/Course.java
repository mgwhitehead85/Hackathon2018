
public class Course {

	private String courseId; // Course department ID and course number
	private String courseTitle; // Name of course
	private String description; // Short description of course
	// private double contactHours=0; // Number of contact hours received for course
	private double minCredits = 0; // Minimum amount of credits allowed for course
	private double maximumCredits = 0; // Maximum amount of credits allowed for course
	private double actualCredits = 0; // Actual amount of credits for the course

	// default constructor
	public Course() {
		courseId = "null";
		courseTitle = "null";
		description = "null";
		// contactHours = -1;
		minCredits = -1;
		maximumCredits = -1;
		actualCredits = -1;

	}

	/**
	 * This is the generated constructor using fields
	 * 
	 * @param courseId
	 * @param courseTitle
	 * @param description
	 * @param minCredits
	 * @param maximumCredits
	 * @param actualCredits
	 */
	public Course(String courseId, String courseTitle, String description, double minCredits, double maximumCredits,
			double actualCredits) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.description = description;
		this.minCredits = minCredits;
		this.maximumCredits = maximumCredits;
		this.actualCredits = actualCredits;
	}
	
	public Course(String courseId, String courseTitle, String description, double minCredits, double maximumCredits) 
	{
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.description = description;
		this.minCredits = minCredits;
		this.maximumCredits = maximumCredits;
		this.actualCredits = minCredits;
	}
	
	
	public Course(String courseId, String courseTitle, String desc, double actualCred)
	{
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.description = desc;
		this.minCredits = actualCred;
		this.maximumCredits = actualCred;
		this.actualCredits = actualCred;
	}

	/**
	 * This is the getters and setters
	 * 
	 * @return the courseNumID
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseNumID the courseNumID to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the minCredits
	 */
	public double getMinCredits() {
		return minCredits;
	}

	/**
	 * @param minCredits the minCredits to set
	 */
	public void setMinCredits(double minCredits) {
		this.minCredits = minCredits;
	}

	/**
	 * @return the maximumCredits
	 */
	public double getMaximumCredits() {
		return maximumCredits;
	}

	/**
	 * @param maximumCredits the maximumCredits to set
	 */
	public void setMaximumCredits(double maximumCredits) {
		this.maximumCredits = maximumCredits;
	}

	/**
	 * @return the actualCredits
	 */
	public double getActualCredits() {
		return actualCredits;
	}

	/**
	 * @param actualCredits the actualCredits to set
	 */
	public void setActualCredits(double actualCredits) {
		this.actualCredits = actualCredits;
	}

	// this is the toString that will return the entire course work load
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return courseId + " " + courseTitle;
	}
/****************************************************************************************************************************
 * This method compares the values between two strings
 * @param othCourse
 * @return
 */
	public boolean isEqual(Course othCourse) 
	{

		if (!this.getCourseId().equalsIgnoreCase(othCourse.getCourseId())) {  
			return false;
		}
		if (!this.getCourseTitle().equalsIgnoreCase(othCourse.getCourseTitle())) {
			return false;
		}
		if (!this.getDescription().equalsIgnoreCase(othCourse.getDescription())) {
			return false;
		}
		if (this.getActualCredits() > othCourse.getMaximumCredits() || this.getActualCredits() < othCourse.getMinCredits()) 
		{
			return false;
		}

		return true;
	}
/**************************************************************************************************************************
 * This method Returns the first 3 locations of the string (course ID)
 * @return
 */
	public String getDept() {
		return this.courseId.substring(0, 2);
	}

}

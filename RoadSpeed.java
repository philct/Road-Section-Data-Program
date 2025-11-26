import java.util.Date;

/**
 * This class keeps the road speed data for one date and time.
 * It stores the date, time, and two speed sensor values.
 */
public class RoadSpeed 
{
	// Declaring the variables
	private Date date;
	private String time;
	private double speedSensor1;
	private double speedSensor2;
	
	/**
	 * This constructor makes a new RoadSpeed object.
	 * @param date the date of the record
	 * @param time the time of the record
	 * @param speedSensor1 the first speed sensor value
	 * @param speedSensor2 the second speed sensor value
	 */
	public RoadSpeed( Date date, String time, double speedSensor1, double speedSensor2 ) 
	{
		this.date = date;
		this.time = time;
		this.speedSensor1 = speedSensor1;
		this.speedSensor2 = speedSensor2;
		
	} // end of constructor
	
	
	/**
	 * This method returns the two speed sensor data in one line.
	 * @return the two sensor values separated by a comma
	 */
	public String getFileData () 
	{
		return String.format("%.1f,%.1f", speedSensor1, speedSensor2 );
		
	} // End of getFileData method
	
	
	/**
	 * This method gives the date of this record.
	 * @return the date of the record
	 */
	public Date getDate () 
	{
		return this.date;
		
	} // End of getDate method
	
	
	/**
	 * This method changes the date to a new one.
	 * @param date the new date value
	 */
	public void setDate ( Date date ) 
	{
		this.date = date;
		
	} // End of setDate method
	
	
	/**
	 * This method gives the time of the record.
	 * @return the time of the record
	 */
	public String getTime () 
	{
		return this.time;
		
	} // End of getTime method
	
	
	/**
	 * This method changes the time to a new one.
	 * @param time the new time value
	 */
	public void setTime ( String time ) 
	{
		this.time = time;
		
	} // End of setTime method
	
	
	/**
	 * This method gives the first speed sensor value.
	 * @return the first speed sensor value
	 */
	public double getSpeedSensor1 () 
	{
		return this.speedSensor1;
		
	} // End of getSpeedSensor1 method
	
	
	/**
	 * This method sets the first speed sensor to a new value.
	 * @param speedSensor1 the new first sensor value
	 */
	public void setSpeedSensor1 ( double speedSensor1 ) 
	{
		this.speedSensor1 = speedSensor1;
		
	} // End of setSpeedSensor1 method
	
	
	/**
	 * Gets the second speed sensor data
	 * @return The second speed sensor value
	 */
	public double getSpeedSensor2 () 
	{
		return this.speedSensor2;
		
	} // End of getSpeedSensor2 method
	
	
	/**
	 * Sets the second speed sensor value to the new provided value
	 * @param Double The new speed sensor
	 */
	public void setSpeedSensor2 ( double speedSensor2 ) 
	{
		this.speedSensor2 = speedSensor2;
		
	} // End of setSpeedSensor2 method
	
	
} // end of class

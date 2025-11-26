import java.util.Date;

/**
 * This class keeps the road volume data for one date and time.
 * It stores the date, time, and four volume sensor values.
 */
public class RoadVolume 
{
	// Declaring the variables
	private Date date;
	private String time;
	private int volumeSensor1;
	private int volumeSensor2;
	private int volumeSensor3;
	private int volumeSensor4;
	
	/**
	 * Creates a RoadVolume object
	 * @param Date Date input from the file
	 * @param String Time input from the file
	 * @param Integer First volume input from the file
	 * @param Integer Second volume input from the file
	 * @param Integer Third volume input from the file
	 * @param Integer Four volume input from the file
	 */
	public RoadVolume( Date date, String time, int volumeSensor1, int volumeSensor2, int volumeSensor3, int volumeSensor4 ) 
	{
		this.date = date;
		this.time = time;
		this.volumeSensor1 = volumeSensor1;
		this.volumeSensor2 = volumeSensor2;
		this.volumeSensor3 = volumeSensor3;
		this.volumeSensor4 = volumeSensor4;
		
	} // end of constructor
	
	
	/**
	 * This method returns the four sensor data in one line.
	 * @return the sensor values separated by commas
	 */
	public String getFileData () 
	{
		return String.format("%d,%d,%d,%d", volumeSensor1, volumeSensor2 , volumeSensor3 , volumeSensor4);
		
	} // End of getFileData method
	
	
	/**
	 * This method gives the date of the record.
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
	 * Gets the time of the data
	 * @return The time of the data
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
	 * Gets the first volume sensor data
	 * @return The first volume sensor value
	 */
	public int getVolumeSensor1 () 
	{
		return this.volumeSensor1;
		
	} // End of getVolumeSensor1 method
	
	
	/**
	 * This method sets the first sensor to a new value.
	 * @param volumeSensor1 the new first sensor value
	 */
	public void setVolumeSensor1 ( int volumeSensor1 ) 
	{
		this.volumeSensor1 = volumeSensor1;
		
	} // End of setVolumeSensor1 method
	
	
	/**
	 * Gets the second volume sensor data
	 * @return The second volume sensor value
	 */
	public int getVolumeSensor2 () 
	{
		return this.volumeSensor2;
		
	} // End of getVolumeSensor2 method
	
	
	/**
	 * This method sets the second sensor to a new value.
	 * @param volumeSensor2 the new second sensor value
	 */
	public void setVolumeSensor2 ( int volumeSensor2 ) 
	{
		this.volumeSensor2 = volumeSensor2;
		
	} // End of setVolumeSensor2 method
	
	
	/**
	 * Gets the third volume sensor data
	 * @return The third volume sensor value
	 */
	public int getVolumeSensor3 () 
	{
		return this.volumeSensor3;
		
	} // End of getVolumeSensor3 method
	
	
	/**
	 * This method sets the third sensor to a new value.
	 * @param volumeSensor2 the new second sensor value
	 */
	public void setVolumeSensor3 ( int volumeSensor3 ) 
	{
		this.volumeSensor3 = volumeSensor3;
		
	} // End of setVolumeSensor3 method
	
	
	/**
	 * Gets the four volume sensor data
	 * @return The four volume sensor value
	 */
	public int getVolumeSensor4 () 
	{
		return this.volumeSensor4;
		
	} // End of getVolumeSensor4 method
	
	
	/**
	 * This method sets the fourth sensor to a new value.
	 * @param volumeSensor2 the new second sensor value
	 */
	public void setVolumeSensor4 ( int volumeSensor4 ) 
	{
		this.volumeSensor4 = volumeSensor4;
		
	} // End of setVolumeSensor4 method
	
	
} // end of class

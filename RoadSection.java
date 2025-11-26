import java.text.SimpleDateFormat;

/**
 * This class connects road volume and road speed data together.
 * It also calculates total and average values for volume and speed.
 */
public class RoadSection 
{
	private RoadVolume roadVolume;
	private RoadSpeed roadSpeed;
	private int volumeTotal;
	private double volumeAvg;
	private double speedAvg;
	
	/**
	 * This constructor makes a new RoadSection object.
	 * @param roadVolume the road volume object
	 * @param roadSpeed the road speed object
	 */
	public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) 
	{
		this.roadVolume = roadVolume;
		this.roadSpeed = roadSpeed;
	} // End of Constructor

	
	/**
	 * This method prepares one line of data that combines
	 * date, time, sensor values, total, and averages.
	 * @return the formatted string with all data separated by commas
	 */
	public String getFileData () 
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = dateFormatter.format(roadVolume.getDate());
	    String timeStr = roadVolume.getTime();

	    // Calculate totals and averages
	    int total = calcVolumeTotal();
	    double volumeAverage = calcVolumeAvg();
	    double speedAverage = calcSpeedAvg();

	    // Store them in the object
	    this.volumeTotal = total;
	    this.volumeAvg = volumeAverage;
	    this.speedAvg = speedAverage;

	    return String.format("%s,%s,%s,%s,%d,%.2f,%.2f", dateStr, timeStr, roadVolume.getFileData(), roadSpeed.getFileData(), total, volumeAverage, speedAverage);
	} // End of method
	
	
	/**
	 * This method gives the road volume object.
	 * @return the road volume object
	 */
	public RoadVolume getRoadVolume() 
	{
		return roadVolume;
	} // End of method

	
	/**
	 * This method sets a new road volume object.
	 * @param roadVolume the new road volume
	 */
	public void setRoadVolume(RoadVolume roadVolume) 
	{
		this.roadVolume = roadVolume;
	} // End of method

	
	/**
	 * This method gives the road speed object.
	 * @return the road speed object
	 */
	public RoadSpeed getRoadSpeed() 
	{
		return roadSpeed;
	} // End of method

	
	/**
	 * This method sets a new road speed object.
	 * @param roadSpeed the new road speed
	 */
	public void setRoadSpeed(RoadSpeed roadSpeed) 
	{
		this.roadSpeed = roadSpeed;
	} // End of method

	
	/**
	 * This method gives the total volume from all sensors.
	 * @return the total volume
	 */
	public int getVolumeTotal() 
	{
		return volumeTotal;
	} // End of method

	
	/**
	 * This method changes the total volume to a new value.
	 * @param volumeTotal the new total volume
	 */
	public void setVolumeTotal(int volumeTotal)
	{
		this.volumeTotal = volumeTotal;
	} // End of method

	
	/**
	 * This method gives the average volume value.
	 * @return the average volume
	 */
	public double getVolumeAvg() 
	{
		return volumeAvg;
	} // End of method

	
	/**
	 * This method changes the average volume to a new value.
	 * @param volumeAvg the new average volume
	 */
	public void setVolumeAvg(double volumeAvg) 
	{
		this.volumeAvg = volumeAvg;
	} // End of method

	
	/**
	 * This method gives the average speed value.
	 * @return the average speed
	 */
	public double getSpeedAvg() 
	{
		return speedAvg;
	} // End of method

	
	/**
	 * This method changes the average speed to a new value.
	 * @param speedAvg the new average speed
	 */
	public void setSpeedAvg(double speedAvg) 
	{
		this.speedAvg = speedAvg;
	} // End of method
	
	
	/**
	 * This private method calculates the total of all four volume sensors.
	 * @return the total volume value
	 */
	private int calcVolumeTotal () 
	{
		return roadVolume.getVolumeSensor1() + roadVolume.getVolumeSensor2() + roadVolume.getVolumeSensor3() + roadVolume.getVolumeSensor4();
	} // End of method
	
	
	/**
	 * This private method calculates the average of four volume sensors.
	 * @return the average volume value
	 */
	private double calcVolumeAvg () 
	{
		return calcVolumeTotal() / 4.0;
	} // End of method
	
	
	/**
	 * This private method calculates the average of two speed sensors.
	 * @return the average speed value
	 */
	private double calcSpeedAvg ()
	{
		return (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2()) / 2;
	} // End of method
	
	
} // end of class

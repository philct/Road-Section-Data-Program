import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class handles reading and writing data files.
 * It loads road volume and speed data from CSV files and
 * also writes combined road section data into a new file.
 */
public class FileHandler 
{
	
	/**
	 * This method reads road volume data from a file and saves it into a list.
	 * @param filename the name of the volume data file
	 * @return a list of RoadVolume objects
	 * @throws FileNotFoundException if the file cannot be found
	 * @throws ParseException if there is a problem with reading the date format
	 * @throws NumberFormatException if a number cannot be converted correctly
	 */
	public ArrayList<RoadVolume> loadVolumeData( String filename ) throws FileNotFoundException, ParseException, NumberFormatException
	{
		ArrayList<RoadVolume> volumeDataLists = new ArrayList<>();
				
			File fileInputStream = new File(filename);
			Scanner fileInputScanner = new Scanner(fileInputStream);
			
			// Removing the first line of the file
			if ( fileInputScanner.hasNext() ) 
			{
				fileInputScanner.nextLine();
			} // End of condition
			
			// Looping through each line in the volume data file
			while ( fileInputScanner.hasNext() ) 
			{
				String volumeDataLine = fileInputScanner.nextLine();
				String volumeDataWords[] = volumeDataLine.split(","); // Separating the words in each line
				SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yy");
				
				// Assigning the values inside the volume data with the right formats
				Date date = dateFormater.parse(volumeDataWords[0]);
				String time = volumeDataWords[1];
				int volumeSensor1 = Integer.parseInt(volumeDataWords[2]);
				int volumeSensor2 = Integer.parseInt(volumeDataWords[3]);
				int volumeSensor3 = Integer.parseInt(volumeDataWords[4]);
				int volumeSensor4 = Integer.parseInt(volumeDataWords[5]);
				
				RoadVolume roadVolume = new RoadVolume( date, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4 );
				
				volumeDataLists.add(roadVolume);
				
			} // End of loop
		
		System.out.println("Volume Data Loaded");
		
		return volumeDataLists;
		
	} // End of loadVolumeData method
	
	
	/**
	 * This method reads road speed data from a file and saves it into a list.
	 * @param filename the name of the speed data file
	 * @return a list of RoadSpeed objects
	 * @throws FileNotFoundException if the file cannot be found
	 * @throws ParseException if there is a problem with reading the date format
	 * @throws NumberFormatException if a number cannot be converted correctly
	 */
	public ArrayList<RoadSpeed> loadSpeedData ( String filename ) throws FileNotFoundException, ParseException, NumberFormatException
	{
		ArrayList<RoadSpeed> speedDataLists = new ArrayList<>();
		
		File fileInputStream = new File(filename);
		Scanner fileInputScanner = new Scanner(fileInputStream);
		
		// Removing the first line of the file
		if ( fileInputScanner.hasNext() ) 
		{
			fileInputScanner.nextLine();
		} // End of condition
		
		// Looping through each line in the speed data file
		while ( fileInputScanner.hasNext() ) 
		{
			String speedDataLine = fileInputScanner.nextLine();
			String speedDataWords[] = speedDataLine.split(","); // Separating the words in each line
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			
			// Assigning the values inside the speed data with the right formats
			Date date = dateFormater.parse(speedDataWords[0]);
			String time = speedDataWords[1];
			double speedSensor1 = Double.parseDouble(speedDataWords[2]);
			double speedSensor2 = Double.parseDouble(speedDataWords[3]);
			
			RoadSpeed roadSpeed= new RoadSpeed( date, time, speedSensor1, speedSensor2);
			
			speedDataLists.add(roadSpeed);
			
		} // End of loop
	
		System.out.println("Speed Data Loaded");
	
		return speedDataLists;
		
	} // End of loadSpeedData method
	
	
	/**
	 * This method writes road section data into a new CSV file.
	 * The file will contain date, time, sensor values, and averages.
	 * @param sectionList the list of RoadSection objects to write
	 * @throws FileNotFoundException if the file cannot be created
	 */
	public void writeRoadSectionData( ArrayList<RoadSection> sectionList ) throws FileNotFoundException 
	{
		File outFile = new File("Road_Section_Data.csv");
		PrintWriter writer = new PrintWriter(outFile);
		
		writer.println("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor_2006,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg");
		
		for ( RoadSection roadSection: sectionList ) 
		{
			writer.println(roadSection.getFileData());
		} // End of loop
		
		System.out.println("Road Section Data Created");
		writer.close();
	} // End of writeRoadSectionData
	
	
} // end of class

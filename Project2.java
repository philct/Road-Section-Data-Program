import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program reads road volume and speed data from two files,
 * combines them together, and then creates a new file with road section data.
 * It helps to see the total and average values for each record.
 * 
 * @author Philimon Tegegn
 * @version 17.0
 * @since 2025-10-17
 */
public class Project2 
{

	/**
	 * The main method that runs the program.
	 * It asks the user to enter the file paths for volume and speed data,
	 * loads the data, creates the road sections, and saves them to a new file.
	 * 
	 * @param args used for command line arguments
	 */
	public static void main(String[] args)
	{
		ArrayList<RoadSection> roadSectionList = new ArrayList<RoadSection>();
		ArrayList<RoadVolume> roadVolumeList = new ArrayList<RoadVolume>();
		ArrayList<RoadSpeed> roadSpeedList = new ArrayList<RoadSpeed>();
		Scanner scnr = new Scanner(System.in); 
		FileHandler fileHandler = new FileHandler();
		
		boolean success = false;
		
		while ( !success ) 
		{
			System.out.println("Enter Path and Name of Volume and Speed Data File");
			String pathForVolume = scnr.next();
			String pathForSpeed = scnr.next();
			
			try 
			{
				System.out.println("Loading Volume Data");
				roadVolumeList = fileHandler.loadVolumeData(pathForVolume);
				System.out.println("Loading Speed Data");
				roadSpeedList = fileHandler.loadSpeedData(pathForSpeed);
				roadSectionList = createRoadSections(roadVolumeList, roadSpeedList);
				fileHandler.writeRoadSectionData(roadSectionList);
				success = true;
			}
			catch (FileNotFoundException e) 
			{
		        System.out.println("File Not Found Error: " + e.getMessage());
		    } 
		    catch (ParseException e) 
			{
		        System.out.println("Date Parse Error: " + e.getMessage());
		    } 
		    catch (NumberFormatException e) 
			{
		        System.out.println("Number Parse Error: " + e.getMessage());
		    }
			
			System.out.println(); // Print new line

		} // End of loop
		
		 
	} // end of main

	
	/**
	 * This method connects the data from volume and speed files
	 * and makes a list of road sections that have the same date and time.
	 * 
	 * @param volumeList list that contains all road volume data
	 * @param speedList list that contains all road speed data
	 * @return a list of RoadSection objects that match by date and time
	 */
	public static ArrayList<RoadSection> createRoadSections ( ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList ) 
	{
		ArrayList<RoadSection> roadSectionList = new ArrayList<RoadSection>();
		for ( RoadVolume volume: volumeList ) 
		{
			for ( RoadSpeed speed: speedList ) 
			{
				if ( volume.getDate().equals(speed.getDate()) && volume.getTime().equals(speed.getTime()) ) 
				{
					RoadSection roadSection = new RoadSection(volume, speed);
					roadSectionList.add(roadSection);
				} // End of condition
				
			} // End of inner loop
			
		} // End of outer loop
		
		return roadSectionList;
	} // End of method 
	
	
} // end of class

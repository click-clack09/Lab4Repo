package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**This class contains the data and methods for the Classifieds scene.
 * 
 * @author Richard Maldonado rlk538 on 10/23/21
 *
 */
public class Classifieds 
{
	//The ArrayList of Advertisement object created from data read in from a csv file.
	private ArrayList<Advertisement> adList;
	
	//No-args constructor
	public Classifieds()
	{
		adList = new ArrayList<Advertisement>();
	}
	
	/**This method accepts a String of the csv file name, reads the file line by line,
	 * creates new Advertisement objects for each line that contains text, adds the
	 * Advertisement object the adList ArrayList, and returns nothing.
	 * 
	 * @param fileName the name of the csv file
	 * @throws IOException
	 */
	public void loadAds(String fileName) throws IOException
	{
		String[] ad;
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
        {
            // read the first line from the text file
            String line = reader.readLine();
            while (line != null) {
            	if (line.length()>0)
            	{
                	ad = (line.split(","));
                	adList.add(new Advertisement(ad[0],ad[1],ad[2],ad[3],ad[4]));
        		}
    			line = reader.readLine();
            }

        }
		
	}

	/**AdList getter
	 * 
	 * @return the adList
	 */
	public ArrayList<Advertisement> getAdList() {
		return adList;
	}

	/**Adlist setter
	 * 
	 * @param adList the adList to set
	 */
	public void setAdList(ArrayList<Advertisement> adList) {
		this.adList = adList;
	}
	
	/**This method takes an int index and calls the format method of the Advertisement
	 * object at corresponding index of the ArrayList adList and returns the String array
	 * of formatted output Strings. 
	 * 
	 * @param index the index of the adList to be formatted
	 * @return an array of formatted output Strings
	 */
	public String[] format(int index)
	{		
		return adList.get(index).format();
	}
}

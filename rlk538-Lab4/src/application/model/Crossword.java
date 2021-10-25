package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.TextField;

/**
 * 
 * @author Richard Maldonado rlk538  on 10/23/21
 *
 */
public class Crossword {
	//As the directions stated class methods, not object methods, should be used, all variables are static.
	private static ArrayList<String> acrossNumber;
	private static ArrayList<String> downNumber;
	private static ArrayList<String> acrossClues;
	private static ArrayList<String> downClues;
	private static ArrayList<String> acrossAnswers;
	private static ArrayList<String> downAnswers;
	private final static char[][] answerSpaces = {{' ','T','E','X','A','S',' ',' ',' '},
				 {' ','X',' ',' ',' ','T',' ',' ',' '},
				 {' ',' ',' ',' ','G','A','S',' ','F'},
			 	 {' ',' ','A',' ',' ','R',' ',' ','A'},
			 	 {' ',' ','C','O','A','S','T','E','R'},
		 	 	 {'B','E','E','F',' ',' ',' ',' ','M'}};
	
	/**This method accepts to Strings used for across and down files, calls the readFile method,
	 * passes the returned data to the parseData method and initializes the class variables from the
	 * parseData returned ArrayLists.
	 * 
	 * @param acrossFile filename for across data
	 * @param downFile filename for down data
	 */
	public static void loadData(String acrossFile, String downFile)
	{
		ArrayList<ArrayList<String>> across = parseData(readFile(acrossFile));
		ArrayList<ArrayList<String>> down = parseData(readFile(downFile));
		acrossNumber=across.get(0);
		acrossClues=across.get(1);
		acrossAnswers=across.get(2);
		downNumber=down.get(0);
		downClues=down.get(1);
		downAnswers=down.get(2);	
	}
	
	/**This method takes a String filename, reads the file line by line, splits the line into an array,
	 * and adds the String array to an Array list which is returned.
	 * 
	 * @param fileName the name of the file to be read
	 * @return the ArrayList of String arrays
	 */
	private static ArrayList<String[]> readFile(String fileName)
	{
		ArrayList<String[]> clueList = new ArrayList<String[]>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
        {
            // read the first line from the text file
            String line = reader.readLine();
            while (line != null) {
            	
                clueList.add(line.split(","));
                line = reader.readLine();
            }

        } 
        
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
        return clueList;
	}
	
	/**This method accepts and ArrayList of String arrays, adds the indices of the array list to separate
	 * ArrayLists of Strings based on their position, and returns an ArrayList of the String ArrayLists containing 
	 * the separated data. 
	 * 
	 * @param rawData the ArrayList of String arrays to be parsed.
	 * @return
	 */
	private static ArrayList<ArrayList<String>> parseData(ArrayList<String[]> rawData)
	{
		ArrayList<String> number = new ArrayList<String>();
		ArrayList<String> clue = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		ArrayList<ArrayList<String>> tempList = new ArrayList<ArrayList<String>>(Arrays.asList(number,clue,answer));
		
		for (int i = 0; i < rawData.size(); i++)
		{
			number.add(rawData.get(i)[0]);
			clue.add(rawData.get(i)[1]);
			answer.add(rawData.get(i)[2]);
		}
		return tempList;
	}
	
	/**This static method takes the clue number and the clue and returns a String of the
	 * concatenated fields.
	 * 
	 * @param list1 the Array list that is added to the string first.
	 * @param list2 the Array list that is added to the string second.
	 * @return
	 */
	public static String print(ArrayList<String> list1,ArrayList<String> list2)
	{
		String temp="";
		for (int i = 0; i < list1.size(); i++)
			temp+=list1.get(i)+". "+list2.get(i)+"\n";
		return temp;
	}
	
	//Getters and Setters listed below
    
	/**
	 * @return the acrossNumber
	 */
	public static ArrayList<String> getAcrossNumber() {
		return acrossNumber;
	}

	/**
	 * @param acrossNumber the acrossNumber to set
	 */
	public static void setAcrossNumber(ArrayList<String> acrossNumber) {
		Crossword.acrossNumber = acrossNumber;
	}

	/**
	 * @return the downNumber
	 */
	public static ArrayList<String> getDownNumber() {
		return downNumber;
	}

	/**
	 * @param downNumber the downNumber to set
	 */
	public static void setDownNumber(ArrayList<String> downNumber) {
		Crossword.downNumber = downNumber;
	}

	/**
	 * @return the acrossClues
	 */
	public static ArrayList<String> getAcrossClues() {
		return acrossClues;
	}

	/**
	 * @param acrossClues the acrossClues to set
	 */
	public static void setAcrossClues(ArrayList<String> acrossClues) {
		Crossword.acrossClues = acrossClues;
	}

	/**
	 * @return the downClues
	 */
	public static ArrayList<String> getDownClues() {
		return downClues;
	}

	/**
	 * @param downClues the downClues to set
	 */
	public static void setDownClues(ArrayList<String> downClues) {
		Crossword.downClues = downClues;
	}

	/**
	 * @return the acrossAnswers
	 */
	public static ArrayList<String> getAcrossAnswers() {
		return acrossAnswers;
	}

	/**
	 * @param acrossAnswers the acrossAnswers to set
	 */
	public static void setAcrossAnswers(ArrayList<String> acrossAnswers) {
		Crossword.acrossAnswers = acrossAnswers;
	}

	/**
	 * @return the downAnswers
	 */
	public static ArrayList<String> getDownAnswers() {
		return downAnswers;
	}

	/**
	 * @param downAnswers the downAnswers to set
	 */
	public static void setDownAnswers(ArrayList<String> downAnswers) {
		Crossword.downAnswers = downAnswers;
	}

	/**
	 * @return the answerSpaces
	 */
	public static char[][] getAnswerSpaces() {
		return answerSpaces;
	}

	/**
	 * @param answerSpaces the answerSpaces to set
	 */
	public void setAnswerSpaces(char[][] answerSpaces) {
		answerSpaces = answerSpaces;
	}

}

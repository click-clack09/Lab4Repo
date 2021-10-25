package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.Crossword;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**This controller will read from the Crossword model and display to the Crossword view.
 * 
 * @author Richard Maldonado rlk538 on 10/23/21
 *
 */
public class CrosswordController {
	
	/**This method calls the Crossword loadData method, and sets the Labels of the Crossword view
	 * based on the data read by the loadData method.
	 * 
	 */
	@FXML
    public void initialize()
    {
		Crossword.loadData("data\\across.csv", "data\\down.csv");
    	acrossHeader.setText("Across\n");
		downHeader.setText("Down\n");
		across.setText(Crossword.print(Crossword.getAcrossNumber(),Crossword.getAcrossClues()));
		down.setText(Crossword.print(Crossword.getDownNumber(),Crossword.getDownClues()));
	}
    
    @FXML
    private AnchorPane crossPane;

    @FXML
    private Label acrossHeader;
    
    @FXML
    private Label downHeader;
    
    @FXML
    private Label across;
   
    @FXML
    private Label down;
    
    @FXML
    private TextField oneAcc0;

    @FXML
    private TextField oneAcc1;

    @FXML
    private TextField oneAcc2;

    @FXML
    private TextField oneAcc3;

    @FXML
    private TextField oneAcc4;

    @FXML
    private TextField oneDown1;

    @FXML
    private TextField sevenDown1;

    @FXML
    private TextField twoAcc0;

    @FXML
    private TextField twoAcc1;

    @FXML
    private TextField twoAcc2;

    @FXML
    private TextField eightDown0;

    @FXML
    private TextField fiveDown0;

    @FXML
    private TextField sevenDown3;

    @FXML
    private TextField eightDown1;

    @FXML
    private TextField threeAcc0;

    @FXML
    private TextField threeAcc1;

    @FXML
    private TextField threeAcc2;

    @FXML
    private TextField threeAcc3;

    @FXML
    private TextField threeAcc4;

    @FXML
    private TextField threeAcc5;

    @FXML
    private TextField threeAcc6;

    @FXML
    private TextField fourAcc0;

    @FXML
    private TextField fourAcc1;

    @FXML
    private TextField fourAcc2;

    @FXML
    private TextField fourAcc3;

    @FXML
    private TextField eightDown3;
    
    /*This table is used with the show method, which sets a value only at the [i][j]
    indices that have a true table value.*/ 
    private Boolean[][] table = {
    		{false,true,true,true,true,true,false,false,false},
    		{false,true,false,false,false,true,false,false,false},
    		{false,false,false,false,true,true,true,false,true},
    		{false,false,true,false,false,true,false,false,true},
    		{false,false,true,true,true,true,true,true,true},
    		{true,true,true,true,false,false,false,false,true}};
    
    /**This method sets the text css to red if the text in the TextField does not match the answer
     * text, and changed the text css back to black if the text is corrected.
     * 
     * @param event
     */
    @FXML
    void check(ActionEvent event) {
    	char[][] temp = Crossword.getAnswerSpaces();
    	TextField[][] textSpaces = {
        		{null,oneAcc0,oneAcc1,oneAcc2,oneAcc3,oneAcc4,null,null,null},
        		{null,oneDown1,null,null,null,sevenDown1,null,null,null},
        		{null,null,null,null,twoAcc0,twoAcc1,twoAcc2,null,eightDown0},
        		{null,null,fiveDown0,null,sevenDown3,null,null,eightDown1},
        		{null,null,threeAcc0,threeAcc1,threeAcc2,threeAcc3,threeAcc4,threeAcc5,threeAcc6},
        		{fourAcc0,fourAcc1,fourAcc2,fourAcc3,null,null,null,null,eightDown3}};
    	for (int i=0; i<textSpaces.length; i++)
    	{
    		for (int j=0; j<textSpaces[i].length; j++)
    		{
    			if (!(textSpaces[i][j]==null))
    			{
    				if (!textSpaces[i][j].getText().equals(""))
    				{
    					if (!textSpaces[i][j].getText().equalsIgnoreCase(temp[i][j]+""))
    						textSpaces[i][j].setStyle("-fx-text-fill:red");
    					else
    						textSpaces[i][j].setStyle("-fx-text-fill:black");
    				}
    			}
			}
    	}
    	
    }

    /**This method shows the correct text for the crossword.
     * 
     * @param event
     */
    @FXML
    void show(ActionEvent event) {
    	char[][] temp = Crossword.getAnswerSpaces();
    	TextField[][] textSpaces = {
        		{null,oneAcc0,oneAcc1,oneAcc2,oneAcc3,oneAcc4,null,null,null},
        		{null,oneDown1,null,null,null,sevenDown1,null,null,null},
        		{null,null,null,null,twoAcc0,twoAcc1,twoAcc2,null,eightDown0},
        		{null,null,fiveDown0,null,null,sevenDown3,null,null,eightDown1},
        		{null,null,threeAcc0,threeAcc1,threeAcc2,threeAcc3,threeAcc4,threeAcc5,threeAcc6},
        		{fourAcc0,fourAcc1,fourAcc2,fourAcc3,null,null,null,null,eightDown3}};
    	for (int i=0; i<textSpaces.length; i++)
    	{
    		for (int j=0; j<textSpaces[i].length; j++)
    		{
    			if (table[i][j])
    			{
    				textSpaces[i][j].setText(temp[i][j]+"");
					textSpaces[i][j].setStyle("-fx-text-fill:black");
    			}
			}
    	}

    }

    /**This method gets the current Stage and sets a new scene to the Stage
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void toHome(ActionEvent event) throws IOException {
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	crossPane = FXMLLoader.load(url);
    	Scene scene = new Scene(crossPane);// pane you are GOING TO show
	    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
    
}

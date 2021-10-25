package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.Advertisement;
import application.model.Classifieds;
import application.model.Crossword;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**This controller will read from the Classifieds model and display to the Classifieds view.
 * 
 * @author Richard Maldonado rlk538 on 10/23/21
 *
 */
public class ClassifiedsController {

    @FXML
    private AnchorPane crossPane;
    
    @FXML
    private Label pos1Header;

    @FXML
    private Label pos1Body;

    @FXML
    private Label pos1Footer;

    @FXML
    private Label pos2Header;

    @FXML
    private Label pos2Body;

    @FXML
    private Label pos2Footer;

    @FXML
    private Label pos3Header;

    @FXML
    private Label pos3Body;

    @FXML
    private Label pos3Footer;
    
    @FXML
    private Label pos4Header;

    @FXML
    private Label pos4Body;

    @FXML
    private Label pos4Footer;

    /**Instantiates a new Classified object and calls the setLabels method to set Label 
     * text based on the number of ads read in by the loadAds method.
     * 
     * @throws IOException
     */
    @FXML
    public void initialize() throws IOException
    {
    	int adCount;
		Classifieds ads = new Classifieds();
		ads.loadAds("data\\ads.csv");
		adCount = ads.getAdList().size();
		
    	switch (adCount)
    	{
    		case 4:
    			setLabels(pos4Header,pos4Body,pos4Footer,ads.format(3));
    		case 3:
    			setLabels(pos3Header,pos3Body,pos3Footer,ads.format(2));
    		case 2:
    			setLabels(pos2Header,pos2Body,pos2Footer,ads.format(1));
    		case 1:
    			setLabels(pos1Header,pos1Body,pos1Footer,ads.format(0));
    			break;
			default:
				break;
    	}
    		
	}
    
    /**This method sets the Label text of the three Labels from the passed in String array.
     * 
     * @param header the top Label in the vBox
     * @param body the middle Label in the VBox
     * @param footer the bottom Label in the vBox
     * @param copy the String array containing the Label text to be set
     */
    public void setLabels(Label header, Label body, Label footer, String[] copy)
    {
    	header.setText(copy[0]);
    	body.setText(copy[1]);
    	footer.setText(copy[2]);
    }
    
    /**This method gets the current Stage and sets a new scene to the Stage
     * 
     * @param event The button click
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

package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import application.model.Crossword;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**This Class is the controller for the main view
 * 
 * @author Richard Maldonado rlk538 on 10/23/21
 *
 */
public class MainController {

    @FXML
    private AnchorPane mainPane;
    
    /**This method gets the current Stage and sets a new scene to the Stage
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void toClassified(ActionEvent event) throws IOException {
    	URL url = new File("src/Classifieds.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        //mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Classified.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    @FXML
    
    /**his method gets the current Stage and sets a new scene to the Stage
     * 
     * @param event
     * @throws IOException
     */
    void toCrossword(ActionEvent event) throws IOException {
    	URL url = new File("src/Crossword.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	//mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Classified.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

}

package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {
	public Controller()
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/slider.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public VBox get_view()
	{
		return root;
	}
	
	@FXML
	private VBox root;
	
	@FXML
    private HBox p1;
	@FXML
    private HBox p2;
	
	@FXML
    private HBox p3;
	
    @FXML
    private Slider sl_red;

    @FXML
    private Slider sl_blue;

    @FXML
    private Slider sl_green;
    
    @FXML
    void blue_sliding(MouseEvent event) {
    	System.out.println(sl_blue.getValue());
    }

    @FXML
    void green_sliding(MouseEvent event) {

    }

    @FXML
    void red_sliding(MouseEvent event) {

    }

}
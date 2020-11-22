package ventanaMem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.sun.prism.paint.Stop;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import controller.Controller;

public class Main extends Application {
	private SimpleDoubleProperty red_val_pro;
	private SimpleDoubleProperty blue_val_pro;
	private SimpleDoubleProperty green_val_pro;
	private Color color;
	private Stage primaryStage;
	private double width;
	private double height;
	private double x_pos;
	private double y_pos;

	@Override
	public void start(Stage s) throws IOException {
		primaryStage = s;
		Controller c1 = new Controller();

		Scene sc = new Scene(c1.get_view(), 400, 200);

		final Slider red_slider = c1.get_red_slider();
		final Slider blue_slider = c1.get_blue_slider();
		final Slider green_slider = c1.get_green_slider();
		final Parent root = c1.get_view();
		
		red_slider.setValue(color.getRed() / 255.0);
		green_slider.setValue(color.getGreen()/255.0);
		blue_slider.setValue(color.getBlue() /255.0);
		root.setStyle("-fx-background-color: #" + color.toString() + ";");
		
		primaryStage.setX(x_pos);
        primaryStage.setY(y_pos);
        
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);

		red_slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				color.setRed(newValue.doubleValue());
				root.setStyle("-fx-background-color: #" + color.toString() + ";");
				System.out.println(color.toString());
			}

		});

		blue_slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				color.setBlue(newValue.doubleValue());
				root.setStyle("-fx-background-color: #" + color.toString() + ";");
			}

		});

		green_slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				color.setGreen(newValue.doubleValue());
				root.setStyle("-fx-background-color: #" + color.toString() + ";");
			}
		});

		s.setScene(sc);
		s.show();
	}

	public void stop() {
		try {
			OutputStream output = new FileOutputStream("ventana.config");
			Properties prop = new Properties();
			prop.setProperty("background.red", Integer.toString(color.getRed()));
			prop.setProperty("background.blue", Integer.toString(color.getBlue()));
			prop.setProperty("background.green", Integer.toString(color.getGreen()));
			prop.setProperty("size.width", Double.toString(primaryStage.getWidth()));
			prop.setProperty("size.height", Double.toString(primaryStage.getHeight()));
			prop.setProperty("location.x", Double.toString(primaryStage.getX()));
			prop.setProperty("location.y", Double.toString(primaryStage.getY()));

			prop.store(output, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		try (InputStream input = new FileInputStream("ventana.config")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            color.setRed(Integer.parseInt(prop.getProperty("background.red")));
            color.setGreen(Integer.parseInt(prop.getProperty("background.green")));
            color.setBlue(Integer.parseInt(prop.getProperty("background.blue")));
            
            x_pos = Double.parseDouble(prop.getProperty("location.x"));
            y_pos = Double.parseDouble(prop.getProperty("location.y"));
            
            width = Double.parseDouble(prop.getProperty("size.width"));
            height = Double.parseDouble(prop.getProperty("size.height"));
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public Main() {
		color = new Color();
		red_val_pro = new SimpleDoubleProperty();
		blue_val_pro = new SimpleDoubleProperty();
		green_val_pro = new SimpleDoubleProperty();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

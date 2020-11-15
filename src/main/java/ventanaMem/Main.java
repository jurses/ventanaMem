package ventanaMem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.Controller;

public class Main extends Application{
	@Override
	public void start(Stage s) throws IOException
	{
		Controller c1 = new Controller();
		
		Scene sc = new Scene(c1.get_view(), 400, 200);
		
		try (OutputStream output = new FileOutputStream("config.properties")) {
			
		}catch (IOException io) {
            io.printStackTrace();
        }
		s.setScene(sc);
		s.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
}

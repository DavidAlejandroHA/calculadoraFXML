package dad.calculadoraFXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CalculadoraController controller = new CalculadoraController();
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(controller.getView(), 600, 400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

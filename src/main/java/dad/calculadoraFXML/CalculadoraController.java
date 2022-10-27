package dad.calculadoraFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable{
	
	@FXML
	private GridPane calculadoraView;
	@FXML
	private TextField textoCalculo;
	
	@FXML
	private Button button0;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	@FXML
	private Button button7;
	@FXML
	private Button button8;
	@FXML
	private Button button9;
	
	@FXML
	private Button buttonBorrarTodo;
	@FXML
	private Button buttonC;
	@FXML
	private Button buttonMultiplicar;
	@FXML
	private Button buttonDividir;
	@FXML
	private Button buttonRestar;
	@FXML
	private Button buttonSumar;
	@FXML
	private Button buttonCalcular;
	@FXML
	private Button buttonDecimal;
	
	private Calculadora calculadora = new Calculadora();
	
	public CalculadoraController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//bindings
		
		calculadora.pantallaProperty().bindBidirectional(textoCalculo.textProperty());
		calculadora.setpantalla("0.0"); /* esto es para que no aparezca vacío al principio y el programa
											acabe soltando una excepción al presionar las teclas de operaciones*/
	}
	
	@FXML
	public void NumberAccion(ActionEvent e){
		Button boton = (Button) e.getSource();
		calculadora.insertar(boton.getText().charAt(0));
	}
	
	@FXML
	public void BorrarAccion(ActionEvent e){
		Button boton = (Button) e.getSource();
		if(boton.getText().equals("CE")) {
			calculadora.borrarTodo();
		} else {
			calculadora.borrar();
		}
	}
	
	
	@FXML
	public void OperadorAccion(ActionEvent e){
		Button boton = (Button) e.getSource();
		if(boton.getText().equals("*")) {
			calculadora.operar(Calculadora.MULTIPLICAR);
		} else if (boton.getText().equals("/")){
			calculadora.operar(Calculadora.DIVIDIR);
		} else if (boton.getText().equals("+")){
			calculadora.operar(Calculadora.SUMAR);
		} else if (boton.getText().equals("-")){
			calculadora.operar(Calculadora.RESTAR);
		} else {
			calculadora.operar(Calculadora.IGUAL);
		}
	}
	
	@FXML
	public void PuntoAccion(ActionEvent e){
		if(!calculadora.getPantalla().contains(".")) {
			calculadora.insertarComa();
		}
	}
	
	public GridPane getView(){
		return calculadoraView;
	}
}

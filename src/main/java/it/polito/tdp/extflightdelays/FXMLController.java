/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController { // l'EntryPoint è già stato sistemato

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML // fx:id="distanzaMinima"
	private TextField distanzaMinima; // Value injected by FXMLLoader

	@FXML // fx:id="btnAnalizza"
	private Button btnAnalizza; // Value injected by FXMLLoader

	@FXML
	void doAnalizzaAeroporti(ActionEvent event) {

		txtResult.clear();
		
		if (distanzaMinima.getText().equals("")) {
			txtResult.appendText("Scrivere una distanza minima!");
			return;
		}
		int distanzaMin;
		
		try {
			distanzaMin = Integer.parseInt(distanzaMinima.getText());
		} catch (NumberFormatException nfe) {
			txtResult.setText("La distanza deve essere un numero!");
			return;
		}
		
		// Dopo aver verificato la distanza, faccio il grafo
		this.model.creaGrafo(distanzaMin);
		
		
		txtResult.appendText(String.format("Grafo creato!\n#Vertici %d\n#Archi %d", this.model.nVertici(),this.model.nArchi()));
		

		// TODO
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
	}

	public void setModel(Model model) {
		this.model = model;
	}
}

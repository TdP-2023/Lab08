/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Model;
import it.polito.tdp.extflightdelays.model.Rotta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

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
      	try {
    		double distance = Double.parseDouble(this.distanzaMinima.getText());
    		
    		/* Nella soluzione sono implementate due versioni del metodo creaGrafo. La prima
    		 * aggrega le rotte opposte di una stessa tratta (ad esempio A->B e B->A) direttamente nella query.
    		 * La seconda invece le legge dal db come entries separate di una lista, e vengono poi
    		 * aggregate nel codice per trovarne la distanza media.
    		 */
    		this.model.creaGrafo(distance); //versione dove le rotte sono aggregate nella quersy 
    		//this.model.creaGrafo2(distance); //versione dove le rotte sono aggregate nel codice
    		this.txtResult.setText("Grafo creato");
    		this.txtResult.appendText("Ci sono " + this.model.getNumberOfVertex() + " vertici.\n");
    		this.txtResult.appendText("Ci sono " + this.model.getNumberOfEdges() + " archi.\n\n");
    		
    		List<Rotta> archi = this.model.getArchi();
    		Collections.sort(archi);
    		for (Rotta r : archi) {
    			this.txtResult.appendText(r.getA1() + " <-> ");
    			this.txtResult.appendText(r.getA2() + " :  ");
    			this.txtResult.appendText(r.getAvgDistance() + "\n");
    		}
    		
    	} catch(NumberFormatException e) {
    		this.txtResult.setText("inserire un valore numerico");
    	}
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

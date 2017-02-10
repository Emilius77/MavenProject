/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa.controller;

import it.tss.clienti.jpa.service.ClienteManager;
import it.tss.clienti.jpa.entity.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javax.swing.table.TableColumn;

/**
 * FXML Controller class
 *
 * @author tss
 */
public class ClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tblClienti;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn ragSoc;
    @FXML
    private TableColumn ind;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("inizialize....");
        ObservableList<Cliente> elencoClienti = FXCollections.observableArrayList(ClienteManager.findAll());
        tblClienti.setItems(elencoClienti);
    }    
    
}

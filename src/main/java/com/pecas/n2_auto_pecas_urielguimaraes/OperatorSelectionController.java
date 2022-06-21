package com.pecas.n2_auto_pecas_urielguimaraes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OperatorSelectionController implements Initializable {

    @FXML
    Button painelOperadorVendasBtn;

    @FXML
    Button painelOperadorEstoqueBtn;

    public void painelOperadorVendasBtnOnAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperadorVendasMenu.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuOperadorVendas");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }

    }

    public void painelOperadorEstoqueBtnOnAction(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}

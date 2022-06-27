package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MenuComprasController {

    @FXML
    private Button efetuarCompra;

    @FXML
    private TextField TxtEstoque;

    @FXML
    private TextField TxtQuantidade;

    @FXML
    private ComboBox<Produto> CboxProduto;

    @FXML
    private ComboBox<OperadorVendas> CboxOperador;

    public void efetuarCompraOnAction(){
        System.out.println("here");
    }

}

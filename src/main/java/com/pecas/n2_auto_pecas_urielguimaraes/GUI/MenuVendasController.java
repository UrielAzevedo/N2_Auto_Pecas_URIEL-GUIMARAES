package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadoresVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoProduto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.events.Event;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuVendasController implements Initializable {

    DaoProduto daoProduto = new DaoProduto();
    DaoOperadoresVendas daoOperadoresVendas = new DaoOperadoresVendas();

    @FXML
    ComboBox<Produto> CboxProduto;

    @FXML
    ComboBox<OperadorVendas> CboxOperadorVendas;

    @FXML
    ListView<UnidadeProduto> lstViewUnidadesProduto;

    @FXML
    TextField TxtEstoque;

    @FXML
    TextField TxtQuantidade;

    @FXML
    TextField TxtTotal;

    @FXML
    Button BtnAdicionar;

    @FXML
    Button BtnRemover;

    @FXML
    Button BtnEfetuarCompra;

    public void BtnAdicionarOnAction () {

    }

    public void CboxProdutoOnAction () {
        if(CboxProduto.getValue() != null){
            TxtEstoque.setText(Integer.toString(CboxProduto.getValue().quantidadeEmEstoque()));
        }
    }

    public void BtnRemoverOnAction () {

    }

    public void BtnEfetuarCompraOnAction () {

    }

    public void atualizarLista () {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Produto> produtos = null;
        List<OperadorVendas> operadoresVendas = null;

        try{
            produtos = daoProduto.listar();
            operadoresVendas = daoOperadoresVendas.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Produto> listProdutos = FXCollections.observableArrayList(produtos);
        CboxProduto.setItems(listProdutos);

        ObservableList<OperadorVendas> listOperadoresVendas = FXCollections.observableArrayList(operadoresVendas);
        CboxOperadorVendas.setItems(listOperadoresVendas);

        CboxProduto.valueProperty().addListener(new ChangeListener<Produto>() {
            @Override
            public void changed(ObservableValue<? extends Produto> observableValue, Produto produto, Produto t1) {
                TxtEstoque.setText(Integer.toString(CboxProduto.getValue().quantidadeEmEstoque()));
            }
        });
    }
}

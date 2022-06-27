package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadoresVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoProduto;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoRecibos;
import com.pecas.n2_auto_pecas_urielguimaraes.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuComprasController implements Initializable {

    DaoProduto daoProduto = new DaoProduto();
    DaoOperadorEstoque daoOperadoresEstoque = new DaoOperadorEstoque();
    DaoRecibos daoRecibos = new DaoRecibos();
    List<UnidadeProduto> listUnidades = new ArrayList<UnidadeProduto>();

    @FXML
    ComboBox<Produto> CboxProduto;

    @FXML
    ComboBox<OperadorEstoque> CboxOperadorEstoque;

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

    public void BtnEfetuarCompraOnAction(){
        if(CboxOperadorEstoque.getValue() != null && listUnidades.size() > 0){
            Recibo recibo = new Recibo(listUnidades, CboxOperadorEstoque.getValue(), Double.parseDouble(TxtTotal.getText()), false);
            try{
                daoRecibos.gravar(recibo);
            } catch (Exception e){
                e.printStackTrace();
            }

            for(int i=0; i<listUnidades.size(); i++){
                try{
                    daoProduto.adicionarUnidades(listUnidades.get(i));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        zerarLista();
        atualizarLista();
    }

    public void BtnAdicionarOnAction () {

        try {
            Integer.parseInt(TxtQuantidade.getText());
            if(CboxProduto.getValue() == null || CboxOperadorEstoque.getValue() == null) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.show();
                return;
            }

            int quantidadeAdicionada = 0;

            for(int j=0; j<Integer.parseInt(TxtQuantidade.getText()); j++){

                UnidadeProduto unidadeProduto = new UnidadeProduto(CboxProduto.getValue());
                listUnidades.add(unidadeProduto);
            }

            atualizarLista();

        } catch (Exception e){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }


    }

    public void BtnRemoverOnAction () {

    }

    public void atualizarLista () {

        double total = 0;

        if(listUnidades.size() > 0){
            for(int i=0; i<listUnidades.size(); i++){
                total += listUnidades.get(i).getProduto().getPreco();
            }

        }

        TxtTotal.setText(Double.toString(total));

        ObservableList<UnidadeProduto> unidadesProdutosObv = FXCollections.observableArrayList(listUnidades);
        lstViewUnidadesProduto.setItems(unidadesProdutosObv);

        List<Produto> produtos = null;

        try{
            produtos = daoProduto.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Produto> listProdutos = FXCollections.observableArrayList(produtos);
        CboxProduto.setItems(listProdutos);
    }

    public void zerarLista () {
        listUnidades = new ArrayList<UnidadeProduto>();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Produto> produtos = null;
        List<OperadorEstoque> operadoresEstoque = null;

        try{
            produtos = daoProduto.listar();
            operadoresEstoque = daoOperadoresEstoque.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Produto> listProdutos = FXCollections.observableArrayList(produtos);
        CboxProduto.setItems(listProdutos);

        ObservableList<OperadorEstoque> listOperadoresEstoque = FXCollections.observableArrayList(operadoresEstoque);
        CboxOperadorEstoque.setItems(listOperadoresEstoque);

        CboxProduto.valueProperty().addListener(new ChangeListener<Produto>() {
            @Override
            public void changed(ObservableValue<? extends Produto> observableValue, Produto produto, Produto t1) {
                if(CboxProduto.getValue() != null) TxtEstoque.setText(Integer.toString(CboxProduto.getValue().quantidadeEmEstoque()));
            }
        });
    }
}

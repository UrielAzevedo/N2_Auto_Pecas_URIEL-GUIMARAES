package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadoresVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoProduto;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoRecibos;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Recibo;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;
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

public class MenuVendasController implements Initializable {

    DaoProduto daoProduto = new DaoProduto();
    DaoOperadoresVendas daoOperadoresVendas = new DaoOperadoresVendas();
    DaoRecibos daoRecibos = new DaoRecibos();
    List<UnidadeProduto> listUnidades = new ArrayList<UnidadeProduto>();

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

        try {
            Integer.parseInt(TxtQuantidade.getText());
            if(CboxProduto.getValue() == null || CboxProduto.getValue().quantidadeEmEstoque() < Integer.parseInt(TxtQuantidade.getText()) || CboxOperadorVendas.getValue() == null) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.show();
                return;
            }

            int quantidadeAdicionada = 0;

            for(int j=0; j<CboxProduto.getValue().quantidadeEmEstoque(); j++){
                for(int i=0; i< rc.size(); i++){
                    if(CboxProduto.getValue().getUnidadesProduto().get(j).getId() != listUnidades.get(i).getId() && quantidadeAdicionada < Integer.parseInt(TxtQuantidade.getText())){
                        listUnidades.add(CboxProduto.getValue().getUnidadesProduto().get(j));
                        quantidadeAdicionada++;
                    }
                }
            }

            atualizarLista();

        } catch (Exception e){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }


    }

    public void BtnRemoverOnAction () {
//        UnidadeProduto unidadeProduto = lstViewUnidadesProduto.getSelectionModel().getSelectedItem();
        if(lstViewUnidadesProduto.getSelectionModel().getSelectedItem() != null) listUnidades.remove(lstViewUnidadesProduto.getSelectionModel().getSelectedItem());
        atualizarLista();
    }

    public void BtnEfetuarCompraOnAction () {

        if(CboxOperadorVendas.getValue() != null && listUnidades.size() > 0){
            Recibo recibo = new Recibo(listUnidades, CboxOperadorVendas.getValue(), Double.parseDouble(TxtTotal.getText()), true);
            try{
                daoRecibos.gravar(recibo);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        zerarLista();
        atualizarLista();
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
                if(CboxProduto.getValue() != null) TxtEstoque.setText(Integer.toString(CboxProduto.getValue().quantidadeEmEstoque()));
            }
        });
    }
}

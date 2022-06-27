package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoRecibos;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Recibo;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuRelatorioVendas implements Initializable {

    DaoRecibos daoRecibos = new DaoRecibos();

    @FXML
    ListView<Recibo> LstViewReciboVenda;

    @FXML
    ListView<Recibo> LstViewReciboCompra;

    @FXML
    TextField TxtTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Recibo> recibos = new ArrayList<Recibo>();
        List<Recibo> recibosCompra = new ArrayList<Recibo>();
        List<Recibo> recibosVenda = new ArrayList<Recibo>();
        double totalValorVendas = 0;
        double totalValorCompras = 0;

        try{
            recibos = daoRecibos.listar();

            for(int i=0; i<recibos.size(); i++){
                if(recibos.get(i).isVenda()) {
                    recibosVenda.add(recibos.get(i));
                    totalValorVendas+= recibos.get(i).getValorTotal();
                }
                else {
                    recibosCompra.add(recibos.get(i));
                    totalValorCompras += recibos.get(i).getValorTotal();
                }
            }

            TxtTotal.setText(Double.toString(totalValorVendas - totalValorCompras));
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Recibo> recibosCompraObv = FXCollections.observableList(recibosCompra);
        LstViewReciboCompra.setItems(recibosCompraObv);

        ObservableList<Recibo> recibosVendaObv = FXCollections.observableList(recibosVenda);
        LstViewReciboVenda.setItems(recibosVendaObv);
    }
}

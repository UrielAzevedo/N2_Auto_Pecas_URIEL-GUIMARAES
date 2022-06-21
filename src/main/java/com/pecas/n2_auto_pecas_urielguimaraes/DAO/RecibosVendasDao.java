package com.pecas.n2_auto_pecas_urielguimaraes.DAO;

import com.pecas.n2_auto_pecas_urielguimaraes.model.ReciboVenda;

import java.util.ArrayList;
import java.util.List;

public class RecibosVendasDao {
    private static List<ReciboVenda> listaCompras = new ArrayList<ReciboVenda>();

    public void adicionarVenda(ReciboVenda reciboVenda){
        listaCompras.add(reciboVenda);
    }
}

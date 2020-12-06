package com.ufpr.pedinte.web.json;

import com.ufpr.pedinte.core.model.Cliente;
import com.ufpr.pedinte.core.model.ItemDoPedido;
import com.ufpr.pedinte.core.model.Pedido;
import com.ufpr.pedinte.core.model.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 09/11/2020
 */

public class PedidoJSON {

    private int id;
    private Date data;
    private Cliente cliente;
    private List<ItemDoPedido> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }

    public static List<PedidoJSON> map(List<Pedido> json) {
        List<PedidoJSON> result = new ArrayList<>();
        for(Pedido each : json) {
            result.add(map(each));
        }
        return result;
    }

    public static PedidoJSON map(Pedido pedido) {
        PedidoJSON result = new PedidoJSON();
        result.setData(pedido.getData());
        result.setItens(pedido.getItens());
        result.setId(pedido.getId());
        result.setCliente(pedido.getCliente());
        return result;
    }

    public static Pedido map(PedidoJSON json) {
        Pedido result = new Pedido();
        result.setData(json.getData());
        result.setItens(json.getItens());
        result.setId(json.getId());
        result.setCliente(json.getCliente());
        return result;
    }
}

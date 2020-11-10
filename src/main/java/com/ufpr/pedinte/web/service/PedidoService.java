package com.ufpr.pedinte.web.service;

import com.ufpr.pedinte.core.dao.PedidoDAO;
import com.ufpr.pedinte.core.model.ItemDoPedido;
import com.ufpr.pedinte.core.model.Pedido;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 24/10/2020
 */

@Service
public class PedidoService {

    PedidoDAO dao = new PedidoDAO();

//    public List<Pedido> findAll() throws SQLException {
//        System.out.println("Buscando todos os Pedidos do CORE.");
//        return dao.fetchAll();
//    }

    public Pedido findById(int id) {
        return null;
    }

    public List<ItemDoPedido> findByClient(int cpf) throws SQLException {
        return dao.findItensDoCliente(cpf);
    }

    public void create(Pedido pedido) throws SQLException {
        dao.createPedido(pedido.getCliente().getId());
    }
}

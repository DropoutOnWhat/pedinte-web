package com.ufpr.pedinte.web.implementation;

import com.ufpr.pedinte.core.dao.PedidoDAO;
import com.ufpr.pedinte.core.model.Pedido;
import com.ufpr.pedinte.web.service.PedidoService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 24/10/2020
 */

@Service
public class PedidoServiceImp implements PedidoService {

    PedidoDAO dao = new PedidoDAO();

    public List<Pedido> findAll() throws SQLException {
        System.out.println("Buscando todos os Pedidos do CORE.");
        return dao.fetchAll();
    }

    public Pedido findById(int id) throws SQLException {
        System.out.println("Procurando Pedido com ID = " + id + " no CORE.");
        return dao.find(id);
    }

    public void create(Pedido pedido) throws SQLException {
        System.out.println("Criando novo pedido no CORE.");
        dao.createPedido(pedido);
    }

    public void update(Pedido pedido) throws SQLException {
        System.out.println("Atualizando pedido com ID = " + pedido.getId() + " no CORE.");
        dao.updatePedido(pedido);
    }

    public void delete(int id) throws SQLException {
        System.out.println("Removendo pedido com ID = " + id + " no CORE.");
        Pedido pedido = new Pedido();
        pedido.setId(id);
        dao.deletePedido(pedido);
    }
}

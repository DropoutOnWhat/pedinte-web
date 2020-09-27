package com.ufpr.pedinte.web.service;

import com.ufpr.pedinte.core.dao.ClienteDAO;
import com.ufpr.pedinte.core.model.Cliente;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 27/09/2020
 */

@Service
public class ClienteService {

    ClienteDAO dao = new ClienteDAO();

    public List<Cliente> findAll() throws SQLException {
        System.out.println("Buscando todos os Clientes do CORE.");
        return dao.fetchAll();
    }

    public Cliente findById(int id) throws SQLException {
        System.out.println("Procurando Cliente com ID = " + id + " no CORE.");
        return dao.find(id);
    }

    public boolean create(Cliente cliente) throws SQLException {
        System.out.println("Criando novo cliente no CORE.");
        return dao.createCliente(cliente);
    }

    public boolean update(Cliente cliente) throws SQLException {
        System.out.println("Atualizando cliente com ID = " + cliente.getId() + " no CORE.");
        return dao.updateCliente(cliente);
    }

    public boolean delete(int id) throws SQLException {
        System.out.println("Removendo cliente com ID = " + id + " no CORE.");
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return dao.removeCliente(cliente);
    }
}

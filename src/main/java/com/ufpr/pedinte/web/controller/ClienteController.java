package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Cliente;
import com.ufpr.pedinte.web.json.ClienteJSON;
import com.ufpr.pedinte.web.json.ResponseJSON;
import com.ufpr.pedinte.web.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 27/09/2020
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    ClienteService clienteService;

    @GetMapping("/")
    public List<ClienteJSON> findAll() {
        List<Cliente> result = new ArrayList<>();
        try {
            clienteService = new ClienteService();
            result = clienteService.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ClienteJSON.map(result);
    }

    @GetMapping("/{id}")
    public ClienteJSON findById(@PathVariable(value="id") int id) {
        Cliente result = null;
        try {
            clienteService = new ClienteService();
            result = clienteService.findById(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ClienteJSON.map(result);
    }

    @PostMapping
    public void createCliente(@RequestBody ClienteJSON json) throws SQLException {
        boolean success = false;
        try {
            clienteService = new ClienteService();
            Cliente cliente = ClienteJSON.map(json);
            success = clienteService.create(cliente);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @PutMapping
    public void updateCliente(@RequestBody ClienteJSON json) {
        try {
            clienteService = new ClienteService();
            Cliente cliente = ClienteJSON.map(json);
            clienteService.update(cliente);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable(value="id") int id) {
        try {
            clienteService = new ClienteService();
            clienteService.delete(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

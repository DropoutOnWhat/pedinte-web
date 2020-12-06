package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Produto;
import com.ufpr.pedinte.web.json.ProdutoJSON;
import com.ufpr.pedinte.web.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 07/09/2020
 */

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/")
    public List<ProdutoJSON> findAll() throws SQLException {
        List<Produto> result = new ArrayList<>();
        try {
            result = service.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ProdutoJSON.map(result);
    }

    @GetMapping("/{id}")
    public ProdutoJSON findById(@PathVariable(value="id") int id) {
        Produto result = null;
        try {
            result = service.findById(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ProdutoJSON.map(result);
    }

    @PostMapping
    public void createProduct(@RequestBody ProdutoJSON json) throws SQLException {
        boolean success = false;
        try {
            Produto produto = ProdutoJSON.map(json);
            success = service.create(produto);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody ProdutoJSON json, @PathVariable(value="id") int id) {
        try {
            Produto produto = ProdutoJSON.map(json);
            service.update(produto);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value="id") int id) {
        try {
            service.delete(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
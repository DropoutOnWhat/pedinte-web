package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Produto;
import com.ufpr.pedinte.web.json.ProdutoJSON;
import com.ufpr.pedinte.web.json.ResponseJSON;
import com.ufpr.pedinte.web.service.ProdutoService;
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

    ProdutoService produtoService;

    @GetMapping("/")
    public ResponseJSON findAll() {
        List<Produto> result = new ArrayList<>();
        try {
            produtoService = new ProdutoService();
            result = produtoService.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ProdutoJSON.map(result);
    }

    @GetMapping("/{id}")
    public ResponseJSON findById(@PathVariable(value="id") int id) {
        Produto result = null;
        try {
            produtoService = new ProdutoService();
            result = produtoService.findById(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ProdutoJSON.map(result);
    }

    @PostMapping
    public void createProduct(@RequestBody ProdutoJSON json) throws SQLException {
        boolean success = false;
        try {
            produtoService = new ProdutoService();
            Produto produto = ProdutoJSON.map(json);
            success = produtoService.create(produto);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @PutMapping
    public void updateProduct(@RequestBody ProdutoJSON json) {
        try {
            produtoService = new ProdutoService();
            Produto produto = ProdutoJSON.map(json);
            produtoService.update(produto);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value="id") int id) {
        try {
            produtoService = new ProdutoService();
            produtoService.delete(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
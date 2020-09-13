package com.ufpr.pedintespring.controller;

import com.ufpr.pedintespring.json.ProdutoJSON;
import com.ufpr.pedintespring.service.ProdutoService;
import model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ProdutoJSON> findAll() {
        System.out.println("Procurando todos os produtos de pedinte-core");
        List<Produto> result = new ArrayList<>();
        try {
            produtoService = new ProdutoService();
            result = produtoService.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ProdutoJSON.map(result);
    }


    public ProdutoJSON findById(Long id) {
        return null;
    }

    public void createProduct(ProdutoJSON produto) {

    }

    public void updateProduct(ProdutoJSON produto) {

    }
}

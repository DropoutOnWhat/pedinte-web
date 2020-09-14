package com.ufpr.pedinte.web.json;

import com.ufpr.pedinte.core.model.Produto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 07/09/2020
 */

public class ProdutoJSON {

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static ResponseJSON map(List<Produto> produtos) {
        ResponseJSON response = new ResponseJSON();
        if(produtos.isEmpty()) {
            response.setStatus(400);
            response.setMessage("Nenhum Produto encontrado.");
            System.out.println(response.getMessage());
        } else {
            System.out.println("Mapeando resposta do CORE: Produto para JSON.");
            response.setStatus(200);
            response.setMessage("Produtos encontrados estão no content.");
            List<ProdutoJSON> result = new ArrayList<>();
            for(Produto each : produtos) {
                ProdutoJSON json = new ProdutoJSON();
                json.setId(each.getId());
                json.setDescricao(each.getDescricao());
                result.add(json);
            }
            response.setContent(result);
        }
        return response;
    }

    public static ResponseJSON map(Produto produto) {
        ResponseJSON response = new ResponseJSON();
        if(produto == null || produto.getId() == 0) {
            response.setStatus(400);
            response.setMessage("Nenhum Produto encontrado.");
            System.out.println(response.getMessage());
        } else {
            System.out.println("Mapeando resposta do CORE: Protudo para JSON.");
            response.setStatus(200);
            response.setMessage("Produtos encontrados estão no content.");
            ProdutoJSON json = new ProdutoJSON();
            json.setId(produto.getId());
            json.setDescricao(produto.getDescricao());
            response.setContent(json);
        }
        return response;
    }

    public static Produto map(ProdutoJSON json) {
        if(StringUtils.isEmpty(json.getDescricao())) {
            System.out.println("Objeto incompleto detectado, cancelando requisição.");
            return null;
        } else {
            System.out.println("Mapeando requisição do CLIENTE: JSON para Produto.");
            Produto produto = new Produto();
            produto.setId(json.getId());
            produto.setDescricao(json.getDescricao());
            return produto;
        }
    }
}

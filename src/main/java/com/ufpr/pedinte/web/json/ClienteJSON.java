package com.ufpr.pedinte.web.json;

import com.ufpr.pedinte.core.model.Cliente;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 27/09/2020
 */

public class ClienteJSON {

    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static List<ClienteJSON> map(List<Cliente> clientes) {
        System.out.println("Mapeando resposta do CORE: Cliente para JSON.");
        List<ClienteJSON> response = new ArrayList<>();
        for(Cliente each : clientes) {
            response.add(map(each));
        }
        return response;
    }

    public static ClienteJSON map(Cliente cliente) {
        ClienteJSON response = new ClienteJSON();
        if (cliente != null) {
            response.setId(cliente.getId());
            response.setNome(cliente.getNome());
            response.setSobrenome(cliente.getSobrenome());
            response.setCpf(cliente.getCpf());
        }
        return response;
    }

    public static Cliente map(ClienteJSON json) {
        if(StringUtils.isEmpty(json.getCpf())) {
            System.out.println("Objeto incompleto detectado, cancelando requisição.");
            return null;
        } else {
            System.out.println("Mapeando requisição do CLIENTE: JSON para Cliente.");
            Cliente cliente = new Cliente();
            cliente.setId(json.getId());
            cliente.setCpf(json.getCpf());
            cliente.setNome(json.getNome());
            cliente.setSobrenome(json.getSobrenome());
            return cliente;
        }
    }
}

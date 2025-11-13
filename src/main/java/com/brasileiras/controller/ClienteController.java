package com.brasileiras.controller;

import com.brasileiras.model.Cliente;
import com.brasileiras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Serviço REST para manutenção de Clientes/Usuários (RF05).
 * Endpoints: /api/clientes
 * @Autor: Andreza da Silva Dantas
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // POST - Cadastra um novo cliente/usuário
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        // Lógica de validação de CPF/Email seria adicionada aqui (RNF01)
        return clienteRepository.save(cliente);
    }

    // GET - Busca todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    
    // GET por ID - Busca um cliente específico
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
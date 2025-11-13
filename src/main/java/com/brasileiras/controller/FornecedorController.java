package com.brasileiras.controller;

import com.brasileiras.model.Fornecedor;
import com.brasileiras.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Serviço REST para manutenção de Fornecedores (CRUD Básico).
 * Endpoints: /api/fornecedores
 * @Autor: Andreza da Silva Dantas
 */
@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    // Injeta o repositório para acesso ao banco de dados
    @Autowired
    private FornecedorRepository fornecedorRepository;

    // GET - Busca todos os fornecedores
    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    // POST - Cadastra um novo fornecedor
    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // GET por ID - Busca um fornecedor específico
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
        return fornecedorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Atualiza um fornecedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedorDetails) {
        return fornecedorRepository.findById(id)
                .map(fornecedor -> {
                    fornecedor.setRazaoSocial(fornecedorDetails.getRazaoSocial());
                    fornecedor.setCnpj(fornecedorDetails.getCnpj());
                    fornecedor.setTelefone(fornecedorDetails.getTelefone());
                    Fornecedor updatedFornecedor = fornecedorRepository.save(fornecedor);
                    return ResponseEntity.ok(updatedFornecedor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Deleta um fornecedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        if (fornecedorRepository.existsById(id)) {
            fornecedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
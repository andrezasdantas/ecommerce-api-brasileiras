package com.brasileiras.controller;

import com.brasileiras.model.Produto;
import com.brasileiras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Serviço REST para manutenção de Produtos e Estoque (RF17, RF18).
 * Endpoints: /api/produtos
 * @Autor: Andreza da Silva Dantas
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // GET - Busca todos os produtos (Catálogo - RF01)
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // POST - Cadastra um novo produto (Entrada no Estoque/Cadastro - RF17)
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        // Lógica para garantir que o valor de venda seja maior que o de compra
        return produtoRepository.save(produto);
    }

    // PUT - Atualiza o estoque ou preço de venda
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setEstoque(produtoDetails.getEstoque());
                    produto.setValorVenda(produtoDetails.getValorVenda());
                    // ...outros campos relevantes para atualização
                    Produto updatedProduto = produtoRepository.save(produto);
                    return ResponseEntity.ok(updatedProduto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Nota: A lógica de baixa de estoque (RF18) ocorreria em um serviço de Vendas,
    // que não está implementado neste Controller.
}
package com.brasileiras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade para Produto - Refere-se aos requisitos RF17 e RF18.
 * @Autor: Andreza da Silva Dantas
 */
@Entity
@Data
@NoArgsConstructor
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoProduto; // Código do produto da NF (RF17)
    private String descricao;
    private String codigoBarras;
    private double valorCompra;
    
    private double valorVenda;
    private int estoque; // RF17
    
    // Em um sistema real, haveria um relacionamento @ManyToOne com Fornecedor.
}
package com.brasileiras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de Exemplo para Fornecedor. Representa a tabela no banco de dados.
 * @Autor: Andreza da Silva Dantas
 */
@Entity
@Data
@NoArgsConstructor
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;
    private String cnpj;
    private String telefone;
}
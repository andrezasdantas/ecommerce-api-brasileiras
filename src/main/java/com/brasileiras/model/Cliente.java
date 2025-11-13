package com.brasileiras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade para Cliente (Usuário) - Refere-se aos requisitos RF05 e RF06.
 * @Autor: Andreza da Silva Dantas
 */
@Entity
@Data
@NoArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    // Em um sistema real, haveria um relacionamento @OneToMany com a Entidade Endereco.
}
package com.brasileiras.repository;

import com.brasileiras.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Cliente.
 * @Autor: Andreza da Silva Dantas
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
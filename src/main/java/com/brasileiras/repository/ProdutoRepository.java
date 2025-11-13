package com.brasileiras.repository;

import com.brasileiras.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Produto.
 * @Autor: Andreza da Silva Dantas
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
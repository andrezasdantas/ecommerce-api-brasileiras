package com.brasileiras.repository;

import com.brasileiras.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Fornecedor.
 * Estende JpaRepository para fornecer operações CRUD padrão.
 * @Autor: Andreza da Silva Dantas
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    // Métodos personalizados de busca, se necessário, seriam adicionados aqui.
    // Exemplo: Optional<Fornecedor> findByCnpj(String cnpj);
}
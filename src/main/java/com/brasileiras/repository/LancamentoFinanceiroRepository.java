package com.brasileiras.repository;

import com.brasileiras.model.LancamentoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade LancamentoFinanceiro (Contas a Pagar/Receber).
 * @Autor: Andreza da Silva Dantas
 */
@Repository
public interface LancamentoFinanceiroRepository extends JpaRepository<LancamentoFinanceiro, Long> {
}
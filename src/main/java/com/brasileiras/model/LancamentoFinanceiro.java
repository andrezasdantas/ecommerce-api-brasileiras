package com.brasileiras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidade para Lançamentos Financeiros (Contas a Pagar/Receber) - Refere-se aos requisitos RF12, RF13, RF14 e RF15.
 * @Autor: Andreza da Silva Dantas
 */
@Entity
@Data
@NoArgsConstructor
public class LancamentoFinanceiro {
    
    public enum TipoLancamento {
        CONTAS_A_PAGAR, CONTAS_A_RECEBER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoLancamento tipo; // CP ou CR
    private double valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento; // Data para pagamento/recebimento
    private String descricao;
}
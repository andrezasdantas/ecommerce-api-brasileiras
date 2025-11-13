package com.brasileiras.controller;

import com.brasileiras.model.LancamentoFinanceiro;
import com.brasileiras.repository.LancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Serviço REST para lançamentos Financeiros (Contas a Pagar/Receber - RF14, RF15).
 * Endpoints: /api/financeiro
 * @Autor: Andreza da Silva Dantas
 */
@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private LancamentoFinanceiroRepository lancamentoRepository;

    // GET - Busca todos os lançamentos
    @GetMapping
    public List<LancamentoFinanceiro> getAllLancamentos() {
        return lancamentoRepository.findAll();
    }

    // POST - Simula a criação de um Contas a Pagar ao dar entrada em uma NF (RF14, RF15)
    @PostMapping("/contas-a-pagar")
    public LancamentoFinanceiro simularContasAPagar(@RequestBody LancamentoFinanceiro lancamento) {
        // Validação obrigatória de regra de negócio: Data de pagamento 30 dias após a emissão.
        if (lancamento.getDataEmissao() != null) {
            lancamento.setDataVencimento(lancamento.getDataEmissao().plusDays(30)); // RF15
        } else {
            // Se a data de emissão não vier, usa a data atual como base
            lancamento.setDataEmissao(LocalDate.now());
            lancamento.setDataVencimento(LocalDate.now().plusDays(30)); 
        }

        lancamento.setTipo(LancamentoFinanceiro.TipoLancamento.CONTAS_A_PAGAR); // RF14
        lancamento.setDescricao("Compra de Mercadoria - NF: " + lancamento.getDescricao());
        
        return lancamentoRepository.save(lancamento);
    }

    // Nota: O lançamento de Contas a Receber (RF12, RF13) seria feito por um Controller de Vendas/Checkout.
}
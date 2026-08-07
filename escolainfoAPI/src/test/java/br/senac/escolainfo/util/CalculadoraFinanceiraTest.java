package br.senac.escolainfo.util;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraFinanceiraTest {

    // ===============================
    // TESTES DO MÉTODO calcularDesconto()
    // ===============================

    @Test
    @DisplayName("CT01 - Desconto de 10%")
    void deveCalcularDesconto10PorCento() {

        BigDecimal resultado =
                CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("1000.00"), 10);

        assertEquals(new BigDecimal("900.00"), resultado);
    }

    @Test
    @DisplayName("CT02 - Desconto de 20%")
    void deveCalcularDesconto20PorCento() {

        BigDecimal resultado =
                CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("500.00"), 20);

        assertEquals(new BigDecimal("400.00"), resultado);
    }

    @Test
    @DisplayName("CT03 - Desconto de 0%")
    void deveCalcularDescontoZero() {

        BigDecimal resultado =
                CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("750.00"), 0);

        assertEquals(new BigDecimal("750.00"), resultado);
    }

    @Test
    @DisplayName("CT04 - Desconto de 100%")
    void deveCalcularDescontoTotal() {

        BigDecimal resultado =
                CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("350.00"), 100);

        assertEquals(new BigDecimal("0.00"), resultado);
    }

    @Test
    @DisplayName("CT05 - Percentual negativo")
    void naoDeveAceitarPercentualNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("100.00"), -5));
    }

    @Test
    @DisplayName("CT06 - Percentual acima de 100")
    void naoDeveAceitarPercentualMaiorQue100() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFinanceira.calcularDesconto(
                        new BigDecimal("100.00"), 150));
    }

    @Test
    @DisplayName("CT07 - Valor nulo")
    void naoDeveAceitarValorNulo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFinanceira.calcularDesconto(
                        null, 10));
    }

    // ===============================
    // TESTES DO MÉTODO pagamentoQuitado()
    // ===============================

    @Test
    @DisplayName("CT08 - Pagamento quitado")
    void pagamentoQuitado() {

        assertTrue(
                CalculadoraFinanceira.pagamentoQuitado(
                        new BigDecimal("1000.00"),
                        new BigDecimal("1000.00")));
    }

    @Test
    @DisplayName("CT09 - Pagamento maior que o valor")
    void pagamentoMaiorQueValor() {

        assertTrue(
                CalculadoraFinanceira.pagamentoQuitado(
                        new BigDecimal("1200.00"),
                        new BigDecimal("1000.00")));
    }

    @Test
    @DisplayName("CT10 - Pagamento parcial")
    void pagamentoParcial() {

        assertFalse(
                CalculadoraFinanceira.pagamentoQuitado(
                        new BigDecimal("800.00"),
                        new BigDecimal("1000.00")));
    }

    // ===============================
    // TESTES DO MÉTODO calcularSaldo()
    // ===============================

    @Test
    @DisplayName("CT11 - Saldo restante")
    void deveCalcularSaldoRestante() {

        BigDecimal saldo =
                CalculadoraFinanceira.calcularSaldo(
                        new BigDecimal("700.00"),
                        new BigDecimal("1000.00"));

        assertEquals(new BigDecimal("300.00"), saldo);
    }

    @Test
    @DisplayName("CT12 - Saldo zerado")
    void saldoZero() {

        BigDecimal saldo =
                CalculadoraFinanceira.calcularSaldo(
                        new BigDecimal("1000.00"),
                        new BigDecimal("1000.00"));

        assertEquals(new BigDecimal("0.00"), saldo);
    }

    @Test
    @DisplayName("CT13 - Saldo com valor pago nulo")
    void saldoValorPagoNulo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFinanceira.calcularSaldo(
                        null,
                        new BigDecimal("1000.00")));
    }

    @Test
    @DisplayName("CT14 - Saldo com valor do curso nulo")
    void saldoValorCursoNulo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFinanceira.calcularSaldo(
                        new BigDecimal("1000.00"),
                        null));
    }

}
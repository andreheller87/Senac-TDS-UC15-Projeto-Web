package br.senac.escolainfo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraFinanceira {

    public static BigDecimal calcularDesconto(BigDecimal valor, double percentual) {

        if (valor == null) {
            throw new IllegalArgumentException("O valor não pode ser nulo.");
        }

        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException(
                    "O percentual deve estar entre 0 e 100.");
        }

        BigDecimal desconto = valor.multiply(
                BigDecimal.valueOf(percentual))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return valor.subtract(desconto);
    }

    /**
     * Verifica se um pagamento está quitado.
     */
    public static boolean pagamentoQuitado(BigDecimal valorPago,
                                           BigDecimal valorCurso) {

        if (valorPago == null || valorCurso == null) {
            throw new IllegalArgumentException("Valores inválidos.");
        }

        return valorPago.compareTo(valorCurso) >= 0;
    }

    /**
     * Calcula o valor restante.
     */
    public static BigDecimal calcularSaldo(BigDecimal valorPago,
                                           BigDecimal valorCurso) {

        if (valorPago == null || valorCurso == null) {
            throw new IllegalArgumentException("Valores inválidos.");
        }

        return valorCurso.subtract(valorPago);
    }

}
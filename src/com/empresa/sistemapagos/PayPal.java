package com.empresa.sistemapagos;

/*
Pasos a seguir
1. Crear PayPal que también EXTIENDE MetodoPago.
2. Implementar realizarPago() con una comisión del 2%.
3. La comisión se calcula como monto * 0.02.
4. El total a descontar es monto + comisión.
5. Valido saldo suficiente antes de descontar.
*/

// Método de pago PayPal (con comisión del 2% por transacción)
public class PayPal extends MetodoPago {

    // Comisión del 2% (constante para hacer el cálculo)
    private static final double COMISION_PORCENTAJE = 0.02;

    public PayPal(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void realizarPago(double monto) {
        if (monto <= 0) {
            System.out.println("[PayPal] Monto inválido (debe ser positivo). No se hace el pago.");
            return;
        }

        double comision = monto * COMISION_PORCENTAJE; // 2% del monto
        double total = monto + comision;               // total a descontar del saldo

        if (saldoDisponible >= total) {
            saldoDisponible -= total;
            System.out.println("[PayPal] Pago: $" + monto + " | Comisión 2%: $" + comision +
                    " | Total descontado: $" + total + " | Saldo restante: $" + saldoDisponible);
        } else {
            System.out.println("[PayPal] Error: saldo insuficiente. Saldo: $" + saldoDisponible +
                    " | Total requerido (monto+comisión): $" + total);
        }
    }
}
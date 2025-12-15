package com.empresa.sistemapagos;

/*
Pasos a seguir
1. Crear TransferenciaBancaria que EXTIENDE MetodoPago.
2. Implementar realizarPago() con comisión fija de $5 por transacción.
3. El total a descontar es monto + 5.
4. Valido saldo suficiente antes de descontar.
*/

// Método de pago Transferencia Bancaria (comisión fija de $5)
public class TransferenciaBancaria extends MetodoPago {

    // Comisión fija de 5 dólares por cada transferencia
    private static final double COMISION_FIJA = 5.0;

    public TransferenciaBancaria(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void realizarPago(double monto) {
        if (monto <= 0) {
            System.out.println("[Transferencia] Monto inválido (debe ser positivo). No se hace el pago.");
            return;
        }

        double total = monto + COMISION_FIJA; // monto + comisión fija

        if (saldoDisponible >= total) {
            saldoDisponible -= total;
            System.out.println("[Transferencia] Pago: $" + monto + " | Comisión fija: $" + COMISION_FIJA +
                    " | Total descontado: $" + total + " | Saldo restante: $" + saldoDisponible);
        } else {
            System.out.println("[Transferencia] Error: saldo insuficiente. Saldo: $" + saldoDisponible +
                    " | Total requerido (monto+comisión): $" + total);
        }
    }
}
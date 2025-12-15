package com.empresa.sistemapagos;

/*
Pasos a seguir
1. Crear TarjetaCredito que EXTIENDE MetodoPago porque comparte el saldo y el reembolso.
2. Implementar realizarPago() restando del saldo (sin comisiones).
3. Antes de restar, verifico si hay saldo suficiente (saldo >= monto).
4. consola para entender qué pasó.
*/

// Método de pago tipo Tarjeta de Crédito (sin comisión adicional, solo valida saldo)
public class TarjetaCredito extends MetodoPago {

    // Constructor: recibe el saldo inicial y se lo pasa a la clase padre (MetodoPago)
    public TarjetaCredito(double saldoInicial) {
        super(saldoInicial);
    }

    // Implementación del pago: valida saldo y resta el monto
    @Override
    public void realizarPago(double monto) {
        if (monto <= 0) {
            System.out.println("[Tarjeta] Monto inválido (debe ser positivo). No se hace el pago.");
            return;
        }

        if (saldoDisponible >= monto) {
            saldoDisponible -= monto; // restamos del saldo
            System.out.println("[Tarjeta] Pago realizado: $" + monto + " | Saldo restante: $" + saldoDisponible);
        } else {
            System.out.println("[Tarjeta] Error: saldo insuficiente. Saldo: $" + saldoDisponible + " | Monto: $" + monto);
        }
    }
}
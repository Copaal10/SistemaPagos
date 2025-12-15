package com.empresa.sistemapagos;

/*
pasos
1. Crear una clase abstracta llamada MetodoPago que implementa la interfaz Pago.
2. Pongo un atributo común: saldoDisponible (double), porque todos los métodos de pago tienen saldo.
3. Implemento reembolsarPago() aquí, porque el reembolso siempre suma al saldo.
4. Dejo realizarPago() como abstracto, porque cada método de pago calcula distinto (comisiones, validaciones).
*/

// Clase abstracta que comparte lógica común entre distintos métodos de pago
public abstract class MetodoPago implements Pago {

    // Atributo común: saldo disponible para realizar operaciones
    protected double saldoDisponible;

    // Constructor para inicializar el saldo al crear el método de pago
    public MetodoPago(double saldoInicial) {
        this.saldoDisponible = saldoInicial;
    }

    // Getter para consultar el saldo (útil para imprimir y verificar)
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Implementación común del reembolso: sumar al saldo
    @Override
    public void reembolsarPago(double monto) {
        // Validación simple: si el monto es positivo, lo sumo al saldo
        if (monto > 0) {
            saldoDisponible += monto;
            System.out.println("[Reembolso] Se reembolsó: $" + monto + " | Nuevo saldo: $" + saldoDisponible);
        } else {
            System.out.println("[Reembolso] Monto inválido (debe ser positivo). No se hizo nada.");
        }
    }

    // Método abstracto: cada subclase debe definir cómo se realiza el pago
    @Override
    public abstract void realizarPago(double monto);
}
package com.empresa.sistemapagos;

/*
Pasos  a seguir, crear una interfaz
1. Crear una interfaz llamada Pago porque el taller pide un "contrato" común.
2. La interfaz define los métodos que todos los pagos deben tener.
3. No pongo lógica aquí, solo las firmas de métodos (qué reciben y qué devuelven).
*/

// Interfaz que define el contrato de cualquier método de pago
public interface Pago {
    // Método para realizar un pago. Recibe un monto y no devuelve nada.
    void realizarPago(double monto);

    // Método para reembolsar (devolver) un pago. Aumenta el saldo en implementaciones concretas.
    void reembolsarPago(double monto);
}
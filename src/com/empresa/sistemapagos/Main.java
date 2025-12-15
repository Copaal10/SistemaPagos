package com.empresa.sistemapagos;

/*
Pasos
1. En el método main, creo instancias de TarjetaCredito, PayPal y TransferenciaBancaria con distintos saldos.
2. Realizo varios pagos (con montos diferentes) para probar validaciones y comisiones.
3. Hago reembolsos para ver cómo aumenta el saldo.
4. Imprimo el saldo después de cada operación para entender qué pasó.
5. Mantengo el código sencillo y secuencial, sin funciones avanzadas ni colecciones complejas.
*/

public class Main {
    public static void main(String[] args) {
        // Creo los métodos de pago con distintos saldos iniciales
        TarjetaCredito tarjeta = new TarjetaCredito(300.0);       // saldo $300
        PayPal paypal = new PayPal(200.0);                         // saldo $200
        TransferenciaBancaria transfer = new TransferenciaBancaria(100.0); // saldo $100

        // Muestro saldos iniciales
        System.out.println("Saldo inicial [Tarjeta]: $" + tarjeta.getSaldoDisponible());
        System.out.println("Saldo inicial [PayPal]: $" + paypal.getSaldoDisponible());
        System.out.println("Saldo inicial [Transferencia]: $" + transfer.getSaldoDisponible());
        System.out.println("-----------------------------------------------------------");

        // PRUEBAS DE PAGO
        tarjeta.realizarPago(120.0);   // debería restar 120 si hay saldo
        paypal.realizarPago(50.0);     // restará monto + 2% comisión
        transfer.realizarPago(20.0);   // restará monto + $5 comisión fija

        System.out.println("Saldo tras pagos [Tarjeta]: $" + tarjeta.getSaldoDisponible());
        System.out.println("Saldo tras pagos [PayPal]: $" + paypal.getSaldoDisponible());
        System.out.println("Saldo tras pagos [Transferencia]: $" + transfer.getSaldoDisponible());
        System.out.println("-----------------------------------------------------------");

        // PRUEBAS DE SALDO INSUFICIENTE
        tarjeta.realizarPago(1000.0);  // debería marcar error (no alcanza)
        paypal.realizarPago(-10.0);    // monto inválido (negativo)
        transfer.realizarPago(200.0);  // debería marcar error (no alcanza)

        System.out.println("Saldo tras intentos inválidos [Tarjeta]: $" + tarjeta.getSaldoDisponible());
        System.out.println("Saldo tras intentos inválidos [PayPal]: $" + paypal.getSaldoDisponible());
        System.out.println("Saldo tras intentos inválidos [Transferencia]: $" + transfer.getSaldoDisponible());
        System.out.println("-----------------------------------------------------------");

        // REEMBOLSOS
        tarjeta.reembolsarPago(50.0);  // suma al saldo
        paypal.reembolsarPago(30.0);   // suma al saldo
        transfer.reembolsarPago(10.0); // suma al saldo

        System.out.println("Saldo final [Tarjeta]: $" + tarjeta.getSaldoDisponible());
        System.out.println("Saldo final [PayPal]: $" + paypal.getSaldoDisponible());
        System.out.println("Saldo final [Transferencia]: $" + transfer.getSaldoDisponible());
    }
}
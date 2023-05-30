package org.example;

import org.example.controlador.ControladorSmartphone;
import org.example.vista.Ventana;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ventana ventana = new Ventana("Smartphones");
        ControladorSmartphone controlador = new ControladorSmartphone(ventana);
    }
}
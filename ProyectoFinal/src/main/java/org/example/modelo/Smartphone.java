package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Smartphone {
    private int id;
    private String marca;
    private String Modelo;
    private int nucleosCpu;
    private String sistemOp;
    private String imagen;

    public Smartphone() {
    }

    public Smartphone(int id, String marca, String modelo, int nucleosCpu, String sistemOp, String imagen) {
        this.id = id;
        this.marca = marca;
        Modelo = modelo;
        this.nucleosCpu = nucleosCpu;
        this.sistemOp = sistemOp;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getNucleosCpu() {
        return nucleosCpu;
    }

    public void setNucleosCpu(int nucleosCpu) {
        this.nucleosCpu = nucleosCpu;
    }

    public String getSistemOp() {
        return sistemOp;
    }

    public void setSistemOp(String sistemOp) {
        this.sistemOp = sistemOp;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Smarthphone{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", nucleosCpu=" + nucleosCpu +
                ", sistemOp='" + sistemOp + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    public ImageIcon getFoto() throws MalformedURLException {
        URL urlFoto = new URL(this.imagen);
        return new ImageIcon(urlFoto);
    }
}

package com.example.viper2.municipioapp;

/**
 * Created by Viper on 29/03/2017.
 */

public class Lista_Entrada {

    //privadas para protejer los atributos
    private int idImagen;
    private String nombre, descrip, direcc;

    //constructor

    public Lista_Entrada(int idImagen, String nombre, String descrip, String direcc) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.direcc = direcc;
    }

    // los metodos que configuran los atributos se llaman getters o setters

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }
}

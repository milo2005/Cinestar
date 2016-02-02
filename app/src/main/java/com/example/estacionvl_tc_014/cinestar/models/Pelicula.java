package com.example.estacionvl_tc_014.cinestar.models;

/**
 * Created by EstacionVL-TC-014 on 2/02/16.
 */
public class Pelicula {

    String nombre;
    float calificacion;
    String duracion;
    String url;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

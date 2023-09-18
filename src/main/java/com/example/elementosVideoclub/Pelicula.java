package com.example.elementosVideoclub;

import java.util.Date;
import java.util.List;

import com.example.videoclub.VideoClubSingleton;

/**
 * La clase Pelicula implementa la interfaz Alquilable y representa una película con propiedades como
 * título, año, género, director, actores, precio de alquiler, período de alquiler y estado de
 * alquiler.
 */
public class Pelicula implements Alquilable {

    private String titulo;
    private int anio;
    private String genero;
    private String nacionalidad;
    private String director;
    private List<String> actores;

    private int precioAlquiler;
    private int periodoAlquiler;
    private Date fechaUltAlquiler = null;
    private boolean alquilado = false;

    public Pelicula(String titulo, int anio, String genero, String nacionalidad, String director,
            List<String> actores, int precioAlquiler, int periodoAlquiler) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.director = director;
        this.actores = actores;
        this.precioAlquiler = precioAlquiler;
        this.periodoAlquiler = periodoAlquiler;

        VideoClubSingleton.getInstancia().altaPelicula(this); // Se da de alta la pelicula en el catalogo
    }

    /**
     * La función "alquilar" establece una variable booleana como verdadera y asigna la fecha actual a
     * una variable de fecha.
     */
    @Override
    public void alquilar() {

        alquilado = true;
        fechaUltAlquiler = new Date();
    }

    /**
     * La función "devolver" establece la variable "alquilado" en falso y la variable
     * "fechaUltAlquiler" en nulo.
     */
    @Override
    public void devolver() {

        alquilado = false;
        fechaUltAlquiler = null;

    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", genero=" + genero + ", alquilado=" + alquilado + "]";
    }

}

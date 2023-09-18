package com.example.elementosVideoclub;

import java.util.List;

/**
 * La clase PeliculaEstreno amplía la clase Pelicula y establece valores
 * predeterminados para el
 * precio de alquiler y el periodo.
 */
public class PeliculaEstreno extends Pelicula {

    public PeliculaEstreno(String titulo, int anio, String genero, String nacionalidad, String director,
            List<String> actores) {
        super(titulo, anio, genero, nacionalidad, director, actores, 5, 1);

    }
}

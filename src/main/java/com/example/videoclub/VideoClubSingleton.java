package com.example.videoclub;

import java.util.ArrayList;
import java.util.List;

import com.example.elementosVideoclub.*;
import com.example.socios.Socio;

import excepciones.ElementoAlquiladoException;

/**
 * La clase VideoClubSingleton es un singleton que administra un catálogo de
 * películas y videojuegos,
 * permite alquilar y devolver artículos, tambien almacena los socios dados de
 * alta.
 */
public class VideoClubSingleton {

    private static VideoClubSingleton instancia;

    private List<Pelicula> catalogoPeliculas = new ArrayList<>();
    private List<VideoJuego> catalogoVideoJuego = new ArrayList<>();

    private List<Alquilable> alquilados = new ArrayList<>();

    private List<Socio> socios = new ArrayList<>();

    public static VideoClubSingleton getInstancia() {

        if (instancia == null) {
            instancia = new VideoClubSingleton();
        }
        return instancia;

    }

    /**
     * Esta función de Java permite alquilar un artículo y genera una excepción si el artículo ya está
     * alquilado.
     * 
     * @param item un objeto que implementa la interfaz Alquilable, que tiene un método llamado
     * "alquilar()" que se llama cuando se alquila el artículo.
     */
    public void alquilar(Alquilable item) throws ElementoAlquiladoException {

        if (alquilados.contains(item)) { // Eleva una excepcion si el elemento esta alquilado
            throw new ElementoAlquiladoException("El item ya esta alquilado.");
        }
        item.alquilar();
        alquilados.add(item);
    }

    /**
     * La función "devolver" devuelve un artículo y lo elimina de una lista de artículos alquilados.
     * 
     * @param item El parámetro "item" es un objeto de una clase que implementa la interfaz
     * "Alquilable". Se llama al método "devolver()" sobre este objeto para marcarlo como devuelto, y
     * luego se elimina el objeto de una lista llamada "alquilados".
     */
    public void devolver(Alquilable item) {

        item.devolver();
        alquilados.remove(item);
    }

    /**
     * La función muestra el catálogo de películas y videojuegos.
     */
    public void mostrarCatalogos() {
        System.out.println("Peliculas: ");
        for (Pelicula peli : catalogoPeliculas) {
            System.out.println(peli.toString());
        }

        System.out.println("\nJuegos: ");
        for (VideoJuego juego : catalogoVideoJuego) {
            System.out.println(juego.toString());
        }
    }

    /**
     * La función agrega un nuevo objeto "Socio" a una lista de "socios".
     * 
     * @param socio El parámetro "socio" es un objeto de la clase "Socio". Se está pasando como
     * argumento al método "altaSocio". El método agrega este objeto a una lista llamada "socios".
     */
    public void altaSocio(Socio socio) {
        socios.add(socio);
    }

    /**
     * La función agrega una película a un catálogo de películas.
     * 
     * @param pelicula El parámetro "pelicula" es un objeto de la clase "Pelicula" que se le está
     * pasando como argumento al método "altaPelicula". Este método agrega el objeto "pelicula" a una
     * lista llamada "catalogoPeliculas".
     */
    public void altaPelicula(Pelicula pelicula) {
        catalogoPeliculas.add(pelicula);
    }

    /**
     * La función añade un videojuego a un catálogo de videojuegos.
     * 
     * @param videoJuego El parámetro "videoJuego" es un objeto de la clase "VideoJuego" que se pasa
     * como argumento al método "altaVideoJuego". El método añade este objeto a una lista llamada
     * "catalogoVideoJuego".
     */
    public void altaVideoJuego(VideoJuego videoJuego) {
        catalogoVideoJuego.add(videoJuego);
    }

}

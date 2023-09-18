package com.example.socios;

import java.util.ArrayList;
import java.util.List;

import com.example.elementosVideoclub.Alquilable;
import com.example.elementosVideoclub.VideoJuego;
import com.example.videoclub.VideoClubSingleton;

import excepciones.*;

/**
 * La clase Socio representa a un miembro de un club de video que puede alquilar y devolver artículos,
 * mostrar interés en los videojuegos y ver su historial de alquiler.
 */
public class Socio {

    private int idSocio;
    private String nombre;

    private Alquilable itemAlquilado = null;
    private List<Alquilable> historialAlquiler = new ArrayList<>();

    public Socio(int idSocio, String nombre) {
        this.idSocio = idSocio;
        this.nombre = nombre;

        VideoClubSingleton.getInstancia().altaSocio(this);

    }

    /**
     * Esta función permite que un usuario alquile un artículo, pero genera una excepción si el
     * usuario ya tiene un artículo alquilado o si se alcanzó el límite de alquiler.
     * 
     * @param item un objeto que implementa la interfaz Alquilable, lo que significa que puede
     * alquilarse o tomarse prestado del videoclub.
     */
    public void alquilar(Alquilable item) throws ElementoAlquiladoException, LimiteAlquilerExcepcion {

        if (this.itemAlquilado != null) { // Eleva una excepcion si el usuario tiene algo alquilado
            throw new LimiteAlquilerExcepcion("Ya tienes un item alquilado");
        }

        VideoClubSingleton.getInstancia().alquilar(item);
        itemAlquilado = item;
        historialAlquiler.add(item);

    }

    /**
     * Esta función devuelve un artículo que se alquiló previamente en un videoclub.
     * 
     * @param item El parámetro "item" es un objeto de una clase que implementa la interfaz
     * "Alquilable". Este método se utiliza para devolver el artículo que se alquiló previamente en un
     * videoclub y toma como parámetro el artículo alquilado. El método llama al método "devolver" del
     * "
     */
    public void devolver(Alquilable item) {

        VideoClubSingleton.getInstancia().devolver(item);
        itemAlquilado = null;
    }

    /**
     * Esta función agrega al usuario actual como parte interesada a un objeto de videojuego.
     * 
     * @param juego un parámetro de tipo VideoJuego, que representa un objeto de videojuego.
     */
    public void interesarseVideojuego(VideoJuego juego) {
        juego.agregarInteresado(this);
    }

    /**
     * Esta función de Java imprime el historial de alquiler de un usuario.
     */
    public void imprimirHistorial() {
        System.out.println("\nEl historial del usuario " + this.toString() + " es:");
        for (Alquilable alquilable : historialAlquiler) {
            System.out.println(alquilable.toString());
        }
    }

    @Override
    public String toString() {
        return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + "]";
    }

}

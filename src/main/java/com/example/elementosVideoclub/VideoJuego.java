package com.example.elementosVideoclub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.socios.Socio;
import com.example.videoclub.VideoClubSingleton;

/**
 * La clase VideoJuego representa un videojuego que se puede alquilar y tiene una lista de miembros
 * interesados a los que se les puede notificar cuando esté disponible.
 */
public class VideoJuego implements Alquilable {

    private String titulo;
    private String compania;
    private int anio;
    private String genero;
    private PlataformaEnum plataforma;

    private int precioAlquiler;
    private int periodoAlquiler;
    private Date fechaUltAlquiler = null;
    private boolean alquilado = false;

    private List<Socio> listaEspera = new ArrayList<>();

    public VideoJuego(String titulo, String compania, int anio, String genero, PlataformaEnum plataforma,
            int precioAlquiler, int periodoAlquiler) {
        this.titulo = titulo;
        this.compania = compania;
        this.anio = anio;
        this.genero = genero;
        this.plataforma = plataforma;
        this.precioAlquiler = precioAlquiler;
        this.periodoAlquiler = periodoAlquiler;

        VideoClubSingleton.getInstancia().altaVideoJuego(this);
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
     * Esta función actualiza el estado de un videojuego a "no alquilado" e imprime
     * una lista de
     * miembros en lista de espera si los hay.
     */
    @Override
    public void devolver() {

        alquilado = false;
        fechaUltAlquiler = null;

        if (!listaEspera.isEmpty()) {
            System.out.println("\nEl videojuego " + this.titulo + " ha sido devuelto llamar a:");
        }

        for (Socio socio : listaEspera) {
            System.out.println(socio.toString());
        }

    }

    /**
     * Esta función agrega un nuevo miembro a una lista de espera para ser notificado.
     * 
     * @param interesado un objeto de la clase "Socio" que representa a una persona que está interesada
     * en ser notificada sobre el juego. Este método agrega el objeto "interesado" a una lista llamada
     * "listaEspera" para que puedan recibir notificaciones.
     */
    public void agregarInteresado(Socio interesado) { // Agrega un interesado para que se le notifique
        listaEspera.add(interesado);
    }

    @Override
    public String toString() {
        return "VideoJuego [titulo=" + titulo + ", genero=" + genero + ", alquilado=" + alquilado + "]";
    }

}

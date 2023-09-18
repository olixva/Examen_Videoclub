package com.example;

import java.util.Arrays;

import com.example.elementosVideoclub.*;
import com.example.socios.Socio;
import com.example.videoclub.VideoClubSingleton;

import excepciones.ElementoAlquiladoException;
import excepciones.LimiteAlquilerExcepcion;

/**
 * La clase Main contiene un programa que simula el funcionamiento del programa, 
 * probando todos los posibles casos de uso y sus respectivos errores.
 */
public class Main {

        public static void main(String[] args) {

                Pelicula pelicula1 = new Pelicula("El Padrino", 1972, "Drama", "EEUU",
                                "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),
                                1500, 7);

                Pelicula pelicula2 = new Pelicula("La La Land", 2016, "Comedia", "Estados Unidos",
                                "Damien Chazelle", Arrays.asList("Ryan Gosling", "Emma Stone", "John Legend"),
                                1200, 5);

                Pelicula peliculaEstreno1 = new PeliculaEstreno("Avengers: Endgame", 2019, "Acción", "Estados Unidos",
                                "Anthony Russo, Joe Russo",
                                Arrays.asList("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo"));

                Pelicula peliculaEstreno2 = new PeliculaEstreno("Mario Bros", 2023, "Acción", "Estados Unidos",
                                "Yo que se, Joe Russo",
                                Arrays.asList("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo"));

                VideoJuego videoJuego1 = new VideoJuego("GTA5", "Rockstar", 2017, "Accion",
                                PlataformaEnum.PLAYSTATION, 10, 7);

                VideoJuego videoJuego2 = new VideoJuego("Halo Infinite", "Xbox Games", 2018, "Acción",
                                PlataformaEnum.XBOX, 12, 7);

                VideoClubSingleton.getInstancia().mostrarCatalogos();

                Socio socio1 = new Socio(1, "Antonio");
                Socio socio2 = new Socio(2, "Fran");

                System.out.println("\nPruebas pelicula normal");// Pruebas pelicula normal
                try { // Caso base
                        socio1.alquilar(pelicula1);
                        socio1.devolver(pelicula1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }

                try { // ElementoAlquiladoException
                        socio2.alquilar(pelicula1);
                        socio1.alquilar(pelicula1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio2.devolver(pelicula1);

                try { // LimiteAlquilerExcepcion
                        socio1.alquilar(pelicula1);
                        socio1.alquilar(pelicula2);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio1.devolver(pelicula1);

                System.out.println("\nPruebas pelicula estreno");// Pruebas pelicula estreno
                try { // Caso base
                        socio1.alquilar(peliculaEstreno1);
                        socio1.devolver(peliculaEstreno1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }

                try { // ElementoAlquiladoException
                        socio2.alquilar(peliculaEstreno1);
                        socio1.alquilar(peliculaEstreno1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio2.devolver(peliculaEstreno1);

                try { // LimiteAlquilerExcepcion
                        socio1.alquilar(peliculaEstreno1);
                        socio1.alquilar(peliculaEstreno2);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio1.devolver(peliculaEstreno1);

                System.out.println("\nPruebas juegos");// Pruebas juegos
                try { // Caso base
                        socio1.alquilar(videoJuego1);
                        socio1.devolver(videoJuego1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }

                try { // ElementoAlquiladoException
                        socio2.alquilar(videoJuego1);
                        socio1.alquilar(videoJuego1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio2.devolver(videoJuego1);

                try { // LimiteAlquilerExcepcion
                        socio1.alquilar(videoJuego1);
                        socio1.alquilar(videoJuego2);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }
                socio1.devolver(videoJuego1);

                try { // Interesados
                        socio2.interesarseVideojuego(videoJuego1);
                        socio1.alquilar(videoJuego1);
                        socio1.devolver(videoJuego1);
                } catch (ElementoAlquiladoException e) {
                        System.out.println(
                                        "Lo sentimos el elemento que intentas alquilar ya esta alquilado,"
                                                        + "en caso de ser un juego te llamaremos cuando este disponible.");
                } catch (LimiteAlquilerExcepcion e) {
                        System.out.println(
                                        "Lo sentimos has superado el cupo de alquiler, porfavor "
                                                        + "devuelva el elemento que tiene alquilado antes de alquilar otro.");
                }

                socio1.imprimirHistorial(); // Pruebas Historiales
                socio2.imprimirHistorial();
        }
}

package excepciones;

/**
 * Esta es una clase de Java para una excepción que se lanza al intentar
 * alquilar un artículo
 * cuando aun no has devuelto el anterior.
 */
public class LimiteAlquilerExcepcion extends Exception {

    public LimiteAlquilerExcepcion(String msg) {
        super(msg);
    }
}

package excepciones;

/**
 * Esta es una clase de Java para una excepción que se lanza al intentar
 * alquilar un artículo ya
 * alquilado.
 */
public class ElementoAlquiladoException extends Exception {

    public ElementoAlquiladoException(String msg) {
        super(msg);
    }
}

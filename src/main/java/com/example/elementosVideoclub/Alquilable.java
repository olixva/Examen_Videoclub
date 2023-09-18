package com.example.elementosVideoclub;

// Esta es una interfaz Java llamada "Alquilable" que define tres métodos: "alquilar()", "devolver()" y
// "toString()". Cualquier clase que implemente esta interfaz debe proporcionar implementaciones para
// estos tres métodos. El propósito de esta interfaz es definir un contrato para las clases que se
// pueden alquilar o tomar prestadas, como lo indican los nombres de los métodos.
public interface Alquilable {

    public void alquilar();

    public void devolver();

    public String toString();
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    @Test
    public void NodoSeCreaConValorCorrecto()
    {
        DequeNode<Integer> nodo = new DequeNode(2, null, null);

        int expectedValue = 2;
        int obtainedValue = nodo.getItem();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoTieneAnterior()
    {
        DequeNode<Integer> anterior = new DequeNode(1, null, null);
        DequeNode<Integer> nodo = new DequeNode(2, null, anterior);

        DequeNode<Integer> expectedValue = anterior;
        DequeNode<Integer> obtainedValue = nodo.getPrevious();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoTienePosterior()
    {
        DequeNode<Integer> posterior = new DequeNode(1, null, null);
        DequeNode<Integer> nodo = new DequeNode(2, posterior, null);

        DequeNode<Integer> expectedValue = posterior;
        DequeNode<Integer> obtainedValue = nodo.getNext();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void comprobarValorConNodoConValorYConectadoConAnteriorYPosterior(){
        DequeNode<Integer> anterior = new DequeNode<>(1,null,null);
        DequeNode<Integer> posterior = new DequeNode<>(2, null, null);
        DequeNode<Integer> node = new DequeNode<>(1, posterior, anterior);
        assertEquals(posterior,node.getNext());
        assertEquals(anterior,node.getPrevious());
        assertEquals(1,node.getItem());
    }

    @Test
    public void comprobarCambioDeValorEnUnNodo(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);
        node.setItem(2);
        assertEquals(2,node.getItem());
    }

    @Test
    public void comprobarNodoConValorNulo(){
        DequeNode<Integer> node = new DequeNode<>(null,null,null);
        assertEquals(null,node.getItem());
    }

    @Test
    public void siNoTieneAnteriorEsPrimero() {
        DequeNode<Integer> Primero = new DequeNode<>(5,null,null);
        DequeNode<Integer> Ultimo = new DequeNode<>(6,null,Primero);
        Primero.setNext(Ultimo);
        assertTrue(Primero.isFirstNode());
    }

    @Test
    public void siNoTienePosteriorEsUltimo() {
        DequeNode<Integer> Primero = new DequeNode<>(5,null,null);
        DequeNode<Integer> Ultimo = new DequeNode<>(6,null,Primero);
        Primero.setNext(Ultimo);
        assertTrue(Ultimo.isLastNode());
    }

    @Test
    public void siTieneAnteriorYPosteriorNoEsNiPrimeroNiUltimo() {
        DequeNode<Integer> Primero = new DequeNode<>(5,null,null);
        DequeNode<Integer> Medio = new DequeNode<>(6,null,Primero);
        DequeNode<Integer> Ultimo = new DequeNode<>(6,null,Medio);
        Primero.setNext(Medio);
        Medio.setNext(Ultimo);
        Ultimo.setPrevious(Medio);
        assertTrue(Medio.isNotATerminalNode());
    }
}
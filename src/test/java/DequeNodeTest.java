import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

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
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

}
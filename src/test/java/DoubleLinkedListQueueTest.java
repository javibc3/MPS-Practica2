import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    @Test
    public void NodoSeCreaConValorCorrecto() {
        DequeNode<Integer> nodo = new DequeNode(2, null, null);

        int expectedValue = 2;
        int obtainedValue = nodo.getItem();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoSeAñadeAListaVacia() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);
        DequeNode<Integer> nodo = new DequeNode(2, null, null);
        lista.append(nodo);
        int expectedSize = 1;
        int obtainedSize = lista.size();
        DequeNode expectedValue = nodo;
        DequeNode obtainedValue = lista.peekFirst();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoSeAñadeALaIzquierdaDeListaNoVacia() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(new DequeNode(3, null, null));
        DequeNode<Integer> nodo = new DequeNode(2, null, null);
        lista.append(nodo);
        int expectedSize = 2;
        int obtainedSize = lista.size();
        DequeNode expectedValue = nodo;
        DequeNode obtainedValue = lista.peekLast();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void AñadirNodoNullLanzaExcepcion()
    {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(new DequeNode(3, null, null));
        assertThrows(RuntimeException.class, () -> lista.append(null));
    }
}
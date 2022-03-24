import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    @Test
    public void NodoSeCreaConValorCorrecto()
    {
        DequeNode<Integer> nodo = new DequeNode(2, null, null);

        int expectedValue = 2;
        int obtainedValue = nodo.getItem();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void añadirNodoIzquierdaEnColaVacia(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        assertEquals(node,lista.peekFirst());

        assertEquals(node,lista.peekLast());
    }

    @Test
    public void añadirNodoIzquierdaEnLColaConUnElemento(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node2,lista.peekFirst());
    }

    @Test
    public void añadirNodoNuloIzquierdaEnCola(){

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        assertThrows(RuntimeException.class,()->lista.appendLeft(null));
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaConUnElemento(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node2.getPrevious(),node);

        assertNull(node2.getNext());
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaVacia(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        assertNull(node.getPrevious());

        assertNull(node.getNext());
    }
}
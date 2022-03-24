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

        assertEquals(1,lista.size());
    }

    @Test
    public void añadirNodoIzquierdaEnLColaConUnElemento(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node2,lista.peekFirst());

        assertEquals(2,lista.size());
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

        assertEquals(node,node2.getNext());

        assertNull(node2.getPrevious());
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaVacia(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        assertNull(node.getPrevious());

        assertNull(node.getNext());
    }

    @Test
    public void buscarUnElementoEnLaPosicionCeroEnColaVacia(){
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        assertThrows(IndexOutOfBoundsException.class,()->{
            lista.getAt(0);
        });
    }

    @Test
    public void buscarUnElementoEnLaPosicionCincoEnColaConUnElemento(){
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        lista.appendLeft(node);

        assertThrows(IndexOutOfBoundsException.class,()->{
            lista.getAt(5);
        });
    }



    @Test
    public void buscarUnElementoEnLaPosicionDosEnColaConCincoElementos(){
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        DequeNode<Integer> node = new DequeNode(2,null,null);

        lista.appendLeft(new DequeNode<>(0,null,null));

        lista.appendLeft(new DequeNode(1,null,null));

        lista.appendLeft(node);

        lista.appendLeft(new DequeNode(3,null,null));

        lista.appendLeft(new DequeNode(4,null,null));

        assertEquals(node,lista.getAt(2));
    }

    @Test
    public void deleteLastBorraUltimoElemento() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> ultimo = new DequeNode(3, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(primero);
        DoubleLinkedListQueue listaEsperada = new DoubleLinkedListQueue<Integer>(primero);
        listaActual.append(ultimo);
        listaActual.deleteLast();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }

    @Test
    public void deleteLastBorraUnicoElemento() {
        DequeNode<Integer> ultimo = new DequeNode(2, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(ultimo);
        DoubleLinkedListQueue listaEsperada = new DoubleLinkedListQueue<Integer>(null);
        listaActual.deleteLast();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekLast(), listaActual.peekLast());
    }

    @Test
    public void deleteLastSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(null);
        assertThrows(RuntimeException.class,()->listaActual.deleteLast());
    }

    @Test
    public void deleteFirstBorraPrimerElemento()
    {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> ultimo = new DequeNode(3, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(primero);
        DoubleLinkedListQueue listaEsperada = new DoubleLinkedListQueue<Integer>(ultimo);
        listaActual.append(ultimo);
        listaActual.deleteFirst();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }


    @Test
    public void deleteFirstBorraUnicoElemento()
    {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(primero);
        DoubleLinkedListQueue listaEsperada = new DoubleLinkedListQueue<Integer>(null);
        listaActual.deleteFirst();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }

    @Test
    public void deleteFirstSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue<Integer>(null);
        assertThrows(RuntimeException.class,()->listaActual.deleteFirst());
    }
}
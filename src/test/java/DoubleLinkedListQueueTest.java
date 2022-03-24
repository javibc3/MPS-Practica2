import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    @Test
    public void NodoSeCreaConValorCorrecto() {
        DequeNode<Integer> nodo = new DequeNode<>(2, null, null);

        int expectedValue = 2;
        int obtainedValue = nodo.getItem();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoSeAñadeAListaVacia() {
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);
        DequeNode<Integer> nodo = new DequeNode<>(2, null, null);
        lista.append(nodo);
        int expectedSize = 1;
        int obtainedSize = lista.size();
        DequeNode<Integer> expectedValue = nodo;
        DequeNode<Integer> obtainedValue = lista.peekFirst();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void NodoSeAñadeALaIzquierdaDeListaNoVacia() {
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(new DequeNode<>(3, null, null));
        DequeNode<Integer> nodo = new DequeNode<>(2, null, null);
        lista.append(nodo);
        int expectedSize = 2;
        int obtainedSize = lista.size();
        DequeNode<Integer> expectedValue = nodo;
        DequeNode<Integer> obtainedValue = lista.peekLast();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void AñadirNodoNullLanzaExcepcion() {
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(new DequeNode<>(3, null, null));
        assertThrows(RuntimeException.class, () -> lista.append(null));
    }

    @Test
    public void añadirNodoIzquierdaEnColaVacia() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        lista.appendLeft(node);

        assertEquals(node,lista.peekFirst());

        assertEquals(node,lista.peekLast());

        assertEquals(1,lista.size());
    }

    @Test
    public void añadirNodoIzquierdaEnLColaConUnElemento() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node2,lista.peekFirst());

        assertEquals(2,lista.size());
    }

    @Test
    public void añadirNodoNuloIzquierdaEnCola() {

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        assertThrows(RuntimeException.class,()->lista.appendLeft(null));
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaConUnElemento() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node,node2.getNext());

        assertNull(node2.getPrevious());
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaVacia() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        lista.appendLeft(node);

        assertNull(node.getPrevious());

        assertNull(node.getNext());
    }

    @Test
    public void buscarUnElementoEnLaPosicionCeroEnColaVacia(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        assertThrows(IndexOutOfBoundsException.class,()->{
            lista.getAt(0);
        });
    }

    @Test
    public void buscarUnElementoEnLaPosicionCincoEnColaConUnElemento(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        lista.appendLeft(node);

        assertThrows(IndexOutOfBoundsException.class,()->{
            lista.getAt(5);
        });
    }

    @Test
    public void buscarUnElementoEnLaPosicionMenosDiezEnColaConDosElementos(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        lista.appendLeft(node);

        lista.appendLeft(new DequeNode<>(2,null,null));

        assertThrows(IndexOutOfBoundsException.class,()->{
            lista.getAt(-10);
        });
    }



    @Test
    public void buscarUnElementoEnLaPosicionDosEnColaConCincoElementos(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        DequeNode<Integer> node = new DequeNode(2,null,null);

        lista.appendLeft(new DequeNode<>(0,null,null));

        lista.appendLeft(new DequeNode<>(1,null,null));

        lista.appendLeft(node);

        lista.appendLeft(new DequeNode<>(3,null,null));

        lista.appendLeft(new DequeNode<>(4,null,null));

        assertEquals(node,lista.getAt(2));
    }

    @Test
    public void deleteLastBorraUltimoElemento() {
        DequeNode<Integer> primero = new DequeNode<>(2, null, null);
        DequeNode<Integer> ultimo = new DequeNode<>(3, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(primero);
        DoubleLinkedListQueue<Integer> listaEsperada = new DoubleLinkedListQueue<>(primero);
        listaActual.append(ultimo);
        listaActual.deleteLast();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }

    @Test
    public void deleteLastBorraUnicoElemento() {
        DequeNode<Integer> ultimo = new DequeNode<>(2, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(ultimo);
        DoubleLinkedListQueue<Object> listaEsperada = new DoubleLinkedListQueue<>(null);
        listaActual.deleteLast();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekLast(), listaActual.peekLast());
    }

    @Test
    public void deleteLastSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(null);
        assertThrows(RuntimeException.class,()->listaActual.deleteLast());
    }

    @Test
    public void deleteFirstBorraPrimerElemento() {
        DequeNode<Integer> primero = new DequeNode<>(2, null, null);
        DequeNode<Integer> ultimo = new DequeNode<>(3, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(primero);
        DoubleLinkedListQueue<Integer> listaEsperada = new DoubleLinkedListQueue<>(ultimo);
        listaActual.append(ultimo);
        listaActual.deleteFirst();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }

    @Test
    public void deleteFirstBorraUnicoElemento() {
        DequeNode<Integer> primero = new DequeNode<Integer>(2, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(primero);
        DoubleLinkedListQueue<Integer> listaEsperada = new DoubleLinkedListQueue<>(null);
        listaActual.deleteFirst();

        assertEquals(listaActual.size(), listaEsperada.size());
        assertEquals(listaEsperada.peekFirst(), listaActual.peekFirst());
    }

    @Test
    public void deleteFirstSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue<>(null);
        assertThrows(RuntimeException.class,()->listaActual.deleteFirst());
    }

    @Test
    public void buscarElElementoNuloEnUnaCola(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);

        assertThrows(RuntimeException.class,()->{
            lista.find(null);
        });
    }

    @Test
    public void buscarElElementoDosYEstaPresenteEnUnaColaConDosElementos(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(new DequeNode<>(1,null,null));

        DequeNode<Integer> node = new DequeNode<>(2,null,null);
        lista.appendLeft(node);

        assertEquals(node,lista.find(2));
    }

    @Test
    public void buscarElElementoDosYNoEstaPresenteEnUnaColaConDosElementos(){
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(new DequeNode<>(1,null,null));

        DequeNode<Integer> node = new DequeNode<>(3,null,null);
        lista.appendLeft(node);

        assertNull(lista.find(2));
    }

    @Test
    public void buscarElElementoDosStringYEstaPresenteEnUnaColaConDosElementos(){
        DoubleLinkedListQueue<String> lista = new DoubleLinkedListQueue<>(null);

        DequeNode<String> node = new DequeNode<>("dos",null,null);

        lista.appendLeft(node);

        assertEquals(node,lista.find("dos"));
    }
}
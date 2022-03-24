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
    public void AñadirNodoNullLanzaExcepcion() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(new DequeNode(3, null, null));
        assertThrows(RuntimeException.class, () -> lista.append(null));
    }

    @Test
    public void añadirNodoIzquierdaEnColaVacia() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        assertEquals(node,lista.peekFirst());

        assertEquals(node,lista.peekLast());

        assertEquals(1,lista.size());
    }

    @Test
    public void añadirNodoIzquierdaEnLColaConUnElemento() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node2,lista.peekFirst());

        assertEquals(2,lista.size());
    }

    @Test
    public void añadirNodoNuloIzquierdaEnCola() {

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        assertThrows(RuntimeException.class,()->lista.appendLeft(null));
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaConUnElemento() {
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        DequeNode<Integer> node2 = new DequeNode<>(2,null,null);

        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);

        lista.appendLeft(node);

        lista.appendLeft(node2);

        assertEquals(node,node2.getNext());

        assertNull(node2.getPrevious());
    }

    @Test
    public void comprobarQueElNodoIntroducidoEstaCorrectamenteConectadoEnUnaColaVacia() {
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
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode segundo = new DequeNode(3, null, null);
        DequeNode ultimo = new DequeNode(4, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);

        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.deleteLast();

        assertEquals(2, listaActual.size());
        assertEquals(segundo, listaActual.peekLast());
    }

    @Test
    public void deleteLastBorraUnicoElemento() {
        DequeNode ultimo = new DequeNode(2, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(ultimo);

        listaActual.deleteLast();

        assertEquals(0, listaActual.size());
        assertNull(listaActual.peekLast());
    }

    @Test
    public void deleteLastSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(null);

        assertThrows(RuntimeException.class,()->listaActual.deleteLast());
    }

    @Test
    public void deleteFirstBorraPrimerElemento() {
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode segundo = new DequeNode(3, null, null);
        DequeNode ultimo = new DequeNode(4, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);

        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.deleteFirst();

        assertEquals(2, listaActual.size());
        assertEquals(segundo, listaActual.peekFirst());
    }

    @Test
    public void deleteFirstBorraUnicoElemento() {
        DequeNode primero = new DequeNode(2, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);

        listaActual.deleteFirst();

        assertEquals(0, listaActual.size());
        assertNull(listaActual.peekFirst());
    }

    @Test
    public void deleteFirstSaltaExcepcionSiListaEstaVacia() {
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(null);

        assertThrows(RuntimeException.class,()->listaActual.deleteFirst());
    }

    @Test
    public void deleteBorraNodoEnMedio() {
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode segundo = new DequeNode(3, null, null);
        DequeNode ultimo = new DequeNode(4, null, null);

        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);
        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(segundo);

        assertEquals(2, listaActual.size());
        assertEquals(ultimo, primero.getNext());
    }

    @Test
    public void deleteBorraNodoAlPrincipio() {
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode segundo = new DequeNode(3, null, null);
        DequeNode ultimo = new DequeNode(4, null, null);

        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);
        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(primero);

        assertEquals(2, listaActual.size());
        assertEquals(listaActual.peekFirst(), segundo);
    }

    @Test
    public void deleteBorraNodoAlFinal() {
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode segundo = new DequeNode(3, null, null);
        DequeNode ultimo = new DequeNode(4, null, null);

        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);
        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(ultimo);

        assertEquals(2, listaActual.size());
        assertEquals(listaActual.peekLast(), segundo);
    }

    @Test
    public void deleteBorraUnicoElemento() {
        DequeNode primero = new DequeNode(2, null, null);

        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);
        listaActual.delete(primero);

        assertEquals(0, listaActual.size());
        assertNull(listaActual.peekLast());
    }

    @Test
    public void deleteSaltaExcepcionSiNodoEsNulo() {
        DequeNode primero = new DequeNode(2, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);

        assertThrows(RuntimeException.class,()->listaActual.delete(null));
    }

    @Test
    public void deleteSaltaExcepcionSiNodoNoEstaEnLista() {
        DequeNode primero = new DequeNode(2, null, null);
        DequeNode nodoABorrar = new DequeNode(5, null, null);
        DoubleLinkedListQueue listaActual = new DoubleLinkedListQueue(primero);

        assertThrows(RuntimeException.class,()->listaActual.delete(nodoABorrar));
    }
}
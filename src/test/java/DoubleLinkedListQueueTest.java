import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    @Test
    public void nodoSeCreaConValorCorrecto() {
        DequeNode<Integer> nodo = new DequeNode(2, null, null);

        int expectedValue = 2;
        int obtainedValue = nodo.getItem();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void nodoSeAñadeAListaVacia() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(null);
        DequeNode<Integer> nodo = new DequeNode(2, null, null);
        lista.append(nodo);
        int expectedSize = 1;
        int obtainedSize = lista.size();
        DequeNode<Integer> expectedValue = nodo;
        DequeNode<Integer> obtainedValue = lista.peekFirst();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void nodoSeAñadeALaDerechaDeListaNoVacia() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(new DequeNode(3, null, null));
        DequeNode<Integer> nodo = new DequeNode(2, null, null);
        lista.append(nodo);
        int expectedSize = 2;
        int obtainedSize = lista.size();
        DequeNode<Integer> expectedValue = nodo;
        DequeNode<Integer> obtainedValue = lista.peekLast();
        assertEquals(expectedSize, obtainedSize);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void añadirNodoNullLanzaExcepcion() {
        DoubleLinkedListQueue lista = new DoubleLinkedListQueue(new DequeNode(3, null, null));
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

    @Test
    public void sortDeListaVacia() {
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(null);
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) return -1;
                if (o1 == o2) return 0;
                return 1;
            }
        });
        assertEquals(0, lista.size());
    }

    @Test
    public void sortDeListaConUnElemento() {
        DequeNode<Integer> nodo = new DequeNode<>(2, null, null);
        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(nodo);
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) return -1;
                if (o1 == o2) return 0;
                return 1;
            }
        });
        assertEquals(1, lista.size());
        assertEquals(nodo, lista.peekFirst());
        assertEquals(nodo, lista.peekLast());
    }

    @Test
    public void sortDeListaConMasDeUnElemento() {
        DequeNode<Integer> nodo1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> nodo2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> nodo3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> nodo4 = new DequeNode<>(4, null, null);
        DequeNode<Integer> nodo5 = new DequeNode<>(5, null, null);

        DoubleLinkedListQueue<Integer> lista = new DoubleLinkedListQueue<>(nodo2);
        lista.append(nodo3);
        lista.append(nodo5);
        lista.append(nodo4);
        lista.append(nodo1);

        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) return -1;
                if (o1 == o2) return 0;
                return 1;
            }
        });

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.getAt(i).getItem());
        }

        assertEquals(5, lista.size());
        assertEquals(1, lista.getAt(0).getItem());
        assertEquals(2, lista.getAt(1).getItem());
        assertEquals(3, lista.getAt(2).getItem());
        assertEquals(4, lista.getAt(3).getItem());
        assertEquals(5, lista.getAt(4).getItem());
    }

    @Test
    public void deleteBorraNodoEnMedio() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> segundo = new DequeNode(3, null, null);
        DequeNode<Integer> ultimo = new DequeNode(4, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);

        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(segundo);

        assertEquals(2, listaActual.size());
        assertEquals(ultimo, primero.getNext());
    }

    @Test
    public void deleteBorraNodoAlPrincipio() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> segundo = new DequeNode(3, null, null);
        DequeNode<Integer> ultimo = new DequeNode(4, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);

        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(primero);

        assertEquals(2, listaActual.size());
        assertEquals(listaActual.peekFirst(), segundo);
    }

    @Test
    public void deleteBorraNodoAlFinal() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> segundo = new DequeNode(3, null, null);
        DequeNode<Integer> ultimo = new DequeNode(4, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);

        listaActual.append(segundo);
        listaActual.append(ultimo);
        listaActual.delete(ultimo);

        assertEquals(2, listaActual.size());
        assertEquals(listaActual.peekLast(), segundo);
    }

    @Test
    public void deleteBorraUnicoElemento() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);

        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);
        listaActual.delete(primero);

        assertEquals(0, listaActual.size());
        assertNull(listaActual.peekLast());
    }

    @Test
    public void deleteSaltaExcepcionSiListaEstaVacia() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(null);

        assertThrows(RuntimeException.class,()->listaActual.delete(primero));
    }

    @Test
    public void deleteSaltaExcepcionSiNodoEsNulo() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);

        assertThrows(RuntimeException.class,()->listaActual.delete(null));
    }

    @Test
    public void deleteSaltaExcepcionSiNodoNoEstaEnLista() {
        DequeNode<Integer> primero = new DequeNode(2, null, null);
        DequeNode<Integer> nodoABorrar = new DequeNode(5, null, null);
        DoubleLinkedListQueue<Integer> listaActual = new DoubleLinkedListQueue(primero);

        assertThrows(RuntimeException.class,()->listaActual.delete(nodoABorrar));
    }
}
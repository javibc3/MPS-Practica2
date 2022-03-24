import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueuees<T> {

    private DequeNode<T> principio;
    private DequeNode<T> fin;
    private int size;

    public DoubleLinkedListQueue(DequeNode<T> nodo) {
        principio = nodo;
        fin = nodo;
        size = (nodo != null) ? 1 : 0;
    }

    @Override
    public void append(DequeNode<T> node) {
        if (node == null) throw new RuntimeException("El nodo que ha pasado es NULL");
        if (size > 0) {
            fin.setNext(node);
            node.setPrevious(fin);
        } else {
            principio = node;
        }
        fin = node;
        size++;
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if (node == null) throw new RuntimeException("El nodo que ha pasado es NULL");
        if(size == 0){
            principio = node;
            fin = node;
        }
        else {
            principio.setNext(node);
            node.setPrevious(principio);
            node.setNext(null);
            principio = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(principio.getNext() != null) {
            principio = principio.getNext();
            principio.setPrevious(null);
        } else if(size == 0){
            throw new RuntimeException("ERROR: LISTA VACIA AL BORRAR PRIMER ELEMENTO");
        } else {
            principio = null;
            fin = null;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if(fin.getPrevious() != null) {
            fin = fin.getPrevious();
            fin.setNext(null);
        } else if(size == 0){
            throw new RuntimeException("ERROR: LISTA VACIA AL BORRAR ULTIMO ELEMENTO");
        } else {
            principio = null;
            fin = null;
        }
        size--;
    }

    @Override
    public DequeNode<T> peekFirst() {
        return principio;
    }

    @Override
    public DequeNode<T> peekLast() {
        return fin;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        return null;
    }

    @Override
    public DequeNode<T> find(T item) {
        if (item == null) throw new RuntimeException("Item a encontrar no puede ser null");
        DequeNode nodo = principio;
        while (nodo != null && nodo.getItem() != item) {
            nodo = nodo.getNext();
        }
        return nodo;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if (node == null) throw new RuntimeException("Nodo a borrar no puede ser null");

        DequeNode<T> nodo = principio;
        while (nodo != null && nodo != node) {
            nodo = nodo.getNext();
        }

        if (nodo == null) throw new RuntimeException("Nodo a borrar no está en la lista");

        DequeNode<T> nodoAnterior = nodo.getPrevious();
        DequeNode<T> nodoSiguiente = nodo.getNext();

        if (nodoAnterior != null) {
            nodoAnterior.setNext(nodoSiguiente);
        } else {
            principio = nodoSiguiente;
        }

        if (nodoSiguiente != null) {
            nodoSiguiente.setPrevious(nodoAnterior);
        } else {
            fin = nodoAnterior;
        }
    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}

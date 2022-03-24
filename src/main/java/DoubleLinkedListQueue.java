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
        if(size == 0) {
            throw new RuntimeException("ERROR: LISTA VACIA AL BORRAR PRIMER ELEMENTO");
        }
        if(principio.getNext() != null) {
            principio = principio.getNext();
            principio.setPrevious(null);
        } else {
            principio = null;
            fin = null;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if(size == 0) {
            throw new RuntimeException("ERROR: LISTA VACIA AL BORRAR ULTIMO ELEMENTO");
        }
        if(fin.getPrevious() != null){
            fin = fin.getPrevious();
            fin.setNext(null);
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
        return null;
    }

    @Override
    public void delete(DequeNode<T> node) {

    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}

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
            principio.setPrevious(node);
            node.setPrevious(null);
            node.setNext(principio);
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
        if(position >= size){
            throw new IndexOutOfBoundsException("La posicion introducida supera el tamaño de la cola");
        }
        else if(position < 0){
            throw new IndexOutOfBoundsException("La posicion introducida es negativa");
        }
        else{
            DequeNode node = principio;
            for(int i = 0; i < position; i++){
                node = node.getNext();
            }
            return node;
        }
    }

    @Override
    public DequeNode<T> find(T item) {
        if (item == null) throw new RuntimeException("Item a encontrar no puede ser null");
        DequeNode<T> nodo = principio;
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

        if (nodo.isFirstNode()) {
            principio = nodo.getNext();
            principio.setPrevious(null);
        } else {
            DequeNode<T> anterior = nodo.getPrevious();
            anterior.setNext(nodo.getNext());
        }

        if (nodo.isLastNode()) {
            fin = nodo.getPrevious();
            fin.setNext(null);
        } else {
            DequeNode<T> siguiente = nodo.getNext();
            siguiente.setPrevious(nodo.getPrevious());
        }
    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}

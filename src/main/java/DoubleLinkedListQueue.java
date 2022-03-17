public class DoubleLinkedListQueue<T> implements DoubleEndedQueuees<T> {

    private DequeNode<T> principio;
    private DequeNode<T> fin;
    private int size;

    public DoubleLinkedListQueue(DequeNode<T> nodo){
        principio = nodo;
        fin = nodo;
        size = (nodo != null) ? 1 : 0;
    }

    @Override
    public void append(DequeNode<T> node) {

    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        principio.setPrevious(node);
        node.setPrevious(null);
        node.setNext(principio);
        principio = node;
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
}

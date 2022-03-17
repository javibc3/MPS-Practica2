public class DoubleEndedQueue<T> implements DoubleEndedQueuees<T> {

    DequeNode<T> principio;
    DequeNode<T> fin;
    int size;

    public DoubleEndedQueue(DequeNode<T> nodo){
        principio = nodo;
        fin = nodo;
        size = (nodo != null) ? 1 : 0;
    }

    @Override
    public void append(DequeNode<T> node) {

    }

    @Override
    public void appendLeft(DequeNode<T> node) {

    }

    @Override
    public void deleteFirst() {
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
        if(fin.getPrevious() != null) {
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
}

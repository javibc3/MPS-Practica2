public class DoubleLinkedListQueue<T> implements DoubleEndedQueuees<T> {

    DequeNode<T> principio;
    DequeNode<T> fin;

    public DoubleEndedQueue(DequeNode<T> nodo){
        principio = nodo;
        fin = nodo;
    }

    @Override
    public void append(DequeNode<T> node) {

    }

    @Override
    public void appendLeft(DequeNode<T> node) {

    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode<T> peekFirst() {
        return null;
    }

    @Override
    public DequeNode<T> peekLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

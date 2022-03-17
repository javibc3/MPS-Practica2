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

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
        return size;
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    @Test
    public void comprobarValorConNodoConValorYConectadoConAnteriorYPosterior(){
        DequeNode<Integer> anterior = new DequeNode<>(1,null,null);
        DequeNode<Integer> posterior = new DequeNode<>(2, null, null);
        DequeNode<Integer> node = new DequeNode<>(1, posterior, anterior);
        assertEquals(posterior,node.getNext());
        assertEquals(anterior,node.getPrevious());
        assertEquals(1,node.getItem());
    }

    @Test
    public void comprobarCambioDeValorEnUnNodo(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);
        node.setItem(2);
        assertEquals(2,node.getItem());
    }

    @Test
    public void comprobarNodoConValorNulo(){
        DequeNode<Integer> node = new DequeNode<>(null,null,null);
        assertEquals(null,node.getItem());
    }
}
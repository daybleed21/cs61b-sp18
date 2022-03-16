package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(10,arb.capacity());
        assertTrue("test isEmpty()",arb.isEmpty());
        arb.enqueue(23.1);
        arb.enqueue(2);
        arb.enqueue(90);
        assertEquals("test peek()",23.1,arb.peek());
        arb.enqueue(54);
        arb.enqueue(45);
        arb.enqueue(21);
        arb.enqueue(3.2);
        arb.enqueue(5.2);
        arb.enqueue(7.5);
        arb.enqueue(1.2);
        assertTrue("test isFull()", arb.isFull());
        assertEquals(23.1,arb.dequeue());
        assertEquals("test fillCount()",9,arb.fillCount());
        Iterator<Double> ringI = arb.new ringIterator();
        while(ringI.hasNext()){
            System.out.println(ringI.next());
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

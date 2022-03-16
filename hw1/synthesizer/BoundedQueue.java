package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T>{

    //return size of the buffer
    int capacity();

    //return number of items currently in the buffer
    int fillCount();

    //add item x to the end
    void enqueue(T x);

    //delete and return item from the front
    T dequeue();

    //return (but do not delete) item from the front
    T peek();

    //is the buffer empty
    default boolean isEmpty(){
        return fillCount() < 1;
    }

    // is the buffer full
    default boolean isFull(){
        return fillCount() == capacity();
    }

}

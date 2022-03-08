public class ArrayDeque <T> implements Deque<T>{
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int capacity = 8;

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    @Override
    public void addFirst(T item){
        if(isFull()){
            resize((int)(capacity * 1.5));
        }
        items[nextFirst] = item;
        nextFirst = subMove(nextFirst);
        size++;
    }
    @Override
    public void addLast(T item){
        if(isFull())
            resize((int)(capacity * 1.5));
        items[nextLast] = item;
        nextLast = addMove(nextLast);
        size++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size ==  items.length;
    }
    /**enlarge the array and rearrange the array
     * new nextFirst should be the end -1 of the array
     * new nextLast should be size
     */

    public void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        int oldIndex = addMove(nextFirst);
        for(int i = 0; i < capacity; i++ ){
            newItems[i] = items[oldIndex];
            nextFirst = addMove(nextFirst);
           oldIndex = nextFirst;
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
        capacity = newSize;
    }
    @Override
    public int size(){
        return size;
    }
    public int addMove(int a){
        return (a + 1 + capacity) % capacity;
    }
    public int subMove(int a){
        return (a - 1 + capacity) % capacity;
    }

    @Override
    public void printDeque(){
        if(isEmpty())
            return;
        int index  = addMove(nextFirst);
        for(int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = addMove(index);
        }
        System.out.println();
    }
    @Override
    public T removeFirst(){
        if(isEmpty())
            return null;
        nextFirst = addMove(nextFirst);
        T itemToReturn = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return itemToReturn;
    }
    @Override
    public T removeLast(){
        if(isEmpty())
            return null;
        nextLast = subMove(nextLast);
        T itemToReturn = items[nextLast];
        items[nextLast] = null;
        size--;
        return itemToReturn;
    }
    @Override
    public T get(int index){
        if(index < 0 || index > size ||isEmpty())
            return null;
        int i = addMove(index + nextFirst);
        return items[i];
    }


}


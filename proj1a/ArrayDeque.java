public class ArrayDeque <T>{
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

    public void addFirst(T item){
        if(isFull()){
            resize((int)(capacity * 1.5));
        }
        items[nextFirst] = item;
        nextFirst = subMove(nextFirst);
        size++;
    }
    public void addLast(T item){
        if(isFull())
            resize((int)(capacity * 1.5));
        items[nextLast] = item;
        nextLast = addMove(nextLast);
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private boolean isFull(){
        return size ==  items.length;
    }
    /**enlarge the array and rearrange the array
     * new nextFirst should be the end -1 of the array
     * new nextLast should be size
     */

    private void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        nextFirst = addMove(nextFirst);
        int oldIndex = nextFirst;
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
    public int size(){
        return size;
    }
    private int addMove(int a){
        return (a + 1 + capacity) % capacity;
    }
    private int subMove(int a){
        return (a - 1 + capacity) % capacity;
    }
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
    private boolean isVacant(){
        if(capacity <= 8){
            return false;
        }
        if( (capacity / 4) > size)
            return true;
        return false;
    }
    public T removeFirst(){
        if(isEmpty())
            return null;
        nextFirst = addMove(nextFirst);
        T itemToReturn = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if ( isVacant())
            resize((int) (capacity * 0.5));
        return itemToReturn;
    }
    public T removeLast(){
        if(isEmpty())
            return null;
        nextLast = subMove(nextLast);
        T itemToReturn = items[nextLast];
        items[nextLast] = null;
        size--;
        if ( isVacant())
            resize((int) (capacity * 0.5));
        return itemToReturn;
    }
    public T get(int index){
        if(index < 0 || index > size ||isEmpty())
            return null;
        int i = addMove(index + nextFirst);
        return items[i];
    }


}


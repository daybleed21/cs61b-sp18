
public class LinkedListDeque<T>{
    private class Node{
        private T item;
        private Node prev;
        private Node next;

        public Node(T item,Node prev, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
//    public LinkedListDeque(LinkedListDeque other){
//        sentinel = new Node(null, null, null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//        for(int i = 0;i < other.size ; i++){
//            addLast((T)other.get(i));
//            size++;
//        }
//
//    }
    /**Adds an item of type T to the front of the deque*/
    public void addFirst(T item){
        Node p = sentinel.next;
        sentinel.next = new Node(item,sentinel,sentinel.next);
        p.prev = sentinel.next;
        size++;
    }
    /**Adds an item to the back of the deque*/
    public void addLast(T item){
        Node p = sentinel.prev;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        p.next = sentinel.prev;
        size++;
    }
    /** return the number of item*/
    public int size() {
        return size;
    }
    /**return true if deque is empty*/
    public boolean isEmpty(){
        return size == 0;
    }
    /**prints the item in the deque*/
    public void printDeque(){
        if (isEmpty())
            return;
        Node ptr = sentinel.next;
        while(ptr != sentinel){
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    /**remove the first item and return it*/
    public T removeFirst(){
        if(sentinel.next == null)
            return null;
        size--;
        Node ptr = sentinel.next;
        sentinel.next = ptr.next;
        ptr.next.prev = sentinel;
        return ptr.item;
    }
    /**remove the last item and return it*/
    public T removeLast(){
        if(isEmpty())
            return null;
        size--;
        Node ptr = sentinel.prev;
        sentinel.prev = ptr.prev;
        ptr.prev.next = sentinel;
        return ptr.item;
    }
    /**Get the item at index and no such item exits return null*/
    public T get(int index){
        if(index < 0 || index > size || isEmpty())
            return null;
        Node ptr = sentinel.next;
        for(int i = 0; i < index; i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }
//    public T getRecursive(int index){
//        if(index > size)
//            return null;
//        return getRecursive(sentinel.next,index);
//    }
//    private T getRecursive(Node node, int i){
//        if(i == 0)
//            return node.item;
//        return getRecursive(node.next,i-1);
//    }
}
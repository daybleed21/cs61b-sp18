public class ArrayDequeTest {
    public static void main(String[] args){

    ArrayDeque a = new ArrayDeque<String>();
    boolean null1 = a.isEmpty();
    System.out.println("Create arraydeque! check method isEmpty()\nexpected: true  actual :" + null1);
    //An apple a day
    a.addFirst("a");
    a.addFirst("apple");
    a.addFirst("An");
    a.addLast("day");
    System.out.println("check method size()\nexpected: 4  actual: "+a.size());
    System.out.print("check method printDeque()\nexpected : An apple a day  actual :");
    a.printDeque();
    a.addLast("keeps");
    a.addLast("the");
    a.addLast("doctor");
    a.addLast("away");
    System.out.println("check method isFull()\nexpected: true  actual: " + a.isFull());
    a.removeFirst();
    a.removeLast();
    a.printDeque();

    System.out.println("check method get(), input i = 3\nexpected : keeps  actual: " + a.get(3));


    }


}

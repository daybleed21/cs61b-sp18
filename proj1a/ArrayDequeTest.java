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
    System.out.print("check method printDeque()\nexpected : An apple a day  actual :");
    a.printDeque();
    a.addFirst("1");
    a.addFirst("2");
    a.addFirst("3");
    a.addFirst("4");
    a.addFirst("5");
    a.addFirst("6");
    System.out.println("check method size()\nexpected: 10  actual: "+a.size());


    a.removeFirst();
    a.removeLast();
    a.removeFirst();
    a.addLast("keeps");
    a.addLast("the");
    a.addFirst("some");
    a.addLast("doctor");
    a.addLast("away");

    a.removeLast();
    a.printDeque();

//    System.out.println("check method get(), input i = 3\nexpected : keeps  actual: " + a.get(3));


    }


}

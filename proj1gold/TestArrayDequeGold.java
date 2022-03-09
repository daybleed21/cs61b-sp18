import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testSomeMethod(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> array = new ArrayDequeSolution<>();
        int count = 0;
        for(int i = 0; i < 500; i++){
            if(i % 5 == 0){
                assertEquals("Test size()",student.size(),array.size());
            }
            double num = StdRandom.uniform();
            if(num < 0.25){
                student.addLast(i);
                array.addLast(i);
                assertEquals("addLast(" + i + ")",student.get(count),array.get(count));
                count++;
            }else if(num >= 0.25 && num < 0.5) {
                student.addFirst(i);
                array.addFirst(i);
                assertEquals("addFirst(" + i + ")", student.get(0),array.get(0));
                count++;
            }else if(count > 0 && num >= 0.5 && num < 0.75 ){
                Integer stuExpected = student.get(0);
                Integer stuActual = student.removeFirst();
                assertEquals("NOt good Random Number. expected:"
                        +stuExpected+"actual:"+stuActual,stuExpected,stuActual);
                Integer arrExpected = array.get(0);
                Integer arrActual = array.removeFirst();
                assertEquals("NOt good Random Number. expected:"
                        +arrExpected+"actual:"+arrActual,arrExpected,arrActual);
                count--;
            }else if(count > 0){
                student.removeLast();
                array.removeLast();
                count--;
            }




        }
    }

}

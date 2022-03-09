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
//                assertEquals("StudentArrayDeque addLast(" + i + ")",(Integer) i,student.get(count));
                assertEquals("addLast("+i+")", student.get(count), array.get(count));
                count++;
            }else if( num < 0.5) {
                student.addFirst(i);
                assertEquals("StudentArrayDeque addFirst (" + i +")",(Integer)i,student.get(0));
                array.addFirst(i);
                assertEquals("ArrayDequeSolution addFirst(" + i + ")", (Integer) i, array.get(0));
                count++;
            }else if( num < 0.75 ){
                if(student.isEmpty()){
                    assertTrue("isEmpty()", student.isEmpty());
                    continue;
                }
                Integer stuExpected = student.get(0);
                Integer stuActual = student.removeFirst();
                assertEquals("StudentArrayDeque removeFirst()",stuExpected,stuActual);
                Integer arrExpected = array.get(0);
                Integer arrActual = array.removeFirst();
                assertEquals("ArrayDequeSolution removeFirst()"
                        ,arrExpected,arrActual);
                count--;
            }else {
                if(student.isEmpty()){
                    assertTrue("isEmpty()", student.isEmpty());
                    continue;
                }
                Integer stuExpected = student.get(count - 1);
                Integer stuActual = student.removeLast();
                assertEquals("StudentArrayDeque removeLast()",stuExpected,stuActual);
                Integer arrExpected = array.get(count - 1);
                Integer arrActual = array.removeLast();
                assertEquals("ArrayDequeSolution removeLast()",arrExpected,arrActual);
                count--;
            }




        }
    }

}

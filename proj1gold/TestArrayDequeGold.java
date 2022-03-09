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
                count++;
                assertEquals("addLast("+i+")", array.get(count - 1), student.get(count - 1));
            }else if( num < 0.5) {
                student.addFirst(i);
                array.addFirst(i);
                count++;
//                assertEquals("StudentArrayDeque addFirst (" + i +")",(Integer)i,student.get(0));
                assertEquals("addFirst(" + i + ")", array.get(0), student.get(0));
            }else if( num < 0.75 ){
                if(student.isEmpty()){
                    assertTrue("isEmpty()", student.isEmpty());
                    continue;
                }
                Integer stuActual = student.removeFirst();
                Integer arrActual = array.removeFirst();
                assertEquals("removeFirst()",arrActual,stuActual);
                count--;
            }else {
                if(student.isEmpty()){
                    assertTrue("isEmpty()", student.isEmpty());
                    continue;
                }
                Integer stuActual = student.removeLast();
                Integer arrActual = array.removeLast();
                assertEquals("removeLast()",arrActual,stuActual);
                //assertEquals("ArrayDequeSolution removeLast()",arrExpected,arrActual);
                count--;
            }




        }
    }

}

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testSomeMethod(){
        StringBuilder msg = new StringBuilder("\n");
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> array = new ArrayDequeSolution<>();
        int count = 0;
        for(int i = 0; i < 500; i++){
            if(i % 5 == 0){
                msg.append("size()\n");
                assertEquals(msg.toString(),student.size(),array.size());
            }
            double num = StdRandom.uniform();
            if(num < 0.25){
                student.addLast(i);
                array.addLast(i);
                msg.append("addLast("+ i +")\n");
//                assertEquals("StudentArrayDeque addLast(" + i + ")",(Integer) i,student.get(count));
                count++;
                assertEquals(msg.toString(), array.get(count - 1), student.get(count - 1));
            }else if( num < 0.5) {
                student.addFirst(i);
                array.addFirst(i);
                count++;
                msg.append("addFirst(" + i + ")\n");
//                assertEquals("StudentArrayDeque addFirst (" + i +")",(Integer)i,student.get(0));
                assertEquals(msg.toString(), array.get(0), student.get(0));
            }else if( num < 0.75 ){
                if(student.isEmpty()){
                    msg.append("isEmpty()\n");
                    assertTrue("isEmpty()", student.isEmpty());
                    continue;
                }
                Integer stuActual = student.removeFirst();
                Integer arrActual = array.removeFirst();
                msg.append("removeFirst()\n");
                assertEquals(msg.toString(),arrActual,stuActual);
                count--;
            }else {
                if(student.isEmpty()){
                    msg.append("isEmpty()\n");
                    assertTrue(msg.toString(), student.isEmpty());
                    continue;
                }
                Integer stuActual = student.removeLast();
                Integer arrActual = array.removeLast();
                count--;
                msg.append("removeLast()\n");
                assertEquals(msg.toString(),arrActual,stuActual);
                //assertEquals("ArrayDequeSolution removeLast()",arrExpected,arrActual);
            }




        }
    }

}

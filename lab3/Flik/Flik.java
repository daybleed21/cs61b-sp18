import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    @Test
    public void testisSameNumber(){
        int a = 129;
        int b = a;
        assertTrue(isSameNumber(a,b));

    }

}

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    //Test OffByN

    @Test
     public void testOffByN(){
         OffByN diff4 = new OffByN(4);
         assertTrue(diff4.equalChars('a','e'));
         assertFalse(diff4.equalChars('b','c'));
     }
}

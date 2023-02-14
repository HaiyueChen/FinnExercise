package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Classes.TypeA;

public class SampleTest {
    
    @Test
    public void test(){
        assertEquals("TypeA", new TypeA().getString());
    }
    
}

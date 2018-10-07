
import org.junit.jupiter.api.*;

import java.beans.Transient;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class test{
    Node root;
    
    @BeforeEach
    void init(){
        //basic tree
        root = new Question("Piros?");
        root.SetFA("korte");
        root.SetRA("alma");
    }
    

    @Test
    void questionTest(){
        String data;
        data = root.getData();
        assertEquals(data, "Piros?");
    
    }
}
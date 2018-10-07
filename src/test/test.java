
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;


public class test{
    Node root;
    
    @BeforeEach
    void init(){
        //basic tree
        root = Serialize.deSer();
    }
    

    @Test
    void questionTest(){
        String data;
        data = root.getData();
        assertEquals(data, "Piros?");
    }

    @Test
    void QuestionRunNULLTest(){
        Node quest = new Question("Piros?");
        boolean throws_err = false;
        try {
            //System.setIn(new ByteArrayInputStream("y".getBytes()));
            quest.run();  
        } catch (NullPointerException e) {
            System.out.println("Error");
            throws_err = true;
        }
        catch(Exception e){
        }
        assertTrue(throws_err);
    }

    @Test
    void QuestionRunTest(){
        try {
            System.setIn(new ByteArrayInputStream("y".getBytes()));
            System.setIn(new ByteArrayInputStream("y".getBytes()));
            assertTrue(!root.run());
        } catch (Exception e) {
            //TODO: handle exception
        }

        
    }

    @Test
    void QuestionWrongAnsTest(){
        boolean no_ex = true;
        Question quest = new Question("Piros?");
        quest.SetFA("Korte");
        quest.SetRA("Alma");
        try {
            quest.wrong_ans(true);
            quest.wrong_ans(false);
        } catch (Exception e) {
            no_ex = false;
        }
        assertTrue(no_ex);
    }

    @Test
    void AnswerRun(){
        Node ans = new Answer("Auto");
        boolean is_correct = false;
        System.setIn(new ByteArrayInputStream("y".getBytes()));
        try {
           is_correct =  ans.run(); 
        } catch (Exception e) {
            //TODO: handle exception
        }
        assertTrue(is_correct);
    }

}
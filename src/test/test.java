
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;



public class test{
    Question quest = null;
    

    //Simulated user input strings
    String simulatedData1 =  "Ferrari" + System.getProperty("line.separator")
    + "Auto?" + System.getProperty("line.separator");

    String simulatedData2 =  "Citrom" + System.getProperty("line.separator")
    + "Citrus fele?" + System.getProperty("line.separator");
    //_________________________

    @BeforeEach
    void init(){
        //basic tree
        //-----------------------
        //Alap fa   Piros?
        //          /    \
        //        Alma  Korte
        //-----------------------
        quest = new Question("Piros?");
        quest.SetRA("Alma");
        quest.SetFA("Korte");
        //-----------------------
    }
    

    //Abban az esetben ha nincs talalat bovitia fat, es a felhasznalotol bekeri
    //a szukseges adatokat.

    //Append tree. Logic and UI test with simulated datas.
    @Test
    void WrongAnsTestTrue(){
        boolean catch_ex = false;
        try {
            System.setIn(new ByteArrayInputStream(simulatedData1.getBytes()));
            quest.wrong_ans(true);  
        }
        catch(Exception e){
            catch_ex = true;
        }
        assertFalse(catch_ex);
        assertEquals(quest.GetRA().getData(), "Auto?");
    }

    //Append tree. Logic and UI test with simulated datas.
    @Test
    void WrongAnsTestFalse(){
        boolean catch_ex = false;
        try {
            System.setIn(new ByteArrayInputStream(simulatedData2.getBytes()));
            quest.wrong_ans(false);  
        }
        catch(Exception e){
            catch_ex = true;
        }
        assertFalse(catch_ex);
        assertEquals(quest.GetFA().getData(), "Citrus fele?");
    }

    //Constructor test
    @Test
    void QuestionConsTest(){
        String data;
        data = quest.getData();
        assertEquals(data, "Piros?");
    }

    //Logic(Error thrown test)
    @Test
    void QuestionRunNULLTest(){
        Node quest = new Question("Piros?");
        boolean throws_err = false;
        try {
            quest.run();  
        } catch (NullPointerException e) {
            throws_err = true;
        }
        catch(Exception e){
        }
        assertTrue(throws_err);
    }

    //Logic test + User input test;
    // TODO: Run test, need refactor run()!
    @Test
    void QuestionRunTest(){

        try {
            System.setIn(new ByteArrayInputStream("y".getBytes()));
            quest.run();
        } catch (Exception e) {
            assertTrue(false);
        }

        
    }

    //Logic testing
    @Test
    void AnswerRun(){
        Node ans = new Answer("Auto");
        boolean is_correct = false;
        try {
           is_correct =  ans.run(); 
        } catch (Exception e) {
            is_correct = true;
        }
        assertTrue(is_correct);
    }


    //Database testing
    @Test
    void SerializeTest(){

        Serialize.Ser(quest);
        Node deserroot = Serialize.deSer();
        assertEquals(deserroot.getData(), "Piros?");

    }



}
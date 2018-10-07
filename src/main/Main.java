import java.io.*;

public class Main{
    public static void main(String args[]) throws NullPointerException, IOException {
       Node root = null;
        
        root = Serialize.deSer();
        root.run();
        Serialize.Ser(root);
   

    }
}
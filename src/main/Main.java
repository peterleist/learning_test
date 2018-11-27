import java.io.*;

public class Main {
    public static void main(String args[]) throws NullPointerException, IOException {
        Node root = null;

        root = Serialize.deSer();
        if (root == null) {
            root = new Question("Piros?");
            root.SetRA("Alma");
            root.SetFA("Korte");
            System.out.print("valami");
        }
        root.run();

        Serialize.Ser(root);

    }
}
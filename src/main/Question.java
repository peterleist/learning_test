import java.io.Serializable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question extends Node implements Serializable{
    private static final long serialVersionUID = 1L;
    private Node right_a;
    private Node false_a;
    private boolean is_ok;

    public Question(String question){
        super(question);
    }

    public void SetRA(String answer){
        right_a = new Answer(answer);
    }
    public void SetFA(String answer){
        false_a = new Answer(answer);
    }

    public boolean run(){
        try {
            System.out.println(this.getData());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            switch(br.readLine()){
                case "y": 
                    if(!right_a.run()){
                        wrong_ans(true);
                    }
                    break;
                case "n": 
                    if(!false_a.run()){
                        wrong_ans(false);
                    }
                break;
            }  
            //System.out.println(right_a.getData());
        } catch (Exception e) {
            //TODO: handle exception
        }
        return true;
        
    }

    public void wrong_ans(boolean side){

        String true_ans, true_ques;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Mire gondoltal?");
            true_ans = br.readLine();
            System.out.println("Mond egy krdest amire az igen valasz: " + true_ans);
            true_ques = br.readLine();
            if(side){
                Node temp;
                temp = right_a;
    
                right_a = new Question(true_ques);
                right_a.SetFA(temp.getData());
                right_a.SetRA(true_ans);
            }
            else{
                Node temp;
                temp = false_a;
    
                false_a = new Question(true_ques);
                false_a.SetFA(temp.getData());
                false_a.SetRA(true_ans); 
            }


        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
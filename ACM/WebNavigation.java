
import java.util.Scanner;
//ShareCode

public class WebNavigation{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int testCase=cin.nextInt();
        cin.nextLine();
        for(int i=0;i<testCase;i++){
            String stack[]=new String[200];
            int backward=-1;int forward=200;
            String current="http://www.acm.org/";
            while(true){
                String command=cin.nextLine();
                String result="";
                if(command.equals("QUIT"))
                    break;
                else if(command.equals("BACK"))
                    if(backward<=-1)result="Ignored";
                    else {
                        result=stack[backward--];
                        stack[--forward]=current;
                        current=result;
                    }
                else if(command.equals("FORWARD"))
                    if(forward>=200) result="Ignored";
                    else{
                        result=stack[forward++];
                        stack[++backward]=current;
                        current=result;
                    }
                else{
                    result=command.substring(6, command.length());
                    stack[++backward]=current;
                    current=result;
                    forward=200;
                }
                System.out.println(result);

            }//while
        }//for
    }//main Method
}//Class Main
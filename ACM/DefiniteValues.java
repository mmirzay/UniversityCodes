
import java.util.Scanner;
//ShareCode
//accepted
public class DefiniteValues{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int counter=0;
        while(true){
            int lines=cin.nextInt();
            if(lines==0)break;
            cin.nextLine();
            counter++;
            String exp[]=new String[lines];
            for(int i=0;i<lines;i++)
                exp[i]=cin.nextLine();
            boolean az[]=new boolean[26];
            az[0]=true;
            for(int i=0;i<lines;i++){
                int e1=exp[i].charAt(0) - 97;
                int e2=exp[i].charAt(4) - 97;
                if(az[e2]) az[e1]=true;
                else az[e1]=false;
            }
            String result="";
            for(int i=0;i<26;i++)
                if(az[i]) result+=(char)(i+97) + " ";
            if(result.equals("")) result="none";
            System.out.println("Program #"+counter);
            System.out.println(result);
            System.out.println("");
        }
    }//main Method
}//Class Main
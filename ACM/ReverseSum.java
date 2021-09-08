
import java.util.Scanner;
//ShareCode
//accepted
public class ReverseSum{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int counter=cin.nextInt();
        for(int i=0;i<counter;i++){
            String num1=cin.next();
            String num2=cin.next();
            String result="",revers1="",revers2="";
            for(int j=num1.length()-1;j>=0;j--)
                revers1+=num1.charAt(j);
            for(int j=num2.length()-1;j>=0;j--)
                revers2+=num2.charAt(j);
            num1=""+(Integer.parseInt(revers1)+Integer.parseInt(revers2));
            for(int j=num1.length()-1;j>=0;j--)
                result+=num1.charAt(j);
            System.out.println(""+(Integer.parseInt(result)));
        }
    }//main Method
}//Class Main

import java.util.Scanner;
//ShareCode
//accepted
public class NoBrainer{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        for(int i=1;i<=t;i++){
            int x=cin.nextInt();
            int y=cin.nextInt();
            if(x<y)System.out.println("NO BRAINS");
            else    System.out.println("MMM BRAINS");
        }
    }//main Method
}//Class Main
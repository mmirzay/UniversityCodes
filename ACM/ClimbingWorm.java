
import java.util.Scanner;
//ShareCode
//accepted
public class ClimbingWorm{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            int n=cin.nextInt();
            if(n==0)break;
            int u=cin.nextInt();
            int d=cin.nextInt();
            int counter=1;
            while(true){
                n-=u;
                if(n<=0) break;
                counter++;
                n+=d;
                counter++;
            }
            System.out.println(counter);
        }
    }//main Method
}//Class Main
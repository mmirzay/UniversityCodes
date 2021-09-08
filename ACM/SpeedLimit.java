
import java.util.Scanner;
//ShareCode

public class SpeedLimit{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            int n=cin.nextInt();
            if(n==-1) break;
            int speed=0;
            int lastT=0;
            for(int i=0;i<n;i++){
                int s=cin.nextInt();
                int t=cin.nextInt();
                speed+=s*(t-lastT);
                lastT=t;
            }
            System.out.println(speed+" miles");
        }//while
    }//main Method
}//Class Main
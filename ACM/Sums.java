
import java.util.Scanner;
//ShareCode
//accepted
public class Sums{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        for(int i=0;i<t;i++){
            int num=cin.nextInt();
            int s1=(num*(num+1))/2;
            int s2=num*num;
            int s3=s2+num;
            System.out.println(""+s1+" "+s2+" "+s3);
        }
    }//main Method
}//Class Main
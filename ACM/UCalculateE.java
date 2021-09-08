
import java.util.Scanner;
//ShareCode

public class UCalculateE{
    static double fact(int i){
        if(i==0 || i==1) return 1;
        return fact(i-1)*i;
    }
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        System.out.println("n e");
        System.out.println("- -----------");
        for(int j=0;j<=9;j++){
            int num=j;
            double e=0;
            for(int i=0;i<=num;i++)
                e+=1/fact(i);
            if(e<=2) System.out.println(j+" "+(int)e);
            else if(e==2.5)System.out.println(j+" "+"2.5");
            else{
                System.out.print(j+" ");
                System.out.printf("%.9f\n",e);
            }
        }
    }//main Method
}//Class Main
/* 6023 shareCode */
import java.util.Scanner;

public class RootOfProblem {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);        
        while(true){
            long b=cin.nextLong();
            int n=cin.nextInt();
            if(b==0 && n==0) break;
            long up=0, low=Long.MAX_VALUE, res=0;
            short counter=0;
            while(counter<=b){
                res=(long)Math.pow(counter, n);
                if(res>=up && res<=b)
                    up=res;
                else if(res<=low && res>=b)
                    low=res;
                else
                    break;              
                counter++;
            }
            if(b-up<=low-b)
                res=up;
            else
                res=low;            
            long resCopy=res;counter=0;
            while(counter<=b){
                res=(int)Math.pow(counter, n);
                if(res==resCopy){
                    System.out.println(counter);
                    break;
                }
                counter++;
            }            
        }
    }
}

/* 6001 shareCode */
import java.util.Scanner;

public class Undercut {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int round=cin.nextInt();
        while(round!=0){
            int a[]=new int[round];
            int b[]=new int[round];
            for(int i=0;i<round;i++)
                a[i]=cin.nextInt();
            for(int i=0;i<round;i++)
                b[i]=cin.nextInt();
            int aPoint=0,bPoint=0;
            for(int i=0;i<round;i++){
                int def=a[i]-b[i];
                boolean maxIsA=true;
                if(def<0){
                    maxIsA=false;
                    def*=-1;
                }
                if(def==1){
                    if(a[i]==2)
                        bPoint+=6;
                    else if(b[i]==2)
                        aPoint+=6;
                    else if(maxIsA)
                        bPoint+=a[i]+b[i];
                    else
                        aPoint+=a[i]+b[i];
                }else if(def>0){
                    if(maxIsA)
                        aPoint+=a[i];
                    else
                        bPoint+=b[i];
                }
            }
            System.out.println("A has "+aPoint+" points. B has "+bPoint+" points.");
            round=cin.nextInt();
            if(round!=0) System.out.println("");
        }
    }
}

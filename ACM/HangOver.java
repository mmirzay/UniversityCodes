/*1032 shareCode*/
// accepted
import java.util.Scanner;

public class HangOver {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(true){
            float c=cin.nextFloat();
            if(c==0f)
                break;
            float sum=0;
            for(int i=1;i<=280;i++){
                sum+=1f/(i+1);
                if(sum>=c){
                    System.out.println(""+i+" card(s)");
                    break;
                }
            }
        }
    }
}

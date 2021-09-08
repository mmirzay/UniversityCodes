
import java.util.Scanner;
//ShareCode
//accepted
public class SkewBinery{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            String num=cin.nextLine();
            if(num.equals("0")) break;
            int sum=0;
            for(int i=0;i<num.length();i++){
                int d=Integer.parseInt(""+num.charAt(i));
                sum+=d*(Math.pow(2, num.length()-i)-1);
            }
            System.out.println(""+sum);
        }
    }//main Method
}//Class Main

import java.math.BigInteger;
import java.util.Scanner;
//ShareCode
//accepted
public class IntegerInquiry{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        cin.nextLine();cin.nextLine();
        BigInteger sum=new BigInteger("0");
        for(int i=0;i<n;i++){
            while (true) {
                String num = cin.nextLine();
                if(num.equals("")) continue;
                if (num.equals("0")) {
                    System.out.println(sum);
                    sum=new BigInteger("0");
                    break;
                }
                sum=sum.add(new BigInteger(num));
            }
            if(i!=n-1) System.out.println("");
        }
    }//main Method
}//Class Main
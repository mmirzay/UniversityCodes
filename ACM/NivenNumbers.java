
import java.util.Scanner;
//ShareCode

public class NivenNumbers{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int cas=Integer.parseInt(cin.nextLine());
        for(int k=1;k<=cas;k++){
            cin.nextLine();
            while (true) {
                int base = cin.nextInt();
                if (base == 0) {
                    cin.nextLine();
                    break;
                }
                String num = cin.next();
                int numint = 0;
                int counter = 0;
                for (int i = num.length() - 1; i >= 0; i--) {
                    int dig = Integer.parseInt("" + num.charAt(i));
                    numint += dig * Math.pow(base, counter);
                    counter++;
                }
                int sum=0;
                int temp=numint;
                while(numint>0){
                    sum+=numint%10;
                    numint/=10;
                }
                numint=temp;
                if(numint%sum==0)System.out.println("yes");
                else System.out.println("no");
            }
            if(k!=cas) System.out.println("");
        }
    }//main Method
}//Class Main
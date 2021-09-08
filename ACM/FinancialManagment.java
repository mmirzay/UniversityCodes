/* 1035 shareCode*/
// accepted
import java.util.Scanner;

public class FinancialManagment {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        float sum=0;
        for(int i=1;i<=12;i++)
            sum+=cin.nextFloat();
        System.out.printf("$"+"%.2f\n", (sum/12));
    }
}

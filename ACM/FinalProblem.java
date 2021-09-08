
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProblem {
public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        ArrayList<String> dates=new ArrayList<String>();
        int maxFinalIntDate = Integer.MIN_VALUE;
        int finalIntDate=0;
        while(true){
            dates.add(cin.nextLine());
            String last=dates.get(dates.size()-1);
            if(last.equals("END"))
                break;
            else if(last.equals("GetFinal"))
                System.out.println(""+finalIntDate);
            else{
                if(maxFinalIntDate<Long.parseLong(last.trim())){
                    finalIntDate=maxFinalIntDate;
                    maxFinalIntDate=Integer.parseInt(last.trim());
                }
            }

        }//while
    }//main Method
}

/* 1119 shareCode */
//accepted
import java.util.Scanner;

public class GoodOrBad {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int nameCounter=cin.nextInt();
        cin.nextLine();
        for(int i=1;i<=nameCounter;i++){
            String name=cin.nextLine();
            int gCounter=0,bCounter=0;
            for(int j=0;j<name.length();j++)
                if(name.charAt(j)=='g' || name.charAt(j)=='G')
                    gCounter++;
                else if(name.charAt(j)=='b' || name.charAt(j)=='B')
                    bCounter++;
            if(gCounter>bCounter)
                System.out.println(name+" is GOOD");
            else if(bCounter>gCounter)
                System.out.println(name+" is A BADDY");
            else
                System.out.println(name+" is NEUTRAL");
        }
    }
}

/* 2203 */
import java.util.Scanner;

public class Smith{
    public static void main(String[] arg1){
        long smith=0, smithCopy=0, smithShow=0;
        int count=0, smithCount=0;
        Scanner cin=new Scanner(System.in);
        count=cin.nextInt();
        smith=cin.nextLong();
        while(smithCount<count && smith<1000000000){
            smithCopy=smithShow=smith;
            long fact=2, factCopy=0, factF=2;
            int factFcount=0;
            int factSum=0;
            int digSum=0;
            while(fact<=smith){
                while(smith%fact==0){
                    factFcount=0;
                    factF=2;
                    while(factF<=fact/2){
                        if(fact%factF==0){
                            factFcount++;
                            break;
                        }
                        factF++;
                    }
                    if(factFcount<=0){
                        factCopy=fact;
                        while(factCopy>0){
                            factSum+=factCopy%10;
                            factCopy/=10;
                        }
                    }
                    smith/=fact;
                }
                fact++;
            }
            while(smithCopy>0){
                digSum+=smithCopy%10;
                smithCopy/=10;
            }
            if(factSum==digSum){
                System.out.println(""+smithShow);
                smithCount++;
            }
            smithShow++;
            smith=smithCopy=smithShow;
        }
    }
}
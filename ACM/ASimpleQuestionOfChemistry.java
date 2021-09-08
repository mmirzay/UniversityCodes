
import java.util.Scanner;

//1020 shareCode
//accepted
public class ASimpleQuestionOfChemistry {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        float lastTemp=cin.nextFloat(),def=0,curTemp=cin.nextFloat();
        while(curTemp!=999){
            def=curTemp-lastTemp;
            System.out.printf("%.2f\n",def);
            lastTemp=curTemp;
            curTemp=cin.nextFloat();
        }
        System.out.println("End of Output");
    }
}

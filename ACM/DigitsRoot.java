import java.util.Scanner;
//6002 shareCode
//accepted
public class DigitsRoot {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        String num=cin.nextLine();
        while(!num.equals("0")){
            int sum=0, realSum=0;
            do{
                int counter=0;
                while(counter<num.length()){
                    realSum+=Integer.parseInt(""+num.charAt(counter));                    
                    counter++;                    
                }
                sum=realSum;
                num=""+realSum;                
                realSum=0;
            }while(sum>9);
            System.out.println(sum);
            num=cin.nextLine();
        }
    }
}

/* 1021 shareCode*/
// accepted
import java.util.Scanner;


public class ContestingDecision {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        byte partCount=cin.nextByte();
        byte counter=1, maxSolved=Byte.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        String winner="";
        while(counter<=partCount){
            String name=cin.next();
            int mul=0;
            byte solved=0;            
            for(int i=0;i<4;i++){
                byte sub=cin.nextByte();
                int penalt=cin.nextInt();
                if(penalt!=0)
                    solved++;
                if(sub>1 && penalt!=0){
                    sub--;                    
                    penalt+=sub*20;
                }                
                mul+=penalt;                
            }            
            if(mul<min && solved>=maxSolved){
                min=mul;
                maxSolved=solved;
                winner=name;
            }            
            counter++;
        }
        System.out.println(""+winner+" "+maxSolved+" "+min);
    }
}

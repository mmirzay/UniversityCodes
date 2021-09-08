/* 1167 shareCode */
// accepted
import java.util.Scanner;

public class StrangeClock {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(true){
            int ang=cin.nextInt();
            if(ang==-1) break;            
            boolean isExact=false;
            int counter=-1;
            if(ang<=90){
                counter=3;
                if(ang%30==0){
                    counter++;
                    isExact=true;
                }
                while(ang>=0){
                    counter--;
                    ang-=30;                    
                }                
            }else if(ang<=180){
                counter=12;
                if(ang%30==0){
                    counter++;
                    isExact=true;
                }
                while(ang>=90){
                    counter--;
                    ang-=30;                    
                }
            }else if(ang<=270){
                counter=9;
                if(ang%30==0){
                    counter++;
                    isExact=true;
                }
                while(ang>=180){
                    counter--;
                    ang-=30;
                }
            }else{
                counter=6;
                if(ang%30==0){
                    counter++;
                    isExact=true;
                }
                while(ang>=270){
                    counter--;
                    ang-=30;
                }
            }
            if(counter==12) counter=0;
            int clock2=counter+1;
            if(clock2==12) clock2=0;
            if(isExact)
                System.out.println("Exactly "+counter+" o'clock");
            else
                System.out.println("Between "+counter+" o'clock and "+clock2+" o'clock");
        }
    }
}

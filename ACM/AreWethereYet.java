
import java.util.Scanner;

/*problem 1002 share Code*/
// accepted
public class AreWethereYet {
    public static void main(String[] args){
        Scanner cin= new Scanner(System.in);
        int cookPos=cin.nextInt();
        while(cookPos!=5280){
            int lastPos=0, curPos;                       
            while(true){
                curPos=cin.nextInt();
                if(curPos==cookPos) break;
                int curDfc=curPos-cookPos;
                int lastDfc=lastPos-cookPos;
                if(curDfc<0) curDfc*=-1;
                if(lastDfc<0) lastDfc*=-1;
                if(curDfc>lastDfc)
                    System.out.println("Moving from "+lastPos+" to "+curPos+": colder.");
                else if(curDfc==lastDfc)
                    System.out.println("Moving from "+lastPos+" to "+curPos+": same.");
                else
                    System.out.println("Moving from "+lastPos+" to "+curPos+": warmer.");
                lastPos=curPos;
            }
            System.out.println("Moving from "+lastPos+" to "+curPos+": found it!");
            cookPos=cin.nextInt();
            if(cookPos!=5280)
                System.out.println("");
        }
    }
}

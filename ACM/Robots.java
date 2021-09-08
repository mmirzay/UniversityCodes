
import java.util.Scanner;

// 1013 share code
public class Robots {
    public static void main (String[] args){
        Scanner cin=new Scanner(System.in);
        int maxI, maxJ, lastI, lastJ, minI=25, minJ=25;
        maxI=cin.nextInt(); maxJ=cin.nextInt();
        lastI=maxI;lastJ=maxJ;
        while(maxI!=-1 && maxJ!=-1){
            int robotCounter=0;
            int i=cin.nextInt();
            int j=cin.nextInt();
            while(i!=0 && j!=0){
                //System.out.println("maxI= "+maxI);
                //System.out.println("maxJ= "+maxJ);
                //System.out.println("minI= "+minI);
                //System.out.println("minJ= "+minJ);
                //System.out.println("lastI= "+lastI);
                //System.out.println("lastJ= "+lastJ);
                //System.out.println("i= "+i);
                //System.out.println("j= "+j);
                if(robotCounter==0) robotCounter=1;                
                boolean noNewRobot=false;
                if(i>=maxI && j>=maxJ){
                    //System.out.println("if 1");
                    noNewRobot=true;
                    maxI=i; maxJ=j;                    
                }else if(i>=lastI && j>=lastJ){
                    //System.out.println("if 2");
                    noNewRobot=true;                    
                }else if(i>minI && j>minJ){
                    //System.out.println("if 5");
                    minI=i;minJ=j;
                    noNewRobot=true;
                }else if(i<=minI || j<=minJ){
                    //System.out.println("if 3");
                    minI=i; minJ=j;
                }
                lastI=i; lastJ=j;
                if(!noNewRobot){
                    //System.out.println("if 4");
                    lastI=i; lastJ=j;
                    robotCounter++;
                }
                //System.out.println("robotCounter= "+robotCounter);
                i=cin.nextInt();
                j=cin.nextInt();
            }
            System.out.println(robotCounter);
            maxI=cin.nextInt(); maxJ=cin.nextInt();
            lastI=maxI;lastJ=maxJ;
        }
    }

}

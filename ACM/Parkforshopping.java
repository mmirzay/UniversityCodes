// 1076 share code
// accepted
import java.util.Scanner;


public class Parkforshopping {
public static void main(String[] args){
        int counter=0;
        Scanner cin=new Scanner(System.in);
        counter=cin.nextInt();
        for(int i=0;i<counter;i++){
            int max=0,min=Integer.MAX_VALUE;
            int parkCount=cin.nextInt();
            for(int j=0;j<parkCount;j++){
               int curPark=cin.nextInt();
               if(curPark>max) max=curPark;
               if(curPark<min) min=curPark;
            }
            System.out.println((2*(max-min)));
        }
    }
}

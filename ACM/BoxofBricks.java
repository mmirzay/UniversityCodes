//accepted
import java.util.Scanner;


public class BoxofBricks {
        public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int counter=0;
        while (true) {
            int stackBob = cin.nextInt();
            if (stackBob == 0) {
                return;
            } else {
                counter++;
                int moves = 0;
                int sum = 0;
                int hieght = 0;
                int bricks[] = new int[stackBob];
                for (int i = 0; i < stackBob; i++) {
                    bricks[i] = cin.nextInt();
                    sum += bricks[i];
                    hieght = sum / stackBob;
                }
                for(int i=0;i<stackBob;i++)
                    if(bricks[i]-hieght>0)
                        moves+=bricks[i]-hieght;
                System.out.println("Set #"+counter);
                System.out.println("The minimum number of moves is "+moves+".");
                System.out.println("");

            }//else
        }//while true

    }//main Method
}

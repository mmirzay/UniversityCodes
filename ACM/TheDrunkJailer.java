
import java.util.Scanner;
//ShareCode
//accepted
public class TheDrunkJailer{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        for(int i=0;i<t;i++){
            int cel=cin.nextInt();
            boolean cells[]=new boolean[cel+1];
            int counter=0;
            for(int k=1;k<=cel;k++)
                cells[k]=true;
            for(int k=2;k<=cel;k++)
                for(int j=1;j<=cel;j++){
                    if(j%k==0 && cells[j]){
                        cells[j]=false;
                    }else if(j%k==0 && !cells[j]){
                        cells[j]=true;
                    }
                }
            for(int k=1;k<=cel;k++)
                if(cells[k]) counter++;
            System.out.println(counter);
        }
    }//main Method
}//Class Main
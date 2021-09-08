
import java.util.Scanner;
//ShareCode
//accepted

public class PseudoRandomNumbers{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int cas=1;
        while(true){
            int z = cin.nextInt();
            int i = cin.nextInt();
            int m = cin.nextInt();
            long l = cin.nextLong();
            if(z==0 && i==0 && m==0 && l==0) break;
            int counter=0;
            long rand=-1;
            long last=l;
            while(rand!=last){
                rand=(z*l+i)%m;
                l=rand;
                counter++;
                if(counter>100000){
                    last=rand;
                    rand=(z*l+i)%m;
                    counter=0;
                }
            }
            System.out.println("Case "+cas+": "+counter);
            cas++;
        }
    }//main Method
}//Class Main
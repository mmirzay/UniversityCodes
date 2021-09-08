
import java.util.Scanner;
//ShareCode
// accepted
public class BineryNumbers{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int data=cin.nextInt();
        for(int i=0;i<data;i++){
            int n=cin.nextInt();
            String bin="";
            while(n>0){
                bin+=""+n%2;
                n/=2;
            }
            bin+=n;
           // System.out.println("bin: "+bin);
            for(int j=0;j<bin.length();j++){
                if(bin.charAt(j)=='1'){
                    System.out.print(j);
                    if(j!=bin.length()-2)
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }//main Method
}//Class Main
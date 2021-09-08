/* 2009 shareCode*/
// accepted
import java.util.Scanner;

public class TwoWayCarryPropagation {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(true){
            int num=cin.nextInt();
            int b=cin.nextInt();
            if(num==0 && b==0) break;
            int counter=0;
            String res="", bRes="", sumRes="";
            while(num!=0){
                counter++;
                res+=""+num%2;
                num/=2;
            }
            while(counter<8){
                res+="0";
                counter++;
            }
            counter=0;
            while(b!=0){
                counter++;
                bRes+=""+b%2;
                b/=2;
            }
            while(counter<8){
                bRes+="0";
                counter++;
            }
            for(int i=0;i<res.length();i++)
                sumRes+=""+(Byte.parseByte(""+res.charAt(i))+Byte.parseByte(""+bRes.charAt(i)));
            int dig[]=new int[sumRes.length()];
            counter=0;
            for(int i=0;i<sumRes.length();i++)
                dig[i]=Byte.parseByte(""+sumRes.charAt(i));
            while(counter<sumRes.length()){
                int d=dig[counter];
                if(d==0 || d==1){
                    dig[counter]=d;
                }else if(d==2){
                    dig[counter]=0;
                    if(counter==0)
                        dig[counter+1]++;
                    else{
                        dig[counter-1]++;
                        dig[counter+1]++;
                    }
                    counter=0;
                    continue;
                }
                counter++;
            }
            int finRes=0;
            for(int i=0;i<sumRes.length();i++)
                finRes+=dig[i]*(int)Math.pow(2, i);
            System.out.println(""+finRes);
        }
    }
}

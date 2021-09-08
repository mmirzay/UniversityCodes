//accepted
import java.util.Scanner;

public class IranianCommunityofPrize {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int cases=cin.nextInt();
        for(int i=0;i<cases;i++){
            int n=cin.nextInt();
            int m=cin.nextInt();
            String result="";
            int need[]=new int[n];
            int bought[]=new int[m];
            for(int j=0;j<n;j++)
                need[j]=cin.nextInt();
            for(int j=0;j<m;j++)
                bought[j]=cin.nextInt();
            for(int j=0;j<n;j++)
                for(int k=j+1;k<n;k++)
                    if(need[j]>need[k]){
                        int temp=need[j];
                        need[j]=need[k];
                        need[k]=temp;
                    }
            for(int j=0;j<n;j++){
                boolean hasBought=false;
                for(int k=0;k<m;k++)
                    if(need[j]==bought[k]){
                        hasBought=true;
                        break;
                    }
                if(!hasBought)
                    if(!result.equals(""))
                        result+=","+need[j];
                    else result=need[j]+"";
            }
            System.out.println(result);
        }
    }//main Method

}

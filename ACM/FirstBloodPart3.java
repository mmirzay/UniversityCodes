/* 2004 shareCode */
import java.util.Scanner;

public class FirstBloodPart3 {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int cas=cin.nextInt();
        for(int i=1;i<=cas;i++){
            double hint=cin.nextDouble();
            int w=cin.nextInt();
            double aliW[]=new double[6];
            double rezaW[]=new double[6];
            int counter=0;
            for(int j=1;j<=w;j++)
                if(aliW[counter]==0)
                    aliW[counter]=cin.nextDouble();
                else{
                    rezaW[counter]=cin.nextDouble();
                    counter++;
                }
            boolean isAli=true;
            double wep=-1,aliWep=-1,rezaWep=-1;            
            for(int l=0;l<6;l++){
                if(aliW[l]>=aliWep)
                    aliWep=aliW[l];
                if(rezaW[l]>=rezaWep)
                    rezaWep=rezaW[l];
            }
            while(hint>1){
                if(isAli){
                    wep=aliWep;
                    isAli=false;
                }
                else{
                    wep=rezaWep;
                    isAli=true;                    
                }
                hint-=hint*wep;
            }
            if(!isAli)
                System.out.println("Ali");
            else
                System.out.println("Reza");
        }
    }
}
// 2106
import java.util.Scanner;


public class DoubleDoubleToilTrouble {
    public static void main(String arg[]){
        double res, dres;
        class Exp{
            float la,lb,lc;
            float dla,dlb,dlc;
            float ua,ub,uc;
            float dua,dub,duc;
            float temp,vol;
            boolean ls, us;
            String status="UNSAFE";
        }
        Scanner cin=new Scanner(System.in);
        int expCount=cin.nextInt();
        Exp exp[]=new Exp[expCount];
        for(int i=0;i<exp.length;i++){
            exp[i]=new Exp();
            exp[i].la=cin.nextFloat();
            exp[i].lb=cin.nextFloat();
            exp[i].lc=cin.nextFloat();            
            exp[i].dla=cin.nextFloat();
            exp[i].dlb=cin.nextFloat();
            exp[i].dlc=cin.nextFloat();            
            exp[i].ua=cin.nextFloat();
            exp[i].ub=cin.nextFloat();
            exp[i].uc=cin.nextFloat();            
            exp[i].dua=cin.nextFloat();
            exp[i].dub=cin.nextFloat();
            exp[i].duc=cin.nextFloat();
            exp[i].temp=cin.nextFloat();
            exp[i].vol=cin.nextFloat();
            res=exp[i].la*exp[i].temp+exp[i].lb*exp[i].vol;
            dres=exp[i].dla*exp[i].temp+exp[i].dlb*exp[i].vol;
            if(res>=dres) exp[i].ls=true;
            res=exp[i].ua*exp[i].temp+exp[i].ub*exp[i].vol;
            dres=exp[i].dua*exp[i].temp+exp[i].dub*exp[i].vol;
            if(res>=dres) exp[i].us=true;
            if(exp[i].ls && exp[i].us) exp[i].status="SAFE";
            System.out.println(""+(i+1)+" "+exp[i].status);
        }        
    }
}

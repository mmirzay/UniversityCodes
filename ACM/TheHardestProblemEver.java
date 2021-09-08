
import java.util.Scanner;
//ShareCode
//accepted
// problem about sezar code
public class TheHardestProblemEver{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            String mes=cin.nextLine();
            if(mes.equals("START") || mes.equals("END")) continue;
            if(mes.equals("ENDOFINPUT"))break;
            String result="";
            for(int i=0;i<mes.length();i++){
                char ch=mes.charAt(i);
                if(ch>='A' && ch<='Z'){
                    int place=ch+21;
                    if(place>90) place=place%90+64;
                    result+=(char)place;
                }else result+=ch;
            }
            System.out.println(result);
        }
    }//main Method
}//Class Main

import java.util.Scanner;
//ShareCode
//accepted

public class CryptoColumns{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            String key=cin.nextLine();
            if(key.equals("THEEND")) break;
            String mes=cin.nextLine();
            int meslen=mes.length();
            int keylen=key.length();
            int mesKey=meslen/keylen;
            char chars[][]=new char[mesKey][keylen];
            for(int i=65;i<=90;i++)
                for(int j=0;j<keylen;j++){
                    char ch=key.charAt(j);
                    if(i==ch){
                        for(int k=0;k<mesKey;k++)
                            chars[k][j]=mes.charAt(k);
                        mes=mes.substring(mesKey);
                    }

                }//for key
            for(int i=0;i<mesKey;i++)
                for(int j=0;j<keylen;j++)
                    System.out.print(chars[i][j]);
            System.out.println("");
        }
    }//main Method
}//Class Main
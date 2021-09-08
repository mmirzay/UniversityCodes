
import java.util.Scanner;
//ShareCode
//accepted
public class WordReversal{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int cas=Integer.parseInt(cin.nextLine());
        for(int k=1;k<=cas;k++){
            cin.nextLine();
            int line=Integer.parseInt(cin.nextLine());
            for(int i=0;i<line;i++){
                String stat=cin.nextLine();
                String rev="", word="";
                for(int j=0;j<stat.length();j++){
                    char chr=stat.charAt(j);
                    if(chr!=' ')
                        word+=""+chr;
                    else{
                        StringBuffer reverse=new StringBuffer(word);
                        rev+=""+reverse.reverse()+" ";
                        word="";
                    }
                    if(j==stat.length()-1){
                        StringBuffer reverse1=new StringBuffer(word);
                        rev+=""+reverse1.reverse();
                    }
                }
                System.out.println(""+rev);
            }
            if(k!=cas) System.out.println("");
        }
    }//main Method
}//Class Main
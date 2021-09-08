
import java.util.Scanner;
//ShareCode
//accepted
//problem about the Morse Code naes P,MTHBGWB

public class MTHBGWB{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        String mors[]=new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                                    "....","..",".---","-.-",".-..","--","-.",
                                    "---",".--.","--.-",".-.","...","-","..-",
                                    "...-",".--","-..-","-.--","--.."};
        int t=cin.nextInt();
        cin.nextLine();
        for(int i=1;i<=t;i++){
            String mes=cin.nextLine();
            String morse="",num="";
            for(int j=0;j<mes.length();j++){
                char ch=mes.charAt(j);
                if(ch=='_'){
                    morse+="..--";
                    num+="4";
                }else if(ch==','){
                    morse+=".-.-";
                    num+="4";
                }else if(ch=='.'){
                    morse+="---.";
                    num+="4";
                }else if(ch=='?'){
                    morse+="----";
                    num+="4";
                }else{
                    morse+=mors[((int)ch)-65];
                    num+=mors[((int)ch)-65].length();
                }
            }//for mes
            mes="";
            for(int p=num.length()-1;p>=0;p--){
                int len=Integer.parseInt(""+num.charAt(p));
                String charac=morse.substring(0, len);
                morse=morse.substring(len);
                boolean isLiteral=false;
                for(int k=0;k<mors.length;k++)
                    if(mors[k].equals(charac)){
                        mes+=(char)(k+65);
                        isLiteral=true;
                        break;
                    }
                if(!isLiteral)
                    if(charac.equals("..--"))
                        mes+="_";
                    else if(charac.equals(".-.-"))
                        mes+=",";
                    else if(charac.equals("---."))
                        mes+=".";
                    else if(charac.equals("----"))
                        mes+="?";
            }
            System.out.println(i+": "+mes);
        }//for t
    }//main Method
}//Class Main
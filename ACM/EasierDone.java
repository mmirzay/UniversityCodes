
import java.util.Scanner;
//ShareCode
//accepted
public class EasierDone{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            String line=cin.nextLine();
            if(line.equals("end")) break;
            boolean isVowel=false;
            boolean isAccept=false;
            int counter=0;
            int vowCounter=0;
            char last='-';
            loop: for(int i=0;i<line.length();i++){
                char ch=line.charAt(i);
                switch (ch){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':{
                        if(isVowel)counter++;
                        else counter=0;
                        if(counter>=2){
                            isAccept=false;
                            break loop;
                        }
                        //System.out.println("counter vow: "+counter);
                        isVowel=true;
                        vowCounter++;
                        break;
                    }//case vowel
                    default: {
                        if(!isVowel && i!=0)
                            counter++;
                        else counter=0;
                        //System.out.println("counterno: "+counter);
                        if(counter>=2){
                            isAccept=false;
                            break loop;
                        }
                        isVowel=false;
                    }//default
                } //switch
                if(i==line.length()-1 && vowCounter==0) isAccept=false;
                else if(i==line.length()-1 && vowCounter>=1) isAccept=true;
                if(last==ch){
                    if(last=='e' || last=='o'){
                        counter--;
                        continue;
                    }
                    isAccept=false;
                    break;
                }else last=ch;
            }//for
            if(isAccept)System.out.println("<"+line+"> "+"is acceptable.");
                else System.out.println("<"+line+"> "+"is not acceptable.");
        }//while
    }//main Method
}//Class Main
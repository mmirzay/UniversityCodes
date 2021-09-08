import java.util.Scanner;
public class IBMMinusOne{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int lines=cin.nextInt();
        String str[]=new String[lines];
        for(int i=0;i<lines;i++)
            str[i]=cin.next();
        for(int i=0;i<lines;i++){
            String temp="";
            for(int j=0;j<str[i].length();j++){
                if(str[i].charAt(j)!='Z')
                    temp+=""+((char)(str[i].charAt(j)+1));
                else
                    temp+="A";
            }
            System.out.println("String #"+(i+1));
            System.out.println(temp);
            System.out.println("");
        }

    }
}
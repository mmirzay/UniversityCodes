import java.util.Scanner;
//ShareCode
//acepted
public class ReverseText{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int lines=cin.nextInt();
        cin.nextLine();
        String text[]=new String[lines];
        for(int i=0;i<lines;i++)
            text[i]=cin.nextLine();
        for(int i=0;i<lines;i++){
            String temp="";
            for(int j=text[i].length()-1;j>=0;j--)
                temp+=""+text[i].charAt(j);
            System.out.println(temp);

        }
    }//main Method
}//Class Main
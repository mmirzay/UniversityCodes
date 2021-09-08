
import java.util.Scanner;
//ShareCode
public class LastName{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int line=cin.nextInt();
        cin.nextLine();
        String names[]=new String[line];
        for(int i=0;i<line;i++)
            names[i]=cin.nextLine();
        for(int i=0;i<line;i++){
            for(int j=0;j<names[i].length();j++){
                for(int k=j+1;k<names[i].length();k++)
                    if(names[i].charAt(j)==names[i].charAt(k)){
                        String result="";
                        String temp[]=names[i].split((""+names[i].charAt(j)),2);
                        for(int p=0;p<temp.length;p++)
                            result+=temp[p];
                        names[i]=result;
                    }

            }
            System.out.println(names[i]);
        }
//        String name="abrabam";
//        String r[]=name.split("r",2);
//        for(int i=0;i<r.length;i++)
//            System.out.println(r[i]);
    }//main Method
}//Class Main
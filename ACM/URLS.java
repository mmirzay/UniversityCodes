
import java.util.Scanner;
//ShareCode

public class URLS{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int cas=cin.nextInt();
        cin.nextLine();
        String urls[]=new String[cas];
        for(int i=0;i<cas;i++)
            urls[i]=cin.nextLine();
        int counter=0;
        for(int i=0;i<cas;i++){
            System.out.println("URL #"+(++counter));
            int slash=urls[i].indexOf("//");
            String protocol=urls[i].substring(0, slash-1);
            System.out.println("Protocol = "+protocol);
            String host="", port="<defualt>" , path="<default>";
            slash=protocol.length()+2;
            int flag=0;
            for(int j=slash+1;j<urls[i].length();j++){
                char ch=urls[i].charAt(j);
                if(ch==':'){ flag=1; continue;}
                else if(ch=='/' && (flag==1 || flag==0)) { flag=2; continue;}
                if(flag==0) host+=ch;
                else if(flag==1) port+=ch;
                else path+=ch;
            }
            System.out.println("Host     = "+host);
            System.out.println("Port     = "+port);
            System.out.println("Path     = "+path);
            if(counter!=cas)
            System.out.println("");
        }
    }//main Method
}//Class Main
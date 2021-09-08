//1007 share code
import java.util.Scanner;


public class ThePartyInDoloresDriveway {
    public static void main(String arg[]){        
        Scanner cin=new Scanner(System.in);
        int setCounter=0;
        while(true){
            String init="";
            init=cin.next();            
            if(init.equals("STOP")) break;
            setCounter++;
            int extCount=cin.nextInt();
            char cars[]=new char[extCount];
            for(int i=0;i<extCount;i++)
                cars[i]=cin.next().charAt(0);
            System.out.println("Dataset #"+setCounter+": The initial order is "+init+".");
            for(int i=0;i<cars.length;i++)
                for(int j=0;j<init.length();j++)
                    if(cars[i]==init.charAt(j)){
                        String went="", stay="";
                        if(j<=init.length()/2){
                            for(int k=j+1;k<init.length();k++)
                                stay+=init.charAt(k);
                            for(int k=j-1;k>=0;k--)
                                went+=init.charAt(k);
                            init="";
                            init+=went; init+=stay;
                        }else{
                            for(int k=0;k<j;k++)
                                stay+=init.charAt(k);
                            for(int k=init.length()-1;k>j;k--)
                                went+=init.charAt(k);
                            init="";
                            init+=stay; init+=went;
                        }
                        System.out.println("After "+cars[i]+" leaves, the order is "+init+".");
                }
            System.out.println("");
        }
    }
}

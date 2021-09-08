/* 1161 shareCode*/
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(true){
            String list1=cin.next();
            if(list1.equals("."))break;
            String op=cin.next();
            String list2=cin.next();
            if(op.equals("++")){
                String tmpl1="",tmpl2="";
                for(int i=1;i<list1.length()-1;i++)
                    tmpl1+=""+list1.charAt(i);
                for(int i=1;i<list2.length()-1;i++)
                    tmpl2+=""+list2.charAt(i);
                if(!tmpl2.equals(""))
                    if(!tmpl1.equals(""))
                        System.out.println("["+tmpl1+","+tmpl2+"]");
                    else
                        System.out.println("["+tmpl2+"]");
                else
                    System.out.println("["+tmpl1+"]");
            }else{
                for(int i=1;i<list2.length()-1;i++){
                    char ch=list2.charAt(i);
                    if(ch==',') continue;
                    String tmp="";
                    for(int j=1;j<list1.length()-1;j++){
                        if(ch!=list1.charAt(j))
                            tmp+=""+list1.charAt(j);
                        else{
                            j++;
                            ch='~';
                        }
                    }
                    if(tmp.endsWith(",")){
                        list1="";
                        for(int k=0;k<tmp.length()-1;k++)
                            list1+=""+tmp.charAt(k);
                        tmp=list1;
                    }
                    list1="["+tmp+"]";                    
                }                
                System.out.println(""+list1);
            }
        }
    }
}
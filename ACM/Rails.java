
import java.util.Scanner;
//ShareCode

public class Rails{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        boolean flag=false;
        int num=-1;
        wh: while(true){
            if(num==-1)
                num=cin.nextInt();
            if(num!=0){
                int coach[]=new int [num];
                for(int i=0;i<num;i++){
                    int temp=cin.nextInt();
                    if(temp!=0)
                        coach[i]=temp;
                    else{ num=0; flag=true; continue wh;}
                }
                if(num==1 || num==2){
                    System.out.println("Yes");
                    continue;
                }
                boolean up=false;
                if(coach[0]>coach[1])
                    up=false;
                else up=true;
                for(int i=0;i<num;i++){
                    for(int j=i+1;j<num;j++){
                        if(up && coach[i]>coach[j]){
                            System.out.println("No1");
                            System.out.println("coach "+coach[i]+" > coch "+coach[j]);
                            continue wh;
                        }else if(!up && coach[i]<coach[j]){
                            System.out.println("No2");
                            System.out.println("coach "+coach[i]+" < coch "+coach[j]);
                            continue wh;
                        }
                    }//for j
                }//for i
                System.out.println("Yes2");
            }else if(flag){
                flag=false;
                num=cin.nextInt();
                if(num!=0) System.out.println("");
                continue;
            }else break;
        }
    }//main Method
}//Class Main
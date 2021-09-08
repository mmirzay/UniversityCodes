
import java.util.Scanner;
//ShareCode
//accepted

public class UniqueAscendingArray{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        while(true){
            int size=cin.nextInt();
            if(size==0) break;
            int array[]=new int[size];
            for(int i=0;i<size;i++)
                array[i]=cin.nextInt();
            for(int i=0;i<size;i++)
                for(int j=i+1;j<size;j++)
                    if(array[i]>array[j]){
                        int temp=array[i];
                        array[i]=array[j];
                        array[j]=temp;
                    }else if(array[i]==array[j])
                        array[j]=-1;
            for(int i=0;i<size;i++)
                if(array[i]!=-1){
                if(i==size-1)
                System.out.println(array[i]);
                else System.out.print(array[i]+" ");
                }
        }
    }//main Method
}//Class Main
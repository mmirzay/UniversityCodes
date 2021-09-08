// 1017 shareCode
//accepted
import java.util.Scanner;
public class Double {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        String strNum=cin.nextLine();
        while(!strNum.equals("-1")){
            int numCounter=0;
            for(int i=0;i<strNum.length();i++)
                if(strNum.charAt(i)==' ')
                    numCounter++;
            int nums[]=new int[numCounter];
            numCounter=0; String temp="";
            for(int i=0;i<strNum.length() && numCounter<nums.length;i++)
                if(strNum.charAt(i)!=' '){
                    temp+=strNum.charAt(i);
                }else{
                    nums[numCounter]=Integer.parseInt(temp);
                    numCounter++;
                    temp="";
                }
            numCounter=0;
            for(int i=0;i<nums.length;i++)
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]*2==nums[j])
                        numCounter++;
                    if(nums[i]==nums[j]*2)
                        numCounter++;
                }
            System.out.println(""+numCounter);
            strNum=cin.nextLine();
        }        
    }
}

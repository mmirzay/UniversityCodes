/* 1074 shareCode */
import java.util.Scanner;

public class PhonList {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int cas=cin.nextInt();
        for(int p=1;p<=cas;p++){
            int phn=cin.nextInt();
            String nums[]=new String[phn];
            int minLen=0;
            for(int i=0;i<phn;i++)
                nums[i]=cin.next();
            boolean isEq=true;
            for(int i=0;i<phn;i++){
                inner: for(int j=i+1;j<phn;j++){
                    if(nums[i].length()<=nums[j].length())
                        minLen=nums[i].length();
                    else
                        minLen=nums[j].length();
                    isEq=true;
                    for(int k=0;k<minLen;k++)
                        if(nums[i].charAt(k)!=nums[j].charAt(k)){
                            isEq=false;
                            continue inner;
                        }                    
                }
                if(isEq)
                    break;
            }
            if(isEq)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}

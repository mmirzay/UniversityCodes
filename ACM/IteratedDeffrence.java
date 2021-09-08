/* 1150 shareCode */
// accepted
import java.util.Scanner;

public class IteratedDeffrence {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int caseCounter=0;
        while(true){
            int nc=cin.nextInt();
            if(nc==0) break;
            caseCounter++;
            int nums[]=new int[nc];
            for(int i=0;i<nc;i++)
                nums[i]=cin.nextInt();
            int iteration=0;
            mainW: while(true){
                outter: for(int i=0;i<nc;i++){
                    for(int j=i+1;j<nc;j++)
                        if(nums[i]!=nums[j])
                            break outter;
                    if(i==nc-1)break mainW;
                }
                iteration++;
                if(iteration>=1000){
                    iteration=-1;
                    break mainW;
                }
                int first=nums[0];
                for(int i=1;i<nc;i++){
                    int def=nums[i]-nums[i-1];
                    if(def<0) def*=-1;
                    nums[i-1]=def;
                }
                int def=nums[nc-1]-first;
                if(def<0) def*=-1;
                nums[nc-1]=def;
            }
            if(iteration!=-1)
                System.out.println("Case "+caseCounter+": "+iteration+" iterations");
            else
                System.out.println("Case "+caseCounter+": not attained");
        }
    }
}

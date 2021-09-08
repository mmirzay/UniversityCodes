
import java.util.Random;
import javax.swing.JOptionPane;

public class MMatrix {
    static int arr1Row=new Random().nextInt(5);
    static int arr2Col=new Random().nextInt(5);
    static int common=new Random().nextInt(5);
    static int arr1[][]=new int[arr1Row][common];
    static int arr2[][]=new int[common][arr2Col];
    static int arrRes[][]=new int[arr1Row][arr2Col];
    static int valCounterArr1;
    static int  valCounterArr2;
    static void initialArrays(){
        for(int i=0;i<arr1Row;i++)
            for(int j=0;j<common;j++)
                if(new Random().nextInt(101)<30){
                    arr1[i][j]=new Random().nextInt(9)+1;
                    valCounterArr1++;
                }
                else
                    arr1[i][j]=0;
        for(int i=0;i<common;i++)
            for(int j=0;j<arr2Col;j++)
                if(new Random().nextInt(101)<30){
                    arr2[i][j]=new Random().nextInt(9)+1;
                    valCounterArr2++;
                }
                else
                    arr2[i][j]=0;
    }
    static void privacyArrays(){
        initialArrays();        
        int privArr1[][]=new int [valCounterArr1+1][3];
        int privArr2[][]=new int [valCounterArr2+1][3];
        int privRow=1;
        privArr1[0][0]=arr1Row; privArr1[0][1]=common; privArr1[0][2]=valCounterArr1;
        privArr2[0][0]=common; privArr2[0][1]=arr2Col; privArr2[0][2]=valCounterArr2;
        for(int i=0;i<arr1Row;i++)
            for(int j=0;j<common;j++){
                if(arr1[i][j]!=0){
                    privArr1[privRow][0]=i; privArr1[privRow][1]=j; privArr1[privRow][2]=arr1[i][j];
                    privRow++;
                }
            }        
        privRow=1;
        for(int i=0;i<common;i++)
            for(int j=0;j<arr2Col;j++){
                if(arr2[i][j]!=0){
                    privArr2[privRow][0]=i; privArr2[privRow][1]=j; privArr2[privRow][2]=arr2[i][j];
                    privRow++;
                }
            }        
        int tempArr[][]=new int [(arr1Row*arr2Col)*10][3];
        int tempValCount=0;
        tempArr[0][0]=privArr1[0][0]; tempArr[0][1]=privArr2[0][1];                
        for(int i=1; i<=privArr1[0][2];i++)
            for(int j=1;j<=privArr2[0][2];j++){
                if(privArr1[i][1]==privArr2[j][0]){
                    tempValCount++;
                    tempArr[tempValCount][0]=privArr1[i][0];
                    tempArr[tempValCount][1]=privArr2[j][1];                    
                }
            }        
        tempArr[0][2]=tempValCount+1;
        int counterComp=1;
        int tempRowComp=0;
        int tempColComp=0;
        while(counterComp<=tempValCount){
            tempRowComp=tempArr[counterComp][0];
            tempColComp=tempArr[counterComp][1];
            for(int i=counterComp+1;i<=tempValCount;i++){
                if(tempRowComp==tempArr[i][0] && tempArr[i][1]==tempColComp){
                    tempArr[i][0]=-1; tempArr[i][1]=-1;
                }
            }
            counterComp++;
        }        
        int tempRes=0;
        for(int i=1; i<=privArr1[0][2];i++)
            for(int j=1;j<=privArr2[0][2];j++)
                if(privArr1[i][1]==privArr2[j][0]){
                    tempRes=0;
                    tempRes=privArr1[i][2]*privArr2[j][2];
                    for(int k=1;k<=tempValCount;k++)
                        if(tempArr[k][0]!=-1 && privArr1[i][0]==tempArr[k][0] && privArr2[j][1]==tempArr[k][1])
                            tempArr[k][2]+=tempRes;
                }
        System.out.println("-------------------------------------------------------");
        System.out.println("First Privacy Array is: ");
        for(int i=1;i<=privArr1[0][2];i++){
            System.out.println("privArr1["+i+"][0]= "+privArr1[i][0]);
            System.out.println("privArr1["+i+"][1]= "+privArr1[i][1]);
            System.out.println("privArr1["+i+"][2]= "+privArr1[i][2]);
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Second Privacy Array is: ");
        for(int i=1;i<=privArr2[0][2];i++){
            System.out.println("privArr2["+i+"][0]= "+privArr2[i][0]);
            System.out.println("privArr2["+i+"][1]= "+privArr2[i][1]);
            System.out.println("privArr2["+i+"][2]= "+privArr2[i][2]);
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Privacy Temp-Array is: ");
        System.out.println("Note: repetitive Values assigned by (-1)");
        for(int i=1;i<=tempValCount;i++){
            System.out.println("tempArr["+i+"][0]= "+tempArr[i][0]);
            System.out.println("tempArr["+i+"][1]= "+tempArr[i][1]);
            System.out.println("tempArr["+i+"][2]= "+tempArr[i][2]);
        } 
        int resultArray[][]=new int[tempArr[0][0]][tempArr[0][1]];
        for(int i=0;i<tempArr[0][0];i++)
            for(int j=0;j<tempArr[0][1];j++)
                for(int k=1;k<=tempValCount;k++)
                    if(i==tempArr[k][0] && j==tempArr[k][1])
                        resultArray[i][j]=tempArr[k][2];                    
        System.out.println("-------------------------------------------------------");
        System.out.println("First Array is: ");
        for(int i=0;i<arr1Row;i++){
            for(int j=0;j<common;j++)
                System.out.print(""+arr1[i][j]+" ");
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Second Array is: ");
        for(int i=0;i<common;i++){
            for(int j=0;j<arr2Col;j++)
                System.out.print(""+arr2[i][j]+" ");
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Result Array for Multiplying is: ");
        for(int i=0;i<arr1Row;i++){
            for(int j=0;j<arr2Col;j++)
                System.out.print(resultArray[i][j]+"   ");
            System.out.println("");
        }        
    }
    public static void main(String[] args) {
           privacyArrays();
           JOptionPane.showMessageDialog(null, "the Result Array has been shown in Output Console","Output",JOptionPane.INFORMATION_MESSAGE);
    }

}

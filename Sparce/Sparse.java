import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
public class Sparse{
    private static int[][] add(int[][] sMatrix1, int[][] sMatrix2) throws Exception{
            int mainResult[][] = null;
            if(sMatrix1[0][0]==sMatrix2[0][0] && sMatrix1[0][1]==sMatrix2[0][1]){
                int temp[][]=new int[sMatrix1[0][0]*sMatrix2[0][0]+1][3];
                int counter=1,col=-1;
                boolean tr=false;
                for(int i=0;i<sMatrix1[0][0];i++)
                    for(int j=0;j<sMatrix1[0][1];j++){                        
                        temp[counter][0]=i;
                        temp[counter][1]=j;
                        temp[counter][2]=-1;
                        counter++;
                    }
                counter=1;
                temp[0][0]=sMatrix1[0][0];temp[0][1]=sMatrix1[0][1];
                for(int i=1;i<sMatrix1.length;i++){                    
                    for(int j=1;j<sMatrix2.length;j++){
                        tr=false;                        
                        if(sMatrix1[i][0]==sMatrix2[j][0] && sMatrix1[i][1]==sMatrix2[j][1]){
                            tr=true;
                            col=j;
                            break;
                        }
                    }
                    if(tr){
                        for(int k=1;k<temp.length;k++)
                            if(temp[k][0]==sMatrix1[i][0] && temp[k][1]==sMatrix1[i][1]){
                                temp[k][2]=sMatrix1[i][2]+sMatrix2[col][2];
                                sMatrix2[col][0]=-2;
                            }
                    }else{
                        for(int k=1;k<temp.length;k++)
                            if(temp[k][0]==sMatrix1[i][0] && temp[k][1]==sMatrix1[i][1])
                                temp[k][2]=sMatrix1[i][2];
                    }
                }                
                for(int i=1;i<sMatrix2.length;i++){
                    for(int k=1;k<temp.length;k++)
                        if(temp[k][0]==sMatrix2[i][0] && temp[k][1]==sMatrix2[i][1]){
                            temp[k][2]=sMatrix2[i][2];
                        }                        
                }
                counter=0;
                for(int i=1;i<temp.length;i++){
                    if(temp[i][2]!=-1)
                        counter++;
                }
                mainResult=new int[counter+1][3];
                mainResult[0][0]=sMatrix1[0][0];
                mainResult[0][1]=sMatrix1[0][1];
                mainResult[0][2]=counter;
                counter=1;
                for(int k=1;k<temp.length;k++){
                    if(temp[k][2]!=-1){
                        mainResult[counter][0]=temp[k][0];
                        mainResult[counter][1]=temp[k][1];
                        mainResult[counter][2]=temp[k][2];
                        counter++;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error in Row and Columns. Invalid values!"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE);
                throw new Exception("Row & Column are not in correct format for ARRAY ADDING!");
            }
        return mainResult;
    }
    private static int[][] multiply(int[][] sMatrix1, int[][] sMatrix2){
        int arr1Row=sMatrix1[0][0];
        int arr2Col=sMatrix2[0][1];
        int tempArr[][]=new int [(arr1Row*arr2Col)*10][3];
        int tempValCount=0;
        tempArr[0][0]=sMatrix1[0][0]; tempArr[0][1]=sMatrix2[0][1];
        for(int i=1; i<=sMatrix1[0][2];i++)
            for(int j=1;j<=sMatrix2[0][2];j++){
                if(sMatrix1[i][1]==sMatrix2[j][0]){
                    tempValCount++;
                    tempArr[tempValCount][0]=sMatrix1[i][0];
                    tempArr[tempValCount][1]=sMatrix2[j][1];
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
        for(int i=1; i<=sMatrix1[0][2];i++)
            for(int j=1;j<=sMatrix2[0][2];j++)
                if(sMatrix1[i][1]==sMatrix2[j][0]){
                    tempRes=0;
                    tempRes=sMatrix1[i][2]*sMatrix2[j][2];
                    for(int k=1;k<=tempValCount;k++)
                        if(tempArr[k][0]!=-1 && sMatrix1[i][0]==tempArr[k][0] && sMatrix2[j][1]==tempArr[k][1])
                            tempArr[k][2]+=tempRes;
                }
        counterComp=0;
        for(int i=1;i<tempArr.length;i++)
            if(tempArr[i][2]!=0) counterComp++;
        int res[][]=new int[counterComp+1][3];
        res[0][0]=sMatrix1[0][0];
        res[0][1]=sMatrix1[0][1];
        res[0][2]=counterComp;
        counterComp=1;
        for(int i=1;i<tempArr.length;i++)
            if(tempArr[i][0]!=-1 && tempArr[i][2]!=0 && counterComp<res.length){
                res[counterComp][0]=tempArr[i][0];
                res[counterComp][1]=tempArr[i][1];
                res[counterComp][2]=tempArr[i][2];
                counterComp++;
            }
        return res;
    }
	// DO NOT CHANGE THE MAIN METHOD
	public static void main(String[] args) throws Exception{
		int[][] sMatrix1, sMatrix2;
		int colNo1, rowNo1, num1, colNo2, rowNo2, num2;
		rowNo1=Integer.parseInt(showInputDialog(null, "Input the number of rows for Matrix 1","Rows of Matrix 1",QUESTION_MESSAGE));
		colNo1=Integer.parseInt(showInputDialog(null, "Input the number of columns for Matrix 1","Columns of Matrix 1",QUESTION_MESSAGE));
                    num1=Integer.parseInt(showInputDialog(null, "Input the number of elements for Matrix 1","Element numbers of Matrix 1",QUESTION_MESSAGE));
		rowNo2=Integer.parseInt(showInputDialog(null, "Input the number of rows for Matrix 2","Rows of Matrix 2",QUESTION_MESSAGE));
		colNo2=Integer.parseInt(showInputDialog(null, "Input the number of columns for Matrix 2","Columns of Matrix 2",QUESTION_MESSAGE));
		num2=Integer.parseInt(showInputDialog(null, "Input the number of elements for Matrix 2","Element numbers of Matrix 2",QUESTION_MESSAGE));
		sMatrix1=new int[num1+1][3];
		sMatrix2=new int[num2+1][3];
		sMatrix1[0][0]=rowNo1;	sMatrix1[0][1]=colNo1;	sMatrix1[0][2]=num1;
		sMatrix2[0][0]=rowNo2;	sMatrix2[0][1]=colNo2;	sMatrix2[0][2]=num2;
		for(int i=1; i<=num1; i++){
			sMatrix1[i][0]=Integer.parseInt(showInputDialog(null, "Input row index for element "+i,"Filling in Matrix 1",QUESTION_MESSAGE));
			sMatrix1[i][1]=Integer.parseInt(showInputDialog(null, "Input column index for element "+i,"Filling in Matrix 1",QUESTION_MESSAGE));
			sMatrix1[i][2]=Integer.parseInt(showInputDialog(null, "Input Data for element "+i,"Filling in Matrix 1",QUESTION_MESSAGE));
		}
		for(int i=1; i<=num2; i++){
			sMatrix2[i][0]=Integer.parseInt(showInputDialog(null, "Input row index for element "+i,"Filling in Matrix 2",QUESTION_MESSAGE));
			sMatrix2[i][1]=Integer.parseInt(showInputDialog(null, "Input column index for element "+i,"Filling in Matrix 2",QUESTION_MESSAGE));
			sMatrix2[i][2]=Integer.parseInt(showInputDialog(null, "Input Data for element "+i,"Filling in Matrix 2",QUESTION_MESSAGE));
		}
		System.out.println("Sparse Matrix 1:");
		for(int i=0; i<=num1; i++)
			System.out.println(sMatrix1[i][0]+"\t"+sMatrix1[i][1]+"\t"+sMatrix1[i][2]);
		System.out.println("Sparse Matrix 2:");
		for(int i=0; i<=num2; i++)
			System.out.println(sMatrix2[i][0]+"\t"+sMatrix2[i][1]+"\t"+sMatrix2[i][2]);
		int[][] addResult=add(sMatrix1, sMatrix2);
		int[][] mulResult=multiply(sMatrix1, sMatrix2);
		System.out.println("Addition:");

                for(int i=0; i<=addResult[0][2]; i++)
			System.out.println(addResult[i][0]+"\t"+addResult[i][1]+"\t"+addResult[i][2]);
		System.out.println("Multiply:");
		for(int i=0; i<=mulResult[0][2]; i++)
			System.out.println(mulResult[i][0]+"\t"+mulResult[i][1]+"\t"+mulResult[i][2]);
	}

}
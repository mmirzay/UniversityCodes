/*	Assignment 01
	Algorithm Design and Analysis
	University of Kurdistan	
	Instructor: Amanj Khorramian	
 *      Collegian Name: Mohsen Mirzay
 *      ID: 8917050113
 */

import java.util.*;

public class MatrixMultiply{
    private static int[][] strassen(int[][] a, int[][] b){
        int counter=0,counter2=0;
        int n=a.length;
        int c[][]=new int[n][n];
        if(n==1)
            c[0][0]=a[0][0]*b[0][0];
        else{
            int a11[][]=new int[n/2][n/2];
            int a12[][]=new int[n/2][n/2];
            int a21[][]=new int[n/2][n/2];
            int a22[][]=new int[n/2][n/2];
            int b11[][]=new int[n/2][n/2];
            int b12[][]=new int[n/2][n/2];
            int b21[][]=new int[n/2][n/2];
            int b22[][]=new int[n/2][n/2];
            int c11[][]=new int[n/2][n/2];
            int c12[][]=new int[n/2][n/2];
            int c21[][]=new int[n/2][n/2];
            int c22[][]=new int[n/2][n/2];
            //------------------------------------------//
            /* deviding a */
            for(int i=0;i<a11.length;i++)
                for(int j=0;j<a11.length;j++)
                    a11[i][j]=a[i][j];
            for(int i=0;i<a12.length;i++){
                counter=0;
                for(int j=n/2;j<a.length;j++){
                    a12[i][counter]=a[i][j];
                    counter++;
                }
            }
            counter=0;
            for(int i=n/2;i<a.length;i++){
                for(int j=0;j<a21.length;j++)
                    a21[counter][j]=a[i][j];
                counter++;
            }
            counter=0;
            for(int i=n/2;i<a.length;i++){
                counter2=0;
                for(int j=n/2;j<a.length;j++){
                    a22[counter][counter2]=a[i][j];
                    counter2++;
                }
                counter++;
            }
            /* deviding b */
            for(int i=0;i<b11.length;i++)
                for(int j=0;j<b11.length;j++)
                    b11[i][j]=b[i][j];
            for(int i=0;i<b12.length;i++){
                counter=0;
                for(int j=n/2;j<b.length;j++){
                    b12[i][counter]=b[i][j];
                    counter++;
                }
            }
            counter=0;
            for(int i=n/2;i<b.length;i++){
                for(int j=0;j<b21.length;j++)
                    b21[counter][j]=b[i][j];
                counter++;
            }
            counter=0;
            for(int i=n/2;i<b.length;i++){
                counter2=0;
                for(int j=n/2;j<b.length;j++){
                    b22[counter][counter2]=b[i][j];
                    counter2++;
                }
                counter++;
            }
            //---------------------------//
            int s1[][]=new int[n/2][n/2];
            int s2[][]=new int[n/2][n/2];
            int s3[][]=new int[n/2][n/2];
            int s4[][]=new int[n/2][n/2];
            int s5[][]=new int[n/2][n/2];
            int s6[][]=new int[n/2][n/2];
            int s7[][]=new int[n/2][n/2];
            int s8[][]=new int[n/2][n/2];
            int s9[][]=new int[n/2][n/2];
            int s10[][]=new int[n/2][n/2];
            /* s initializing */
            for(int i=0;i<b12.length;i++)
                for(int j=0;j<b22.length;j++)
                    s1[i][j]=b12[i][j]-b22[i][j];
            for(int i=0;i<a11.length;i++)
                for(int j=0;j<a12.length;j++)
                    s2[i][j]=a11[i][j]+a12[i][j];
            for(int i=0;i<a21.length;i++)
                for(int j=0;j<a22.length;j++)
                    s3[i][j]=a21[i][j]+a22[i][j];
            for(int i=0;i<b21.length;i++)
                for(int j=0;j<b11.length;j++)
                    s4[i][j]=b21[i][j]-b11[i][j];
            for(int i=0;i<a11.length;i++)
                for(int j=0;j<a22.length;j++)
                    s5[i][j]=a11[i][j]+a22[i][j];
            for(int i=0;i<b11.length;i++)
                for(int j=0;j<b22.length;j++)
                    s6[i][j]=b11[i][j]+b22[i][j];
            for(int i=0;i<a12.length;i++)
                for(int j=0;j<a22.length;j++)
                    s7[i][j]=a12[i][j]-a22[i][j];
            for(int i=0;i<b21.length;i++)
                for(int j=0;j<b22.length;j++)
                    s8[i][j]=b21[i][j]+b22[i][j];
            for(int i=0;i<a11.length;i++)
                for(int j=0;j<a21.length;j++)
                    s9[i][j]=a11[i][j]-a21[i][j];
            for(int i=0;i<b11.length;i++)
                for(int j=0;j<b12.length;j++)
                    s10[i][j]=b11[i][j]+b12[i][j];
            //-----------------------------------------//
            int p1[][]=new int[n/2][n/2];
            int p2[][]=new int[n/2][n/2];
            int p3[][]=new int[n/2][n/2];
            int p4[][]=new int[n/2][n/2];
            int p5[][]=new int[n/2][n/2];
            int p6[][]=new int[n/2][n/2];
            int p7[][]=new int[n/2][n/2];
            p1=strassen(a11, s1);
            p2=strassen(s2, b22);
            p3=strassen(s3, b11);
            p4=strassen(a22, s4);
            p5=strassen(s5, s6);
            p6=strassen(s7, s8);
            p7=strassen(s9, s10);
            //---------------------------------------//
            /* c11 initializing */
            for(int i=0;i<c11.length;i++)
                for(int j=0;j<c11.length;j++)
                    c11[i][j]=p5[i][j]+p4[i][j]-p2[i][j]+p6[i][j];
            for(int i=0;i<c12.length;i++)
                for(int j=0;j<c12.length;j++)
                    c12[i][j]=p1[i][j]+p2[i][j];
            for(int i=0;i<c21.length;i++)
                for(int j=0;j<c21.length;j++)
                    c21[i][j]=p3[i][j]+p4[i][j];
            for(int i=0;i<c22.length;i++)
                for(int j=0;j<c22.length;j++)
                    c22[i][j]=p5[i][j]+p1[i][j]-p3[i][j]-p7[i][j];
            /* initializing result */
            for(int i=0;i<c11.length;i++)
                for(int j=0;j<c11.length;j++)
                    c[i][j]=c11[i][j];
            for(int i=0;i<c12.length;i++){
                counter=0;
                for(int j=n/2;j<c.length;j++){
                    c[i][j]=c12[i][counter];
                    counter++;
                }
            }
            counter=0;
            for(int i=n/2;i<c.length;i++){
                for(int j=0;j<c21.length;j++)
                    c[i][j]=c21[counter][j];
                counter++;
            }
            counter=0;
            for(int i=n/2;i<c.length;i++){
                counter2=0;
                for(int j=n/2;j<c.length;j++){
                    c[i][j]=c22[counter][counter2];
                    counter2++;
                }
                counter++;
            }
        }
        return c;
    }

    // DO NOT CHANGE THE FOLLOWING METHODS
    private static int[][] regular(int[][] matrix1, int[][] matrix2){
        int n=matrix1.length;
	int[][] result=new int[n][n];
	for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                for(int k=0; k<n; k++)
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
	return result;
    }
    public static void main(String[] args){
        Random r=new Random();
	int k=r.nextInt(3)+1;
	int n=2; for(int i=1; i<k; i++) n*=2;
	int[][] matrix1=new int[n][n];
	int[][] matrix2=new int[n][n];
	for(int i=0; i<n; i++)
            for(int j=0; j<n; j++){
                matrix1[i][j]=r.nextInt(100);
		matrix2[i][j]=r.nextInt(100);
            }
	int[][] result1=regular(matrix1, matrix2);
	int[][] result2=strassen(matrix1, matrix2);
	System.out.println("N = "+n+"\n\nMatrix1:");
	for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix1[i][j]+"\t");
            }
            System.out.println();
	}
	System.out.println("\nMatrix2:");
	for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix2[i][j]+"\t");
            }
            System.out.println();
	}
	System.out.println("\nResult for Regular Multiplication:");
	for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result1[i][j]+"\t");
            }
            System.out.println();
	}
	System.out.println("\nResult for Strassen Multiplication:");
	for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result2[i][j]+"\t");
            }
            System.out.println();
	}
    }
}
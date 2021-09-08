
import java.util.Scanner;
//ShareCode
//presentation Error
public class LCDisplay{

    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int counter=1;
        while (true) {
            int s = cin.nextInt();
            String num = cin.next();
            if (s == 0 && num.equals("0"))
                return;
            if(counter>1) System.out.println("");
            counter++;
            String digit[][]=new String[10][2*s+3];
            for(int i=0;i<10;i++)
                for(int j=0;j<2*s+3;j++){
                    String p="";
                    switch(i){
                        case 0:{
                            if(j==0 || j==2*s+2){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if((j>0 && j<=s) || (j>s+1 && j<2*s+2)){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }else{
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 0
                        case 1:{
                            if(j==0 || j==2*s+2) digit[i][j]=" ";
                            else if((j>0 && j<=s) || (j>s+1 && j<2*s+2)) digit[i][j]= "|";
                            else digit[i][j]=" ";
                            break;
                        }//case 1
                        case 2:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if(j>0 && j<=s){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }else{
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 2
                        case 3:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if((j>0 && j<=s) || (j>s+1 && j<2*s+2)){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 3
                        case 4:{
                            if(j==0 || j==2*s+2){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }else if(j>0 && j<=s){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }else if(j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else{
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 4
                        case 5:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if(j>0 && j<=s){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }else{
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 5
                        case 6:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if(j>0 && j<=s){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }else{
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 6
                        case 7:{
                            if(j==0){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if((j>0 && j<=s) || (j>s+1 && j<2*s+2)){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }else{
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+=" ";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 7
                        case 8:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if((j>0 && j<=s) || (j>s+1 && j<2*s+2)){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }//case 8
                        case 9:{
                            if(j==0 || j==2*s+2 || j==s+1){
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+="-";
                                p+=" ";
                                digit[i][j]=p;
                            }else if(j>0 && j<=s){
                                p="|";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }else{
                                p=" ";
                                for(int k=0;k<s;k++)
                                    p+=" ";
                                p+="|";
                                digit[i][j]=p;
                            }
                            break;
                        }
                    }//switch
                }//for
            for(int j=0;j<2*s+3;j++){
                for(int i=0;i<num.length();i++){
                    int d=Integer.parseInt(""+num.charAt(i));
                    System.out.print(digit[d][j]);
                    if(i!=num.length()-1)
                        System.out.print(" ");
                }
                System.out.println(" ");
            }
        }//while

    }//main Method
}//Class Main
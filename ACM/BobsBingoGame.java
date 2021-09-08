// 1003 share code
import java.util.Scanner;


public class BobsBingoGame {
    public static void main(String arg[]){
        Scanner cin= new Scanner(System.in);
        int counter=0, cardCount=0, numCount=0;
        String pat="";
        while(true){
            counter=0;
            pat="";
            numCount=0;
            while(counter<5){
                pat+=cin.next();
                //System.out.println("pat= "+pat);
                counter++;
            }
            counter=0;
            //System.out.println("hi");
            cardCount=0;
            cardCount=cin.nextInt();
            //System.out.println("cardCont= "+cardCount);
            if(cardCount==0) break;
            for(int i=0;i<pat.length();i++)
                if(pat.charAt(i)=='X') counter++;
            int patCell[]=new int[counter];
            counter=0;
            for(int i=0;i<pat.length();i++)
                if(pat.charAt(i)=='X'){
                    patCell[counter]=i;
                    counter++;
                }
            int cards[][]=new int[cardCount][25];
            counter=0;
            while(counter<cardCount){
                cards[counter][numCount]=cin.nextInt();
                //System.out.println("cards["+counter+"]["+numCount+"= "+cards[counter][numCount]);
                numCount++;
                if(numCount==25){
                    numCount=0;
                    counter++;
                }
            }
            int selNum[][]=new int[cardCount][patCell.length];
            counter=0;numCount=0;
            while(counter<cardCount){
                int pos=patCell[numCount];                
                selNum[counter][numCount]=cards[counter][pos];                
                //System.out.println("selNum["+counter+"]["+numCount+"]= "+selNum[counter][numCount]);
                numCount++;
                if(numCount==patCell.length){
                    numCount=0;
                    counter++;
                }
            }
            counter=0; numCount=-1;
            for(int i=0;i<cardCount;i++){
                col: for(int j=i+1;j<cardCount;j++){
                    counter=0;
                    cur: for(int k=0;k<patCell.length;k++){
                        for(int l=0;l<patCell.length;l++){
                            int num1=selNum[i][k];
                            int num2=selNum[j][l];
                            if(num1==num2){
                                counter++;
                                if(counter==patCell.length &&numCount!=j){
                                    System.out.println("Card "+(j+1)+" is equivalent to card "+(i+1));
                                    numCount=j;
                                    continue col;
                                }
                                continue cur;
                            }
                        }
                    }
                }
            }
        }
    }
}

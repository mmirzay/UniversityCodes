
import java.util.Scanner;

//1012 share code
//accepted
public class ClayBully {
    public static void main(String[] args){        
        Scanner cin=new Scanner(System.in);
        int stuCount=cin.nextInt();
        while(stuCount!=-1){
            int defClay=-1;
            String stu[][]=new String[stuCount][5];
            for(int i=0;i<stu.length;i++){
                for(int j=0;j<4;j++)
                    stu[i][j]=cin.next();
                stu[i][4]=""+Integer.parseInt(stu[i][0]) * Integer.parseInt(stu[i][1]) * Integer.parseInt(stu[i][2]);                
            }
            if(stuCount==2){                
                if(Integer.parseInt(stu[0][4])<Integer.parseInt(stu[1][4]))
                    System.out.println(""+stu[1][3]+" took clay from "+stu[0][3]+".");
                else
                    System.out.println(""+stu[0][3]+" took clay from "+stu[1][3]+".");
            }else{
                if(stuCount==3){
                    int min=Integer.parseInt(stu[0][4]);
                    int max=Integer.parseInt(stu[0][4]);
                    for(int i=1;i<stu.length;i++){
                        if(min<Integer.parseInt(stu[i][4]))
                            min=Integer.parseInt(stu[i][4]);
                        if(max>Integer.parseInt(stu[i][4]))
                            max=Integer.parseInt(stu[i][4]);
                    }
                    defClay=(max+min)/2;
                }else{
                    out: for(int i=0;i<stu.length;i++)
                    for(int j=i+1;j<stu.length;j++)
                        if(Integer.parseInt(stu[i][4])==Integer.parseInt(stu[j][4])){
                            defClay=Integer.parseInt(stu[j][4]);
                            break out;
                        }
                }
                int cheaters[]=new int[]{-1,-1};                
                for(int i=0;i<stu.length;i++)
                    if(defClay!=Integer.parseInt(stu[i][4]))
                        if(cheaters[0]==-1)
                            cheaters[0]=i;
                        else{
                            cheaters[1]=i;
                            break;
                        }
                if(Integer.parseInt(stu[cheaters[0]][4])<Integer.parseInt(stu[cheaters[1]][4]))
                    System.out.println(""+stu[cheaters[1]][3]+" took clay from "+stu[cheaters[0]][3]+".");
                else
                    System.out.println(""+stu[cheaters[0]][3]+" took clay from "+stu[cheaters[1]][3]+".");
            }//else stuCount==2
            stuCount=cin.nextInt();
        }//while(true)
    }//main
}

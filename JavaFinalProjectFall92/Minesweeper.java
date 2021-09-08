import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import static javax.swing.JOptionPane.*;
// ???
class Board extends JFrame{
 boolean[][] mine;
 int[][] count;
 JButton[][] b;
 JPanel jp;
 // ??? ADD OTHER GRAPHICAL OBJECTS AND INNER CLASSES

 Board(int x, int y, int n){
  super("Minesweeper");
  setSize(x*20, y*25);
  jp = new JPanel(new GridLayout(x,y));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  getContentPane().add(jp);
  mine = new boolean[x][y];
  count = new int[x][y];
  b = new JButton[x][y];
  insertRandomMines(mine, n);
  insertNumbers(count, mine);
  for(int i=0; i<b.length; i++)
   for(int j=0; j<b[0].length; j++)
  jp.add(b[i][j]=new JButton());

                for(int i=0;i<b.length;i++)
                    for(int j=0;j<b[0].length;j++){
                     b[i][j].setBackground(Color.LIGHT_GRAY);
                        b[i][j].addMouseListener(new ML(i,j));
                    }
  // ??? ASSEMBLE GRAPHICAL OBJECTS
  setVisible(true);
 }

 class ML implements MouseListener {
  int a1,a2;
  ML(int i,int j){a1=i;a2=j;}
  @Override
  public void mouseClicked(MouseEvent e) {
  int code = e.getButton();
  if(code== MouseEvent.BUTTON1){
      int i = a1;
      int j = a1;
           if(b[i][j]==e.getSource()==(count[i][j]==9)){
      showMessageDialog(rootPane, "You Are Amount Lost In A Game");
   }//if==9
     if(b[i][j]==e.getSource() == (count[i][j]!=0 && count[i][j]!= 9)){
       b[i][j].setText(""+ count[i][j]);
     }//if!=9,0
      if(b[i][j]==e.getSource()== (count[i][j]==0)){
                           count[a1][a2]=0;
                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                           if(i==0 && j==0)
                       {
                        //   if(count[0][1]==0)
                               b[0][1].setText("" + count[0][1]);

                           // if(count[1][0]==0)
                               b[1][0].setText("" + count[1][0]);

                           // if(count[1][1]==0)
                               b[1][1].setText("" + count[1][1]);
                       }//if satre1
                           break;
                     }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                           if((i==0) && (j>0 && j<b[0].length-1))
                       {
                           //if(count[0][j-1]== 0)
                               b[0][j-1].setText("" + count[0][j-1]);

                            // if(count[0][j+1]== 0)
                               b[0][j+1].setText("" + count[0][j+1]);

                            //  if(count[1][j-1]== 0)
                               b[1][j-1].setText("" + count[1][j-1]);

                           // if(count[1][j]== 0)
                               b[1][j].setText("" + count[1][j]);

                           //  if(count[1][j+1]== 0)
                               b[1][j+1].setText("" + count[1][j+1]);
                       }//if satre2
                           break;
                     }  //for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                        if(i==0 && j==b[0].length-1)
                        {
                           // if(count[0][j-1]== 0)
                               b[0][j-1].setText("" + count[0][j-1]);

                           // if(count[1][j-1]== 0)
                               b[1][j-1].setText("" + count[1][j-1]);

                            // if(count[1][j]== 0)
                               b[1][j].setText("" + count[1][j]);
                        }//if satre3
                        break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                        if(i==b.length-1 && j==0)
                        {
                           // if(count[i-1][0]== 0)
                               b[i-1][0].setText("" + count[i-1][0]);

                           // if(count[i-1][1] == 0)
                               b[i-1][1].setText("" + count[i-1][1]);

                            // if(count[i][1]== 0)
                               b[i][1].setText("" + count[i][1]);
                        }//if satre4
                        break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                         if((i>0 && i<b.length-1) && j==0)
                        {
                           // if(count[i-1][0]== 0)
                               b[i-1][0].setText("" + count[i-1][0]);

                           //  if(count[i-1][1] == 0)
                               b[i-1][1].setText("" + count[i-1][1]);

                          //  if(count[i+1][0] == 0)
                               b[i+1][0].setText("" + count[i+1][0]);

                           // if(count[i+1][1] == 0)
                               b[i+1][1].setText("" + count[i+1][1]);

                            // if(count[i][1] == 0)
                               b[i][1].setText("" + count[i][1]);
                        }//if satre5
                         break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                          if(i==b.length-1 && j==b[0].length-1)
                        {
                          //  if(count[i-1][j-1] == 0)
                               b[i-1][j-1].setText("" + count[i-1][j-1]);

                            // if(count[i-1][j] == 0)
                               b[i-1][j].setText("" + count[i-1][j]);

                          //  if(count[i][j-1] == 0)
                               b[i][j-1].setText("" + count[i][j-1]);
                        }//if satre6
                          break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                          if(i==b.length-1 && (j>0 && j<b[0].length-1))
                        {
                           // if(count[i][j-1] == 0)
                               b[i][j-1].setText("" + count[i][j-1]);

                           //  if(count[i-1][j-1] == 0)
                               b[i-1][j-1].setText("" + count[i-1][j-1]);

                           // if(count[i-1][j]== 0)
                               b[i-1][j].setText("" + count[i-1][j]);

                        // if(count[i-1][j+1]== 0)
                               b[i-1][j+1].setText("" + count[i-1][j+1]);

                          //   if(count[i][j+1]== 0)
                               b[i][j+1].setText("" + count[i][j+1]);
                        }//if satre7
                          break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                           if((i>0 && i<b.length-1)&& j==b[0].length-1)
                        {
                           //  if(count[i-1][j]== 0)
                               b[i-1][j].setText("" + count[i-1][j]);

                           //  if(count[i-1][j-1]== 0)
                               b[i-1][j-1].setText("" + count[i-1][j-1]);

                           //  if(count[i][j-1]== 0)
                               b[i][j-1].setText("" + count[i][j-1]);

                           //  if(count[i+1][j-1]== 0)
                               b[i+1][j-1].setText("" + count[i+1][j-1]);

                           //  if(count[i+1][j]== 0)
                               b[i+1][j].setText("" + count[i+1][j]);
                        }//if satre8
                           break;
                       }//for

                     for(i=0;i<b.length;i++)
                       for(j=0;j<b[0].length;j++){
                           if((i>0 && i<b.length-1)&& (j>0 && j<b[0].length-1))
                           {
                            // if(count[i-1][j-1]== 0)
                               b[i-1][j-1].setText("" + count[i-1][j-1]);

                            // if(count[i-1][j]== 0)
                               b[i-1][j].setText("" + count[i-1][j]);

                            // if(count[i-1][j+1] == 0)
                               b[i-1][j+1].setText("" + count[i-1][j+1]);

                            // if(count[i][j-1] == 0)
                               b[i][j-1].setText("" + count[i][j-1]);

                            // if(count[i][j+1] == 0)
                               b[i][j+1].setText("" + count[i][j+1]);

                           //  if(count[i+1][j-1] == 0)
                               b[i+1][j-1].setText("" + count[i+1][j-1]);

                           //  if(count[i+1][j] == 0)
                               b[i+1][j].setText("" + count[i+1][j]);

                           //  if(count[i+1][j+1] == 0)
                               b[i+1][j+1].setText("" + count[i+1][j+1]);
                           }//if satre9
                           break;
                          }//for
                         }//if==0
                        }//button1

    for(int i=0; i<b.length; i++)
   for(int j=0; j<b.length; j++){

  if(code== MouseEvent.BUTTON3 && e.getSource()== b[i][j]){
  b[i][j].setBackground(Color.GREEN);
       }//if
      }//for
     }//mouseclick
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
  @Override
  public void mousePressed(MouseEvent e) {}
  @Override
    public void mouseReleased(MouseEvent e) {}
 }
void insertNumbers(int[][] c, boolean[][] m){
  // ??? IMPLEMENT THIS METHOD
               for(int i=0; i<c.length; i++)
                  for(int j=0; j<c[0].length; j++)
                     if(m[i][j]==true)
                   {
                       c[i][j]=9;
                       if(i==0 && j==0)
                       {
                           if(c[0][1]!= 9)
                               c[0][1]+=1;
                            if(c[1][0]!= 9)
                               c[1][0]+=1;
                             if(c[1][1]!= 9)
                               c[1][1]+=1;
                       }//if satre1
                           if((j>0 && j<c[0].length-1)&&(i==0))
                       {
                           if(c[0][j-1]!= 9)
                               c[0][j-1]+=1;
                             if(c[0][j+1]!= 9)
                               c[0][j+1]+=1;
                              if(c[1][j-1]!= 9)
                               c[1][j-1]+=1;
                            if(c[1][j]!= 9)
                               c[1][j]+=1;
                             if(c[1][j+1]!= 9)
                               c[1][j+1]+=1;
                       }//if satre2
                        if(i==0 && j==c[0].length-1)
                        {
                            if(c[0][j-1]!= 9)
                               c[0][j-1]+=1;
                            if(c[1][j-1]!= 9)
                               c[1][j-1]+=1;
                             if(c[1][j]!= 9)
                               c[1][j]+=1;
                        }//if satre3
                        if(i==c.length-1 && j==0)
                        {
                            if(c[i-1][0]!= 9)
                               c[i-1][0]+=1;
                            if(c[i-1][1]!= 9)
                               c[i-1][1]+=1;
                             if(c[i][1]!= 9)
                               c[i][1]+=1;
                        }//if satre4
                         if((i>0 && i<c.length-1) && j==0)
                        {
                            if(c[i-1][0]!= 9)
                               c[i-1][0]+=1;
                             if(c[i-1][1]!= 9)
                               c[i-1][1]+=1;
                            if(c[i+1][0]!= 9)
                               c[i+1][0]+=1;
                            if(c[i+1][1]!= 9)
                               c[i+1][1]+=1;
                             if(c[i][1]!= 9)
                               c[i][1]+=1;
                        }//if satre5
                          if(i==c.length-1 && j==c[0].length-1)
                        {
                            if(c[i-1][j-1]!= 9)
                               c[i-1][j-1]+=1;
                             if(c[i-1][j]!= 9)
                               c[i-1][j]+=1;
                            if(c[i][j-1]!= 9)
                               c[i][j-1]+=1;
                        }//if satre6
                          if(i==c.length-1 && (j>0 && j<c[0].length-1))
                        {
                            if(c[i][j-1]!= 9)
                               c[i][j-1]+=1;
                             if(c[i-1][j-1]!= 9)
                               c[i-1][j-1]+=1;
                            if(c[i-1][j]!= 9)
                               c[i-1][j]+=1;
                         if(c[i-1][j+1]!= 9)
                               c[i-1][j+1]+=1;
                             if(c[i][j+1]!= 9)
                               c[i][j+1]+=1;
                        }//if satre7
                           if((i>0 && i<c.length-1)&& j==c[0].length-1)
                        {
                             if(c[i-1][j]!= 9)
                               c[i-1][j]+=1;
                             if(c[i-1][j-1]!= 9)
                               c[i-1][j-1]+=1;
                             if(c[i][j-1]!= 9)
                               c[i][j-1]+=1;
                             if(c[i+1][j-1]!= 9)
                               c[i+1][j-1]+=1;
                             if(c[i+1][j]!= 9)
                               c[i+1][j]+=1;
                        }//if satre8
                           if((i>0 && i<c.length-1)&& (j>0 && j<c[0].length-1))
                           {
                             if(c[i-1][j-1]!= 9)
                               c[i-1][j-1]+=1;
                             if(c[i-1][j]!= 9)
                               c[i-1][j]+=1;
                             if(c[i-1][j+1]!= 9)
                               c[i-1][j+1]+=1;
                             if(c[i][j-1]!= 9)
                               c[i][j-1]+=1;
                             if(c[i][j+1]!= 9)
                               c[i][j+1]+=1;
                             if(c[i+1][j-1]!= 9)
                               c[i+1][j-1]+=1;
                             if(c[i+1][j]!= 9)
                               c[i+1][j]+=1;
                             if(c[i+1][j+1]!= 9)
                               c[i+1][j+1]+=1;
                           }//if satre9
                   }

  System.out.println();
                for(int i=0; i<c.length; i++ ,System.out.println())
   for(int j=0; j<c[0].length; j++)
    System.out.print(c[i][j]);
 }

 void insertRandomMines(boolean[][] m, int n){
 // DO NOT CHANGE THIS METHOD
  for(int i=0; i<m.length; i++)
   for(int j=0; j<m[0].length; j++)
    m[i][j]=false;
  Random r = new Random();
  int temp[] = new int[m.length*m[0].length];
  for(int i=0; i<temp.length; i++) temp[i]=i;
  for(int i=0; i<temp.length; i++){
   int random = r.nextInt(temp.length-i) + i;
   int t = temp[random];
   temp[random] = temp[i];
   temp[i] = t;
  }
  for(int i=0; i<n; i++) m[temp[i]%m.length][temp[i]/m.length] = true;
  for(int i=0; i<m.length; i++ ,System.out.println())
   for(int j=0; j<m[0].length; j++)
    System.out.print(m[i][j]?'X':'.');
 }
}
public class Minesweeper{
 // DO NOT CHANGE THE MAIN METHOD
 public static void main(String[] args){
  String[] options={"Beginner (9 x 9): 10 mines", "Intermediate (16 x 16): 40 mines", "Advanced (16 x 30): 99 mines"};
  String hardness=(String) showInputDialog(null, "Select the level of difficulty", "Hardness", PLAIN_MESSAGE,null,options,options[0]);
  if(hardness.equals(options[0])) new Board(9,9,10);
  else if(hardness.equals(options[1])) new Board(16,16,40);
  else new Board(30,16,99);
 }
}
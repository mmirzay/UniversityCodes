
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MazeRunner extends JFrame{
    int counter=-1 , backCounter=-1, curCel=0 , stackArray[], backStackArray[];
    boolean isWay=true, isRight=true, isLeft=true, isUp=true, isDown=true , go=false;
    JButton jb=new JButton("Momo");
    JButton cels[]=new JButton[100];
    JButton exit=new JButton("EXIT");
    JButton solv=new JButton("Solve it");
    JButton newg= new JButton("New Game");
    JButton ba=new JButton();
    JLabel jl=new JLabel("Design by: Mohsen.Mirzay");
    JPanel jp = new JPanel(new GridLayout(10, 10));
    MazeRunner(){
        for(int i=0;i<cels.length;i++){
            cels[i]=new JButton("+");
            cels[i].setSize(10, 10);
            cels[i].setEnabled(false);
            cels[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            if(new Random().nextInt(101)<60){
                cels[i].setBackground(Color.white);
                curCel++;
            }
            else{
                cels[i].setBackground(Color.black);
                if(i!=0 && i!=cels.length-1)
                    cels[i].setText("-");
            }
            jp.add(cels[i]);
        }
        cels[0].setBackground(Color.white);
        cels[0].setText("S");
        cels[0].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        cels[0].setForeground(Color.red);
        cels[0].setEnabled(true);
        cels[cels.length-1].setBackground(Color.white);
        cels[cels.length-1].setText("E");
        cels[cels.length-1].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        cels[cels.length-1].setForeground(Color.red);
        cels[cels.length-1].setEnabled(true);
        stackArray=new int[curCel];
        backStackArray=new int[curCel];
        curCel=0;
        add(jp);
        jp.setBounds(10,10,700,700);
        ba.setBounds(8,8,705,705);
        ba.setEnabled(false);
        ba.setBackground(Color.cyan);
        add(ba);
        add(jl);
        setLayout(null);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        solv.addActionListener(new AL(0));
        solv.setSize(180, 50);
        solv.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        solv.setBackground(Color.yellow);
        solv.setLocation(jp.getX()+jp.getWidth()+10, 5);
        add(solv);
        newg.addActionListener(new AL(1));
        newg.setSize(180, 50);
        newg.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        newg.setBackground(Color.yellow);
        newg.setLocation(jp.getX()+jp.getWidth()+10, solv.getY()+solv.getHeight()+10);
        add(newg);
        exit.addActionListener(new AL(2));
        exit.setSize(180, 50);
        exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        exit.setBackground(Color.yellow);
        exit.setLocation(jp.getX()+jp.getWidth()+10, newg.getY()+newg.getHeight()+10);
        add(exit);
        jl.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        jl.setBounds(jp.getX()+jp.getWidth()+5, exit.getHeight()+5, 900, 300);
        jl.setForeground(Color.blue);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    class AL implements ActionListener{
    private int sel;
    private DoActions doIt=new DoActions();
    AL(int i){
        sel=i;
    }
    public void actionPerformed(ActionEvent e) {
        switch(sel){
            case 0:
                solv.setEnabled(false);
                newg.setEnabled(false);
                Thread t =new Thread(doIt);
                t.start();
                break;
            case 1:
                dispose();
                new MazeRunner();
                break;
            case 2:
                doIt.exit();
                break;
        }
    }
}
    class DoActions implements Runnable{
        public void exit(){
            System.exit(0);
        }
        private void push(int c){            
            counter++;
            stackArray[counter]=c;            
        }
        private int pop(){
            int tmp=stackArray[counter];
            counter--;
            return tmp;
        }
        private void backPush(int c){
            backCounter++;
            backStackArray[backCounter]=c;
        }
        private int backPop(){
            int tmp=backStackArray[backCounter];
            backCounter--;
            return tmp;
        }
        public void run() {
            while(isWay){                
                cels[curCel].setBackground(Color.green);
                backPush(curCel);
                if(curCel==cels.length-1)
                    break;
                int right=curCel+1, down=curCel+10, left=curCel-1, up=curCel-10;
                if(right<100 && isRight && curCel%10!=9 && cels[right].getBackground()==Color.white){
                    isLeft=false;
                    isUp=false;
                    isDown=false;
                    go=true;
                    if(down<100 && cels[down].getBackground()==Color.white)
                        push(curCel);
                    else if(left>-1 && curCel%10!=0 && cels[left].getBackground()==Color.white)
                        push(curCel);
                    else if(up>-1 && cels[up].getBackground()==Color.white)
                        push(curCel);
                    curCel=right;
                }else if(down<100 && isDown && cels[down].getBackground()==Color.white){
                    isRight=false;
                    isUp=false;
                    isLeft=false;
                    go=true;
                    if(right<100 && curCel%10!=9 && cels[right].getBackground()==Color.white)
                        push(curCel);
                    else if(left>-1 && curCel%10!=0  && cels[left].getBackground()==Color.white)
                        push(curCel);
                    else if(up>-1 && cels[up].getBackground()==Color.white)
                        push(curCel);
                    curCel=down;
                }else if(left>-1 && isLeft && curCel%10!=0  && cels[left].getBackground()==Color.white){
                    isRight=false;
                    isUp=false;
                    isDown=false;
                    go=true;
                    if(down<100 && cels[down].getBackground()==Color.white)
                        push(curCel);
                    else if(right<100 && curCel%10!=9 && cels[right].getBackground()==Color.white)
                        push(curCel);
                    else if(up>-1 && cels[up].getBackground()==Color.white)
                        push(curCel);
                    curCel=left;
                }else if(up>-1 && isUp && cels[up].getBackground()==Color.white){
                    isDown=false;
                    isRight=false;
                    isLeft=false;
                    go=true;
                    if(down<100 && cels[down].getBackground()==Color.white)
                        push(curCel);
                    else if(left>-1 && curCel%10!=0  && cels[left].getBackground()==Color.white)
                        push(curCel);
                    else if(right<100 && curCel%10!=9 && cels[right].getBackground()==Color.white)
                        push(curCel);
                    curCel=up;
                }else if(go){
                    go=false;
                    isRight=true;
                    isUp=true;
                    isDown=true;
                    isLeft=true;
                }else if(counter>-1){
                    curCel=pop();
                    int lastCel=backPop();
                    while(lastCel!=curCel){
                        cels[lastCel].setBackground(Color.blue);
                        lastCel=backPop();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    int lastCel=backPop();
                    while(lastCel!=0){
                        cels[lastCel].setBackground(Color.blue);
                        lastCel=backPop();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    isWay=false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//while
            for(int i=0;i<cels.length;i++)
                if(isWay && cels[i].getBackground()==Color.blue)
                    cels[i].setBackground(Color.white);
            if(isWay)
                JOptionPane.showMessageDialog(rootPane, "Hooray!!! way found.",
                        "Result", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(rootPane, "Sorry!!! way not found.",
                        "Result", JOptionPane.INFORMATION_MESSAGE);
            newg.setEnabled(true);
        }
    }
    public static void main(String arg[]){
        new MazeRunner();        
    }
}

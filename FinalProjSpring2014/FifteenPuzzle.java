
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Game extends JFrame {

    GridLayout board = new GridLayout(4, 4, 3, 3);
    Color back = Color.GRAY;
    JPanel panel = new JPanel(board);
    JPanel cell[] = new JPanel[16];
    JButton slide[] = new JButton[15];
    public static int emptyPlace=-1;
    byte place[] = new byte[16];
    Random rnd = new Random();

    class AL implements ActionListener {
        int placeI;
        int i;
        AL(int i, int pl){
            placeI=pl;
            this.i=i;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource()==slide[placeI]){                               
                //cell[emptyPlace].add(slide[place[i]]);
                (cell[i].getComponent(0)).setBackground(Color.RED);
                (cell[emptyPlace].getComponent(0)).setBackground(Color.RED);
                emptyPlace=i;
                panel.repaint();
                System.out.println("emptyPlace is: "+emptyPlace);
            }
        }
    }

    public Game() {
        setTitle("15-Puzzle");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        panel.setBackground(back);
        for (byte i = 0; i < 15; i++) {
            place[i] = i;
        }
        for (byte i = 0; i < 15; i++) {
            byte random = (byte) (rnd.nextInt(16 - i) + i);
            byte temp = place[i];
            place[i] = place[random];
            place[random] = temp;
        }
        for (byte i = 0; i < 16; i++) {
            System.out.println("i = " + i + " place[i] = " + place[i] + " , ");
            cell[i] = new JPanel(new GridLayout(1, 1));
            cell[i].setBackground(Color.GREEN);
            panel.add(cell[i]);
        }
        for (byte i = 0; i < 16; i++) {
            
            if ( i!=15) {
                cell[i].add(slide[place[i]] = new JButton("" + place[i]));
                slide[place[i]].addActionListener(new AL(i,place[i]));
                
            }else
                emptyPlace=i;            
        }        
        setVisible(true);
        System.out.println("emptyPlace: "+emptyPlace);
    }
}

public class FifteenPuzzle {

    public static void main(String[] agrs) {
        new Game();
    }
}

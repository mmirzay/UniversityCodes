

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;


class Demo{
    JFrame jf = new JFrame("Mohsen Mirza");
    JPanel jp = new JPanel(null);
    JMenuBar jmb = new JMenuBar();
    JMenu jmFile = new JMenu("File");
    JMenuItem jmi1 = new JMenuItem("New                     ");
    JMenuItem jmi3 = new JMenuItem("Open                     ");
    JMenuItem jmi4 = new JMenuItem("Save                     ");
    JMenuItem jmi6 = new JMenuItem("Exit                        ");
    JButton button[] = new JButton[20];
    JFileChooser jfc = new JFileChooser();
    private Color [] clr={Color.black,Color.orange,Color.BLUE,Color.WHITE,Color.DARK_GRAY,Color.yellow,Color.CYAN,Color.LIGHT_GRAY,Color.RED,Color.GREEN,Color.MAGENTA,Color.LIGHT_GRAY,Color.PINK};
    private int index = 0 ,indexC = 0, contcat = 0,tedad = 0, x = 0, y = 0, current, returnVa, returnVal;
    private ActionEvent ae;
    Demo(){
        jf.setSize(550,550);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.getContentPane().add(jp);
        jf.setJMenuBar(jmb);
        jmb.add(jmFile);jmFile.add(jmi1);jmFile.add(jmi3);jmFile.add(jmi4);jmFile.add(jmi6);
        jmFile.setMnemonic('F');
        jf.setLocation(410, 110);
        for(int i=0 ; i<button.length ; i++){
              button[i] = new JButton(String.valueOf(i));
              button[i].setBounds(10,10,50,50);
              button[i].setLocation(10,10);
              button[i].setToolTipText("  Button ["+i+"]  ");
              button[i].addKeyListener(new KL(button[i]));
              button[i].addMouseListener(new ML());
              button[i].addMouseMotionListener(new MML(button[i]));
              button[i].setVisible(false);
              jp.add(button[i]);

        }
        jp.addKeyListener(new KL());
        jmi1.addActionListener(new AL(1));
        jmi3.addActionListener(new AL(3));
        jmi4.addActionListener(new AL(4));
        jmi6.addActionListener(new AL(6));
    }
        class AL implements ActionListener{
        private int i;
        AL(int i){ this.i = i;}
        public void actionPerformed(ActionEvent ae){
            switch(i){
                case 1: add(); break;
                case 3: open(); break;
                case 4: save(); break;
                case 6: exit();break;
            }
         }
      }
        class ML implements MouseListener {
            ML(){}
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                x = e.getX();
		y = e.getY();
            }
            public void mouseReleased(MouseEvent e) {}
        }
        class FL implements FocusListener {
            private JButton b;
            FL(JButton b){this.b = b;}
            public void focusGained(FocusEvent e) {
                b.addFocusListener(this);
            }
            public void focusLost(FocusEvent e) {}
        }
        class KL implements KeyListener {
            private JButton b;
            KL(JButton b){this.b = b;}

        private KL() {
//            throw new UnsupportedOperationException("Not yet implemented");
        }
            public void keyPressed(KeyEvent e) {
                if(e.getModifiers()== 2 && e.getKeyCode() == 78){
                    add();
                }
                if(e.getKeyCode() == 39){
                   if(!isContact(b,0)){
                   b.setLocation(b.getX()+1, b.getY());
                   }
                   else{
                       buzz();
                       try {
                           throw new Barkhord();
                       } catch (Barkhord ex) {
                           contcat++;
                       }
                    }
                }
                if(e.getKeyCode() == 37){
                    if(!isContact(b,1)){
                   b.setLocation(b.getX()-1, b.getY());
                    }
                   else{
                     buzz();
                       try {
                           throw new Barkhord();
                       } catch (Barkhord ex) {
                           contcat++;
                       }
                   }
                }
                if(e.getKeyCode() == 38){
                   if(!isContact(b,2)){
                   b.setLocation(b.getX(), b.getY()-1);
                   }
                   else{
                       buzz();
                       try {
                           throw new Barkhord();
                       } catch (Barkhord ex) {
                           contcat++;
                       }
                   }
                }
                if(e.getKeyCode() == 40){
                    if(!isContact(b,3)){
                   b.setLocation(b.getX(), b.getY()+1);
                    }
                    else {
                     buzz();
                       try {
                           throw new Barkhord();
                       } catch (Barkhord ex) {
                           contcat++;
                       }
                    }
                }
                int a;
                for(int i=0 ; i<tedad ; i++){
                if(e.getKeyCode() == 27){

                    button[current].setVisible(false);
                    tedad--;

                    }
                }
                if(e.getKeyCode() == 32)
                   if(indexC == clr.length){
                       indexC = 0;
                       b.setBackground(clr[indexC++]);
                    }
                   else
                       b.setBackground(clr[indexC++]);
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
    }
        class MML implements MouseMotionListener {
            private JButton b;
            MML(JButton b){this.b = b;}
            public void mouseDragged(MouseEvent e) {
                if(!isContact(b,-1)){
                    b.setLocation(b.getX() + e.getX() - x, b.getY() + e.getY() - y);
                }
                 else{
                     buzz();
                       try {
                           throw new Barkhord();
                       } catch (Barkhord ex) {
                           contcat++;
                       }
                     }
            }
            public void mouseMoved(MouseEvent e) {}
        }
        public boolean isContact(JButton b,int status){
            boolean acc = false;
            current = Integer.parseInt(b.getText());
            //Hareket ba maos
            if(status == -1){
                for(int i=0 ; i<tedad && !acc ; i++){
                   if((button[current].getX()+50 == button[i].getX() && button[current].getY()<button[i].getY() && button[i].getY()<button[current].getY()+50) || (button[current].getX()+50 == button[i].getX() && button[current].getY()>button[i].getY()&&button[current].getY()<button[i].getY()+50) || (button[current].getX()+50 == button[i].getX() && button[current].getY()+50 == button[i].getY()+50)){
                        acc=true;
                        button[current].setLocation(b.getX()-1, b.getY());
                    }
                   if((button[current].getX() == button[i].getX()+50 && button[current].getY()<button[i].getY() && button[i].getY()<button[current].getY()+50) || (button[current].getX() == button[i].getX()+50 && button[current].getY()>button[i].getY()&&button[current].getY()<button[i].getY()+50) || (button[current].getX() == button[i].getX()+50 && button[current].getY()+50 == button[i].getY()+50)){
                        acc=true;
                        button[current].setLocation(b.getX()+1, b.getY());
                    }
                    if((button[current].getY() == button[i].getY()+50 && button[current].getX()<button[i].getX() && button[i].getX()<button[current].getX()+50) || (button[current].getY() == button[i].getY()+50 && button[current].getX()>button[i].getX()&&button[current].getX()<button[i].getX()+50) || (button[current].getY() == button[i].getY()+50 && button[current].getX()+50 == button[i].getX()+50)){
                        acc=true;
                        button[current].setLocation(b.getX(), b.getY()+1);
                    }
                    if((button[current].getY()+50 == button[i].getY() && button[current].getX()<button[i].getX() && button[i].getX()<button[current].getX()+50) || (button[current].getY()+50 == button[i].getY() && button[current].getX()>button[i].getX()&&button[current].getX()<button[i].getX()+50) || (button[current].getY()+50 == button[i].getY() && button[current].getX()+50 == button[i].getX()+50)){
                        acc=true;
                        button[current].setLocation(b.getX(), b.getY()-1);
                    }
                }
            }
            if(status == 0){
                //jelo
                for(int i=0 ; i<tedad && !acc ; i++){
                    if ((button[current].getX() + 50 == button[i].getX() && button[current].getY() < button[i].getY() && button[i].getY() < button[current].getY() + 50) || (button[current].getX() + 50 == button[i].getX() && button[current].getY() > button[i].getY() && button[current].getY() < button[i].getY() + 50) || (button[current].getX() + 50 == button[i].getX() && button[current].getY() + 50 == button[i].getY() + 50)) {
                        acc=true;
                    }
                }
            }
            if(status == 1){
                //aghab
                for(int i=0 ; i<tedad && !acc ; i++){
                    if((button[current].getX() == button[i].getX()+50 && button[current].getY()<button[i].getY() && button[i].getY()<button[current].getY()+50) || (button[current].getX() == button[i].getX()+50 && button[current].getY()>button[i].getY()&&button[current].getY()<button[i].getY()+50) || (button[current].getX() == button[i].getX()+50 && button[current].getY()+50 == button[i].getY()+50)){
                        acc=true;
                    }
                }
            }
            if(status == 2){
                //bala
                for(int i=0 ; i<tedad && !acc ; i++){
                    if((button[current].getY() == button[i].getY()+50 && button[current].getX()<button[i].getX() && button[i].getX()<button[current].getX()+50) || (button[current].getY() == button[i].getY()+50 && button[current].getX()>button[i].getX()&&button[current].getX()<button[i].getX()+50) || (button[current].getY() == button[i].getY()+50 && button[current].getX()+50 == button[i].getX()+50)){
                        acc=true;
                    }
                }
            }
            if(status == 3){
                //paein
                for(int i=0 ; i<tedad && !acc ; i++){
                    if((button[current].getY()+50 == button[i].getY() && button[current].getX()<button[i].getX() && button[i].getX()<button[current].getX()+50) || (button[current].getY()+50 == button[i].getY() && button[current].getX()>button[i].getX()&&button[current].getX()<button[i].getX()+50) || (button[current].getY()+50 == button[i].getY() && button[current].getX()+50 == button[i].getX()+50)){
                        acc=true;
                    }
                }
            }
            return acc;
        }
        public void add(){
             button[index++].setVisible(true);
             tedad++;
             for(int i=1 ; i<tedad ; i++){
                 if((button[current].getX() == button[i].getX() && button[current].getY() == button[i].getY()) && (button[current].getX()+50 == button[i].getX()+50 && button[current].getY()+50 == button[i].getY()+50)){
                     JOptionPane.showMessageDialog(jf, "The Button created is under the last Button!!\n\tPlease move the last Button!");
                 }
             }
        }
        public void save(){
            int n = JOptionPane.showConfirmDialog(jp , "Do you want to save this Frame?" , "An Inane Question" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
            if(n == JOptionPane.YES_OPTION){
                returnVa = jfc.showSaveDialog(jp);
                if(returnVa == jfc.APPROVE_OPTION){
                    File file = jfc.getSelectedFile();
                    try {
                       write(file);
                      } catch (IOException ex) {
                          JOptionPane.showMessageDialog(jf , "Warning: "+ex.toString());
                         }
                    }
               }
        }
        public void open(){
            returnVal = jfc.showOpenDialog(jp);
            if(returnVal == jfc.APPROVE_OPTION){
                File file = jfc.getSelectedFile();
                try {
                    read(file);
                    } catch (IOException ex) {
                          JOptionPane.showMessageDialog(jf , "Warning: "+ex.toString());
                    } catch (ClassNotFoundException ex) {
                          JOptionPane.showMessageDialog(jf , "Warning: "+ex.toString());
                    }
             }
        }
        public void write(File file) throws IOException{
            MyButton []mb = new MyButton[tedad];
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            mb[0] = new MyButton();
            mb[0].x = tedad;// khneye aval tedade button haye mojod ast
            oos.writeObject(mb[0]);
            oos.flush();
            for(int i=0 ; i<tedad ; i++){
                mb[i] = new MyButton();
                mb[i].num = Integer.parseInt(button[i].getText());
                mb[i].x = button[i].getX();
                mb[i].y = button[i].getY();
                mb[i].color = button[i].getBackground();
                oos.writeObject(mb[i]);
                oos.flush();
            }
            oos.close();
        }
        public void read(File file) throws IOException, EOFException, ClassNotFoundException{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            MyButton mbn = null;
            try{
            mbn = (MyButton)ois.readObject();
            JPanel jp1 = new JPanel(null);
            jf.setContentPane(jp1);
            for(int i=0 ; i<mbn.x ; i++){
                mbn = (MyButton)ois.readObject();
                jp1.add(button[i]);
                button[i].setBounds(10, 10, 50, 50);
                button[i].setVisible(true);
                button[i].setLocation(mbn.x, mbn.y);
                button[i].setBackground(mbn.color);
                jp1.add(button[i]);
                }
            }
            catch(EOFException e){
                JOptionPane.showMessageDialog(jf , "Warning: "+e.toString());
                ois.close();
            }
            catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(jf , "Warning class: "+e.toString());
            }
        }
        public void exit(){
            JOptionPane.showMessageDialog(jf, "Number of your encounters is: "+contcat);
            System.exit(0);
        }
        public void buzz(){
            int i=0;
            while(i<4){
            jf.setLocation(418,128);
            jf.setLocation(402,122);
            try{
                Thread.sleep(10);
            }catch(Exception er){}
            jf.setLocation(430,140);
            jf.setLocation(410,110);
            try{
                Thread.sleep(10);
            }catch(Exception er){}
            jf.setLocation(418,112);
            jf.setLocation(419,119);
            try{
                Thread.sleep(10);
            }catch(Exception er){}
            jf.setLocation(430,138);
            jf.setLocation(410,110);
             try{
                Thread.sleep(10);
            }catch(Exception er){}
            i++;
            }
        }
}
public class LayoutTest {
    public static void main(String[] args) {
        new Demo();
    }
}
class MyButton implements Serializable{
    int x,y,num;
    Color color;
}
class Barkhord extends IOException{
    public Barkhord() {
        JOptionPane.showMessageDialog(new JFrame(), "You hit the button with another button!!");
    }
}
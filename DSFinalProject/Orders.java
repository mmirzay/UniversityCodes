/*
 Collegian & Programmer properties:
        * name: Mohsen
        * family: Mirzay
        * collegian ID number: 8917050113
        * university field: Information Technology Engineering (ITE)
        * entrance year: 1389
 Project properties:
        >>>Working On Tree of Mathematic Expressions<<<
	* Final Project
	* Data Structures
	* University of Kurdistan
	* Fall 2011
	* Instructor: Amanj Khorramian
 *************************************************
 Some Mathematic Expression:
        INFIX: ((a+((b-(c*d))^e))-(f^(g^((h/(~i))+k))))
        POSTFIX: abcd*-e^+fghi~/k+^^-
        PREFIX: -+a^-b*cde^f^g+/h~ik
    ///////////////////////////////////
        INFIX: (e^((f+(g/h))+(i*j)))
        POSTFIX: efgh/+ij*+^
        PREFIX: ^e++f/gh*ij
    //////////////////////////////////
        INFIX: (((a-b)*(c+d))/e)
        POSTFIX: ab-cd+*e/
        PREFIX: /*-ab+cde
    //////////////////////////////////
        INFIX: ((a+((~b)-c))*(d/e))
        POSTFIX: ab~c-+de/*
        PREFIX: *+a-~bc/de
    //////////////////////////////////
        INFIX: ((a*(b+(c-d)))-(e^((f+(g/h))+(i*j))))
        POSTFIX: abcd-+*efgh/+ij*+^-
        PREFIX: -*a+b-cd^e++f/gh*ij
    ///////////////////////////////////
        INFIX: (e^(f+(g%(h*(i*j)))))
        POSTFIX: efghij**%+^
        PREFIX: ^e+f%g*h*ij
    /////////////////////
        INFIX: e^(f/g%h*i*j)
        POSTFIX: efg/hi*j*%^
        PREFIX: ^e%/fg**hij
    /////////////////////////////////////
        INFIX: (((~e)^((f+((~g)/h))+((~i)*(~j))))/k)
        POSTFIX: e~fg~h/+i~j~*+^k/
        PREFIX: /^~e++f/~gh*~i~jk
    /////////////////////////////////////
        INFIX: (((a-b)*(c+(~d)))%e)
        POSTFIX: ab-cd~+*e%
        PREFIX: %*-ab+c~de
    //////////////////////////////////////
        INFIX: ((a-b)*(c+d))/((e+e)%~(f-f))
        POSTFIX: ab-cd+*ee+ff-~%/
        PREFIX: /*-ab+cd%+ee~-ff
    ////////////////////////////////////
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.JOptionPane.*;

class ArrayStack{
    private static final int CAPACITY=50;
    private int capacity;
    private char arrayStack[];
    private int top=-1;

    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int cap){
        capacity=cap;
        arrayStack=new char[capacity];
    }
    private int getStackSize(){return top+1;}
    private int getStackCapacity(){return capacity;}
    public boolean isEmpty(){return getStackSize()==0;}
    public char getTop() throws Exception{
        if(isEmpty())
            throw new Exception("No Top Element");
        return arrayStack[top];
    }
    public void push(char chr) throws Exception{
        if(getStackCapacity()==getStackSize())
            throw new Exception("Stack is Full");
        top++;
        arrayStack[top]=chr;
    }
    public char pop() throws Exception{
        if(isEmpty())
            throw new Exception("No element to Pop");
        char temp=arrayStack[top];
        top--;
        return temp;
    }
}// Char ArrayStack.

class IntegerArrayStack{
    private static final int CAPACITY=50;
    private int capacity;
    private int arrayStack[];
    private int top=-1;

    public IntegerArrayStack() {
        this(CAPACITY);
    }
    public IntegerArrayStack(int cap){
        capacity=cap;
        arrayStack=new int[capacity];
    }
    private int getStackSize(){return top+1;}
    private int getStackCapacity(){return capacity;}
    public boolean isEmpty(){return getStackSize()==0;}
    public int getTop() throws Exception{
        if(isEmpty())
            throw new Exception("No Top Element");
        return arrayStack[top];
    }
    public void push(int pos) throws Exception{
        if(getStackCapacity()==getStackSize())
            throw new Exception("Stack is Full");
        top++;
        arrayStack[top]=pos;
    }
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("No element to Pop");
        int temp=arrayStack[top];
        top--;
        return temp;
    }
}// IntegerArrayStack.

class TreeNode{
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private char element=0;
    private int posX , posY;

    public TreeNode() {
        left=null;
        right=null;
        parent=null;
        element=0;
    }
    TreeNode(char elem){
        element=elem;
        left=null;
        right=null;
        parent=null;
    }
    public TreeNode(char element, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.element = element;
        parent = null;
    }
    public void setElem(char chr){element=chr;}
    public char getElem(){return element;}
    public void setLeft(TreeNode tn){left=tn;}
    public TreeNode getLeft(){return left;}
    public void setRight(TreeNode tn){right=tn;}
    public TreeNode getRight(){return right;}
    public void setParent(TreeNode tn){parent=tn;}
    public TreeNode getParent(){return parent;}    
    public void setX(int x){posX=x;}
    public int getX(){return posX;}
    public void setY(int y){posY=y;}
    public int getY(){return posY;}
}// TreeNode.

class TreeShow extends JPanel{
    private TreeNode tree[];

    TreeShow(TreeNode[] tn){tree=tn;}    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        int st=200, lev=2,lstlev=0, constSpace=70;
        tree[0].setX(650);
        tree[0].setY(0);
        for(int i=1;i<tree.length;i++){
            int x1=0 , x2=0;
            int y1=0 , y2=0;
            char ch=0;
            if(tree[i]!=null){
                x2=tree[i].getParent().getX();
                y2=tree[i].getParent().getY();
                if(tree[i]==tree[i].getParent().getLeft())
                    tree[i].setX(x2-st);
                else
                    tree[i].setX(x2+st);
                if(tree[i-1]!=null )
                    if((i-1>lstlev && i-1<=lev) && tree[i].getX()<=tree[i-1].getX()+40)
                        tree[i].setX(tree[i].getX()+20);                
                tree[i].setY(y2+65);
                x1=tree[i].getX();
                y1=tree[i].getY();
                ch=tree[i].getElem();
                g.setColor(Color.red);
                g.drawLine(x1+15, y1+12, x2+15, y2+12);
            }// if tree[i]!null
            if(i==lev){
                st-=constSpace;
                lstlev=lev;
                lev=lev*2+2;
            }
            if(st<0) st=15;
        }// for lines.
        st=200;
        g.setColor(Color.blue);
        g.fillOval(tree[0].getX(), tree[0].getY(), 30, 30);
        g.setColor(Color.yellow);
        g.drawString(""+tree[0].getElem(), tree[0].getX()+10, tree[0].getY()+20);
        for(int i=1;i<tree.length;i++){
            int x1=0;
            int y1=0;
            char ch=0;            
            if(tree[i]!=null){                
                x1=tree[i].getX();
                y1=tree[i].getY();
                ch=tree[i].getElem();
                g.setColor(Color.blue);
                g.fillOval(x1, y1, 30, 30);
                g.setColor(Color.yellow);
                g.drawString(""+ch, x1+10, y1+20);
            }//if!NULL
            if(i==lev){
                st-=constSpace;
                lev=lev*2+2;
            }
            if(st<0) st=15;
        }// for Ovals.
    }// painComponent.
}// TreeShow.

class Fram extends JFrame{
    TreeShow tr;
    JButton exit= new JButton(">>> Exit <<<");
    JPanel jp=new JPanel(new BorderLayout());
    Fram(TreeNode[] tn){
        tr=new TreeShow(tn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        getContentPane().add(jp);
        jp.add(exit, BorderLayout.SOUTH);
        jp.add(tr);
        tr.setBackground(Color.darkGray);
        jp.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        jp.setToolTipText("MOHSENmirzay");
        exit.setForeground(Color.red);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setFont(new Font(Font.MONOSPACED, Font.BOLD, 36));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}// Fram.

public class Orders{
    static char exp[];

    private static String infix2postfix(String infix) throws Exception{
        if(infix.equals("")){
            JOptionPane.showMessageDialog(null, "the Mathematic " +
                "Expression is null.\ntry again.","Null Expression",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }// if ""
        String result="";
        int oppr=0,clpr=0;
        exp=new char[infix.length()];
        ArrayStack charStack=new ArrayStack(infix.length());
        ////////////////////////////////////////////////////
        for(int i=0;i<infix.length();i++){
            exp[i]=infix.charAt(i);
            switch(exp[i]){
                case '!':
                case '@':
                case '#':
                case '$':
                case '&':
                case '_':
                case '=':
                case '{':
                case '}':
                case '[':
                case ']':
                case '\\':
                case '|':
                case '`':
                case '.':
                case ',':
                case '<':
                case '>':
                case '?':
                case '"':
                case '\'':
                case ':':
                case ';':{
                    JOptionPane.showMessageDialog(null, "the Entrance " +
                        "Expression has NOT correct Foramt.\n" +
                        "EXPRESSION: "+infix+"\n" +
                        "Use just below Characters:\n" +
                        "~ ^ * / % + -\n" +
                        "try again.", "Incorrect Input",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                break;
                case '(':
                    oppr++;
                    break;
                case ')':
                    clpr++;
                    break;
            }//switch
            if(exp[i]>='0' && exp[i]<='9'){
                JOptionPane.showMessageDialog(null, "Do NOT use " +
                    "Numeral Character (0~9).\n" +
                    "Use Literal " +
                    "Character (a~z) or (A~Z) and try again.",
                    "Incorrect Input", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }//for numeral.
        }//mainfor.
        if(oppr!=clpr){
            JOptionPane.showMessageDialog(null, "The Mathematic " +
                "Expression has NOT correct Format.\n " +
                "the Computation of " +
                "Open Parenthesis does Not " +
                "equal to Close Parenthesis!!!\n" +
                "try again.",
                    "Incorrect Input",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//if oppr!=clpr
        for(int i=0;i<exp.length;i++){
            if((exp[i]>=65 && exp[i]<=90) ||
                    (exp[i]>=97 && exp[i]<=122)){
                result+=exp[i];
                continue;
            }//if literal.
            if(exp[i]=='('){
                charStack.push(exp[i]);
                continue;
            }//if (
            if(exp[i]==')'){
                char temp=0;
                if(!charStack.isEmpty()){
                    temp=charStack.getTop();
                    if(temp=='('){
                        temp=charStack.pop();
                        continue;
                    }
                }
                while(!charStack.isEmpty() && temp!='('){
                    temp=charStack.pop();
                    if(temp!='(')
                        result+=temp;
                }
                continue;
            }// if )
            if(exp[i]=='~'){
                charStack.push(exp[i]);
                continue;
            }// if ~
            char x=exp[i];
            char y=0;
            if(!charStack.isEmpty()) y=charStack.getTop();
            if(x=='^'){
                if(y=='~'){
                    y=charStack.pop();
                    while(y=='~'){
                        result+=y;
                        if(!charStack.isEmpty()){
                            y=charStack.pop();
                            if(y!='~')
                                charStack.push(y);
                        }else y=0;
                    }//while y=='~'
                    charStack.push(x);
                    continue;
                }//if y==~
                charStack.push(x);
                continue;
            }//if x==^
            if(x=='*' || x=='/'){
                if(y=='^' || y=='*' || y=='/' || y=='~'){
                    y=charStack.pop();                    
                    while(y!='%' && y!='+' && y!='-' && y!='('){
                        result+=y;
                        if(!charStack.isEmpty()){
                            y=charStack.pop();
                            if(y=='%' || y=='+'||y=='-'||y=='(')
                                charStack.push(y);
                        }else{
                            y=0;
                            break;
                        }
                    }//while(y!='+' && y!='-' && y!='(')
                    charStack.push(x);
                    continue;
                }//if(y=='^' || y=='*' || y=='/' || y=='~')
                charStack.push(x);
                continue;
            }//if(x=='*' || x=='/')
            if(x=='%'){
                if(y=='^' || y=='*' || y=='/' || y=='~' || y=='%'){
                    y=charStack.pop();
                    while(y!='+' && y!='-' && y!='('){
                        result+=y;
                        if(!charStack.isEmpty()){
                            y=charStack.pop();
                            if(y=='+'||y=='-'||y=='(')
                                charStack.push(y);
                        }else{
                            y=0;
                            break;
                        }
                    }//while(y!='+' && y!='-' && y!='(')
                    charStack.push(x);
                    continue;
                }//if(y=='^' || y=='*' || y=='/' || y=='~' y=='%)
                charStack.push(x);
                continue;
            }//if x=='%
            if(x=='+' || x=='-'){
                if(y!='(' && y!=0){
                    y=charStack.pop();
                    while(y!='('){
                        result+=y;
                        if(!charStack.isEmpty()){
                            y=charStack.pop();
                            if(y=='(')
                                charStack.push(y);
                        }
                        else{
                            y=0;
                            break;
                        }
                    }//while(y!='(';
                    charStack.push(x);
                    continue;
                }//if(y!='(' && y!=0)
                charStack.push(x);
                continue;
            }//if x==+ x==-
        }// main for
        while(!charStack.isEmpty())
            result+=charStack.pop();
	return result;
    }// infix to postfix
    private static String postfix2prefix(String postfix) throws Exception{
        if(postfix.equals("")){
            JOptionPane.showMessageDialog(null, "the Mathematic " +
                "Expression is null.\ntry again.","Null Expression",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }// if ""
        exp=new char[postfix.length()];
        String preExp[]=new String[postfix.length()];
        String strExp[]=new String[postfix.length()];
        String result="";
        char chr=0;
        int pos=0;
        /////////////////////////////////////////////
        for(int i=0;i<postfix.length();i++){
            exp[i]=postfix.charAt(i);
            switch(exp[i]){
                case '!':
                case '@':
                case '#':
                case '$':
                case '&':
                case '_':
                case '=':
                case '{':
                case '}':
                case '[':
                case ']':
                case '\\':
                case '|':
                case '`':
                case '.':
                case ',':
                case '<':
                case '>':
                case '?':
                case '"':
                case '\'':
                case ':':
                case ';':{
                    JOptionPane.showMessageDialog(null, "the Entrance " +
                        "Expression has NOT correct Foramt.\n" +
                        "EXPRESSION: "+postfix+"\n" +
                        "Use just below Characters:\n" +
                        "~ ^ * / % + -\n" +
                        "try again.", "Incorrect Input",
                        JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                    break;
                case '(':
                case ')':{
                    JOptionPane.showMessageDialog(null, "You could NOT " +
                        "use Parenthesis () in Postfix Expression.\n" +
                        "try again.", "Incorrect Input",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                    break;
            }//switch
            if(exp[i]>='0' && exp[i]<='9'){
                JOptionPane.showMessageDialog(null, "Do NOT use " +
                    "Numeral Character (0~9).\n" +
                    "Use Literal " +
                    "Character (a~z) or (A~Z) and try again.",
                        "Incorrect Input", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }// if numeral
            strExp[i]=""+exp[i];
        }// main for.
        for(int i=0;i<strExp.length;i++){
            chr=strExp[i].charAt(0);
            if((chr>=65 && chr<=90)
                || (chr>=97 && chr<=122)){
                preExp[pos]=strExp[i];
                pos++;
                continue;
            }//if lit.
            if(chr=='~'){
                preExp[pos-1]="~"+preExp[pos-1];
                continue;
            }//if ~
            if(chr=='^' || chr=='*' || chr=='/'
                || chr=='+' || chr=='-' || chr=='%'){
                String temp="";
                temp=""+chr;
                for(int k=pos-2;k<preExp.length;k++){
                    if(preExp[k]==null) break;
                    temp+=preExp[k];
                    preExp[k]=null;
                }
                preExp[pos-2]=temp;
                pos--;
                continue;
            }//if operand.
        }//main for
        for(int k=0;k<preExp.length;k++){
            if(preExp[k]==null) break;
            result+=preExp[k];
        }
        return result;
    }// postfix to infix
    private static TreeNode[] myInfix2tree(String inf) throws Exception{
        String postfix=infix2postfix(inf);
        IntegerArrayStack RLpos=new IntegerArrayStack(postfix.length());
        char charExp[]=new char[postfix.length()];
        int lpos=-1, rpos=-1, opCount=0;
        ////////////////////////////////////////////////////////////////
        for(int i=0;i<postfix.length();i++){
            charExp[i]=postfix.charAt(i);
            char chr=charExp[i];
            if((chr>=65 && chr<=90)
                    || (chr>=97 && chr<=122))
                opCount++;
            if(chr=='~' || chr=='^' || chr=='*' || chr=='/'
                    || chr=='+' || chr=='-' || chr=='%')
                opCount++;
        }// opCounter
        TreeNode myTree[]=new TreeNode[postfix.length()];
        for(int i=0;i<postfix.length();i++){
            char chr=charExp[i];
            if((chr>=65 && chr<=90)
                    || (chr>=97 && chr<=122)){
                myTree[i]=new TreeNode(chr);
                RLpos.push(i);
                continue;
            }// if literal char.
            if(chr=='~'){
                rpos=RLpos.pop();
                myTree[i]=new TreeNode(chr, null, myTree[rpos]);
                myTree[i].getRight().setParent(myTree[i]);
                RLpos.push(i);
                continue;
            }// if chr.
            if(chr=='^' || chr=='*' || chr=='/'
                    || chr=='+' || chr=='-' || chr=='%'){
                rpos=RLpos.pop();
                lpos=RLpos.pop();
                myTree[i]=new TreeNode(chr, myTree[lpos], myTree[rpos]);
                myTree[i].getLeft().setParent(myTree[i]);
                myTree[i].getRight().setParent(myTree[i]);
                RLpos.push(i);
                continue;
            }// if operand
        }//main for switching TREE.
        TreeNode[] result=new TreeNode[myTree.length*100];
        int i=0;
        result[0]=myTree[RLpos.getTop()];
        while(2*i+2<result.length){
            if(result[i]!=null){
                result[2*i+1]=result[i].getLeft();
                result[2*i+2]=result[i].getRight();
                if(result[2*i+1]!=null)
                    result[2*i+1].setParent(result[i]);
                if(result[2*i+2]!=null)
                    result[2*i+2].setParent(result[i]);
            }else{
                result[2*i+1]=null;
                result[2*i+2]=null;
            }
            i++;
        }// Switch to Array.
        return result;
    }// myInfixToTree.
    private static TreeNode[] bookInfix2tree(String inf) throws Exception{
        String infix=inf;
        IntegerArrayStack childpos=new IntegerArrayStack(infix.length());
        IntegerArrayStack parentpos=new IntegerArrayStack(infix.length());
        char charExp[]=new char[infix.length()];
        int lpos=-1, rpos=-1, pos=0, opCount=0;
        //////////////////////////////////////////////////////////////////
        for(int i=0;i<infix.length();i++){
            charExp[i]=infix.charAt(i);
            char chr=charExp[i];
            if((chr>=65 && chr<=90)
                    || (chr>=97 && chr<=122))
                opCount++;
            if(chr=='~' || chr=='^' || chr=='*' || chr=='/'
                    || chr=='+' || chr=='-' || chr=='%')
                opCount++;
        }// opCounter.
        TreeNode myTree[]=new TreeNode[opCount];
        for(int i=0;i<infix.length();i++){
            char chr=charExp[i];
            if((chr>=65 && chr<=90)
                    || (chr>=97 && chr<=122)){
                myTree[pos]=new TreeNode(chr);
                childpos.push(pos);
                pos++;
                continue;
            }//if literal char.
            if(chr=='~'){
                myTree[pos]=new TreeNode(chr);
                parentpos.push(pos);
                pos++;
                continue;
            }// if ~
            if(chr=='^' || chr=='*' || chr=='/'
                    || chr=='+' || chr=='-' || chr=='%'){
                lpos=childpos.pop();
                myTree[pos]=new TreeNode(chr, myTree[lpos], null);
                myTree[pos].getLeft().setParent(myTree[pos]);
                parentpos.push(pos);
                pos++;
                continue;
            }// if operand.
            if(chr==')'){
                lpos=childpos.pop();
                rpos=parentpos.pop();
                myTree[rpos].setRight(myTree[lpos]);
                myTree[rpos].getRight().setParent(myTree[rpos]);
                childpos.push(rpos);
            }// if )
        }//main for.        
        TreeNode[] result=new TreeNode[myTree.length*100];
        int i=0;
        result[0]=myTree[childpos.getTop()];
        while(2*i+2<result.length){
            if(result[i]!=null){
                result[2*i+1]=result[i].getLeft();
                result[2*i+2]=result[i].getRight();
                if(result[2*i+1]!=null)
                    result[2*i+1].setParent(result[i]);
                if(result[2*i+2]!=null)
                    result[2*i+2].setParent(result[i]);
            }else{
                result[2*i+1]=null;
                result[2*i+2]=null;
            }
            i++;
        }// Switch to Array.
        return result;
    }// bookInfixToPostfix.
    private static void infix2tree(String inf) throws Exception{
        TreeNode tr[] = null;
        int clpr=0, oppr=0, opCount=0;
        if(inf.equals("")){
            JOptionPane.showMessageDialog(null, "the Mathematic " +
                "Expression is null.\ntry again.","Null Expression",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//if ""
        for(int i=0;i<inf.length();i++){
            switch(inf.charAt(i)){
                case '!':
                case '@':
                case '#':
                case '$':
                case '&':
                case '_':
                case '=':
                case '{':
                case '}':
                case '[':
                case ']':
                case '\\':
                case '|':
                case '`':
                case '.':
                case ',':
                case '<':
                case '>':
                case '?':
                case '"':
                case '\'':
                case ':':
                case ';':{
                    JOptionPane.showMessageDialog(null, "the Entrance " +
                        "Expression has NOT correct Foramt.\n" +
                         "EXPRESSION: "+inf+"\n" +
                         "Use just below Characters:\n" +
                         "~ ^ * / % + -\n" +
                            "try again.", "Incorrect Input",
                                JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                    break;
                case '^':
                case '*':
                case '/':
                case '+':
                case '-':
                case '%':
                case '~':
                    opCount++;
                    break;
                case '(':
                    oppr++;
                    break;
                case ')':
                    clpr++;
                    break;
            }//switch
            if(inf.charAt(i)>='0' && inf.charAt(i)<='9'){
                JOptionPane.showMessageDialog(null, "Do NOT use " +
                    "Numeral Character (0~9).\n" +
                    "Use Literal " +
                    "Character (a~z) or (A~Z) and try again.",
                        "Incorrect Input", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }// if numeral char.
        }// main for.
        JOptionPane.showMessageDialog(null, "Please Note that " +
        "the Entrance Mathematic Expression "+
        "has been POSED FULL PARENTHESIS,\n means " +
        "you must Use open parenthesis and close parenthesis " +
        "for each Expression and Sub Expression.\n" +
        "USE '( )' FOR EACH OPERAND ~ ^ * / % + -\n" +
        "\nfor Example use like this Format for input:\n" +
        "       ((a+(((c+b)*d)^f))-((g/(~h))-k)) \n" +
        "instead of: \n" +
        "       a+((c+b)*d)^f-(g/~h-k)\n\n" +
        "--------------------------------------------------" +
        "--------------------------------------------------" +
        "------------------------------\n" +
        "NOTE: if input Expression had WRONG FORMAT then" +
        " the INFIX TREE will NOT be true at all.( or maybe)\n" +
        "--------------------------------------------------" +
        "--------------------------------------------------" +
        "------------------------------"
            ,"PLEASE NOTE",
                JOptionPane.WARNING_MESSAGE);
        if(oppr!=clpr){
            JOptionPane.showMessageDialog(null, "The Mathematic " +
                "Expression has NOT correct Format.\n " +
                "the Computation of " +
                "Open Parenthesis does Not " +
                "equal to Close Parenthesis!!!\n" +
                "try again.",
                    "Incorrect Input",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }// if oppr!=clpr
        if(oppr!=opCount){
            int res=0;
            res=JOptionPane.showConfirmDialog(null, "The Mathematic " +
                "Expression has been NOT POSED FULL PARENTHESIS.\n " +
                "the Computation of " +
                "Parenthesis () does Not " +
                "equal to OPERANDs computation!!!\n" +
                "If you want to Continue anyway click YES or to Exit click NO..." +
                "\n\n" +
                "---------------------------------------------------------------" +
                "-----------------------------------\n" +
                "NOTE: if you want to Continue, the INFIX TREE maybe not be True!\n" +
                "---------------------------------------------------------------" +
                "-----------------------------------",
                    "Incorrect Input",
                        JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
            if(res==JOptionPane.NO_OPTION)
                System.exit(0);
            else
                tr=myInfix2tree(inf);
        }else
            tr=bookInfix2tree(inf);
        Fram f=new Fram(tr);
    }// infix to Tree.
// DO NOT CHANGE THE MAIN METHOD
    public static void main(String[] args) throws Exception{
        String[] options={"Infix to Postfix", "Postfix to Prefix", "Infix to Tree"};
	String input=showInputDialog(null, "Input the statement:","Input order",QUESTION_MESSAGE);        
	if(input==null)System.exit(0);
	String method=(String)
			showInputDialog(null,"Converting\n"+input,"Choose the method",PLAIN_MESSAGE,null,options,options[0]);
	if(method.equals(options[0]) || method.equals(options[1])){
                String output=method.equals(options[0])?infix2postfix(input):postfix2prefix(input);
                    showMessageDialog(null, input+"\n>>>>>\n"+output, method, PLAIN_MESSAGE);
        }
	if(method.equals(options[2])) infix2tree(input);
    }// main method.
}// Orders.
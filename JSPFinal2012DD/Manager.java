/**
 * This program should be completed by the students
 * @author Amanj Khorramian, Instructor at University of Kurdistan
 * @version 1.0 May, 2012
 */
import static javax.swing.JOptionPane.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Student{
    String name, family, field, ID;
    float gpa;
    int passed;

}
class Instructor{
    String name, family, field, course1, course2;
}
class Course{
    String name, field, book;
    int num, unit;
}
class University{}
public class Manager extends JFrame{
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel(new GridLayout(12, 1));
    JPanel centerPanel = new JPanel(new GridLayout(0, 8));
    JPanel bottomPanel = new JPanel();
    JMenuBar bar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenuItem itemNew = new JMenuItem("New University");
    JMenuItem itemSave = new JMenuItem("Save");
    JMenuItem itemSaveAs = new JMenuItem("Save As..");
    JMenuItem itemOpen = new JMenuItem("Open University");
    JMenuItem itemExit = new JMenuItem("Exit");
    JButton b[]=new JButton[10];
    JLabel[] label=new JLabel[8];
    JTextField[][] data=new JTextField[25][8];
    ///////////needful fields/////////////
    boolean  isEditing;
    Color color=Color.blue, defColor=Color.white, eColor=Color.yellow;
    int selectedRowsCounter=0, selectedRowIndex=-1;
    int editingRowIndex=-1;
    int inframW=300, inframH=200;
    Student stus[]=new Student[25];
    int studentCounter=-1;
    Instructor ins[]=new Instructor[25];
    int instructorCounter=-1;
    Course crs[]=new Course[25];
    int courseCounter=-1;
    int whichOne=-1;
    //-----------------------------------//
    Manager(){
        super("University Management,by 8917050141");
	setSize(800, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setJMenuBar(bar);
	bar.add(menuFile);
	menuFile.add(itemNew); menuFile.add(itemSave); menuFile.add(itemSaveAs); menuFile.add(itemOpen);
	menuFile.addSeparator(); menuFile.add(itemExit);
	itemExit.addActionListener(new AL());
	getContentPane().add(mainPanel);
	mainPanel.add(topPanel, BorderLayout.NORTH);
	mainPanel.add(leftPanel, BorderLayout.WEST);
	mainPanel.add(centerPanel, BorderLayout.CENTER);
	mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	b[0] = new JButton("Add new record");
	b[1] = new JButton("Find");
	b[2] = new JButton("Delete record");
        b[2].setEnabled(false);
	b[3] = new JButton("Edit record");
        b[3].setEnabled(false);
	b[4] = new JButton("Sort");
	b[5] = new JButton("Students");
	b[6] = new JButton("Instructors");
	b[7] = new JButton("Courses");
	b[8] = new JButton("<< Previous Page");
        b[8].setEnabled(false);
	b[9] = new JButton("Next Page >>");
        b[9].setEnabled(false);
	topPanel.setBackground(Color.gray);
	leftPanel.setBackground(Color.gray);
	bottomPanel.setBackground(Color.gray);
	topPanel.add(b[0]); topPanel.add(b[1]); topPanel.add(b[2]); topPanel.add(b[3]); topPanel.add(b[4]);
	leftPanel.add(b[5]); leftPanel.add(b[6]); leftPanel.add(b[7]);
	bottomPanel.add(b[8]); bottomPanel.add(b[9]);
        ///////////needful actions////////////
        itemNew.addActionListener(new AL());
        itemSave.addActionListener(new AL());
        b[3].addActionListener(new AL());
        mainPanel.addMouseListener(new ML());
        topPanel.addMouseListener(new ML());
        centerPanel.addMouseListener(new ML());
        bottomPanel.addMouseListener(new ML());
        leftPanel.addMouseListener(new ML());
        //-----------------------------------//
	for(int i=0; i<8; i++)	b[i].addActionListener(new AL());
            for(int i=0; i<label.length; i++) centerPanel.add(label[i]=new JLabel("",SwingConstants.CENTER));
            for(int i=0; i<data.length; i++)
                for(int j=0; j<data[0].length; j++){
                    centerPanel.add(data[i][j]=new JTextField());
                    data[i][j].addMouseListener(new ML(i, j));
                    data[i][j].setEditable(false);
                    data[i][j].setEnabled(false);
                    data[i][j].setDisabledTextColor(color.MAGENTA);
                    data[i][j].setBackground(defColor);
		}
            setVisible(true);
    }
    public static void main(String[] args) {
        new Manager();
    }
    class AddStudent extends JFrame{
        Student s=new Student();
        JLabel name=new JLabel("Name: ");
        JTextField namejtf=new JTextField();
        JLabel family=new JLabel("Family: ");
        JTextField familyjtf=new JTextField();
        JLabel ID=new JLabel("ID: ");
        JTextField idjtf=new JTextField();
        JLabel field=new JLabel("Field: ");
        JTextField fieldjtf=new JTextField();
        JLabel gpa=new JLabel("GPA: ");
        JTextField gpajtf=new JTextField();
        JLabel passed=new JLabel("Passed: ");
        JTextField passedjtf=new JTextField();
        JButton submitInfram=new JButton("Submit");
        JButton cancelInfram=new JButton("Cancel");
        Font f=new Font(Font.SANS_SERIF, Font.BOLD, 18);
        int wl=80, hl=20;
        int wt=100, ht=20;        
        AddStudent(){
            super("Adding Student");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);                        
            setLocation(inframW, inframH);
            setMinimumSize(new Dimension(500, 220));
            setLayout(null);            
            add(name); add(namejtf);
            name.setBounds(5, 5, wl, hl);
            name.setFont(f);name.setForeground(color);
            namejtf.setBounds(name.getX()+wl, name.getY(), wt, ht);
            add(family);add(familyjtf);
            family.setBounds(namejtf.getX()+wt+50,name.getY(),wl, hl);
            family.setFont(f);family.setForeground(color);
            familyjtf.setBounds(family.getX()+wl, family.getY(), wt, ht);
            add(ID); add(idjtf);
            ID.setBounds(5,name.getY()+hl+20,wl,hl);
            ID.setFont(f);ID.setForeground(color);
            idjtf.setBounds(ID.getX()+wl,namejtf.getY()+ht+20 , wt, ht);
            add(field); add(fieldjtf);
            field.setBounds(idjtf.getX()+wt+50, ID.getY(), wl, hl);
            field.setForeground(color);field.setFont(f);
            fieldjtf.setBounds(field.getX()+wl, field.getY(), wt, ht);
            add(gpa); add(gpajtf);
            gpa.setBounds(5, field.getY()+hl+20, wl, hl);
            gpa.setForeground(color); gpa.setFont(f);
            gpajtf.setBounds(gpa.getX()+wl, gpa.getY(), wt, ht);
            add(passed);add(passedjtf);
            passed.setBounds(gpajtf.getX()+wt+50,gpa.getY(),wl,hl);
            passed.setFont(f);passed.setForeground(color);
            passedjtf.setBounds(passed.getX()+wl, passed.getY(), wt, ht);
            add(submitInfram); add(cancelInfram);
            submitInfram.setBounds(gpa.getX(), gpa.getY()+hl+20, wl+20, hl+10);
            submitInfram.setForeground(color.red);submitInfram.setFont(f);
            cancelInfram.setBounds(submitInfram.getX()+submitInfram.getWidth()+10, submitInfram.getY(),
                       submitInfram.getWidth() , submitInfram.getHeight());
            cancelInfram.setForeground(color.red);cancelInfram.setFont(f);
            submitInfram.addActionListener(new inframeAL());
            cancelInfram.addActionListener(new inframeAL());            
        }
        class inframeAL extends AL{
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submitInfram)
                    if(namejtf.getText().equals("") || familyjtf.getText().equals("")
                        || idjtf.getText().equals("") || fieldjtf.getText().equals("")
                            || gpajtf.getText().equals("") || passedjtf.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill all cells", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    else{
                        s.name=namejtf.getText();
                        s.family=familyjtf.getText();
                        s.ID=idjtf.getText();
                        s.field=fieldjtf.getText();
                        s.gpa=Float.parseFloat(gpajtf.getText());
                        s.passed=Integer.parseInt(passedjtf.getText());
                        studentCounter++;
                        stus[studentCounter]=s;
                        dispose();
                        for(int i=0;i<25;i++)
                            if(stus[i]!=null){
                                data[i][0].setText(stus[i].name);
                                data[i][1].setText(stus[i].family);
                                data[i][2].setText(stus[i].ID);
                                data[i][3].setText(stus[i].field);
                                data[i][4].setText(""+stus[i].gpa);
                                data[i][5].setText(""+stus[i].passed);
                            }else break;
                    }
                if(e.getSource()==cancelInfram)
                    dispose();
            }
        }
    }
    class AddInstructor extends JFrame{
        Instructor s=new Instructor();
        JLabel name=new JLabel("Name: ");
        JTextField namejtf=new JTextField();
        JLabel family=new JLabel("Family: ");
        JTextField familyjtf=new JTextField();
        JLabel field=new JLabel("Field: ");
        JTextField fieldjtf=new JTextField();
        JLabel course1=new JLabel("Course1: ");
        JTextField course1jtf=new JTextField();
        JLabel course2=new JLabel("Course2: ");
        JTextField course2jtf=new JTextField();
        JButton submitInfram=new JButton("Submit");
        JButton cancelInfram=new JButton("Cancel");
        Font f=new Font(Font.SANS_SERIF, Font.BOLD, 18);
        int wl=100, hl=20;
        int wt=100, ht=20;
        AddInstructor(){
            super("Adding Instructor");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            setLocation(inframW, inframH);
            setMinimumSize(new Dimension(500, 220));
            setLayout(null);
            add(name); add(namejtf);
            name.setBounds(5, 5, wl, hl);
            name.setFont(f);name.setForeground(color);
            namejtf.setBounds(name.getX()+wl, name.getY(), wt, ht);
            add(family);add(familyjtf);
            family.setBounds(namejtf.getX()+wt+50,name.getY(),wl, hl);
            family.setFont(f);family.setForeground(color);
            familyjtf.setBounds(family.getX()+wl, family.getY(), wt, ht);
            add(field); add(fieldjtf);
            field.setBounds(5, name.getY()+hl+20, wl, hl);
            field.setForeground(color);field.setFont(f);
            fieldjtf.setBounds(field.getX()+wl, field.getY(), wt, ht);
            add(course1); add(course1jtf);
            course1.setBounds(5, field.getY()+hl+20, wl, hl);
            course1.setForeground(color); course1.setFont(f);
            course1jtf.setBounds(course1.getX()+wl, course1.getY(), wt, ht);
            add(course2);add(course2jtf);
            course2.setBounds(course1jtf.getX()+wt+50,course1.getY(),wl,hl);
            course2.setFont(f);course2.setForeground(color);
            course2jtf.setBounds(course2.getX()+wl, course2.getY(), wt, ht);
            add(submitInfram); add(cancelInfram);
            submitInfram.setBounds(course1.getX(), course1.getY()+hl+20, wl+20, hl+10);
            submitInfram.setForeground(color.red);submitInfram.setFont(f);
            cancelInfram.setBounds(submitInfram.getX()+submitInfram.getWidth()+10, submitInfram.getY(),
                       submitInfram.getWidth() , submitInfram.getHeight());
            cancelInfram.setForeground(color.red);cancelInfram.setFont(f);
            submitInfram.addActionListener(new inframeAL());
            cancelInfram.addActionListener(new inframeAL());
        }
        class inframeAL extends AL{
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submitInfram)
                    if(namejtf.getText().equals("") || familyjtf.getText().equals("")
                        || fieldjtf.getText().equals("")
                            || course1jtf.getText().equals("") || course2jtf.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill all cells", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    else{
                        s.name=namejtf.getText();
                        s.family=familyjtf.getText();
                        s.field=fieldjtf.getText();
                        s.course1=course1jtf.getText();
                        s.course2=course2jtf.getText();
                        instructorCounter++;
                        ins[instructorCounter]=s;
                        dispose();
                for(int i=0;i<25;i++)
                            if(ins[i]!=null){
                                data[i][0].setText(ins[i].name);
                                data[i][1].setText(ins[i].family);
                                data[i][2].setText(ins[i].field);
                                data[i][3].setText(ins[i].course1);
                                data[i][4].setText(ins[i].course2);
                            }else break;
                    }
                if(e.getSource()==cancelInfram)
                    dispose();
            }
        }
    }
    class AddCourse extends JFrame{
        Course s=new Course();
        JLabel name=new JLabel("Name: ");
        JTextField namejtf=new JTextField();
        JLabel number=new JLabel("Number: ");
        JTextField numberjtf=new JTextField();
        JLabel unit=new JLabel("Units: ");
        JTextField unitjtf=new JTextField();
        JLabel field=new JLabel("Field: ");
        JTextField fieldjtf=new JTextField();
        JLabel book=new JLabel("Book: ");
        JTextField bookjtf=new JTextField();        
        JButton submitInfram=new JButton("Submit");
        JButton cancelInfram=new JButton("Cancel");
        Font f=new Font(Font.SANS_SERIF, Font.BOLD, 18);
        int wl=100, hl=20;
        int wt=100, ht=20;        
        AddCourse(){
            super("Adding Course");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);                        
            setLocation(inframW, inframH);
            setMinimumSize(new Dimension(500, 220));
            setLayout(null);            
            add(name); add(namejtf);
            name.setBounds(5, 5, wl, hl);
            name.setFont(f);name.setForeground(color);
            namejtf.setBounds(name.getX()+wl, name.getY(), wt, ht);
            add(number);add(numberjtf);
            number.setBounds(namejtf.getX()+wt+50,name.getY(),wl, hl);
            number.setFont(f);number.setForeground(color);
            numberjtf.setBounds(number.getX()+wl, number.getY(), wt, ht);
            add(unit); add(unitjtf);
            unit.setBounds(5,name.getY()+hl+20,wl,hl);
            unit.setFont(f);unit.setForeground(color);
            unitjtf.setBounds(unit.getX()+wl,namejtf.getY()+ht+20 , wt, ht);
            add(field); add(fieldjtf);
            field.setBounds(unitjtf.getX()+wt+50, unit.getY(), wl, hl);
            field.setForeground(color);field.setFont(f);
            fieldjtf.setBounds(field.getX()+wl, field.getY(), wt, ht);
            add(book); add(bookjtf);
            book.setBounds(5, field.getY()+hl+20, wl, hl);
            book.setForeground(color); book.setFont(f);
            bookjtf.setBounds(book.getX()+wl, book.getY(), wt, ht);            
            add(submitInfram); add(cancelInfram);
            submitInfram.setBounds(book.getX(), book.getY()+hl+20, wl+20, hl+10);
            submitInfram.setForeground(color.red);submitInfram.setFont(f);
            cancelInfram.setBounds(submitInfram.getX()+submitInfram.getWidth()+10, submitInfram.getY(),
                       submitInfram.getWidth() , submitInfram.getHeight());
            cancelInfram.setForeground(color.red);cancelInfram.setFont(f);
            submitInfram.addActionListener(new inframeAL());
            cancelInfram.addActionListener(new inframeAL());            
        }
        class inframeAL extends AL{
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submitInfram)
                    if(namejtf.getText().equals("") || numberjtf.getText().equals("")
                        || unitjtf.getText().equals("") || fieldjtf.getText().equals("")
                            || bookjtf.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill all cells", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    else{
                        s.name=namejtf.getText();
                        s.num=Integer.parseInt(numberjtf.getText());
                        s.unit=Integer.parseInt(unitjtf.getText());
                        s.field=fieldjtf.getText();
                        s.book=bookjtf.getText();                        
                        courseCounter++;
                        crs[courseCounter]=s;
                        dispose();
                        for(int i=0;i<25;i++)
                            if(crs[i]!=null){
                                data[i][0].setText(crs[i].name);
                                data[i][1].setText(""+crs[i].num);
                                data[i][2].setText(""+crs[i].unit);
                                data[i][3].setText(crs[i].field);
                                data[i][4].setText(crs[i].book);
                            }else break;
                    }
                if(e.getSource()==cancelInfram)
                    dispose();
            }
        }
    }
    class AL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==itemNew){
                deselecting();
                dispose();
                new Manager();
            }            
            if(e.getSource()==itemExit)	System.exit(0);            
            if(e.getSource()==b[5]){
                deselecting();
                whichOne=5;
                b[3].setEnabled(true);
                String[] stField={"Name", "Family", "ID", "Field", "GPA", "#Passed", "",""};
                for(int i=0; i<stField.length; i++) label[i].setText(stField[i]);
                clearPage();
                for(int i=0;i<25;i++)
                    if(stus[i]!=null){
                        data[i][0].setText(stus[i].name);
                        data[i][1].setText(stus[i].family);
                        data[i][2].setText(stus[i].ID);
                        data[i][3].setText(stus[i].field);
                        data[i][4].setText(""+stus[i].gpa);
                        data[i][5].setText(""+stus[i].passed);

                    }else break;
            }
            if(e.getSource()==b[6]){
                deselecting();
                whichOne=6;
                b[3].setEnabled(true);
                String[] inField={"Name", "Family", "Field", "Course 1", "Course 2", "", "",""};
                for(int i=0; i<inField.length; i++) label[i].setText(inField[i]);
                clearPage();
                for(int i=0;i<25;i++)
                    if(ins[i]!=null){
                        data[i][0].setText(ins[i].name);
                        data[i][1].setText(ins[i].family);
                        data[i][2].setText(ins[i].field);
                        data[i][3].setText(ins[i].course1);
                        data[i][4].setText(ins[i].course2);
                    }else break;
            }
            if(e.getSource()==b[7]){
                deselecting();
                whichOne=7;
                b[3].setEnabled(true);
                String[] crsField={"Course Name", "Course No", "#Units", "Field", "Ref. Book", "", "",""};
                for(int i=0; i<crsField.length; i++) label[i].setText(crsField[i]);
                clearPage();
                for(int i=0;i<25;i++)
                    if(crs[i]!=null){
                        data[i][0].setText(crs[i].name);
                        data[i][1].setText(""+crs[i].num);
                        data[i][2].setText(""+crs[i].unit);
                        data[i][3].setText(crs[i].field);
                        data[i][4].setText(crs[i].book);
                    }else break;
            }
            if(e.getSource()==b[0]){
                deselecting();
                if(whichOne==-1)
                    JOptionPane.showMessageDialog(null, "Selecet a Button (Student or Instructor " +
                            "or Course) to adding new Record", "Select", JOptionPane.WARNING_MESSAGE);
                if(whichOne==5)
                    if(studentCounter==24)
                        JOptionPane.showMessageDialog(null, "You could Not new One", "Table is full",
                                JOptionPane.ERROR_MESSAGE);
                    else{
                        new AddStudent();                        
                    }
                if(whichOne==6)
                    if(instructorCounter==24)
                        JOptionPane.showMessageDialog(null, "You could Not new One", "Table is full",
                                JOptionPane.ERROR_MESSAGE);
                    else
                        new AddInstructor();
                if(whichOne==7)
                    if(courseCounter==24)
                        JOptionPane.showMessageDialog(null, "You could Not new One", "Table is full",
                                JOptionPane.ERROR_MESSAGE);
                    else
                        new AddCourse();
            }
            if(e.getSource()==b[1]){
                deselecting();
                if(whichOne==-1)
                    JOptionPane.showMessageDialog(null, "Selecet a Button (Students or Instructors " +
                            "or Courses) to Finding", "Find", JOptionPane.WARNING_MESSAGE);
                if(whichOne==5){
                    String opt[]=new String[]{"Name","Family","ID","Field","GPA","#Passed"};
                    int showCounter=0;
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to find", "Find", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                            null, opt, JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        String inputName=JOptionPane.showInputDialog(null, "Enter the name: ",
                                "Name of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputName.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(inputName.equals(stus[i].name)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==1){
                        String inputFamily=JOptionPane.showInputDialog(null, "Enter the family: ",
                                "Family of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputFamily.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(inputFamily.equals(stus[i].family)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==2){
                        String inputID=JOptionPane.showInputDialog(null, "Enter the ID: ",
                                "ID of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputID.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(inputID.equals(stus[i].ID)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==3){
                        String inputField=JOptionPane.showInputDialog(null, "Enter the Field: ",
                                "Field of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputField.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(inputField.equals(stus[i].field)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==4){
                        String inputGPA=JOptionPane.showInputDialog(null, "Enter the GPA: ",
                                "GPA of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputGPA.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(stus[i].gpa==Float.parseFloat(inputGPA)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==5){
                        String inputPassed=JOptionPane.showInputDialog(null, "Enter the passed: ",
                                "Family of Student", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputPassed.equals("")){
                            clearPage();
                            for(int i=0;i<=studentCounter;i++)
                                if(stus[i].passed==Integer.parseInt(inputPassed)){
                                    data[showCounter][0].setText(stus[i].name);
                                    data[showCounter][1].setText(stus[i].family);
                                    data[showCounter][2].setText(stus[i].ID);
                                    data[showCounter][3].setText(stus[i].field);
                                    data[showCounter][4].setText(""+stus[i].gpa);
                                    data[showCounter][5].setText(""+stus[i].passed);
                                    showCounter++;
                                }
                        }
                    }
                }// student
                if(whichOne==6){
                    String opt[]=new String[]{"Name","Family","Field","Course 1","Course 2"};
                    int showCounter=0;
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to find", "Find", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                            null, opt, JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        String inputName=JOptionPane.showInputDialog(null, "Enter the name: ",
                                "Name of Insructor", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputName.equals("")){
                            clearPage();
                            for(int i=0;i<=instructorCounter;i++)
                                if(inputName.equals(ins[i].name)){
                                    data[showCounter][0].setText(ins[i].name);
                                    data[showCounter][1].setText(ins[i].family);
                                    data[showCounter][2].setText(ins[i].field);
                                    data[showCounter][3].setText(ins[i].course1);
                                    data[showCounter][4].setText(ins[i].course2);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==1){
                        String inputFamily=JOptionPane.showInputDialog(null, "Enter the family: ",
                                "Family of Instructor", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputFamily.equals("")){
                            clearPage();
                            for(int i=0;i<=instructorCounter;i++)
                                if(inputFamily.equals(ins[i].family)){
                                    data[showCounter][0].setText(ins[i].name);
                                    data[showCounter][1].setText(ins[i].family);
                                    data[showCounter][2].setText(ins[i].field);
                                    data[showCounter][3].setText(ins[i].course1);
                                    data[showCounter][4].setText(ins[i].course2);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==2){
                        String inputField=JOptionPane.showInputDialog(null, "Enter the Field: ",
                                "Field of Instructor", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputField.equals("")){
                            clearPage();
                            for(int i=0;i<=instructorCounter;i++)
                                if(inputField.equals(ins[i].field)){
                                    data[showCounter][0].setText(ins[i].name);
                                    data[showCounter][1].setText(ins[i].family);
                                    data[showCounter][2].setText(ins[i].field);
                                    data[showCounter][3].setText(ins[i].course1);
                                    data[showCounter][4].setText(ins[i].course2);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==3){
                        String inputCourse1=JOptionPane.showInputDialog(null, "Enter the Course 1: ",
                                "Course 1 of Instructor", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputCourse1.equals("")){
                            clearPage();
                            for(int i=0;i<=instructorCounter;i++)
                                if(inputCourse1.equals(ins[i].course1)){
                                     data[showCounter][0].setText(ins[i].name);
                                    data[showCounter][1].setText(ins[i].family);
                                    data[showCounter][2].setText(ins[i].field);
                                    data[showCounter][3].setText(ins[i].course1);
                                    data[showCounter][4].setText(ins[i].course2);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==4){
                        String inputCourse2=JOptionPane.showInputDialog(null, "Enter the Course 2: ",
                                "Course 2 of Instructor", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputCourse2.equals("")){
                            clearPage();
                            for(int i=0;i<=instructorCounter;i++)
                                if(stus[i].gpa==Float.parseFloat(inputCourse2)){
                                    data[showCounter][0].setText(ins[i].name);
                                    data[showCounter][1].setText(ins[i].family);
                                    data[showCounter][2].setText(ins[i].field);
                                    data[showCounter][3].setText(ins[i].course1);
                                    data[showCounter][4].setText(ins[i].course2);
                                    showCounter++;
                                }
                        }
                    }
                }// instructor
                if(whichOne==7){
                    String opt[]=new String[]{"Name","Number","Unit","Field","Book"};
                    int showCounter=0;
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to find ? ",
                            "Find", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opt,JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        String inputName=JOptionPane.showInputDialog(null, "Enter the name: ",
                                "Name of Course", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputName.equals("")){
                            clearPage();
                            for(int i=0;i<=courseCounter;i++)
                                if(inputName.equals(crs[i].name)){
                                    data[showCounter][0].setText(crs[i].name);
                                    data[showCounter][1].setText(""+crs[i].num);
                                    data[showCounter][2].setText(""+crs[i].unit);
                                    data[showCounter][3].setText(crs[i].field);
                                    data[showCounter][4].setText(crs[i].book);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==1){
                        String inputNum=JOptionPane.showInputDialog(null, "Enter the number of course: ",
                                "Number of course", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputNum.equals("")){
                            clearPage();
                            for(int i=0;i<=courseCounter;i++)
                                if(crs[i].num==Integer.parseInt(inputNum)){
                                    data[showCounter][0].setText(crs[i].name);
                                    data[showCounter][1].setText(""+crs[i].num);
                                    data[showCounter][2].setText(""+crs[i].unit);
                                    data[showCounter][3].setText(crs[i].field);
                                    data[showCounter][4].setText(crs[i].book);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==2){
                        String inputUnit=JOptionPane.showInputDialog(null, "Enter the Unit: ",
                                "Unit of course", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputUnit.equals("")){
                            clearPage();
                            for(int i=0;i<=courseCounter;i++)
                                if(crs[i].unit==Integer.parseInt(inputUnit)){
                                    data[showCounter][0].setText(crs[i].name);
                                    data[showCounter][1].setText(""+crs[i].num);
                                    data[showCounter][2].setText(""+crs[i].unit);
                                    data[showCounter][3].setText(crs[i].field);
                                    data[showCounter][4].setText(crs[i].book);                                    
                                    showCounter++;
                                }
                        }
                    }
                    if(res==3){
                        String inputField=JOptionPane.showInputDialog(null, "Enter the field: ",
                                "Field of Course", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputField.equals("")){
                            clearPage();
                            for(int i=0;i<=courseCounter;i++)
                                if(inputField.equals(crs[i].field)){
                                    data[showCounter][0].setText(crs[i].name);
                                    data[showCounter][1].setText(""+crs[i].num);
                                    data[showCounter][2].setText(""+crs[i].unit);
                                    data[showCounter][3].setText(crs[i].field);
                                    data[showCounter][4].setText(crs[i].book);
                                    showCounter++;
                                }
                        }
                    }
                    if(res==4){
                        String inputBook=JOptionPane.showInputDialog(null, "Enter the Book: ",
                                "Book  of Course", JOptionPane.INFORMATION_MESSAGE);
                        if(!inputBook.equals("")){
                            clearPage();
                             for(int i=0;i<=courseCounter;i++)
                                if(inputBook.equals(crs[i].book)){
                                    data[showCounter][0].setText(crs[i].name);
                                    data[showCounter][1].setText(""+crs[i].num);
                                    data[showCounter][2].setText(""+crs[i].unit);
                                    data[showCounter][3].setText(crs[i].field);
                                    data[showCounter][4].setText(crs[i].book);
                                    showCounter++;
                                }
                        }
                    } 
                }// course
            }// if(b[1])
            if(e.getSource()==b[4]){
                deselecting();
                if(whichOne==-1)
                    JOptionPane.showMessageDialog(null, "Selecet a Button (Students or Instructors " +
                            "or Courses) to Sorting", "Sort", JOptionPane.WARNING_MESSAGE);
                if(whichOne==5){
                    String opt[]=new String[]{"Name","Family","ID","Field","GPA","#Passed"};
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to Sort", "Sort", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                            null, opt, JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        for(int i=0;i<=studentCounter;i++){
                            String name1=stus[i].name;
                            for(int j=i+1;j<=studentCounter;j++){
                                String name2=stus[j].name;
                                int comResult=compareStrings(name1, name2);
                                if(comResult==-1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if Name
                    if(res==1){
                        for(int i=0;i<=studentCounter;i++){
                            String family1=stus[i].family;
                            for(int j=i+1;j<=studentCounter;j++){
                                String family2=stus[j].family;
                                int comResult=compareStrings(family1, family2);
                                if(comResult==-1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if family
                    if(res==2){
                        for(int i=0;i<=studentCounter;i++){
                            String id1=stus[i].ID;
                            for(int j=i+1;j<=studentCounter;j++){
                                String id2=stus[j].ID;
                                int comResult=compareStrings(id1, id2);
                                if(comResult==-1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if ID
                    if(res==3){
                        for(int i=0;i<=studentCounter;i++){
                            String field1=stus[i].field;
                            for(int j=i+1;j<=studentCounter;j++){
                                String field2=stus[j].field;
                                int comResult=compareStrings(field1, field2);
                                if(comResult==-1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if field
                    if(res==4){
                        for(int i=0;i<=studentCounter;i++){
                            float gpa1=stus[i].gpa;
                            for(int j=i+1;j<=studentCounter;j++){
                                float gpa2=stus[j].gpa;
                                if(gpa2<gpa1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if gpa
                    if(res==5){
                        for(int i=0;i<=studentCounter;i++){
                            int passed1=stus[i].passed;
                            for(int j=i+1;j<=studentCounter;j++){
                                int passed2=stus[j].passed;
                                if(passed2<passed1){
                                    Student tmp=stus[i];
                                    stus[i]=stus[j];
                                    stus[j]=tmp;
                                }
                            }
                        }
                    }// if passed
                    for(int i=0;i<25;i++)
                            if(stus[i]!=null){
                                data[i][0].setText(stus[i].name);
                                data[i][1].setText(stus[i].family);
                                data[i][2].setText(stus[i].ID);
                                data[i][3].setText(stus[i].field);
                                data[i][4].setText(""+stus[i].gpa);
                                data[i][5].setText(""+stus[i].passed);
                            }else break;
                }// if student
                if(whichOne==6){
                    String opt[]=new String[]{"Name","Family","Field","Course1","Course2"};
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to Sort", "Sort",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opt, JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        for(int i=0;i<=instructorCounter;i++){
                            String name1=ins[i].name;
                            for(int j=i+1;j<=instructorCounter;j++){
                                String name2=ins[j].name;
                                int comResult=compareStrings(name1, name2);
                                if(comResult==-1){
                                    Instructor tmp=ins[i];
                                    ins[i]=ins[j];
                                    ins[j]=tmp;
                                }
                            }
                        }
                    }// if Name
                    if(res==1){
                        for(int i=0;i<=instructorCounter;i++){
                            String family1=ins[i].family;
                            for(int j=i+1;j<=instructorCounter;j++){
                                String family2=ins[j].family;
                                int comResult=compareStrings(family1 , family2);
                                if(comResult==-1){
                                    Instructor tmp=ins[i];
                                    ins[i]=ins[j];
                                    ins[j]=tmp;
                                }
                            }
                        }
                    }// if family
                    if(res==2){
                        for(int i=0;i<=instructorCounter;i++){
                            String field1=ins[i].field;
                            for(int j=i+1;j<=instructorCounter;j++){
                                String field2=ins[j].field;
                                int comResult=compareStrings(field1 , field2);
                                if(comResult==-1){
                                    Instructor tmp=ins[i];
                                    ins[i]=ins[j];
                                    ins[j]=tmp;
                                }
                            }
                        }
                    }// if field
                    if(res==3){
                        for(int i=0;i<=instructorCounter;i++){
                            String course1=ins[i].course1;
                            for(int j=i+1;j<=instructorCounter;j++){
                                String course11=ins[j].course1;
                                int comResult=compareStrings(course1 , course11);
                                if(comResult==-1){
                                    Instructor tmp=ins[i];
                                    ins[i]=ins[j];
                                    ins[j]=tmp;
                                }
                            }
                        }
                    }// if course1
                    if(res==4){
                        for(int i=0;i<=instructorCounter;i++){
                            String course1=ins[i].course2;
                            for(int j=i+1;j<=instructorCounter;j++){
                                String course11=ins[j].course2;
                                int comResult=compareStrings(course1 , course11);
                                if(comResult==-1){
                                    Instructor tmp=ins[i];
                                    ins[i]=ins[j];
                                    ins[j]=tmp;
                                }
                            }
                        }
                    }// if course2
                    for(int i=0;i<25;i++)
                            if(ins[i]!=null){
                                data[i][0].setText(ins[i].name);
                                data[i][1].setText(ins[i].family);
                                data[i][2].setText(ins[i].field);
                                data[i][3].setText(ins[i].course1);
                                data[i][4].setText(ins[i].course2);
                            }else break;
                }// if instructor
                if(whichOne==7){
                    String opt[]=new String[]{"Name","Number","Unit","Field","Book"};
                    int res=JOptionPane.showOptionDialog(null, "Which one do you want to Sort", "Sort",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opt, JOptionPane.UNINITIALIZED_VALUE);
                    if(res==0){
                        for(int i=0;i<=courseCounter;i++){
                            String name1=crs[i].name;
                            for(int j=i+1;j<=courseCounter;j++){
                                String name2=crs[j].name;
                                int comResult=compareStrings(name1, name2);
                                if(comResult==-1){
                                    Course tmp=crs[i];
                                    crs[i]=crs[j];
                                    crs[j]=tmp;
                                }
                            }
                        }
                    }// if Name
                    if(res==1){
                        for(int i=0;i<=courseCounter;i++){
                            int num1=crs[i].num;
                            for(int j=i+1;j<=courseCounter;j++){
                                int num2=crs[j].num;
                                if(num1>num2){
                                    Course tmp=crs[i];
                                    crs[i]=crs[j];
                                    crs[j]=tmp;
                                }
                            }
                        }
                    }// if number
                    if(res==2){
                        for(int i=0;i<=courseCounter;i++){
                            int u1=crs[i].unit;
                            for(int j=i+1;j<=courseCounter;j++){
                                int u2=crs[j].unit;
                                if(u1>u2){
                                    Course tmp=crs[i];
                                    crs[i]=crs[j];
                                    crs[j]=tmp;
                                }
                            }
                        }
                    }// if unit
                    if(res==3){
                        for(int i=0;i<=courseCounter;i++){
                            String f1=crs[i].field;
                            for(int j=i+1;j<=courseCounter;j++){
                                String f2=crs[j].field;
                                int comResult=compareStrings(f1, f2);
                                if(comResult==-1){
                                    Course tmp=crs[i];
                                    crs[i]=crs[j];
                                    crs[j]=tmp;
                                }
                            }
                        }
                    }// if field
                    if(res==3){
                        for(int i=0;i<=courseCounter;i++){
                            String b1=crs[i].book;
                            for(int j=i+1;j<=courseCounter;j++){
                                String b2=crs[j].book;
                                int comResult=compareStrings(b1, b2);
                                if(comResult==-1){
                                    Course tmp=crs[i];
                                    crs[i]=crs[j];
                                    crs[j]=tmp;
                                }
                            }
                        }
                    }// if Book
                    for(int i=0;i<25;i++)
                            if(crs[i]!=null){
                                data[i][0].setText(crs[i].name);
                                data[i][1].setText(""+crs[i].num);
                                data[i][2].setText(""+crs[i].unit);
                                data[i][3].setText(crs[i].field);
                                data[i][4].setText(crs[i].book);
                            }else break;
                }
            }// if b[4]
            if(e.getSource()==b[3] && whichOne!=-1){
                if(selectedRowsCounter==1){
                    if(whichOne==5 && stus[selectedRowIndex]!=null)
                        editing(selectedRowIndex);
                    else if(whichOne==6 && ins[selectedRowIndex]!=null)
                        editing(selectedRowIndex);
                    else if(whichOne==7 && crs[selectedRowIndex]!=null)
                        editing(selectedRowIndex);                   
                    b[2].setEnabled(false);
                }
            }
        }// actionPerformed
    }
    class ML implements MouseListener {
        int satr, sotoon;
        public ML() {
        }
        public ML(int i,int j){
            satr=i; sotoon=j;
        }
        public void mouseClicked(MouseEvent e) {
            Object source=e.getSource();           
            if(source==data[satr][sotoon] && whichOne!=-1){
                deselecting();                              
                selectedRowsCounter=1;
                selectedRowIndex=satr;
                if(selectedRowIndex!=editingRowIndex){
                    selectRow(satr);
                    if(isEditing){                        
                        int sure=JOptionPane.showConfirmDialog(null, "are you sure to submit changes?",
                                "Edited", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(sure==JOptionPane.YES_OPTION)
                            if(whichOne==5){
                                stus[editingRowIndex].name=data[editingRowIndex][0].getText();
                                stus[editingRowIndex].family=data[editingRowIndex][1].getText();
                                stus[editingRowIndex].ID=data[editingRowIndex][2].getText();
                                stus[editingRowIndex].field=data[editingRowIndex][3].getText();
                                stus[editingRowIndex].gpa=Float.parseFloat(data[editingRowIndex][4].getText());
                                stus[editingRowIndex].passed=Integer.parseInt(data[editingRowIndex][5].getText());
                            }else if(whichOne==6){
                                ins[editingRowIndex].name=data[editingRowIndex][0].getText();
                                ins[editingRowIndex].family=data[editingRowIndex][1].getText();
                                ins[editingRowIndex].field=data[editingRowIndex][2].getText();
                                ins[editingRowIndex].course1=data[editingRowIndex][3].getText();
                                ins[editingRowIndex].course2=data[editingRowIndex][4].getText();
                            }else if(whichOne==7){
                                crs[editingRowIndex].name=data[editingRowIndex][0].getText();
                                crs[editingRowIndex].num=Integer.parseInt(data[editingRowIndex][0].getText());
                                crs[editingRowIndex].unit=Integer.parseInt(data[editingRowIndex][0].getText());
                                crs[editingRowIndex].field=data[editingRowIndex][0].getText();
                                crs[editingRowIndex].book=data[editingRowIndex][0].getText();

                            }
                        unEdit();
                    }
                    b[2].setEnabled(true);
                }
            }
            if(source==topPanel || source==centerPanel
                    || source==bottomPanel || source==leftPanel)
                deselecting();
        }
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
    }
    class FL implements FocusListener {
        public void focusGained(FocusEvent e) {}
	public void focusLost(FocusEvent e) {}
    }
    class KL implements KeyListener {
        public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
    }
    class MML implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
    }
    void selectRow(int row){
        for(int j=0;j<data[row].length;j++){
            data[row][j].setBackground(color);
            data[row][j].setDisabledTextColor(color.yellow);
        }
    }
    void deselecting(){
        selectedRowsCounter=0;
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data[0].length;j++)
                if(data[i][j].getBackground()==color){
                    data[i][j].setBackground(defColor);
                    data[i][j].setDisabledTextColor(color.magenta);
                }
    }
    void editing(int row){
        isEditing=true;
        for(int i=0;i<data[row].length;i++){
            data[row][i].setBackground(color.yellow);
            data[row][i].setEditable(true);
            data[row][i].setEnabled(true);
            data[row][0].grabFocus();
        }
        editingRowIndex=row;
    }
    void unEdit(){
        isEditing=false;
        for(int i=0;i<data[editingRowIndex].length;i++){
            data[editingRowIndex][i].setBackground(defColor);
            data[editingRowIndex][i].setDisabledTextColor(color.magenta);
            data[editingRowIndex][i].setEditable(false);
            data[editingRowIndex][i].setEnabled(false);
        }
        editingRowIndex=-1;
    }
    void clearPage(){
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data[i].length;j++)
                data[i][j].setText("");
    }
    int compareStrings(String s1, String s2){
        int res=0;
        int len1=s1.length(); int len2=s2.length();
        if(len1<len2)
            res=1;
        else if(len2<len1)
            res=-1;
        else{
            for(int i=0;i<len1;i++){
                int chr1=s1.charAt(i);
                int chr2=s2.charAt(i);
                if(chr1<chr2){
                    res=1;
                    break;
                }else if(chr2<chr1){
                    res=-1;
                    break;
                }
            }
        }
        return res;
    }
}
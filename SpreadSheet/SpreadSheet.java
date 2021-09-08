import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/* karhaye ezafei ke injaneb barruye proje anjam dadam, be sharhe zir ast:
 * 1- khane ha ba yek Click entekhab mishawand.
 * 2- khane ha ba double Click gabele Edit mishwand wa menuye Edit Fa'al mishawad.
 * 3- agar 3 bar Click shawad barruye khanei, angah matne dakhele an Entekhab mishawa.
 * 4- RIGHT CLICK baraye khaneha, Fa'al mibashad.
 * 5- be menuye Edit gozineye Select all Ezafe shode ast.
 * 6- ba zadane klide CTRL+A tamaiye khaneha entekhab mishawand.
 * 7- ba zadane klide ESC tamamiye khane ha az halate entekhab, kharej mishawand.
 * 8- gablaz NEW, OPEN waya EXIT, az karbar So'al mishawad ke bar name SAVE konad.
 * 9- agar GUSHEYE PAEIN SAMTE RAST, entekhab shawad, COPY emkan pazir ast.
 * 10- tamame khane ha, daraye ToolTip mibashand.
 * 11- KELID HAYE JAHATI, bar ruye khane ha, Fa'al shode ast.
 * 12- TitleBar panjere daraye NameCounter mibashad.
 * 13- wa ...
 */
public class SpreadSheet extends JFrame {
    /*sakhtane yek MenuBar*/
    JMenuBar jmb = new JMenuBar();
    /* Sakhtane Menoye File*/
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiNew = new JMenuItem("New                     Ctrl+N");
    JMenuItem jmiOpen = new JMenuItem("Open                   Ctrl+O");
    JMenuItem jmiSave = new JMenuItem("Save                    Ctrl+S");
    JMenuItem jmiSaveAs = new JMenuItem("Save As...           Ctrl+Shift+S");
    JMenuItem jmiExit = new JMenuItem("Exit                      Alt+F4");
    /*Sakhtane menoye Edit*/
    JMenu jmEdit = new JMenu("Edit");
    JMenuItem jmiCut = new JMenuItem("Cut              Ctrl+X");
    JMenuItem jmiCopy = new JMenuItem("Copy           Ctrl+C");
    JMenuItem jmiPaste = new JMenuItem("Paste         Ctrl+V");
    JMenuItem jmiSelAll = new JMenuItem("Select All         Ctrl+A");
    /*Sakhtane menoye Function*/
    JMenu jmFunction = new JMenu("Function");
    JMenuItem jmiMax = new JMenuItem("Maximum        Ctrl+1");
    JMenuItem jmiMin = new JMenuItem("Minimum         Ctrl+2");
    JMenuItem jmiSum = new JMenuItem("Sum                  Ctrl+3");
    JMenuItem jmiAve = new JMenuItem("Average           Ctrl+4");
    JMenuItem jmiCount = new JMenuItem("Count               Ctrl+5");
    /*sakhtane meno Baraye Klike Raste Maws*/
    JPopupMenu jpm=new JPopupMenu();
    JMenuItem jpmiCut = new JMenuItem("Cut                   Ctrl+X");
    JMenuItem jpmiCopy = new JMenuItem("Copy                Ctrl+C");
    JMenuItem jpmiPaste = new JMenuItem("Paste              Ctrl+V");
    /* sakhte Panel barname Hamrah ba Scroll Bar ha*/
    JPanel jp = new JPanel(new GridLayout(30,26));
    JScrollPane scp= new JScrollPane(jp);
    /* sakhte selulhaye Excel*/
    JTextField[][] jtf = new JTextField[30][26];
    /* sakhte motageyer haye static mohem*/
    static boolean isEditing; //baraye zamani ke khanei fa'al ast.
    static boolean isDraging; // baraye zamani ke khanei drag mishawad.
    static boolean isSelected; // baraye zamani ke khanei entekhab shod.
    static boolean isCopying; // baraye zamani ke copy otomatic surat migirad.
    static boolean isAutoCopying;// baraye zamani ke copy pishrafte surat migirad.
    static boolean isRightClick;// baraye zamani ke rast klik mishawad.
    static boolean saved=true;// baraye zamani ke barname zakhire mishawad.
    static boolean isOpenable=true;// baraye zamani ke fili gable baz kardan bashad.
    static String fileName="DefaultName";// baray esme file zakhire shode karbord darad.
    static String realFileName;// name file baz shode inja garar migirad.
    static String text;// mane dakhele khane hara dar khod garar midahad.
    static int namC=1;// shomarande tedad panjerehaye new shode ast.
    static int savingCounter=0;// dafa'ate zakhire sazi ra bar migardanad.
    static int textIndex;// andise khanehara dar khod darad.
    static int txp1,txp2; // neshanegozari khaneye entekhab shode baraye Focusing.
    static int mlpp1, mlpp2; // neshane baraye zamani ke draging surat migirad.
    static int tmpx, tmpy; // neshane baraye zamni ke copy otomatik surat migirad.
    static int cellSelCounter=0; // megdari kemelan nadorost az khanehaye entekhabi ra bar migardanad.
    int txtCreasing=0;
    static double dfc;// ekhtelafe beyne chand khaneye motawaliye entekhab shode ra bar migardanad.
    double []allNum=new double[780];// adade tabdil shode, dar in Araye garar migirand.
    String []allText=new String[30];
    int txtIndex;
    int index;// baraye jesteju dar arayeye adad , bekar mirawad.
    double ave;// megdae miyangin dar an garar migirad.
    int selectedCellCounter=0;// tedade khanehaye entekhabi ra dar khod darad.
    int emptyCellCounter;// tedade khanehaye khali ra dar khod darad.
    int charCounter;// tedade horuf ra dar khod darad.
    int sCellCharCounter;// tedade horufe khanehaye ntekhab shode ast.
    int askingResult;// natige OptionPan hara dar khod negah midarad.
    /*sazandeye barname*/
    SpreadSheet() {
        /* Taene Onwane Windowz wa andazeye an*/
        super("My Basic SpreadSheet "+namC+", Spring 2011, University of Kurdistan-MOHSENmirzay");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*ezafe kardane menu wa item haye an*/
        setJMenuBar(jmb);
        jmb.add(jmFile); jmb.add(jmEdit); jmb.add(jmFunction);
        jmFile.add(jmiNew); jmFile.add(jmiOpen); jmFile.add(jmiSave); jmFile.add(jmiSaveAs); jmFile.add(jmiExit);
        jmEdit.add(jmiCut); jmEdit.add(jmiCopy); jmEdit.add(jmiPaste); jmEdit.addSeparator(); jmEdit.add(jmiSelAll);
        jmFunction.add(jmiMax); jmFunction.add(jmiMin); jmFunction.add(jmiSum); jmFunction.add(jmiAve); jmFunction.add(jmiCount);
        /*ezafe kardane khate zirin baraye menu ha wa item ha*/
        jmFile.setMnemonic('F'); jmEdit.setMnemonic('E'); jmFunction.setMnemonic('u'); jmiSelAll.setMnemonic('l');
        jmiNew.setMnemonic('N'); jmiOpen.setMnemonic('O'); jmiSave.setMnemonic('S'); jmiSaveAs.setMnemonic('A'); jmiExit.setMnemonic('E');
        jmiMax.setMnemonic('M'); jmiMin.setMnemonic('i'); jmiSum.setMnemonic('S'); jmiAve.setMnemonic('A'); jmiCount.setMnemonic('C');
        /*ezafe kardane Item Popupmenu baraye klike RAST*/
        jpm.add(jpmiCut);
        jpm.add(jpmiCopy);
        jpm.add(jpmiPaste);
        /*ezafe kardane Listener be meno ha jahat fa'al sazi events*/
        jmiNew.addActionListener(new AL(1));
        jmiOpen.addActionListener(new AL(2));
        jmiSave.addActionListener(new AL(3));
        jmiSaveAs.addActionListener(new AL(4));
        jmiExit.addActionListener(new AL(5));
        jmiCut.addActionListener(new AL(6));
        jmiCopy.addActionListener(new AL(7));
        jmiPaste.addActionListener(new AL(8));
        jmiSelAll.addActionListener(new AL(14));
        jpmiCut.addActionListener(new AL(6));
        jpmiCopy.addActionListener(new AL(7));
        jpmiPaste.addActionListener(new AL(8));
        jmiMax.addActionListener(new AL(9));
        jmiMin.addActionListener(new AL(10));
        jmiSum.addActionListener(new AL(11));
        jmiAve.addActionListener(new AL(12));
        jmiCount.addActionListener(new AL(13));
        jmFile.addMouseListener(new ML());
        jmFile.addFocusListener(new FL());
        jmFile.addKeyListener(new KL());
        jmEdit.addMouseListener(new ML());
        jmEdit.addFocusListener(new FL());
        jmEdit.addKeyListener(new KL());
        jmFunction.addMouseListener(new ML());
        jmFunction.addFocusListener(new FL());
        jmFunction.addKeyListener(new KL());
        /* ezafe kardane khanehaye Excel be Panel barname*/
        for(int i=0; i<30; i++)
            for(int j=0; j<26; j++){
                jtf[i][j]=new JTextField();
                jtf[i][j].setEnabled(false);
                jtf[i][j].addMouseListener(new ML(i,j));
                jtf[i][j].addFocusListener(new FL(i,j));
                jtf[i][j].addKeyListener(new KL(i, j));
                jtf[i][j].addMouseMotionListener(new MML(i,j));
                jtf[i][j].setToolTipText("cell["+i+"]"+"["+j+"]");
                jtf[i][j].setDisabledTextColor(Color.red);
                jtf[i][j].add(jpm);
                jp.add(jtf[i][j]);
            }
        /* Fa'al sazi Windowse marbut be barname*/
        addKeyListener(new KL());
        jp.addKeyListener(new KL());
        getContentPane().add(scp);
        setVisible(true);
    }/* payane sazandeye barname*/
    /*piyade sazi kelase Action Listener*/
    class AL implements ActionListener {
        private int sel=0;
        DoActions o=new DoActions();// objecti az kelase DoACtion sakhte mishawad.
        /*sazandeye kelas baes mishawad motageyere sel, megdar dehi shawad*/
        AL(int ref){
            sel=ref;
        }// payane sazandeye kelase AL.
        /* ba entekhabe har Object daraye Listener in method ejra mishawad*/
        public void actionPerformed(ActionEvent ae) {
            /* dar in switch Objecti ke method ra farakhani karde ast, shenasaei mishavad*/
            switch (sel){
                case 1:// in case marbut be menuye NEW mibashad.
                    if(saved){
                        askingResult=JOptionPane.showConfirmDialog(null, "You Have Saved Your Data Befor."+
                                "\n"+"Are you sure to Have New One?", "New",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(askingResult==JOptionPane.YES_OPTION){
                            dispose();// ba estefade az in dastur, panjereye jari baste mishawad.
                            namC++;// tedade panjere haye jadid ezafe mishawad.
                            new SpreadSheet();// panjereye jadid sakhte mishawad.
                            setSaved();
                            savingCounter=0;
                        }
                    }// payane if(saved).
                    else{// agar barname az gabl, zakhire nashode bashad, dasturate zir ejra mishawad.
                        askingResult=JOptionPane.showConfirmDialog(null, "You Have Not Saved Your Data Befor."+
                                "\n"+"Do you Want to Save Your Data?", "Save",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(askingResult==JOptionPane.YES_OPTION){
                            new AL(3).actionPerformed(null);// agar yes entekhab shawd, bayad zakhire gardad.
                            dispose();
                            namC++;
                            new SpreadSheet();
                            setSaved();
                            savingCounter=0;
                        }
                        else if(askingResult==JOptionPane.NO_OPTION){
                            dispose();
                            namC++;
                            new SpreadSheet();
                            setSaved();
                            savingCounter=0;
                        }
                    }// payane else(saved).
                    break;// payane case NEW.
                case 2:// in case marbut be Menuye OPEN ast.
                    isOpenable=true;
                    if(saved){// waziyate zakhireiye barname , barresi mishawad.
                        try {

                            o.open();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null,
                                "InCorrect FileName!!!"+"\n"+"try again.",
                                "Error" ,JOptionPane.WARNING_MESSAGE);
                            isOpenable=false;
                        }
                    }// payane if(saved).
                    else{
                        askingResult=JOptionPane.showConfirmDialog(null, "You Have Not Saved Your Data Befor."+
                                "\n"+"Do you Want to Save Your Data?", "Save",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(askingResult==JOptionPane.YES_OPTION){
                            try {
                                new AL(3).actionPerformed(null);// barname zakhire mishawad.
                                o.open();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null,
                                    "InCorrect FileName!!!"+"\n"+"try again.",
                                    "Error" ,JOptionPane.WARNING_MESSAGE);
                                isOpenable=false;
                            }
                        }
                        else if(askingResult==JOptionPane.NO_OPTION){
                            try {
                                o.open();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null,
                                    "InCorrect FileName!!!"+"\n"+"try again.",
                                    "Error" ,JOptionPane.WARNING_MESSAGE);
                                isOpenable=false;
                            }
                        }
                    }// payane else(saved).
                    break;// payane case OPEN.
                case 3:// in case marbut be SAVE ast.
                    if(savingCounter<=1){// bayad tedade dafa'ate zakhire saziye barname barresi shawd-
                        try {            //-bein surat ke agar barname az gabl zakhire shode bashad-
                            o.savingAs();//-digar lazem nis ba esme jadid zakhire shawad wa bayad-
                        } catch (IOException ex) {//- dar makane gabl, save shawad.
                            Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        try {
                            o.justSave();
                        } catch (IOException ex) {
                            Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;// payane case SAVE.
                case 4:// case Marbut be SAVEas.
                    try {
                        o.savingAs();
                    } catch (IOException ex) {
                        Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;// payane case SAVE AS.
                case 5:// case marbut be EXIT.
                    if(saved){// agar barname zakhire nashode bashad, behtar ast, zakhire shawad.
                        System.exit(0);
                    }
                    else{
                        askingResult=JOptionPane.showConfirmDialog(null, "You Have Not Saved Your Data Befor."+
                                "\n"+"Do you Want to Save Your Data?", "Save",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(askingResult==JOptionPane.YES_OPTION){
                            new AL(3).actionPerformed(null);
                            System.exit(0);
                        }
                        else if(askingResult==JOptionPane.NO_OPTION){
                            System.exit(0);
                        }
                    }
                    break;// payane case EXIT.
                case 6:// case 6 wa 7 wa 8, marbut be menoye EDIT ast.
                    if(isEditing)             // dar Surati ke range khane zard bashad-
                        jtf[txp1][txp2].cut();// -matne entekhab shode, be ClipBoard, Cut mishawad
                    break;
                case 7:
                    if(isEditing)              // dar Surati ke range khane zard bashad-
                        jtf[txp1][txp2].copy();// -matne entekhab shode, be ClipBoard, Copy mishawad
                    break;
                case 8:
                    if(isEditing){               // dar Surati ke range khane zard bashad-
                        jtf[txp1][txp2].paste();// -matn az ClipBoard, Paste mishawad
                        if(jtf[txp1][txp2].getBackground()==Color.yellow){ // -darSurate Fa'al Budan-
                            jtf[txp1][txp2].setEnabled(true);              // -angah akharin khane fa'al shode-
                            jtf[txp1][txp2].grabFocus();                   // -nabayad gere fa'al gardad.
                            setNotSaved();
                        }
                    }
                    break;
                case 9:// case 9 , 10 , 11 , 12 wa 13, marbut be menuye FUNCTION ast.
                    if(isSelected){// note: in case ha fagat barruye khanehaye Entkhab shode, emal mishawand.
                        o.convertToDigit();// note: khane ha, ebteda bayad be ADAD tabdil shawand.
                        JOptionPane.showMessageDialog(null, "The Maximum Number = "+o.getMax()
                                ,"Maximum",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please Select One or More Cells!!!"+"\n"+
                                "To Select Whole Cells, Press Ctrl+A or Select all in EditMenu.",
                                "No Selected Cells" ,JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 10:// case MIN
                    if(isSelected){
                        o.convertToDigit();
                        JOptionPane.showMessageDialog(null, "The Minimum Number = "+o.getMin()
                                ,"Minimum",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please Select One or More Cells!!!"+"\n"+
                                "To Select Whole Cells, Press Ctrl+A or Select all in EditMenu.",
                                "No Selected Cells" ,JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 11:// case SUM
                    if(isSelected){
                        o.convertToDigit();
                        JOptionPane.showMessageDialog(null, "Sum of Numbers = "+
                                o.getSum(),"Sum",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please Select One or More Cells!!!"+"\n"+
                                "To Select Whole Cells, Press Ctrl+A or Select all in EditMenu.",
                                "No Selected Cells" ,JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 12:// case AVERAGE
                    if(isSelected){
                        o.convertToDigit();
                        ave=(double)o.getSum()/index;
                        JOptionPane.showMessageDialog(null, "the Computation of Numbers = "+index+"\n"+
                                "Average of Numbers = "+ave
                                ,"Average",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please Select One or More Cells!!!"+"\n"+
                                "To Select Whole Cells, Press Ctrl+A or Select all in EditMenu.",
                                "No Selected Cells" ,JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 13:// case COUNTER
                    if(isSelected){
                        o.convertToDigit();
                        o.getCounter();
                        JOptionPane.showMessageDialog(null,
                                "the Computation of Empty Cells = "+emptyCellCounter+// tedade khanehaye khali.
                                "\n"+"the Computation of non-Empty Cells = "+(780-emptyCellCounter)+// tedade khanehaye por
                                "\n"+"the Computation of Selected Cells Characters = "+sCellCharCounter+// tedade horufe khanehaye entekhab shode
                                "\n"+"the Computation of Whole Used Characters = "+ charCounter+// tedade kole horuf
                                "\n"+"the Computation of Numeral Cells = "+index+// tedade khanehaye adadi
                                "\n"+"the Computation of Selected Cells = "+ selectedCellCounter+// tedade khanehaye entekhab shode
                                "\n"+"the Computation of UnSelected Cells = "+ (780 - selectedCellCounter)+// tedade khanehaye geyre fa'al
                                "\n"+"the Computation of Whole Cells = "+(780),// tedade kole kaneha.
                                "Counter", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Please Select One or More Cells!!!"+"\n"+
                                "To Select Whole Cells, Press Ctrl+A or Select all in EditMenu.",
                                "No Selected Cells" ,JOptionPane.WARNING_MESSAGE);
                    }
                    break;// payane case Function.
                case 14:// in case marbut be gozineye Select All ast.
                    for(int i=0;i<30;i++)
                        for(int j=0;j<26;j++){
                            jtf[i][j].setBackground(Color.blue);
                            jtf[i][j].setEnabled(false);
                            jp.grabFocus();
                            setSelected();
                            setNotEdit();
                            cellSelCounter=2;
                        }
                    break;
                }// payane Switch Case.
            }// payane method actionPerformed.
    }// payane kelase Action Listener.
    /* piyade sazi kelase FocuseListener*/
    class FL implements FocusListener {
        int flp1,flp2;
        FL(){}
        FL(int i, int j){flp1=i; flp2=j;}
        /* agar Object Focus ra dar ekhtiyar be girad, in method Farakhani mishawad*/
        public void focusGained(FocusEvent e) {
            if (e.getSource()==jtf[flp1][flp2]){ // agar Object Khanehaye jadwal bashad-
                jtf[flp1][flp2].setEnabled(true);// -angah Gabele neweshtan mishawad.
                setEdit();
            }
            if(e.getSource()==jmEdit)                              // agar object menuye Edit bashad-
                if(jtf[txp1][txp2].getBackground()==Color.yellow){ // -darSurate Fa'al Budan-
                    jtf[txp1][txp2].setEnabled(true);              // -angah akharin khane fa'al shode-
                    jtf[txp1][txp2].grabFocus();                   // -nabayad gere fa'al gardad.
                    setNotSaved();
                }
            if (e.getSource()==jmFile || e.getSource()==jmFunction) // Menoye File wa Function-
                for(int i=0; i<30; i++)                             // -baroye Khanehaye Entekhab shode-
                    for(int j=0; j<26; j++)                         // -gable ejra hastand.
                        if(jtf[i][j].getBackground()==Color.yellow){
                            jtf[i][j].setEnabled(false);
                            jtf[i][j].setBackground(Color.blue);
                            setSelected();
                            setNotEdit();
                        }
        }// payane methode FocusGained
        /* agar Object Focus ra az dast dahad, in Method ejra mishawad*/
        public void focusLost(FocusEvent e) {
            if (e.getSource()==jtf[flp1][flp2])   // agar Khaneha Focus ra az dast dahad-
                jtf[flp1][flp2].setEnabled(false);// -angah geyre gable Neweshtan mishawad.
            }// payane methode focusLost
    }// payane kelase FocusListener
    /* piyade sazi kelase MouseListener*/
    class ML implements MouseListener {
        int mlp1,mlp2;
        ML(){}
        ML(int i, int j){mlp1=i; mlp2=j;};
        /* in Method Fagat zamani ejra mishawad, ke do amale Press and Release , Anjam Shode bashad*/
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==jtf[mlp1][mlp2]){
                if(!e.isControlDown()){
                    if(e.getSource()!=jtf[txp1][txp2] || !isEditing)
                        for(int i=0; i<30; i++)
                            for(int j=0; j<26; j++){
                                jtf[i][j].setEnabled(false);
                                setNotEdit();
                                setNotSelected();
                                jtf[i][j].setBackground(Color.white);
                                cellSelCounter=1;
                            }
                    if(e.getClickCount()==3){                      // dar surati ke sebar-
                        jtf[mlp1][mlp2].grabFocus();                // -click shawad, matne dakhele-
                        jtf[mlp1][mlp2].setEnabled(true);           // -khaneye excel, entekhab mishawad.
                        jtf[mlp1][mlp2].setBackground(Color.yellow);
                        jtf[mlp1][mlp2].select(0, 20);
                        setEdit();
                        setNotSelected();
                        setNotSaved();
                        setTxp(mlp1, mlp2);
                    }// payane if(e.getClickCount()==3).
                    if(e.getClickCount()==2){                           // dar surate DoubleClick-
                        jtf[mlp1][mlp2].grabFocus();                    // -khaneye morede nazar-
                        jtf[mlp1][mlp2].setEnabled(true);           // -gabele neweshtan mishawad-
                        jtf[mlp1][mlp2].setBackground(Color.yellow);// -range an zard mishawad.
                        setEdit();
                        setNotSelected();
                        setNotSaved();
                        setTxp(mlp1, mlp2);                         // alamat gozari mishawad.
                    }// payane if(e.getClickCount()==2).
                    if(e.getClickCount()==1){
                        if(jtf[mlp1][mlp2].getBackground()!=Color.yellow){
                            jtf[mlp1][mlp2].setBackground(Color.blue);
                            setSelected();
                            setNotEdit();
                        }
                    }
                }// payane if(!e.isControlDown()).
            }// payane if marbut be Khane haye Excel.
            if(e.getSource()==jmEdit) // agar bar rue menuye Edit click shawad-
                jmEdit.grabFocus();   // -angah Focus ra dar ekhtiyar migirad.
            if(e.getSource()==jmFunction) // agar bar rue menuye Function click shawad-
                jmFunction.grabFocus();   // -angah Focus ra dar ekhtiyar migirad.
            if(e.getSource()==jmFile) // agar bar rue menuye File click shawad-
                jmFile.grabFocus();   // -angah Focus ra dar ekhtiyar migirad.
        }// payane method mouseClicked.
        /* agar eshare gare mouse warede Mahdudeye Object shawad, in method farakhani migardad*/
	public void mouseEntered(MouseEvent e) {
            int creasing=0;

            if (isDraging){ // agar bar ruye khane ha Draging surat girad, khaneha entekhab migardand.
                setCopying(); // copy otomatik anjam pazir ast.
                setNotSaved();
                if(mlpp1<mlp1){ // baraye harekate be paein.
                    for(int p=mlpp1;p<=mlp1; p++){
                        if(mlpp2<mlp2) // baraye harekat be rast wa paein.
                            for(int k=mlpp2;k<=mlp2;k++){
                                jtf[p][k].setBackground(Color.blue);
                                setNotCopying();
                                setNotAutoCopy();// copy otomatik anjam pazir nist chon bish az yek sotun entekhab shode ast.
                                ++cellSelCounter;
                            }
                        if(mlpp2>mlp2) // baraye harekat be chap wa paein.
                            for(int k=mlpp2;k>=mlp2;k--){
                                jtf[p][k].setBackground(Color.blue);
                                ++cellSelCounter;
                                setNotCopying();
                                setNotAutoCopy();// copy otomatik anjam pazir nist chon bish az yek sotun entekhab shode ast.
                            }
                        jtf[p][mlpp2].setBackground(Color.blue);
                        if(e.getSource()==jtf[mlp1][mlp2])// agar Object khane bashad, gosheye paen samte rast baresi mishawad.
                            if((tmpx>=(3*jtf[0][0].getWidth()/4)) && tmpy>=(3*jtf[0][0].getHeight()/4) &&isCopying){
                                if(isAutoCopying){
                                    jtf[mlp1][mlp2].setText(""+(long)(allNum[index-1]+dfc*creasing));
                                    creasing++;
                                }else{
                                    jtf[mlp1][mlp2].setText(allText[txtCreasing]);
                                    if(txtCreasing>txtIndex-1)
                                        txtCreasing=0;
                                }
                            }else{
                                setNotAutoCopy();
                                setNotCopying();
                            }
                        ++cellSelCounter;
                    }//payane for(int p=mlpp1;p<=mlp1; p++).
                    if(!isAutoCopying && isCopying)
                        txtCreasing++;
                } // payane harekat be paein.
                if(mlpp1>mlp1){ // baraye harekat be bala.
                    for(int p=mlpp1;p>=mlp1; p--){
                        if(mlpp2<mlp2) // baraye harekat be bala samte rast.
                            for(int k=mlpp2;k<=mlp2;k++){
                                jtf[p][k].setBackground(Color.blue);
                                setNotCopying();
                                setNotAutoCopy();
                                ++cellSelCounter;
                            }
                        if(mlpp2>mlp2)// baraye harekat be bala samte chap
                            for(int k=mlpp2;k>=mlp2;k--){
                                jtf[p][k].setBackground(Color.blue);
                                setNotCopying();
                                setNotAutoCopy();
                                ++cellSelCounter;
                            }
                        jtf[p][mlpp2].setBackground(Color.blue);
                        ++cellSelCounter;
                    }
                } // payane harekat be bala
                if(mlpp2<mlp2){ // baraye harekat fagat be rast
                    for(int k=mlpp2 ; k<=mlp2;k++){
                        jtf[mlpp1][k].setBackground(Color.blue);
                            if(e.getSource()==jtf[mlp1][mlp2])// baraye gusheye paeine khane samte rast
                                if((tmpx>=(3*jtf[0][0].getWidth()/4)) && tmpy>=(3*jtf[0][0].getHeight()/4) && isCopying){
                                    if(isAutoCopying){
                                    jtf[mlp1][mlp2].setText(""+(long)(allNum[index-1]+dfc*creasing));
                                    creasing++;
                                }else{
                                    jtf[mlp1][mlp2].setText(allText[txtCreasing]);
                                    if(txtCreasing>txtIndex-1)
                                        txtCreasing=0;
                                }
                            }else{
                                setNotAutoCopy();
                                setNotCopying();
                            }
                        ++cellSelCounter;
                    }
                    if(!isAutoCopying && isCopying)
                        txtCreasing++;
                } // payane harekat fagat be rast
                if(mlpp2>mlp2) // fagat baraye harekat be chap
                    for(int k=mlpp2;k>=mlp2;k--){
                        jtf[mlpp1][k].setBackground(Color.blue);
                        ++cellSelCounter;
                    }
            } // payane amale Dragin
            if(e.getSource()==jtf[mlp1][mlp2] && !isEditing)
                jp.grabFocus();
            if (e.getSource()==jmEdit){ // fagat dar surate wojude khaneye gable neweshtan-
                if (isEditing){         // -menuye Edit Fa'al mishawad.
                    jmiCut.setEnabled(true);
                    jmiCopy.setEnabled(true);
                    jmiPaste.setEnabled(true);
                }
                else{
                    jmiCut.setEnabled(false);
                    jmiCopy.setEnabled(false);
                    jmiPaste.setEnabled(false);
                }
                jmEdit.grabFocus();
            }
            if(e.getSource()==jmFunction){
                setNotSelected();
                setNotEdit();
                jmFunction.grabFocus();
                for(int i=0; i<30; i++)
                    for(int j=0; j<26; j++){ // khanehaye zard bayad abi shawand.
                        if(jtf[i][j].getBackground()==Color.yellow){
                            jtf[i][j].setBackground(Color.blue);
                            jtf[i][j].setEnabled(false);
                        }
                        if(jtf[i][j].getBackground()==Color.blue) // agar khaneye abi wojud dasht-
                            setSelected();                        // -angah Function bayad fa'al shawad.
                    }
                if(!isSelected){// fa'al wa geyre fa'al sazi menuye Function.
                    jmiMax.setEnabled(false);
                    jmiMin.setEnabled(false);
                    jmiSum.setEnabled(false);
                    jmiAve.setEnabled(false);
                    jmiCount.setEnabled(false);
                }
                else{
                    jmiMax.setEnabled(true);
                    jmiMin.setEnabled(true);
                    jmiSum.setEnabled(true);
                    jmiAve.setEnabled(true);
                    jmiCount.setEnabled(true);
                }
            }// payane jmiFunction.
        }// payane methode mouseEntered.
        /* agar eshare gare mouse az object kharej shawad in method gfarakhani mishawad*/
	public void mouseExited(MouseEvent e) {
            if (isDraging){// ger fal kardane khanehaye drag shode ba raftane dobare ruye Anha
                setNotCopying();
                if(mlpp1<mlp1){// baraye raftan be paein
                    for(int p=mlpp1;p<=mlp1; p++){
                        if(mlpp2<mlp2)// baraye raftan be paein samte rast
                            for(int k=mlpp2;k<=mlp2;k++){
                                jtf[p][k].setBackground(Color.white);
                                ++cellSelCounter;
                            }
                        if(mlpp2>mlp2)// baraye raftan be pain samte chap
                            for(int k=mlpp2;k>=mlp2;k--){
                                jtf[p][k].setBackground(Color.white);
                                ++cellSelCounter;
                            }
                        jtf[p][mlpp2].setBackground(Color.white);
                        ++cellSelCounter;
                    }
                }// payane raftan be paein
                if(mlpp1>mlp1){// baraye raftan be bala
                    for(int p=mlpp1;p>=mlp1; p--){
                        if(mlpp2<mlp2)// baraye raftan be bala samte rast
                            for(int k=mlpp2;k<=mlp2;k++){
                                jtf[p][k].setBackground(Color.white);
                                ++cellSelCounter;
                            }
                        if(mlpp2>mlp2)// baraye raftan be bala samte chap
                            for(int k=mlpp2;k>=mlp2;k--){
                                jtf[p][k].setBackground(Color.white);
                                ++cellSelCounter;
                            }
                        jtf[p][mlpp2].setBackground(Color.white);
                        ++cellSelCounter;
                    }
                }// payane harekat be bala.
                if(mlpp2<mlp2)// baraye raftan be rast
                    for(int k=mlpp2 ; k<=mlp2;k++){
                        jtf[mlpp1][k].setBackground(Color.white);
                        ++cellSelCounter;
                    }
                if(mlpp2>mlp2)// baraye harekat be chap
                    for(int k=mlpp2;k>=mlp2;k--){
                        jtf[mlpp1][k].setBackground(Color.white);
                        ++cellSelCounter;
                    }
            }// payane geyre fa'al kardane khane haye drag shode
            if(e.getSource()==jtf[mlp1][mlp2])                  // agar az samte paein az khane sabz kharej shod-
                if(jtf[mlp1][mlp2].getBackground()==Color.green)//- range an bayad be abi tabdil shawad.
                    jtf[mlp1][mlp2].setBackground(Color.blue);
        }// payane methode mouseExited
        /*agar esharegare mouse fagat bar ruye object press shawad in method ejra migardad*/
	public void mousePressed(MouseEvent e) {
            setMlPresingPoit(mlp1, mlp2);// awalin khaneye entekhab shode jahate Draging , moshakhas mishawad.
            setTextMousePoint(e.getX(), e.getY());// mahale neshanegare mouse moshakhas mishawad.
            if(e.getSource()==jtf[mlp1][mlp2]){
                if(e.getButton()== e.BUTTON3)// jahate tashkhide click rast wa chap
                    isRightClick();
                else
                    isNotRightClick();
                if(!e.isControlDown())                              // agar kelide Control paein nabashad-
                    if(e.getSource()!=jtf[txp1][txp2] || !isEditing)//- khaneha geyre fa'al mishawand
                        for(int i=0; i<30; i++)
                            for(int j=0; j<26; j++){
                                jtf[i][j].setEnabled(false);
                                setNotEdit();
                                jtf[i][j].setBackground(Color.white);
                                cellSelCounter=1;
                            }
                if(jtf[mlp1][mlp2].getBackground()!=Color.yellow){
                    jtf[mlp1][mlp2].setBackground(Color.blue);
                    setSelected();
                    ++cellSelCounter;
                    jp.grabFocus();// focus dar ekhtiyare Panel barname garar migirad.
                }
                if(jtf[txp1][txp2].getBackground()==Color.yellow && e.getSource()!=jtf[txp1][txp2]){// kaneye darhale neweshtan, abi mishawad
                    jtf[txp1][txp2].setBackground(Color.blue);
                    jtf[txp1][txp2].setEnabled(false);
                    setNotEdit();
                    setSelected();
                }
            }// payane press baraye khanehaye Excel
        }// payane method mousePresse
        /* agar esharegare mouse az ruye object realease gardad in method ejra mishawad*/
	public void mouseReleased(MouseEvent e) {
            DoActions da= new DoActions();
            txtIndex=0;
            txtCreasing=0;
            for(int c=0;c<30;c++)
                allText[c]="";
            int st=0;
            boolean isStr = false;
            boolean isConvertable=false;
            String reStr="";
            int lastCellR, lastCellC;// andise akharin khaneye entekhab shode ra darad.
            double def1=0,def2= 0;// ekhtelafe beyn khanehaye entekhabi.
            int bcc = 0;// yek harfe character adadi be integer tabdil mishawad.
            if(e.getSource()==jtf[mlp1][mlp2]){
                outerFor: for(int i=0;i<30;i++)
                    for(int j=0;j<26;j++)
                        if(jtf[i][j].getBackground()==Color.blue && !e.isControlDown()){
                            lastCellR=i;
                            lastCellC=j;
                            bcc++;
                            if(lastCellC==mlpp2 && lastCellR>=mlpp1){// aya yek sotun fagat entekhab shode ast.
                                isStr=true;
                            }
                            else if(lastCellR==mlpp1 && lastCellC>=mlpp2){// aya yek radif entekhab shode ast.
                                isStr=true;
                            }
                            else{// agar bish az yek radif waya sotun entekhab shawad, halge payan miyabad.
                                isStr=false;
                                break outerFor;
                            }
                        }// payane awalin if az bala, dakhele halge.
                if(isStr){
                    for(int i=0;i<30;i++)
                        for(int j=0;j<26;j++)
                            if(jtf[i][j].getBackground()==Color.blue || jtf[i][j].getBackground()==Color.green){
                                allText[txtIndex]=jtf[i][j].getText();
                                txtIndex++;
                            }
                    outerFor: for(int t=0;t<txtIndex;t++){
                        reStr=allText[t];
                        for(int p=0;p<reStr.length();p++){
                            if(p==0)
                                if(reStr.charAt(p)=='-'){
                                    if(reStr.length()!=1){
                                        p=1;
                                    }else{
                                        setNotAutoCopy();
                                        break outerFor;
                                    }
                                }
                            if(reStr.charAt(p)>=48 && reStr.charAt(p)<=57){

                                if(p==reStr.length()-1){
                                    isConvertable=true;
                                }else{
                                    isConvertable=false;
                                    setNotAutoCopy();
                                }
                            }else{
                                isConvertable=false;
                                setNotAutoCopy();
                                break outerFor;
                            }
                        }
                    }
                    if(isConvertable){
                        da.convertToDigit();
                        if(isAutoCopying){
                            if(index==1){
                                setNotAutoCopy();
                            }else if(index==2){
                                dfc=allNum[1]-allNum[0];
                            }else{
                                for(int f=index-1;f>1;f--){
                                    def1=allNum[f]-allNum[f-1];
                                    def2=allNum[f-1]-allNum[f-2];
                                    if(def1==def2){
                                        dfc=def1;
                                        setAutoCopy();
                                    }else{
                                        dfc=0;
                                        setNotAutoCopy();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }// payane if(e.getSource()==jtf[mlp1][mlp2]).
            if ( e.isPopupTrigger() ) // baraye fa'al saziye menuye RightClick ya haman PopupMenu
                if (e.getSource()==jtf[mlp1][mlp2]){
                    jpm.show( e.getComponent(), e.getX(), e.getY() );
                    jtf[mlp1][mlp2].grabFocus();                    // -khaneye morede nazar-
                    jtf[mlp1][mlp2].setEnabled(true);           // -gabele neweshtan mishawad-
                    jtf[mlp1][mlp2].setBackground(Color.yellow);// -range an zard mishawad.
                    setEdit();
                    setNotSelected();
                    setNotSaved();
                    setTxp(mlp1, mlp2);
                }
        }// payane methode mouseReleased
    }// payane kelase MouseListener
    /* agar mouse harekat konad kelase zir piayade sazi mishawad*/
    class MML implements MouseMotionListener{
        int mmlp1, mmlp2;
        MML(){}
        MML(int i, int j){ mmlp1=i; mmlp2=j;}
        /* agar kelide mouse feshar dadeshawad wa neshanegar harekat konad Drag Surat migirad*/
        public void mouseDragged(MouseEvent e) {
            if(jtf[mmlp1][mmlp2].getBackground()==Color.yellow || isRightClick)
                setNotDraging();// agar khane zard rang bashad wa ya rast klik shawad-
            else                //-nemitan bar ruye an draging kard.
                setDraging();
        }// payane methode mouseDraged
        /* agar mouse hargune harekati anjam dahad methode zir ejra mishawad*/
        public void mouseMoved(MouseEvent e) {
            setNotDraging();// agar mouse fagat harekat konad, Draging surat nagirad.
            if(e.getSource()==jtf[mmlp1][mmlp2]){
                if(jtf[mmlp1][mmlp2].getBackground()==Color.blue || jtf[mmlp1][mmlp2].getBackground()==Color.green)
                    if(e.getX()>=(3*jtf[0][0].getWidth()/4) && e.getY()>=(3*jtf[0][0].getHeight()/4)){
                        jtf[mmlp1][mmlp2].setBackground(Color.GREEN);
                            jtf[mmlp1][mmlp2].setToolTipText("You Could Copy Automatically");
                    }
                    else{
                        jtf[mmlp1][mmlp2].setBackground(Color.blue);
                        jtf[mmlp1][mmlp2].setToolTipText("You Could Not Copy Automatically");
                    }
            }
        }// payane methode mouseMoved.
    }// payane Kelase MouseMotionListener.
    /* agar kelidi az KeyBoard zade shawad in kelas farakhani migardad*/
    class KL implements KeyListener{
        int klp1, klp2;
        private int keyCode;
        KL() {}
        KL(int i, int j){klp1=i; klp2=j;}
        /* agar kelidi feshar dade shawad in method farakhni mishawad*/
        public void keyPressed(KeyEvent e){
            keyCode= e.getKeyCode();// kode kelidi ke feshar dade mishawad ra darad.
            /* dar dasturate in If, kelide Enter wa ArrowKeys Fa'al mishawand-*/
            if(cellSelCounter==1 &&(e.getSource()==jp || e.getSource()==jtf[klp1][klp2]))
                for(int i=0; i<30; i++)
                    for(int j=0; j<26; j++){
                        if(i!=-1 && i!=30)
                            if(jtf[i][j].getBackground()==Color.blue || jtf[i][j].getBackground()==Color.yellow){
                                if(i<=29 && i>=0 && j>=0 && j<=25){// nabayad az mahdudeye Khaneha Kharej shod.
                                    if(keyCode==10 || keyCode==40){ // 10 baraye kelide Enter wa 40 baraye kelide DownArrowKey
                                        jtf[i][j].setEnabled(false);
                                        setNotEdit();
                                        jtf[i][j].setBackground(Color.white);// khanye gabli sefid mishawad.
                                        if(++i!=30)// nabayad az mahdudeye khaneha kharej shod.
                                            jtf[i][j].setBackground(Color.blue);// khaneye paeini abi mishawad.
                                        jp.grabFocus();
                                    }
                                    if(keyCode==39 && jtf[i][j].getBackground()!=Color.yellow){// 39 baraye kelide RightArrowKey
                                        jtf[i][j].setEnabled(false);
                                        setNotEdit();
                                        jtf[i][j].setBackground(Color.white);
                                        if(++j!=26)
                                            jtf[i][j].setBackground(Color.blue);
                                        jp.grabFocus();
                                    }
                                    if(keyCode==37 && jtf[i][j].getBackground()!=Color.yellow){// 37 baraye kelide LeftArrowKey
                                        jtf[i][j].setEnabled(false);
                                        setNotEdit();
                                        jtf[i][j].setBackground(Color.white);
                                        if(--j!=-1)
                                            jtf[i][j].setBackground(Color.blue);
                                        jp.grabFocus();
                                    }
                                    if(keyCode==38){// 38 baraye kelide UpArrowKey
                                        jtf[i][j].setEnabled(false);
                                        setNotEdit();
                                        jtf[i][j].setBackground(Color.white);
                                        if(--i!=-1)
                                            jtf[i][j].setBackground(Color.blue);
                                        jp.grabFocus();
                                    }
                                }//payane if(i<=29 && i>=0 && j>=0 && j<=25).
                            }// payane if(jtf[i][j].getBackground()...
                        cellSelCounter=1;
                    }// payane Barresiye Kelidhaye jahati wa Enter
            /* ba estefade az dasture ife zir, Kelidhaye harfi wa ragami barresi mishawad*/
            if(cellSelCounter==1 && e.getSource()==jp && !e.isAltDown() && !e.isControlDown() && !e.isShiftDown())
                if(/*kelide A-Z*/(keyCode>=65 && keyCode<=90) || /*Kelide 1-9*/(keyCode>=48 && keyCode<=57) ||
                /*Kelid NUMpad*/(keyCode>=96 && keyCode<=105) || (/* backSpace */keyCode==8) || (/* Space */keyCode==32))
                    for(int i=0;i<30;i++)                             // bazadane yeki az kelidhaye-
                        for(int j=0;j<26;j++)                         // -harfi ya adadi waya BackSpase ya Space-
                            if(jtf[i][j].getBackground()==Color.blue){// -khaneye fa'al gable neweshtan mishawad.
                                jtf[i][j].setBackground(Color.yellow);
                                jtf[i][j].setEnabled(true);
                                jtf[i][j].grabFocus();
                                if(keyCode!=8)// agar kelide BackSpace Bashad, matn pak mishawad.
                                    jtf[i][j].setText(""+e.getKeyChar());
                                else
                                    jtf[i][j].setText("");
                                setEdit();
                                setNotSaved();
                                setTxp(i, j);
                                cellSelCounter=1;
                            }// payane barresiye kelidhaye harfi wa adadi
            if(keyCode==27 && (e.getSource()==jp || e.getSource()==jtf[klp1][klp2]) )
                for(int i=0; i<30; i++)// agare kelide Escape (Esc) zade shawad, tamamiye khaneha geyre fal mishawand
                    for(int j=0; j<26; j++){
                        if(jtf[i][j].getBackground()==Color.yellow)
                            jtf[i][j].setText("");
                        jtf[i][j].setEnabled(false);
                        jtf[i][j].setBackground(Color.white);
                        jp.grabFocus();
                        setNotEdit();
                        setNotSelected();
                    }// payane barresiye Kelide Esc
            if (e.isControlDown())// kelidhaye miyanBor Shenasaie maishwand
                switch(keyCode){
                    case (int)'N':// Menuye New
                        new AL(1).actionPerformed(null);
                        break;
                    case (int)'O':// menuye Open
                        new AL(2).actionPerformed(null);
                        break;
                    case (int)'S':// menuye Save
                        if (e.isShiftDown())// agar Shift ham gerefte shawad, Save as Entekhab migardad
                            new AL(4).actionPerformed(null);
                        else// agar fagat control gerefte shawad, save entekhab mishawad.
                            new AL(3).actionPerformed(null);
                        break;
                    case (int)'X':// menuye Cut
                        new AL(6).actionPerformed(null);
                        break;
                    case (int)'C':// Menuye Copy
                        new AL(7).actionPerformed(null);
                        break;
                    case (int)'V':// Menuye Paste
                        new AL(8).actionPerformed(null);
                        break;
                    case (int)'A':
                        new AL(14).actionPerformed(null);
                        break;
                    case 49:// 49 baraye kelide 1 wa menuye Max ast
                        new AL(9).actionPerformed(null);
                        break;
                    case 50:// 50 baraye kelide 2 wa menuye Min ast
                        new AL(10).actionPerformed(null);
                        break;
                    case 51:// 51 baraye kelide 3 wa menuye Sum ast
                        new AL(11).actionPerformed(null);
                        break;
                    case 52:// 52 baraye kelide 4 wa menuye Average ast
                        new AL(12).actionPerformed(null);
                        break;
                    case 53:// 53 baraye kelide 5 wa menuye Count ast
                        new AL(13).actionPerformed(null);
                        break;
                } // payane Barresiye ShortKeys
            if(e.isAltDown()) // barresiye menoye Exit wa Kelide F4
                if (keyCode==115)
                    new AL(5).actionPerformed(null);// menoye Exit farakhani mishawad
        }// payane methode keyPressed.
        /* agar kelidi az KeyBoard Raha shawad in method Ejra migardad*/
        public void keyReleased(KeyEvent e){}// payane methode keyReleased
        /* agar kelidi az KeyBoard Ham feshar dade shawad wa ham raha shawad methode zir Ejra migardad*/
        public void keyTyped(KeyEvent e){}// payane methode keyTyped.
    }// payane kelase KeyListener
    /* Baraye piyade sazi tawabe wa sayer daturat az kelase zir estefade mishawad*/
    class DoActions {
        double maxItem=0;
        double minItem=0;
        String strNum;// adade reshtei ra darad.
        double temp;
        double sum;
        double num;// adade tabdil shode ra dar khod darad.
        void getCounter(){// wazifeye in mthod, shomaresh ast.
            selectedCellCounter=0;
            emptyCellCounter=0;
            charCounter=0;
            for(int i=0; i<30;i++)
                for(int j=0; j<26;j++){
                    if(jtf[i][j].getText().length()==0)
                        ++emptyCellCounter;
                    else
                        charCounter+=jtf[i][j].getText().length();
                    if(jtf[i][j].getBackground()==Color.blue || jtf[i][j].getBackground()==Color.green)
                        ++selectedCellCounter;
               }
        }// payane getCounter.
        void convertToDigit(){// wazifeye in mthod, tabdile reshtehaye harfi be Integer ast.
            index=0;
            sCellCharCounter=0;
            for(int i=0;i<780;i++)
                allNum[i]=0;
            for(int i=0; i<30;i++){
                innerFor: for(int j=0; j<26;j++)
                    if((jtf[i][j].getBackground()==Color.blue || jtf[i][j].getBackground()==Color.green)&& jtf[i][j].getText().length()!=0){
                        sCellCharCounter+=jtf[i][j].getText().length();
                        strNum=jtf[i][j].getText();
                        for(int c=0;c<strNum.length();c++){
                            if(c==0)
                                if(strNum.charAt(c)=='-')// adade manfi barresi mishawad.
                                    if(strNum.length()!=1){
                                        c=1;
                                    }else{
                                        continue innerFor;
                                    }
                            if(strNum.charAt(c)>=48 && strNum.charAt(c)<=57 || strNum.charAt(c)=='.'){// character ha bayad adadi bashand.
                                if(c==strNum.length()-1){
                                    if((strNum.charAt(0)!='.')){
                                        if(strNum.charAt(0)=='0'){
                                            if(strNum.length()==1){
                                                num=Double.parseDouble(strNum);
                                                allNum[index]=num;
                                                index++;
                                                num=0;
                                                setAutoCopy();
                                            }else if(strNum.charAt(1)=='.'){
                                                num=Double.parseDouble(strNum);
                                                allNum[index]=num;
                                                index++;
                                                num=0;
                                            }else{
                                                setNotAutoCopy();
                                                continue innerFor;
                                            }
                                        }else if(strNum.charAt(0)=='-'){
                                                    if(strNum.length()!=1){
                                                        if(strNum.charAt(1)!='.'){
                                                            num=Double.parseDouble(strNum);
                                                            allNum[index]=num;
                                                            index++;
                                                            num=0;
                                                            setAutoCopy();
                                                }
                                            }
                                        }else{
                                            num=Double.parseDouble(strNum);// nabayad ragame awal, sefr bashad.
                                            allNum[index]=num;
                                            index++;
                                            num=0;
                                            setAutoCopy();
                                        }
                                    }else if(strNum.charAt(0)=='.'){
                                        setNotAutoCopy();
                                        continue innerFor;
                                    }
                                }else{
                                    setNotAutoCopy();
                                }
                            }
                            else{
                                setNotAutoCopy();
                                continue innerFor;}
                        }//payane for(int c=0;c<strNum.length();c++).
                    }// payane awalin if az bala.
            }// payane for(int i=0; i<30;i++).
        }// payane methode convertToDigit.
        double getSum(){// majmue adade tabdil shode ra bar migardanad.
            sum=0;
            for(int p=0;p<index;p++)
                sum+=allNum[p];
            return sum;
        }// payane getSum.
        double getMax(){// bozorgtarin adad ra moshakhas mikonad.
            maxItem=allNum[0];
            for(int m=1;m<index;m++)
                if(maxItem<=allNum[m])
                    maxItem=allNum[m];
            return maxItem;
        }// payane getMax.
        double getMin(){// kochektarin adad ra moshakhas mikonad.
            minItem=allNum[0];
            for(int m=1;m<index;m++)
                if(minItem>=allNum[m])
                    minItem=allNum[m];
            return minItem;
        }// payane getMin
        void savingAs()throws IOException{// barname ra ba name jadid zakhire mikonad.
            text="";// matne kole khane hara, dar khod darad.
            JFileChooser fc=new JFileChooser();
            fc.setSelectedFile(new File("SpreadSheet"+namC));
            int option=fc.showSaveDialog(null);
            if(option==fc.APPROVE_OPTION){
                fileName=fc.getCurrentDirectory()+"\\"+fc.getSelectedFile().getName();// masire file
                File f=new File(fileName);
                FileOutputStream fos=new FileOutputStream(f);
                BufferedOutputStream bos=new BufferedOutputStream(fos);
                ObjectOutputStream oos=new ObjectOutputStream(bos);
                for(int i=0;i<30;i++)
                    for(int j=0;j<26;j++)
                        text= text+ jtf[i][j].getText()+"&";
                oos.writeUTF(text);
                oos.flush();
                oos.close();
                setSaved();
                ++savingCounter;
                JOptionPane.showMessageDialog(null,"Your Data Have Been Saved in this path: "+"\n"+fileName,"SaveAs" ,JOptionPane.INFORMATION_MESSAGE);
            }// payane if(option==fc.APPROVE_OPTION)
        }// payane savingAS.
        void justSave()throws IOException{// barname ra ba name gabli zakhire mikonad.
            text="";
            File f=new File(realFileName);
            f.delete();
            f.createNewFile();
            FileOutputStream fos=new FileOutputStream(f);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            for(int i=0;i<30;i++)
                for(int j=0;j<26;j++)
                    text= text+ jtf[i][j].getText()+"&";
            oos.writeUTF(text);
            oos.flush();
            oos.close();
            setSaved();
            ++savingCounter;
            JOptionPane.showMessageDialog(null,"Your Data Have Been Saved in this path: "+"\n"+realFileName,"Save" ,JOptionPane.INFORMATION_MESSAGE);
        }// payane justSave.
        void open()throws IOException{
            text="";
            textIndex=0;
            JFileChooser fc=new JFileChooser();
            int option=fc.showOpenDialog(null);
            if(option==fc.APPROVE_OPTION){
                fileName=fc.getCurrentDirectory()+"\\"+fc.getSelectedFile().getName();
                FileInputStream fis=new FileInputStream(fileName);
                BufferedInputStream bis= new BufferedInputStream(fis);
                ObjectInputStream ois=new ObjectInputStream(bis);
                text=ois.readUTF();
                if(isOpenable)
                    realFileName=fileName;
                for(int i=0;i<30;i++)
                    for(int j=0;j<26;j++){
                        jtf[i][j].setText("");
                        jtf[i][j].setBackground(Color.white);
                    }
                for(int i=0;i<30;i++)
                    for(int j=0;j<26;j++){
                        while(text.charAt(textIndex)!='&'){
                            jtf[i][j].setText(jtf[i][j].getText()+text.charAt(textIndex));
                            textIndex++;
                        }
                        textIndex++;
                    }
                ois.close();
                setSaved();
                savingCounter=2;
                jp.grabFocus();
            }// payane if(option==fc.APPROVE_OPTION)
        }// payane open.
    }// payane class DoAction.
    static void setEdit(){isEditing=true;}// khane ra gabele neweshtan mikonad.
    static void setNotEdit(){isEditing=false;}
    static void setDraging(){isDraging=true;}// gabelyate drag shodan ra emkan pazir mikonad.
    static void setNotDraging(){isDraging=false;}
    static void setSelected(){isSelected=true;}// baraye khane haye abi, farakhani mishawad.
    static void setNotSelected(){isSelected=false;}
    static void setMlPresingPoit(int i, int j){mlpp1=i;mlpp2=j;}// khaneyei ke klik shode, moshakhas mikonad.
    static void setTxp(int i, int j){txp1=i;txp2=j;}// khaney ke dar hale neweshtan ast, moshakhas mikonad.
    static void setTextMousePoint(int i,int j){tmpx=i;tmpy=j;}// makani ke esharegare mouse garar darad.
    static void setCopying(){isCopying=true;}// khaneye entekhab shode, autoCopy mishawad.
    static void setNotCopying(){isCopying=false;}
    static void setAutoCopy(){isAutoCopying=true;}// fagat marbut be copy HOOSHMANDE AUTOMATIC ast.
    static void setNotAutoCopy(){isAutoCopying=false;}
    static void isRightClick(){isRightClick=true;}// baraye klike rast farakhani mishawad.
    static void isNotRightClick(){isRightClick=false;}
    static void setSaved(){saved=true;}// agar Barname zakhire shawad, farakhani migardad.
    static void setNotSaved(){saved=false;}

    public static void main(String[] args) {new SpreadSheet();}
}// payane kole barname. 1151 khatKod.

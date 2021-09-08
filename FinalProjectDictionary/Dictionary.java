
import java.util.Scanner;
class ArrayStack{
    int index=-1;
    TreeNodes arr[]=new TreeNodes[30];
    void push(TreeNodes tn){
        index++;
        if(index==30){
            System.out.println("full");
            return;
        }
        arr[index]=tn;
    }
    TreeNodes pop(){
        if(index==-1){            
            return null;
        }
        TreeNodes tmp=arr[index];
        index--;
        return tmp;
    }
}
class TreeNodes{
    char elem;
    boolean endFlag;
    TreeNodes characters[]=new TreeNodes[29];

    public TreeNodes() {
    }
    
    public TreeNodes(char e) {
        elem=e;
    }
    
}
class TrieTreeEn{
    TreeNodes Eroot=new TreeNodes();
    TreeNodes harfeAkhar, awalinRishe=Eroot;
    ArrayStack es=new ArrayStack();
    boolean notDeclared=false;
    private void trieInsertEnglish(String x){
        TreeNodes p=Eroot;        
        for(int i=0;i<x.length();i++){
            char chr=x.charAt(i);
            int value=-1;
            if(chr>='a' && chr<='z')
                value=(int)chr-(int)'a';
            else if(chr=='-')
                value=26;
            else if(chr=='\'')
                value=27;
            else{
                System.out.println("ERRor! invalid character");
                System.exit(0);
            }
            if(p.characters[value]==null){
                p.characters[value]=new TreeNodes(chr);
                notDeclared=true;
            }else{
                notDeclared=false;
            }
            p=p.characters[value];
        }// for
        if(p.endFlag==false)
            notDeclared=true;        
        p.endFlag=true;
        harfeAkhar=p;
    }    
    void declareEnglish(String word){
        Eroot=awalinRishe;
        trieInsertEnglish(word);
        if(notDeclared)
            System.out.println("declared successfull.");
        else
            System.out.println("already declared.");
    }    
    private void removeEn(String x){
        TreeNodes p=Eroot, tmp;
        for(int i=0;i<x.length();i++){
            char chr=x.charAt(i);
            int value=-1;
            if(chr>='a' && chr<='z')
                value=(int)chr-(int)'a';
            else if(chr=='-')
                value=26;
            else if(chr=='\'')
                value=27;
            else{
                System.out.println("ERRor! invalid character");
                return;
            }
            if(p.characters[value]!=null){                
                es.push(p.characters[value]);
                notDeclared=false;
            }else{
                notDeclared=true;                
                return;
            }
            p=p.characters[value];
        }// for
        if(p.endFlag==false)
            notDeclared=true;
        p.endFlag=false;
    }    
    void removeEnglish(String word){
        Eroot=awalinRishe;
        removeEn(word);
        if(notDeclared==false){
            TreeNodes p=es.pop();
            while(p!=null){
                p=null;
                p=es.pop();
            }
            System.out.println("removeEnglish successfull.");
        }
        else
            System.out.println("no such word exist inEnglish.");
    }    
    void addPair(String x, String y){
        Eroot=awalinRishe;
        trieInsertEnglish(x);
        System.out.println("notdeclare: "+notDeclared);
        if(harfeAkhar.characters[28]==null)
            harfeAkhar.characters[28]=new TreeNodes('=');
        Eroot=harfeAkhar.characters[28];
        trieInsertEnglish(y);
        if(notDeclared)
            System.out.println("addPair successfulll.");
        else
            System.out.println("pair already exists");
    }
    /*void removePair(String x, String y){
        Eroot=awalinRishe;
        trieInsertEnglish(x);
        TreeNodes eq=harfeAkhar.characters[28];
        if(eq==null)
            System.out.println("no such pair exist.");
        else{
            Eroot=eq;
            trieInsertEnglish(y);
            if(notDeclared)
                System.out.println("no such pair exist.");
            else{
                int i=0;
                char end=y.charAt(y.length()-1);
                char first=y.charAt(0);
                for(i=0;i<eq.characters.length;i++)
                    if(eq.characters[i]!=null &&
                        eq.characters[i].elem==first && harfeAkhar.elem==end){                        
                        break;
                    }
                if(i<eq.characters.length)
                    eq.characters[i]=null;
                else
                    eq.characters[28]=null;
                System.out.println("removePair successfull.");
            }
        }
    }*/
    void queryEnglish(String x){
        Eroot=awalinRishe;
        trieInsertEnglish(x);
        if(notDeclared){
            removeEn(x);
            System.out.println("?");
        }else{
            TreeNodes eq=harfeAkhar.characters[28];
            if(eq==null)
                System.out.println("");
            else{
               // showWords(eq);// in method bayad liste kalamate mojod dar risheye eq ra bar gardanad.
                System.out.println(" liste kalamat ra namayesh midahad");
            }
        }
    }
   /*void showWords(TreeNodes r){
        TreeNodes p=r;
        if(p==null)
            return;                
        for(int i=0;i<p.characters.length;i++){
            if(p.characters[i]!=null){
                if(p.characters[i].endFlag){
                    System.out.print(p.characters[i].elem+" ");
                }else{
                    System.out.print(""+p.characters[i].elem);                    
                }        
                showWords(p.characters[i]);
            }
        }
    }*/
}
class TrieTreePen{
    TreeNodes Proot=new TreeNodes();
    TreeNodes harfeAkhar, awalinRishe=Proot;
    ArrayStack ps=new ArrayStack();
    boolean notDeclared=false;
    private void trieInsertPenglish(String x){
        TreeNodes p=Proot;
        for(int i=0;i<x.length();i++){
            char chr=x.charAt(i);
            int value=-1;
            if(chr>='a' && chr<='z')
                value=(int)chr-(int)'a';
            else if(chr=='-')
                value=26;
            else if(chr=='\'')
                value=27;
            else{
                System.out.println("ERRor! invalid character");
                return;
            }
            if(p.characters[value]==null){
                p.characters[value]=new TreeNodes(chr);
                notDeclared=true;
            }else{
                notDeclared=false;
            }
            p=p.characters[value];
        }// for
        if(!p.endFlag)
            notDeclared=true;
        p.endFlag=true;
        harfeAkhar=p;
    }
    void declarePenglish(String word){
        Proot=awalinRishe;
        trieInsertPenglish(word);
        if(notDeclared)
            System.out.println("declare successfull inPenglish.");
        else
            System.out.println("already declared inPenglish.");
    }
    private void removePen(String x){
        TreeNodes p=Proot, tmp;
        for(int i=0;i<x.length();i++){
            char chr=x.charAt(i);
            int value=-1;
            if(chr>='a' && chr<='z')
                value=(int)chr-(int)'a';
            else if(chr=='-')
                value=26;
            else if(chr=='\'')
                value=27;
            else{
                System.out.println("ERRor! invalid character");
                return;
            }
            if(p.characters[value]!=null){
                tmp=p.characters[value];
                ps.push(tmp);
                notDeclared=false;
            }else{
                notDeclared=true;
                return;
            }
            p=tmp;
        }// for
        if(!p.endFlag)
            notDeclared=true;
        p.endFlag=false;
    }
    void removePenglish(String word){
        Proot=awalinRishe;
        removePen(word);
        if(!notDeclared){
            TreeNodes p=ps.pop();
            while(p!=null){
                p=null;
                p=ps.pop();
            }
            System.out.println("removePenglish successfull.");
        }
        else
            System.out.println("no such word exist inPenglish.");
    }
    void addPair(String x, String y){
        Proot=awalinRishe;
        trieInsertPenglish(x);
        if(harfeAkhar.characters[28]==null)
            harfeAkhar.characters[28]=new TreeNodes('=');
        Proot=harfeAkhar.characters[28];
        trieInsertPenglish(y);
    }
    /*void removePair(String x, String y){
        Proot=awalinRishe;
        trieInsertPenglish(x);
        TreeNodes eq=harfeAkhar.characters[28];
        if(eq==null){
            System.out.println("no such pair exist.");
        }else{
            Proot=eq;
            trieInsertPenglish(y);
            if(notDeclared)
                System.out.println("no such pair exist.");
            else{
                int i=0;
                char end=y.charAt(y.length()-1);
                char first=y.charAt(0);
                for(i=0;i<eq.characters.length;i++)
                    if(eq.characters[i]!=null &&
                        eq.characters[i].elem==first && harfeAkhar.elem==end){                        
                        break;
                    }
                if(i<eq.characters.length)
                    eq.characters[i]=null;
                else
                    eq.characters[28]=null;
                System.out.println("removePair successfull.");
            }
        }
    }*/
    void queryPenglish(String x){
        Proot=awalinRishe;
        trieInsertPenglish(x);
        if(notDeclared){
            removePen(x);
            System.out.println("?");
        }else{
            TreeNodes eq=harfeAkhar.characters[28];
            if(eq==null)
                System.out.println("");
            else{
                //showWords(eq);// in methode...
                System.out.println("kalamat...");
            }
        }
    }
    /*void showWords(TreeNodes r){
        TreeNodes p=r;
        if(p==null)
            return;
        for(int i=0;i<p.characters.length;i++){
            if(p.characters[i]!=null){
                if(p.characters[i].endFlag){
                    System.out.print(p.characters[i].elem+" ");
                }else{
                    System.out.print(""+p.characters[i].elem);
                }
                showWords(p.characters[i]);
            }
        }
    }*/
}
public class Dictionary {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        TrieTreeEn englishDiction=new TrieTreeEn();
        TrieTreePen penglishDiction= new TrieTreePen();        
        int instructionCounter = in.nextInt();
        for(int i=1;i<=instructionCounter;i++){
            String instruction=in.next();
            String engWord=""; String pengWord=""; 
            int ins=-1;
            if(instruction.equals("declareEnglish"))
                ins=0;            
            if(instruction.equals("removeEnglish"))
                ins=1;
            if(instruction.equals("queryEnglish"))
                ins=2;
            if(instruction.equals("declarePenglish"))
                ins=3;
            if(instruction.equals("removePenglish"))
                ins=4;
            if(instruction.equals("queryPenglish"))
                ins=5;
            if(instruction.equals("addPair"))
                ins=6;
            if(instruction.equals("removePair"))
                ins=7;
            if(ins==0 || ins==1 || ins==2){
                engWord=in.next();
                if(ins==0)
                    englishDiction.declareEnglish(engWord);
                else if(ins==1)
                    englishDiction.removeEnglish(engWord);
                else if(ins==2)
                    englishDiction.queryEnglish(engWord);
            }
            else if(ins==3 || ins==4 || ins==5){
                pengWord=in.next();
                if(ins==3)
                    penglishDiction.declarePenglish(pengWord);
                else if(ins==4)
                    penglishDiction.removePenglish(pengWord);
                else if(ins==5)
                    penglishDiction.queryPenglish(pengWord);
            }
            else if(ins==6 || ins==7){
                engWord=in.next();
                pengWord=in.next();
                if(ins==6){
                    englishDiction.addPair(engWord, pengWord);
                    penglishDiction.addPair(pengWord, engWord);
                }else if(ins==7){
                    System.out.println("removePair kar nemikonad.");
                }
            }else  {
                System.out.println("Error! Try again");
                break;
            }                        
        }// for*/
    }// main
}

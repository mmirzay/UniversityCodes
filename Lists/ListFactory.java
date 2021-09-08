//////////////////////////////////////////////
class Node{
    private Node next;
    private Object element;
    Node(){
        this(null, null);
    }
    Node(Node no,Object ob){
        next=no;
        element=ob;
    }
    void setElement(Object ob){element=ob;}
    void setNextNode(Node no){next=no;}
    Object getElement(){return element;}
    Node getNextNode(){return next;}
}
///////////////////////////////
/*list yek sooye*/
class UnilateralList{
    Node firstNode;
    static int listSize=1;
    void createList(){
        firstNode=new Node();
        listSize=1;
    }
    int getSize(){return listSize;}
    boolean isEmpty(){
        return getSize()==0;
    }
    void insertFirstNode(Object ob) throws Exception{
        firstNode=new Node(getFirstNode(),ob);
        listSize++;
    }
    void insertAfterNode(Node no, Object ob) throws Exception{
        if(no==null)
            throw new Exception("Incorrect type node");
        no.setNextNode(new Node(no.getNextNode(), ob));
        listSize++;
    }
    void deleteFirstNode() throws Exception{
        if(isEmpty())
            throw new Exception("Removing First is Impossible");
        Node lastFirstNode;
        lastFirstNode=getFirstNode();
        firstNode=lastFirstNode.getNextNode();
        lastFirstNode=null;
        listSize--;
    }
    void deleteAfterNode(Node no) throws Exception{
        if(isEmpty() || no==null || no.getNextNode()==null)
            throw new Exception("Impossible removing");
        Node deletingNode;
        deletingNode=no.getNextNode();
        no.setNextNode(deletingNode.getNextNode());
        deletingNode=null;
        listSize--;
    }
    Node getFirstNode() throws Exception{
        if(getSize()==0)
            throw new Exception("List is Empty");
        return firstNode;
    }
    ///////////////////////////////////
    /*Baraks kardan*/
    Node resursiveReverse(Node p){
        if (p.getNextNode()==null || p==null ){
            System.out.println("p= "+p.getElement());
            return p;
        }
        //System.out.println("p out if= "+p.getElement());
        Node q= p.getNextNode();
        //System.out.println("q= "+q.getElement());
        Node r=resursiveReverse(q);
        //System.out.println("r= "+r.getElement());
        q.setNextNode(p);
        //System.out.println("new q= "+q.getElement());
        p.setNextNode(null);
        return r;
    }
    Node nonRecursiveReverce()throws Exception{
        if(getSize()<=1)
            return getFirstNode();
        Node p=null;
        Node q=getFirstNode();
        //System.out.println("first q= "+q.getElement());
        Node r=q.getNextNode();
        //System.out.println("first r= "+r.getElement());
        while (r!=null){
            //System.out.println("in while r= "+r.getElement());
            //System.out.println("in while q= "+q.getElement());
            q.setNextNode(p);
            //System.out.println("in while q.next= "+q.getNextNode());
            p=q;
            //System.out.println("in while p= "+p.getElement());
            q=r;
            //System.out.println("second q in while= "+q.getElement());
            //System.out.println("in while r.next= "+r.getNextNode().getElement());
            r=r.getNextNode();
            //System.out.println("new r in while= "+r.getElement());
        }
        //System.out.println("out of while q= "+q.getElement());
        //System.out.println("out of while q.next= "+q.getNextNode().getElement());
        //System.out.println("out of while p= "+p.getElement());
        q.setNextNode(p);
        //System.out.println("out of while second q.next= "+q.getNextNode().getElement());
        return q;
    }
    //////////////////////////////////////
    /* masaleye josefoos*/
    Object joesephouse(int n) throws Exception{
        Node q= new Node(null, 1);
        firstNode=q;
        Node p=q;
        for(int i=2;i<=n;i++){
            p.setNextNode(new Node(p.getNextNode(),i));
            p=p.getNextNode();
        }
        p.setNextNode(q);
        listSize=n;
        p=getFirstNode();
        while(p.getNextNode()!=p){
            //System.out.println("deleted p= "+p.getElement());
            deleteAfterNode(p);
            p=p.getNextNode();
            //System.out.println("new p= "+p.getElement());
        }
        return p.getElement();
    }
    ///////////////////////////////////////
}
/////////////////////////////////////////////
/*Liste 2sooye*/
class BilateralNode{
    private Object element;
    private BilateralNode next;
    private BilateralNode prev;

    public BilateralNode() {
        this(0 , null, null);
    }
    public BilateralNode(Object ob, BilateralNode nextNo, BilateralNode prevNo) {
        element = ob;
        next = nextNo;
        prev = prevNo;
    }
}
class BilateralList{
    BilateralNode firstNode2;
    static int listSize2;
    void createList2(){
        listSize2=0;
    }
    int getSize2(){
        return listSize2;
    }
    boolean isEmpty2(){
        return getSize2()==0;
    }
    void inserFirstNode2(Object ob){
        firstNode2=new BilateralNode(ob, firstNode2, firstNode2);
        listSize2++;
    }
    void insertAfterNode2(BilateralNode bino, Object ob)throws Exception{
        if(isEmpty2() || bino==null)
            throw new Exception("Bilateral Node is Null");
    }
}
/////////////////////////////////////////////
/* methode main ro khodet benewis, alaki neweshtam
 * fagat baraye teste barname bood */
public class ListFactory {
    static UnilateralList list1=new UnilateralList();
    public static void main(String[] args)throws Exception{
        System.out.println("list1.joesephouse(10)= "+list1.joesephouse(10));
       /*list1.createList();
        list1.insertFirstNode(1);
        list1.insertAfterNode(list1.getFirstNode(), 2);
        list1.insertAfterNode(list1.getFirstNode().getNextNode(), 3);
        list1.insertAfterNode(list1.getFirstNode().getNextNode().getNextNode(), 4);
        list1.insertAfterNode(list1.getFirstNode().getNextNode().getNextNode().getNextNode(), 5);
        System.out.println("first= "+list1.getFirstNode().getElement());
        System.out.println("second= "+list1.getFirstNode().getNextNode().getElement());
        System.out.println("third= "+list1.getFirstNode().getNextNode().getNextNode().getElement());
        System.out.println("fourth= "+list1.getFirstNode().getNextNode().getNextNode().getNextNode().getElement());
        System.out.println("fiveth= "+list1.getFirstNode().getNextNode().getNextNode().getNextNode().getNextNode().getElement());
        System.out.println("newFirst= "+list1.nonRecursiveReverce().getNextNode().getNextNode().getElement());
        //list1.resursiveReverse(list1.getFirstNode());
        //System.out.println("first= "+list1.getFirstNode().getElement());
        //System.out.println("second= "+list1.getFirstNode().getNextNode().getElement());
        //System.out.println("third= "+list1.getFirstNode().getNextNode().getNextNode().getElement());
        //System.out.println("fourth= "+list1.getFirstNode().getNextNode().getNextNode().getNextNode().getElement());
        //System.out.println("fiveth= "+list1.getFirstNode().getNextNode().getNextNode().getNextNode().getNextNode().getElement());
        */
    }
}

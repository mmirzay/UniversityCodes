class TreeNode{
    TreeNode leftNode;
    TreeNode rightNode;
    Object element;
    public TreeNode() {
        this(null,null,null);
    }

    public TreeNode(TreeNode leftNode, TreeNode rightNode, Object element) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.element = element;
    }
}
class Tree{
    TreeNode root;
    TreeNode parent;
    int stopper=0;
    int treeSize;
    static int nodeHeight=0;
    static int realHeight=0;

    public Tree() {this(null);}
    public Tree(TreeNode root) {this.root = root;}
    TreeNode getRoot(){return root;}
    TreeNode leftMostChild(TreeNode tn){return tn.leftNode;}
    TreeNode rightSibling(TreeNode tn){return tn.rightNode;}
    void preOrder(TreeNode pre){        
        if(pre==null)
            return;               
        System.out.print(pre.element+" ");
        preOrder(leftMostChild(pre));
        preOrder(rightSibling(pre));
    }
    void inOrder(TreeNode in){        
        if(in==null)            
            return;        
        inOrder(leftMostChild(in));
        System.out.print(""+in.element+" ");
        inOrder(rightSibling(in));
    }
    void postOrder(TreeNode pos){
        if(pos==null)
            return;
        postOrder(leftMostChild(pos));
        postOrder(rightSibling(pos));
        System.out.print(""+pos.element+" ");

    }
    int countTreeNode(TreeNode count){
        if(count==null)
            return 0;
        if(root==null){
            System.out.println("the Root of Tree is Null");
            return 0;
        }
        else{       
            treeSize=1;
            treeSize+=countTreeNode(count.leftNode);
            treeSize+=countTreeNode(count.rightNode);            
        }
        return treeSize;
    }
    int nodeHeight(TreeNode hg){
        if(stopper==0 && hg!=null){
            System.out.print("the Height of Tree Node ("+hg.element+") was Computted. ");
            stopper=1;
        }
        if(nodeHeight>=realHeight)
            realHeight=nodeHeight;
        if(hg.leftNode!=null){
            nodeHeight++;            
            nodeHeight(hg.leftNode);
        }
        if(hg.rightNode!=null){
            nodeHeight++;            
            nodeHeight(hg.rightNode);
        }
        nodeHeight--;        
        return realHeight;        
    }
    TreeNode nodeParent(TreeNode root, TreeNode node){
        if(root==node){
            return null;
        }
        if(root.leftNode!=null){
            if(root.leftNode.leftNode==node || root.leftNode.rightNode==node)
                parent=root.leftNode;
            nodeParent(root.leftNode, node);
        }
        if(root.rightNode!=null){
            if(root.rightNode.leftNode==node || root.rightNode.leftNode==node)
                parent=root.rightNode;
            nodeParent(root.rightNode, node);
        }        
        return parent;
    }
}
public class Derakht {        
    static TreeNode h=new TreeNode(null, null, "h");
    static TreeNode g=new TreeNode(null, null, "g");
    static TreeNode f=new TreeNode(g, h, "f");
    static TreeNode m=new TreeNode(null, null, "m");
    static TreeNode l=new TreeNode(null, null, "l");
    static TreeNode i=new TreeNode(l, m, "i");
    static TreeNode e=new TreeNode(i, null, "e");
    static TreeNode d=new TreeNode(null, e, "d");
    static TreeNode c=new TreeNode(f, d, "c");        
    static TreeNode b=new TreeNode(null, c, "b");
    static TreeNode o=new TreeNode(null, null, "o");
    static TreeNode r=new TreeNode(null, null, "r");
    static TreeNode q=new TreeNode(null, r, "q");
    static TreeNode p=new TreeNode(null, null, "p");
    static TreeNode n=new TreeNode(p, q, "n");
    static TreeNode k=new TreeNode(o, n, "k");
    static TreeNode a=new TreeNode(b, k, "a");
    static Tree myTree= new Tree(a);
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("preORDER: ");
        myTree.preOrder(a);
        System.out.println("");
        System.out.println("inORDER: ");
        myTree.inOrder(a);
        System.out.println("");
        System.out.println("postORDER: ");
        myTree.postOrder(a);
        System.out.println("");
        System.out.println("Computation of Tree Nodes: "+myTree.countTreeNode(a));        
        System.out.println("Height of the Node: "+myTree.nodeHeight(a));
        TreeNode temp=myTree.nodeParent(a, g);
        if(temp!=null)
            System.out.println("parent= "+temp.element);
    }
}

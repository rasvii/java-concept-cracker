package src.main.dsa.datastructure.BinaryTree;

public class BinaryTreeMain {
    public static void main(String[] args){
        firstActions();
    }
    
    private static void firstActions(){
        int[] nodes = {50, 34, 24, 59, 30, 69, 11};
        BinaryTree tree = new BinaryTree();
        tree.buildTree(nodes);
        tree.print(TraversalEnums.INORDER); 
        tree.print(TraversalEnums.PRE_ORDER);
        tree.print(TraversalEnums.POST_ORDER);
    }
}

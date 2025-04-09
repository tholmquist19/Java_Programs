public class BinaryTree {

    Node root;
    public static class Node {
        int key;
        Node left;
        Node right;

        Node(int value) {
            this.key = value;
            this.right = null;
            this.left = null;
        }
    }



    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.key) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.key) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(BinaryTree b, int value) {
        b.root = addRecursive(b.root, value);
    }

    public void copyTree(BinaryTree newTree, Node root){
        if (root==null)
            return;
        newTree.add(newTree, root.key);
        if(root.right != null)
            copyTree(newTree, root.right);
        if(root.left!=null)
            copyTree(newTree, root.left);
    }

    public void copyTree2(Node root){
        BinaryTree newTree = new BinaryTree();
        if (root==null)
            return;
        newTree.add(newTree, root.key);
        if(root.right != null)
            copyTree(newTree, root.right);
        if(root.left!=null)
            copyTree(newTree, root.left);
    }


    public static void main(String[] argv) {
        BinaryTree bt = new BinaryTree();
        BinaryTree nt = new BinaryTree();
        //bt.root = new Node(3);
        bt.add(bt,6);
        bt.add(bt, 4);
        bt.add(bt, 8);
        bt.add(bt, 3);
        bt.add(bt, 5);
        bt.add(bt, 7);
        bt.add(bt, 9);
        System.out.println(bt.root.left.key);
        nt.copyTree2(bt.root);
        System.out.println(nt.root.left.key);

    }//end of main

}

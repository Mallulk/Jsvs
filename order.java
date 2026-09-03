public class order {
    public static void main(String[] args) {
        order o = new order();
        tnode root = new tnode(1);
        root.left = new tnode(2);
        root.right = new tnode(3);
        root.left.left = new tnode(4);
        root.left.right = new tnode(5);

        System.out.println("Inorder traversal:");
        o.inorder(root);
        System.out.println("\nPreorder traversal:");
        o.preorder(root);
        System.out.println("\nPostorder traversal:");
        o.postorder(root);
    }
    void inorder(tnode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    void preorder(tnode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(tnode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

class tnode {
    int data;
    tnode left;
    tnode right;
    
    tnode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
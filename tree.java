import java.util.Scanner;

public class tree {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root = null;

    // 1. INSERT
    static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } 
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // 2. TREE TRAVERSALS

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // 3. MINIMUM
    static int min(Node root) {

        if (root == null) {
            return -1;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    // 4. MAXIMUM
    static int max(Node root) {

        if (root == null) {
            return -1;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    // 5. COUNT NODES
    static int count(Node root) {

        if (root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    // 6. SEARCH - BOOLEAN
    static boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // 7. DELETE
    static Node delete(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            root.data = min(root.right);

            root.right = delete(root.right, root.data);
        }

        return root;
    }

    // 8. HEIGHT
    static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BINARY SEARCH TREE =====");
            System.out.println("1. Insert");
            System.out.println("2. Tree Traversal");
            System.out.println("3. Minimum");
            System.out.println("4. Maximum");
            System.out.println("5. Count Nodes");
            System.out.println("6. Search (Boolean)");
            System.out.println("7. Delete");
            System.out.println("8. Height");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    root = insert(root, value);

                    System.out.println("Inserted successfully.");
                    break;

                case 2:
                    System.out.println("\nInorder:");
                    inorder(root);

                    System.out.println("\nPreorder:");
                    preorder(root);

                    System.out.println("\nPostorder:");
                    postorder(root);

                    System.out.println();
                    break;

                case 3:
                    System.out.println("Minimum = " + min(root));
                    break;

                case 4:
                    System.out.println("Maximum = " + max(root));
                    break;

                case 5:
                    System.out.println("Number of nodes = " + count(root));
                    break;

                case 6:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();

                    if (search(root, key)) {
                        System.out.println("true - Element found");
                    } else {
                        System.out.println("false - Element not found");
                    }
                    break;

                case 7:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = sc.nextInt();

                    if (search(root, deleteValue)) {
                        root = delete(root, deleteValue);
                        System.out.println("Deleted successfully.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 8:
                    System.out.println("Height = " + height(root));
                    break;

                case 9:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
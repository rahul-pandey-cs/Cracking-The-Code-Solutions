
public class RightViewTree {

    Node root;
    static int max_level;

    void printRightView(Node root, int level) {

        if (root == null)
            return;

        if (max_level < level) {
            System.out.println(root.data);
            max_level = level;
        }
        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);

    }

    void printLeftView(Node root, int level) {

        if (root == null)
            return;

        if (max_level < level) {
            System.out.println(root.data);
            max_level = level;
        }
        printRightView(root.left, level + 1);
        printRightView(root.right, level + 1);

    }

    void rightView() {
        printRightView(root, 1);
    }


    public static void main(String args[]) {

        RightViewTree tree = new RightViewTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        //tree.root.right.right = new Node(7);
        tree.root.right.left.left = new Node(8);
        tree.root.right.left.left.left = new Node(9);

        System.out.println("Right View is: ");
        tree.printRightView(tree.root, 1);

        max_level=0;
        System.out.println("Left View is: ");
        tree.printLeftView(tree.root, 1);

    }
}

class Node {
    int data;
    Node left, right;

    Node(int n) {
        this.data = n;
        this.left = null;
        this.right = null;
    }
}

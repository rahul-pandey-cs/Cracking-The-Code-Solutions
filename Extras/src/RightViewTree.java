import com.sun.source.tree.BinaryTree;

// class to access maximum level by reference
class Max_level {

    int max_level;
}

public class RightViewTree {

    Node root;
    Max_level max = new Max_level();

    void printRightView(Node root, int level, Max_level maxLevel) {

        if (root == null)
            return;

        if (maxLevel.max_level < level) {
            System.out.println(root.data);
            maxLevel.max_level = level;
        }
        printRightView(root.right, level + 1, maxLevel);
        printRightView(root.left, level + 1, maxLevel);

    }

    void rightView() {
        printRightView(root, 1, max);
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

        tree.rightView();

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

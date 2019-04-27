
public class MirrorTree {


    class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            right = left = null;
        }

    }

    class MirrorBinaryTree {

        Node tree;


        Node Mirror(Node root) {

            if (root == null)
                return root;

            Node leftTree = Mirror(root.left);
            Node rightTree = Mirror(root.right);

            root.left = rightTree;
            root.right = leftTree;

            return root;
        }
    }

}

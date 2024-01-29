package bst;

public class BinarySearchTree {
    Node root;

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node currentNode, int data) {
        if(currentNode == null) {
            currentNode = new Node(data);
        } else if(currentNode.data > data) {
            currentNode.left = insertHelper(currentNode.left, data);
        } else {
            currentNode.right = insertHelper(currentNode.right, data);
        }

        return currentNode;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node currentNode) {
        if(currentNode == null) {
            return;
        }

        displayHelper(currentNode.left);
        System.out.println(currentNode.data);
        displayHelper(currentNode.right);
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node currentNode, int data) {
        if(currentNode == null) {
            return false;
        }

        if(currentNode.data == data) {
            return true;
        } else if(currentNode.data > data) {
            return searchHelper(currentNode.left, data);
        } else {
            return searchHelper(currentNode.right, data);
        }
    }

    public void remove(int data) {
        if(search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " cannot find.");
        }
    }

    private Node removeHelper(Node currentNode, int data) {
        if(currentNode == null) {
            return null;
        }

        if(currentNode.data == data) {
            if(currentNode.left == null && currentNode.right == null) {
                currentNode = null;
            } else if(currentNode.right != null) {
                currentNode.data = successor(currentNode);
                currentNode.right = removeHelper(currentNode.right,currentNode.data);
            } else {
                currentNode.data = predecessor(currentNode);
                currentNode.left = removeHelper(currentNode.left,currentNode.data);
            }
        } else if(currentNode.data > data) {
            currentNode.left = removeHelper(currentNode.left, data);
        } else {
            currentNode.right = removeHelper(currentNode.right, data);
        }

        return currentNode;
    }

    private int successor(Node currentNode) {
        currentNode = currentNode.right;

        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.data;
    }

    private int predecessor(Node currentNode) {
        currentNode = currentNode.left;

        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.data;
    }
}

package stack.mystack;

public class Node {
    int value;
    Node beforeNode;
    public Node(int value) {
        this.value = value;
        this.beforeNode = null;
    }

    public int getValue(){
        return this.value;
    }

    public Node getNextNode() {
        return this.beforeNode;
    }
}

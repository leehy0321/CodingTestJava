package stack.mystack;


public class MyStackUsingLinkedList {

    Node top;

    public MyStackUsingLinkedList() {
        top = null;
    }
    public void push(int value) {
        Node newNode = new Node(value);

        if(top != null) {
            newNode.beforeNode = top;
        }

        top = newNode;
    }

    public int pop() {
        int popValue = 0;

        if(top != null) {
            popValue = top.value;
            top = top.beforeNode;
        }

        return popValue;
    }
    public int peek() {
        return top.value;
    }


}

import stack.mystack.MyStackUsingArray;
import stack.mystack.MyStackUsingLinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // check my stack using Array
        MyStackUsingArray stackUsingArray = new MyStackUsingArray(3);

        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);

        int value = stackUsingArray.pop();
        value = stackUsingArray.pop();
        value = stackUsingArray.peek();

        // check my stack using LinkedList
        MyStackUsingLinkedList stackLinkedList = new MyStackUsingLinkedList();

        stackLinkedList.push(1);
        stackLinkedList.push(2);
        stackLinkedList.push(3);

        value = stackLinkedList.pop();
        value = stackLinkedList.pop();
        value = stackLinkedList.peek();

        // check origin stack
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        value = stack.pop();
        value = stack.pop();
        value = stack.peek();


    }
}
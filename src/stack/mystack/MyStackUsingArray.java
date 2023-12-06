package stack.mystack;

public class MyStackUsingArray {
    private int stackMaxSize;
    private int[] stackArray;
    private int topIndex;

    public MyStackUsingArray(int stackSize) {
        this.stackMaxSize = stackSize;
        this.stackArray = new int[stackMaxSize];
        this.topIndex = -1;
    }
    public boolean push(int val) {
        if (topIndex < stackMaxSize - 1) {
            stackArray[++topIndex] = val;
            return true;
        }

        return false;
    }
    public int pop() {
        int popValue = -1;
        if(topIndex > -1) {
            popValue = stackArray[topIndex];
            stackArray[topIndex--] = 0;
        }

        return popValue;
    }

    public int peek() {
        if(topIndex > -1) {
            return stackArray[topIndex];
        }

        return -1;
    }
}

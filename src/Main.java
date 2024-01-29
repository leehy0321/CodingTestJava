import bst.BinarySearchTree;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree solution = new BinarySearchTree();

        solution.insert(5);
        solution.insert(9);
        solution.insert(1);
        solution.insert(7);
        solution.insert(3);
        solution.insert(2);
        solution.insert(8);
        solution.insert(6);
        solution.insert(4);

      //  solution.display();

        solution.remove(9);
        solution.display();
    }
}
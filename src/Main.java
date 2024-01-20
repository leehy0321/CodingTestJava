import dfs.Solution_0119;
import dfs.TreeNode;
public class Main {
    public static void main(String[] args) {
        Solution_0119 solution = new Solution_0119();

        /*
        TreeNode tree = new TreeNode(1,new TreeNode(2, new TreeNode(3, null, new TreeNode(4, new TreeNode(5, null, null), new TreeNode(6, null, null))), null),null);
        List<Integer> answer = solution.Solution94(tree);
        */

        TreeNode tree = new TreeNode(4, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(5, null, null)), new TreeNode(9, null, new TreeNode(7, null, null)));
        int answer = solution.Solution563(tree);

    }
}
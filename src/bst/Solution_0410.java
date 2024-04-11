package bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_0410 {

    // way 1.
    Map<Integer, Integer> map = new HashMap<>();

    public int[] Solution501(TreeNode root) {
        checkTree(root);

        int maxCount = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
            if (maxCount < map.get(key)) {
                maxCount = map.get(key);
                result.clear();
                result.add(key);
            } else if (maxCount == map.get(key)) {
                result.add(key);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void checkTree(TreeNode node) {
        if (node == null) return;

        int count = map.get(node.val) == null ? 0 : map.get(node.val);
        map.put(node.val, ++count);

        checkTree(node.left);
        checkTree(node.right);
    }

    // way2.
    List<Integer> values = new ArrayList<>();
    int count, parentValue = 0, maxCount;

    public int[] Solution501Way2(TreeNode root) {
        checkNode(root);

        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private void checkNode(TreeNode node) {
        if (node == null) return;

        checkNode(node.left);

        if (node.val == parentValue) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            maxCount = count;
            values.clear();
            values.add(node.val);
        } else if (count == maxCount) {
            values.add(node.val);
        }

        parentValue = node.val;
        checkNode(node.right);
    }
}

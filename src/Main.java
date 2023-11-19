import array_list.Solution_1118;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Solution_1118 solution = new Solution_1118();

//        String input5 = "bbbb";
//        String a5 = solution.Solution5(input5);

//        int[] nums = {1000000000,1000000000,1000000000,1000000000};
//        int target = -294967296;
//        List<List<Integer>> a18 = solution.Solution18(nums,target);

        int[] nums = {5,2,5,3,5,3,1,1,3};
        int k = 2;
        int[] a347 = solution.Solution347(nums, k);
    }
}
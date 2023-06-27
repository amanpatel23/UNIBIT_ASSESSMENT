import java.io.*;
import java.util.*;

public class UNIBIT_ASSESSMENT_SOLUTION {
    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        List<List<Integer>> result_list = solve(nums, target);

        for (List<Integer> list : result_list) {
            System.out.println(list);
        }

    }

    private static List<List<Integer>> solve(int[] nums, int target) {

        // get the pair sum 2-d list
        List<int[]> pair_sum_list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    pair_sum_list.add(new int[]{nums[i], nums[j]});
                }
            }
        }

        // converting list of arrays(pair_sum_list) to list of integers by merging the arrays
        List<Integer> merged_list = new ArrayList<>();
        for (int[] curr_arr : pair_sum_list) {
            merged_list.add(curr_arr[0]);
            merged_list.add(curr_arr[1]);
        }

        // sorting the merged list
        Collections.sort(merged_list);

        // double the target
        int doubled_target = 2 * target;

        List<List<Integer>> result_list = new ArrayList<>();
        // storing all the combinations of nums that sum to doubled_target
        find_all_combinations(0, merged_list, doubled_target, new ArrayList<>(), result_list);


        return result_list;
    }

    private static void find_all_combinations(int i, List<Integer> merged_list, int target,
                                              List<Integer> curr_list, List<List<Integer>> result_list) {

        // base case
        if (i == merged_list.size()) {
            int sum = 0;
            for (int num : curr_list) sum += num;
            if (sum == target) {
                // if the curr_list nums sum equals to the target sum
                result_list.add(new ArrayList<>(curr_list));
            }

            return;
        }

        // don't take the current num
        find_all_combinations(i + 1, merged_list, target, curr_list, result_list);

        // take the current num
        curr_list.add(merged_list.get(i));
        find_all_combinations(i + 1, merged_list, target, curr_list, result_list);
        curr_list.remove(curr_list.get(curr_list.size() - 1));
    }
}
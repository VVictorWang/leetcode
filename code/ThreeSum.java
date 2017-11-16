
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by victor on 9/6/17.
 * email: chengyiwang@hustunque.com
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
*
 *Note: The solution set must not contain duplicate triplets.
*
 *For example, given array S = [-1, 0, 1, 2, -1, -4],
*
 *A solution set is:
 *[
 *[-1, 0, 1],
 *[-1, -1, 2]
 *]
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //convert the array to a sorted array
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {      // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1; 
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public  List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums); // convert the array to a sorted array
    for (int m = 0; m + 3 < nums.length; m++) {
      if (m > 0 && nums[m] == nums[m - 1]) //skip the same result
        continue;
      for (int i = m + 1; i + 2 < nums.length; i++) {
        if (i > m + 1 && nums[i] == nums[i - 1]) { // skip the same result
          continue;
        }
        int j = i + 1, k = nums.length - 1;
        int temp = nums[i] + nums[m];
        while (j < k) {
          if (nums[j] + nums[k] + temp == target) {
            res.add(Arrays.asList(nums[m], nums[i], nums[j], nums[k]));
            j++;
            k--;
            while (j < k && nums[j] == nums[j - 1])
              j++; // skip same result
            while (j < k && nums[k] == nums[k + 1])
              k--; // skip same result
          } else if (nums[j] + nums[k] + temp > target) {
            k--;
          } else {
            j++;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 0, 0, 0};
    System.out.println(new FourSum().fourSum(nums, 0));
  }
}
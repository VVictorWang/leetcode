import java.util.Arrays;

public class ThreeSumClosetst {
  public static int threeSumClosest(int[] nums, int target) {
    int result = 65536;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int diff = Math.abs(target - (nums[i] + nums[j] + nums[k]));
        if (diff < Math.abs(result - target)) {
          result = nums[i] + nums[j] + nums[k];
        }
        if (j >= nums.length - 1 && k <= 0) {
          continue;
        } else if (j >= nums.length - 1 && k >= 0) {
          k--;
        } else if (j < nums.length - 1 && k <= 0) {
          j++;
        } else {
          int diff1 = Math.abs(target - (nums[i] + nums[j + 1] + nums[k]));
          int diff2 = Math.abs(target - (nums[i] + nums[j] + nums[k - 1]));
          if (diff1 < diff2)
            j++;
          else
            k--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.print(threeSumClosest(new int[] {-1, 2, 1, -1,3,5}, 1));
  }
}
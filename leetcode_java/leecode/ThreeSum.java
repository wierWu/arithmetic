package leecode;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * three sum 算法
 *
 * 给定一个n个整数的数组S，是否存在S中的元素a，b，c，使得a + b + c = 0？查找数组中所有唯一的三元组，它们的总和为零。
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/3sum/description/
 * @since 1.0
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == nums || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //剔除相同的，相同必然组合相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int sum = target - nums[i];
            while (left < right) {
                int kSum = nums[left] + nums[right];
                if (kSum == sum) {
                    List<Integer> group = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(group);

                    //剔除相同的数字，相同必然组合相同
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (kSum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 1, 1, 1, 2, -1, -1, -1, -4};
        int[] nums = {-1, -1, 0, 0, 1, 2, 2, 2, 2, -2, -4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(nums, 0);
        for (List<Integer> sigRes : res) {
            for (int i : sigRes) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}

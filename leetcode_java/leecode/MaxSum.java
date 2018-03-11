package leecode;

/**
 * 在数组中找到连续的子数组（至少包含一个数字），这个数组的总和最大。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/maximum-subarray/description/
 * @since 1.0
 */
public class MaxSum {

    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums
                ) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }


        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, 2, 2, 0, 1, 0, 2, 1};
        int[] nums = {1, 0, 2, 2, -2, 1, 0, 2, 1};

        MaxSum maxSum = new MaxSum();
        System.out.print(maxSum.maxSubArray(nums));
    }
}

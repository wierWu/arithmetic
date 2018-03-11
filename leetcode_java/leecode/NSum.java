package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * N sum 的问题，
 * 给定一个n个整数的数组S，是否存在S中的预算a[0]...a[n]，使得a[0] + a[1] ...a[n] = 0？查找数组中所有唯一的N元组，它们的总和为零。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
 * @since 1.0
 */
public class NSum {

    public List<List<Integer>> nSum(int[] nums, int target, int nNum, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int leg = nums.length;

        //解决为2Sum的问题
        if (nNum == 2) {
            int left = start;
            int right = leg - 1;
            while (left < right) {
                int sum = target - nums[left];
                if (nums[right] == sum) {
                    List<Integer> group = new ArrayList<Integer>();
                    group.add(nums[left]);
                    group.add(nums[right]);
                    res.add(group);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }

            return res;
        }

        for (int i = start; i < leg - nNum + 1; i++) {
            if (i > start&& nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> subRes = nSum(nums, target - nums[i], nNum - 1, i + 1);
            for (List<Integer> group : subRes
                    ) {
                group.add(0, nums[i]);
            }

            res.addAll(subRes);
        }

        return res;
    }


    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 1, 1, 1, 2, -1, -1, -1, -4};
//        int[] nums = {-1, -1, 0, 0, 1, 2, 2, 2, 2, -2, -4};
        int[] nums = {1,0,-1,0,-2,2};

        NSum threeSum = new NSum();
        Arrays.sort(nums);
        List<List<Integer>> res = threeSum.nSum(nums, 0, 4, 0);
        for (List<Integer> sigRes : res) {
            for (int i : sigRes) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}

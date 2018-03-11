package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给出两个字符串，找到最长公共子串，并返回其长度。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link http://www.cnblogs.com/theskulls/p/5134361.html
 * @since 1.0
 */
public class LongestCommonSubstring {

    /**
     * 给出两个字符串，找到最长公共子串（子串是连续的）
     *
     * @param strA
     * @param strB
     * @return
     */
    public int longestCommonSubstring(String strA, String strB) {
        if (strA == null || strA.trim().equals("") || strB == null || strB.equals("")) {
            return 0;
        }

        int longest = -1;
        int aLeg = strA.length();
        int bLeg = strB.length();
        //考虑矩阵的对角线问题，是一条斜线的话，必定是连续的字符串。
        //子串一定在对角线上，连续对角线上1最多的那个就是最长的子串，子串的起始位置就是左上的第一个1，结束位置就是右下的最后一个一，暴力方法就是对每一个点开始的对角线1的个数，最大值就是答案，
        int[][] matrices = new int[aLeg + 1][bLeg + 1];

        for (int i = 1; i <= aLeg; i++) {
            for (int j = 1; j <= bLeg; j++) {
                char charA = strA.charAt(i - 1);
                char charB = strB.charAt(j - 1);
                if (charA == charB) {
                    matrices[i][j] = matrices[i - 1][j - 1] + 1;
                } else {
                    matrices[i][j] = 0;
                }

                if (matrices[i][j] > longest) {
                    longest = matrices[i][j];
                }
            }
        }
        return longest;
    }

    /**
     * 最长公共子序列
     * 给出两个字符串，找到最长公共子序列(LCS,LCS不需要是连续的子串)，返回LCS的长度。
     *
     * @param strA
     * @param strB
     * @return
     * @link http://www.cnblogs.com/theskulls/p/5131767.html
     */
    public int longestCommonSubsequence(String strA, String strB) {
        if (strA == null || strA.trim().equals("") || strB == null || strB.equals("")) {
            return 0;
        }

        int aLeg = strA.length();
        int bLeg = strB.length();

        int[][] matrices = new int[aLeg + 1][bLeg + 1];

        for (int i = 1; i <= aLeg; i++) {
            for (int j = 1; j <= bLeg; j++) {
                char charA = strA.charAt(i - 1);
                char charB = strB.charAt(j - 1);
                if (charA == charB) {
                    matrices[i][j] = matrices[i - 1][j - 1] + 1;
                } else {
                    matrices[i][j] = Math.max(matrices[i][j - 1], matrices[i - 1][j]);
                }
            }
        }

        return matrices[aLeg][bLeg];
    }

    /**
     * 最长公共子序列(递归二叉树搜索)
     * 给出两个字符串，找到最长公共子序列(LCS,LCS不需要是连续的子串)，返回LCS的长度。
     *
     * @param strA
     * @param strB
     * @return
     * @link http://www.cnblogs.com/theskulls/p/5131767.html
     */
    public int longestCommonSubsequenceByBinary(String strA, String strB) {
        if (strA == null || strA.trim().equals("") || strB == null || strB.equals("")) {
            return 0;
        }

        int aLeg = strA.length();
        int bLeg = strB.length();

        if (aLeg < 1 || bLeg < 1) {
            return 0;
        }

        char charA = strA.charAt(0);
        char charB = strB.charAt(0);
        if (charA == charB) {
            String subA = strA.substring(1);
            String subB = strB.substring(1);
            return 1 + longestCommonSubsequenceByBinary(subA, subB);
        } else {
            String subA = strA.substring(1);
            String subB = strB.substring(1);
            int lefLongest = longestCommonSubsequence(strA, subB);
            int rgtLongest = longestCommonSubsequence(strB, subA);
            return Math.max(lefLongest, rgtLongest);
        }
    }


    /**
     * 最长上升子序列
     * <p>
     * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
     * 样例
     * 给出[5,4,1,2,3]，这个LIS是[1,2,3]，返回 3
     * 给出[4,2,4,5,3,7]，这个LIS是[4,4,5,7]，返回 4
     * <p>
     * 定义一个数组，A，A[i] 表示到达当前 i 位置 的某种 意义，如：最大值个数，最小值个数，长度等等。
     * <p>
     * 这里也是定义一个数组sublongest sublongest[i] 表示到i 位置的最长升序子序列的长度。
     * <p>
     * 到达第i 个元素的最长子序列长度是 sublongest[i]  ，则到达第 i + 1 个元素的最长子序列长度 sublongest[i + 1 ]  =   nums[j] <= nums[i] 时候的最长子序列长度 + 1
     *
     * @param nums
     * @return
     * @link http://www.cnblogs.com/theskulls/p/5128694.html
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }


        int maxDp = 0;
        //// 记录到当前位置最长升序序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int subMax = 0;
            for (int j = 0; j < i; j++) {
                // nums[i] 前面有几个比自己小的数 比自己小的那个数到自己就是一个递增序列
                // sublongest[j]  j 这个下标对应 nums[j] 这个元素的，
                if (nums[j] <= nums[i]) {
                    subMax = Math.max(subMax, dp[j]);
                }
            }

            dp[i] = subMax + 1;
            maxDp = Math.max(maxDp, dp[i]);
        }

        return maxDp;
    }

    /**
     * 最长上升子序列（二分查找）
     * 这里是定义一个List数组，存储这个升序子序列，并且还是动态变化的，对于新来的元素，如果>=最后一个元素，直接插入。如果小于，
     * 通过二分查找，找到List中第一个大于这个元素的数据，直接替换
     *
     * @param nums
     * @return
     */
    public int longestIncreasingSubsequenceBySearch(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        List<Integer> sortList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (sortList.isEmpty() || sortList.get(sortList.size() - 1) <= nums[i]) {
                sortList.add(nums[i]);
            } else {
                int repartIndex = findFristLargeIndex(sortList, nums[i]);
                sortList.set(repartIndex, nums[i]);
            }
        }

        return sortList.size();

    }

    /**
     * 二分查找
     *
     * @param numList
     * @param targetNum
     * @return
     */
    private int findFristLargeIndex(List<Integer> numList, int targetNum) {
        int left = 0;
        int right = numList.size() - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (numList.get(mid) <= targetNum) {
                left++;
            } else {
                right = mid;
            }
        }

        return left;
    }


    /**
     * 求最长连续序列，并给定了O(n)复杂度限制。
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     *
     * @param nums
     * @return
     * @link http://www.cnblogs.com/grandyang/p/4276225.html
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int num : nums) {
            s.add(num);
        }

        int bestLeg = 0;
        for (int num : nums) {

            if (s.remove(num)) {
                int pre = num - 1;
                int next = num + 1;
                while (s.remove(pre)) pre--;
                while (s.remove(next)) next++;
                bestLeg = Math.max(bestLeg, next - pre + 1);
            }
        }

        return bestLeg;
    }

    /**
     * 求最长连续序列，并给定了O(n)复杂度限制。
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     *
     * @param nums
     * @return
     * @link http://www.cnblogs.com/grandyang/p/4276225.html
     */
    public int longestConsecutiveByMap(int[] nums) {
        int bestLeg = 0;
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num)) continue;
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;
            m.put(num, sum);
            bestLeg = Math.max(bestLeg, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }

        return bestLeg;
    }

    public static void main(String[] args) {
        String A = "ABCD";
        String B = "BCED";
        System.out.println(new LongestCommonSubstring().longestCommonSubstring(A, B));
        System.out.println(new LongestCommonSubstring().longestCommonSubsequence(A, B));
        System.out.println(new LongestCommonSubstring().longestCommonSubsequenceByBinary(A, B));

        int[] nums = {5, 4, 1, 2, 1, 4, 4};
        System.out.println("longestIncreasingSubsequence");
        System.out.println(new LongestCommonSubstring().longestIncreasingSubsequence(nums));
        System.out.println("longestIncreasingSubsequenceBySearch");
        System.out.println(new LongestCommonSubstring().longestIncreasingSubsequenceBySearch(nums));
    }
}

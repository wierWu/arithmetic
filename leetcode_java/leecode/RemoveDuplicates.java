package leecode;

/**
 * 跟进“删除重复”： 如果重复最多允许两次
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @Link https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * @since 1.0
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums, int duplicateNum) {
        int i = 0;
        for (int n : nums)
            if (duplicateNum < 1 || i < duplicateNum || n > nums[i - duplicateNum])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int leg = duplicates.removeDuplicates(nums, 2);
        System.out.println(leg);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");

        }
    }
}

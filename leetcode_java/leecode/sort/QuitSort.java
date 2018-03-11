package leecode.sort;

/**
 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class QuitSort {


    public void quitSort(int[] nums, int left, int right) {
//        if (right <= left) {
//            return;
//        }
        if (left < right) {
            int mid = getMid(nums, left, right);
            quitSort(nums, left, mid - 1);
            quitSort(nums, mid + 1, right);
        }
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int getMid(int[] nums, int left, int right) {
        int mid = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= mid) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }

            while (left < right && nums[left] <= mid) {
                left++;
            }

            if (left < right) {
                nums[right--] = nums[left];
            }
        }

        nums[left] = mid;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 1, 3, 2, 7, 5, 2, 8};
        QuitSort quitSort = new QuitSort();
        quitSort.quitSort(nums, 0, nums.length - 1);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");
        }
    }
}

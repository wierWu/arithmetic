package leecode.array;

/**
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link http://blog.csdn.net/taotaoah/article/details/49045425
 * @since 1.0
 */
public class MinInOrder {

    public int min(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int index1 = 0;
        int index2 = nums.length - 1;

        //解决有可能本身就是一个有序数组比如{1,2,3,4,5}
        int mid = index1;

        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }

            mid = (index1 + index2) / 2;

            //如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素。此时数组中最小的元素应该位于该中间元素的后面
            //如果中间元素位于后面的递增子数组，那么它应该小于或者等于第二个指针指向的元素
            if (nums[mid] >= nums[index1]) {
                index1 = mid;
            } else if (nums[mid] <= nums[index2]) {
                index2 = mid;
            }
        }

        return nums[mid];

    }


    /**
     * 解决有连续相同的的数字
     * <p>
     * 比如 :数组{1,0,1,1,1}和数组{1,1,1,0,1}都可以看成是递增排序数组{0,1,1,1,1}的旋转
     *
     * @param nums
     * @return
     */
    public int min2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int index1 = 0;
        int index2 = nums.length - 1;

        //解决有可能本身就是一个有序数组比如{1,2,3,4,5}
        int mid = index1;

        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }

            mid = (index1 + index2) / 2;
//比如 :数组{1,0,1,1,1}和数组{1,1,1,0,1}都可以看成是递增排序数组{0,1,1,1,1}的旋转
            if (nums[index1] == nums[index2] && nums[index2] == nums[mid]) {
                return minInOrder(nums, index1, index2);
            }

            //如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素。此时数组中最小的元素应该位于该中间元素的后面
            //如果中间元素位于后面的递增子数组，那么它应该小于或者等于第二个指针指向的元素
            if (nums[mid] >= nums[index1]) {
                index1 = mid;
            } else if (nums[mid] <= nums[index2]) {
                index2 = mid;
            }
        }

        return nums[mid];
    }


    private int minInOrder(int[] nums, int index1, int index2) {
        int resut = nums[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (resut > nums[i]) {
                resut = nums[i];
            }
        }

        return resut;
    }
}

package leecode;

/**
 * Sort Colors
 * 给定一个带有红色，白色或蓝色的n个对象的数组，对它们进行排序，使相同颜色的对象相邻，颜色顺序为红色，白色和蓝色。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/leecode.sort-colors/description/
 * @since 1.0
 */
public class ColorSort {

    public void sortColors(int[] nums) {
        int red = 0, whihte = 0, blue = 0;
        for (int num : nums
                ) {
            switch (num) {
                case 0:
                    red++;
                    break;
                case 1:
                    whihte++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            } else if (i < red + whihte) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int red = 0, white = 0;
        for (int i = 0; i < nums.length; i++) {
            int color = nums[i];
            //值范围越广，++越多，保证大数在后面
            nums[i] = 2;
            if (color < 2) {
                nums[white] = 1;
                white++;
            }

            if (color < 1) {
                nums[red] = 0;
                red++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, 2, 2, 0, 1, 0, 2, 1};
        int[] nums = {1, 0, 2, 2, 0, 1, 0, 2, 1};
        ColorSort colorSort = new ColorSort();
//        colorSort.sortColors(nums);
        colorSort.sortColors2(nums);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");

        }
    }
}

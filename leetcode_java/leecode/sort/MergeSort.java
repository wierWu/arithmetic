package leecode.sort;

/**
 * 归并排序
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class MergeSort implements Sort {

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }


    private void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, right, mid);
        }
    }

    private void merge(int[] nums, int left, int right, int mid) {
        // 定义一个辅助数组，所以该算法的空间复杂度为O（n）
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;


        // 找出较小值元素放入temp数组中
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }


        //处理较长部分
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 使用temp中的元素覆盖nums中元素
        for (int l = 0; l < temp.length; l++) {
            nums[l + left] = temp[l];
        }

        for (int l = 0; l < temp.length; l++) {
            nums[l + left] = temp[l];
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 9, 1, 3, 2, 7, 5, 2, 8};
        MergeSort sort = new MergeSort();
        sort.sort(nums);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");
        }
    }

}

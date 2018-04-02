package offer.array;

import java.util.Comparator;

/**
 * 把数组排成最小的数
 *
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-thirty-three.html
 */
public class PrintMinNumForArr {

    public class MyCommper implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            if (o1==null||o2==null){
                throw  new RuntimeException(" str not empty!");
            }
            return o1.compareTo(o2);
        }
    }

    /**
     * 根据题目的要求，两个数字 m 和 n 能拼接成数字 m 和 m。如果 mn < nm，那么我们应该打印出 m，也就是 m 应该排在 n 的前面，我们定义此时 m 小于 n：反之，如果 nm < mn，我们定义 n 小于 m。如果 mn=nm，m 等于 n。在下文中，符号“<”、“>”及“＝”表示常规意义的数值的大小关系，而文字“大于”、“小于”、“等于”表示我们新定义的大小关系。
     * @param nums
     * @param left
     * @param right
     * @param comparator
     */

    public void printMinNum(String [] nums,int left,int right,Comparator<String> comparator){

        if (left<right){
            int start =left;
            int end=right;
            String mid = nums[left];
            while (left<right&&comparator.compare(nums[right],mid)>=0){
                right--;
            }
            if (left<right){
                nums[left++]=nums[right--];
            }
            while (left<right&&comparator.compare(nums[left],mid)<=0){
                left++;
            }
            if (left<right){
                nums[right--]=nums[left++];
            }
            nums[left]=mid;

            printMinNum(nums,start,left-1,comparator);
            printMinNum(nums,left+1,end,comparator);
        }
    }
}

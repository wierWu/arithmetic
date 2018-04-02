package offer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为 s 的两个数字 vs 和为 s 的连续正数序列
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-forty-one.html
 */
public class FindNumbersWithSum {

    /**
     * 输入一个递增排序的数组和一个数字 s，在数组中查找两个数，得它们的和正好是 s。如果有多对数字的和等于 s，输出任意一对即可。
     * @param data
     * @param sum
     * @return
     */
    public List<Integer> findNumbersWithSum(int [] data,int sum){
        List<Integer> res = new ArrayList<>();
        int head=0;
        int tail=data.length-1;

        while (head<tail){
            int culNum=data[head]+data[tail];
            if (culNum==sum){
                res.add(data[head]);
                res.add(data[tail]);
                break;
            }else if (culNum<sum){
                head++;
            }else {
                tail--;
            }
        }

        return res;
    }
}

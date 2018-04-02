package offer.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环问题)
 * 0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。求出这个圈圈里剩下的最后一个数字。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-forty-five.html
 */
public class LastRemaining {


    public int lastRemaining(int n,int m){
        if (m>n){
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size()>1){

            for (int i = 1; i <m ; i++) {
                index++;
                if (index==list.size()){
                    index=0;
                }
            }

            int next =++index;
            if (next==list.size()){
                next=0;
            }

            --index;
            list.remove(index);
            index=next;
        }

        return list.get(0);
    }

    public int lastRemaining2(int n,int m){
        if (m>n|| n<1||m<1){
            return -1;
        }

        int last =0 ;
        for (int i = 2; i <n ; i++) {
            last=(last+m)%i;
        }

        return last;
    }
}

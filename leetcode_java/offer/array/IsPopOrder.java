package offer.array;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应
 * 的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-twenty-two.html
 */
public class IsPopOrder {
    /**
     * 解决这个问题很直观的想法就是建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数字。
     * 判断一个序列是不是栈的弹出序列的规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
     * 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
     * 如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
     */

    public boolean isPopOrder(int [] push,int [] pop){
        if (push==null||pop==null||push.length==0||pop.length==0||pop.length!=push.length){
            return false;
        }

        int pushIndex=0;
        int popIndex=0;
        Stack<Integer> stack = new Stack<Integer>();
        while (popIndex<pop.length){
            while (pushIndex<push.length &&(stack.empty()||stack.peek()!=pop[popIndex])){
                stack.push(push[pushIndex]);
                pushIndex++;
            }

            // 辅助栈顶元素永远和出栈队列的栈顶元素相同
            if (stack.peek()==pop[popIndex]){
                stack.pop();
                popIndex++;
            }else {
                return false;
            }
        }

        return true;
    }
}

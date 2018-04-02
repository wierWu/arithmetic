package offer.array;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-forty-seven.html
 */
public class SumForBinary {

    public int add(int x,int y){
        int sum,carry;
        do {
            sum=x^y;
            carry=(x&y)<<1;
            x=sum;
            y=carry;
        }while (y!=0);

        return sum;
    }
}

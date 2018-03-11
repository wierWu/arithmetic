package leecode;

/**
 * 让我们找一个范围内的各位上不相同的数字，比如123就是各位不相同的数字，而11,121,222就不是这样的数字
 * 通项公式为f(k) = 9 * 9 * 8 * ... (9 - k + 2)
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link http://www.cnblogs.com/grandyang/p/5582633.html
 * @since 1.0
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res += count(i);
        }
        return res;

    }

    int count(int k) {
        if (k < 1) return 0;
        if (k == 1) return 10;
        int res = 1;
        for (int i = 9; i >= (9 - k + 2); --i) {
            res *= i;
        }
        return res * 9;
    }
}

package leecode;

/**
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class Fib {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int getFib(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFib(n - 1) + getFib(n - 2);
        }
    }

    /**
     * 尾递归
     * 尾调用的重要性在于它可以不在调用栈上面添加一个新的堆栈帧——而是更新它，如同迭代一般。尾递归因而具有两个特征： 调用自身函数(Self-called)； 计算仅占用常量栈空间(Stack Space)。 而形式上只要是最后一个return语句返回的是一个完整函数，它就是尾递归。
     * 简单理解，就是处于函数尾部的递归调用本身的情形下，前面的变量状态都不需要再保存了，可以释放，从而节省很大的内存空间。在前面的代码中，明显在调用递归调用Fibonacci(n-1)的时候，还有Fibonacci(n-2)没有执行，需要保存前面的状态，因此开销较大的。
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public int getFid2(int n, int a, int b) {
        if (n <= 1) {
            return b;
        }

        return getFid2(n - 1, b, a + b);
    }

    public int getFid3(int n) {
        if (n < 2) {
            return 0;
        }

        if (n < 3) {
            return 1;
        }

        int f1 = 0, f2 = 1, fn = f1 + f2;
        for (int i = 2; i <=n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }

        return fn;
    }


    public static void main(String args[]) {
        Fib fib = new Fib();
        System.out.println(fib.getFib(5));
        System.out.println(fib.getFid2(5,0,1));
        System.out.println(fib.getFid3(5));
    }
}

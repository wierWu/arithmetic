package leecode;

/**
 * 设计一个算法，输出一个字符串字符的全排列。
 * 比如，String = "abc"
 * 输出是"abc","bac","cab","bca","cba","acb"
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://segmentfault.com/a/1190000002710424
 * @since 1.0
 */
public class Permutation {

    public void permutaion(char[] s, int from, int to) {
        if (to <= 1) {
            return;
        }

        if (from == to) {
            System.out.println(s);
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from);
                permutaion(s, from + 1, to);
                swap(s, from, i);
            }
        }

    }

    private void swap(char[] s, int i, int j) {
//        s[i] ^= s[j];
//        s[j] ^= s[i];
//        s[i] ^= s[j];

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        char[] ss = "abc".toCharArray();
        permutation.permutaion(ss, 0, ss.length - 1);
    }


    public void combination(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int n = 1 << s.length;

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s.length; j++) {
                if ((i&(1<<j))!=0){
                    stringBuilder.append(s[j]);
                }
            }

            System.out.print(stringBuilder + " ");
        }
    }
}

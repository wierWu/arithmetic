package offer.string;

/**
 * 字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc。则打印出由字符 a、b、c 所能排列出来的所有字符串 abc、acb、bac 、bca、cab 和 cba 。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-twenty-eight.html
 */
public class Permutation {

    public static void permutation(char [] chars){
        if (chars==null||chars.length<1){
            return;
        }

        permutaion(chars,0);
    }

    /**
     *
     * 把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。在图 4.14 中，我们用两种不同的背景颜色区分字符串的两部分。
     * 我们求整个字符串的排列，可以看成两步：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。图 4.14 就是分别把第一个字符 a 和后面的 b、c 等字符交换的情形。首先固定第一个字符（如图 4.14 (a ）所示〉，求后面所有字符的排列。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换（如图 4.14 （b）所示）。。。。。。
     * 这其实是很典型的递归思路。
     * @param chars
     * @param begain
     */
    public static void permutaion(char [] chars,int begain){

        if (begain==chars.length-1){
            System.out.print(new String(chars) + " ");
            return;
        }

        char tmp ;
        for (int i = begain; i <chars.length ; i++) {
            tmp = chars[begain];
            chars[begain]=chars[i];
            chars[i]=tmp;

            permutaion(chars,begain+1);

            tmp = chars[i];
            chars[i]=chars[begain];
            chars[begain]=tmp;

        }
    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}

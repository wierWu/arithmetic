package leecode;

/**
 * 输出n位数内所有十进制的数据
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class PrintNDigts {


    public void printOneToNthDigits(int n) {

        if (n < 1) {
            System.out.println(0);
            return;
        }

        byte[] arr = new byte[n];
        dropNextLayer(0, arr);

    }

    /**
     * 向下一层递归
     *
     * @param n
     * @param arr
     */
    private void dropNextLayer(int n, byte[] arr) {
        if (n >= arr.length) {
            print(arr);
            return;
        }

        //本层处理，0~9
        for (byte i = 0; i < 10; i++) {
            arr[n] = i;
            //向下drop
            dropNextLayer(n + 1, arr);
        }
    }



    private void print(byte[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }

        for (; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
//        new PrintNDigts().printOneToNthDigits(2);
//        new PrintNDigts().whilePrint(2);
    }

}

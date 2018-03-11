package leecode.array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class FindForTwoArray {

    /**
     * 既然是对等矩阵，只能从右上角和左下角来找了
     *
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findForTwoArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int clo = matrix[0].length - 1;

        while (row < matrix.length && clo >= 0) {
            int curretValue = matrix[row][clo];

            if (curretValue == target) {
                return true;
            }

            if (target > curretValue) {
                row++;
            } else {
                clo--;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(new FindForTwoArray().findForTwoArray(matrix, 5));
    }
}

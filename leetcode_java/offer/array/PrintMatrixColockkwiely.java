package offer.array;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-twenty.html
 */
public class PrintMatrixColockkwiely {

    public void printMatrix(int [][] matrix,int col,int row){
        if (matrix==null||matrix.length==0){
            return;
        }

        if (col<=0||row<=0){
            return;
        }

        int start=0;
        while (col>(start*2)&& row>(start*2)){
            printMatrixForCycle(matrix,start,col,row);
            start++;
        }

    }

    private void printMatrixForCycle(int [][] matrix,int start,int col,int row){
        int endX=col-start-1;
        int endY=row-start-1;

        //从左到右
        for (int i = start; i < endX; i++) {
            int num =matrix[start][i];
            System.out.print(num);
            System.out.print(" ");
        }

        //从上到下
        if (start<endY){
            for (int i = start+1; i <=endY ; i++) {
                int num = matrix[i][endX];
                System.out.print(num);
                System.out.print(" ");
            }
        }


        // 从右到左边
        if (start<endX && start<endY){
            for (int i = endX-1; i >=start; i--) {
                int num =matrix[endY][i];
                System.out.print(num);
                System.out.print(" ");
            }
        }

        //从下到上
        if (start<endX && start<endY-1){
            for (int i = endY-1; i >start ; i--) {
                int num =matrix[i][start];
                System.out.print(num);
                System.out.print(" ");
            }
        }


    }
}

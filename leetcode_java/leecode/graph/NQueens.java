package leecode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后
 * <p>
 * 循环每一行，然后对每一列进行
 * <p>
 * 保证轴距上上下左右，以及8个角不能被相互攻击
 * na左斜角=(row-col=(row=col)),pie右对角线=（row+col=(row=-col)）
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class NQueens {

    //访问记录
    List<Integer> colVisited = new ArrayList<Integer>();
    List<Integer> naVisited = new ArrayList<Integer>();
    List<Integer> pieVisited = new ArrayList<Integer>();

    List<List<String>> resList = new ArrayList<List<String>>();

    public void printNQueens(int n) {

        // 3以下没有n皇后
//        if (n < 4) {
//            return;
//        }

        dfs(n, 0, new int[n][n]);

        for (List<String> oneRet : resList) {
            System.out.println();
            for (String row : oneRet) {
                System.out.println(row);
            }
        }
    }

    private void dfs(int n, int row, int[][] levBox) {

        if (row >= n) {
            resList.add(boxFormat(levBox, n));
            return;
        }

        for (int clo = 0; clo < n; clo++) {

            int na = row - clo;
            int pie = row + clo;
            if (colVisited.contains(clo) || pieVisited.contains(pie) || naVisited.contains(na)) {
                continue;
            }

            //只记录皇后
            levBox[row][clo] = 1;
            colVisited.add(clo);
            pieVisited.add(pie);
            naVisited.add(na);
            dfs(n, row + 1, levBox);


            //一根筋做完了，需要重置这根筋
            levBox[row][clo] = 0;
            colVisited.remove((Integer) clo);
            pieVisited.remove((Integer) pie);
            naVisited.remove((Integer) na);


        }
    }


    private List<String> boxFormat(int[][] levBox, int n) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (levBox[i][j] == 1) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            ret.add(row.toString());
        }

        return ret;
    }

    public static void main(String[] args) {
        new NQueens().printNQueens(1);
    }
}

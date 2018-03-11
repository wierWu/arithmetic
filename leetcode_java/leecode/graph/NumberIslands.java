package leecode.graph;

/**
 * 从一个二维数组中找到大陆，大陆为周边都是水(x轴和y轴都是1的为大陆)
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/number-of-islands/description/
 * @since 1.0
 */
public class NumberIslands {

    int[][] brod = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numOfLands(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int rowLeg = grid.length;
        for (int i = 0; i < rowLeg; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    floodFill(grid, visited, i, j);
                }
            }
        }

        return count;
    }


    /**
     * dfs 遍历周边四个格子是否被访问过
     *
     * @param grids
     * @param visited
     * @param x
     * @param y
     */
    public void floodFill(int[][] grids, int[][] visited, int x, int y) {


        visited[x][y] = 1;
        for (int i = 0; i < brod.length; i++) {
            int nx = x + brod[i][0];
            int ny = y + brod[i][1];

            if (nx >= grids[0].length || ny >= grids.length || nx < 0 || ny < 0 || visited[nx][ny] == 1 || grids[nx][ny] == 0) {
                continue;
            }

            floodFill(grids, visited, nx, ny);
        }
    }
}

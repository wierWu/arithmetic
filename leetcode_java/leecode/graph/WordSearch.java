package leecode.graph;

/**
 * 给一个2d的盒子，然后搜索一个词
 * <p>
 * 1、这个词可以由顺序相邻单元格的字母构成，其中“相邻”单元格是那些水平或垂直相邻的单元格。
 * 2、一个字母单元格只能使用一次
 *
 * @author <a href='mailto:jian.wu@happyelements.com'>jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/word-search/description/
 * @since 1.0
 */
public class WordSearch {


    public boolean wordInGrid(char[][] grids, String word) {
        if (grids == null || grids.length == 0 || word.length() == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        boolean[][] visited = new boolean[grids.length][grids[0].length];
        //dfs搜索，从每个位置向四周搜索，看是否符合
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (exitsForDfs(grids, i, j, words, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 深度搜索，一个字符字符搜索，保证顺序一致
     *
     * @param grids
     * @param x
     * @param y
     * @param words
     * @param searchIndex
     * @param visited
     * @return
     */
    private boolean exitsForDfs(char[][] grids, int x, int y, char[] words, int searchIndex, boolean[][] visited) {

        if (searchIndex >= words.length) {
            return true;
        }

        if (x < 0 || y < 0 || x >= grids.length || y >= grids[x].length) {
            return false;
        }

        if (grids[x][y] != words[searchIndex]) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        //横轴或者树立轴,四个方向
        boolean isExist = exitsForDfs(grids, x - 1, y, words, searchIndex+1, visited) || exitsForDfs(grids, x + 1, y, words, searchIndex+1, visited) || exitsForDfs(grids, x, y + 1, words, searchIndex+1, visited) || exitsForDfs(grids, x, y - 1, words, searchIndex+1, visited);

        //这个x,y位置搜索过了，需要重置一下，防止下个操作有误解;
        visited[x][y] = false;
        return isExist;


    }


    public static void main(String[] args) {
        char[][] grids = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        boolean f = wordSearch.wordInGrid(grids, word);
        System.out.println(f);

    }
}

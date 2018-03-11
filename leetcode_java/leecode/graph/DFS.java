package leecode.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 深度优先遍历
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * @since 1.0
 */
public class DFS {

    public void searchGraph(Graph<Integer> graph, int startV) {
        boolean[] visited = new boolean[graph.getVSize()];
        dfs(graph, startV, visited);
    }

    public void dfs(Graph<Integer> graph, int v, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        System.out.print(v + " ");
        visited[v] = true;
        Iterator<Integer> vEges = graph.getAdj()[v].listIterator();
        while (vEges.hasNext()) {
            int nextV = vEges.next();
            //没有访问过droop下一层
            if (!visited[nextV]) {
                dfs(graph, nextV, visited);
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        new DFS().searchGraph(g, 2);
    }

}

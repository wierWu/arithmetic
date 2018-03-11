package leecode.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * @since 1.0
 */
public class BFS {

    public void bfs(Graph<Integer> graph, int startV) {

        if (graph == null) {
            return;
        }

        boolean visited[] = new boolean[graph.getVSize()];

        LinkedList<Integer> vQueue = new LinkedList<Integer>();
        vQueue.add(startV);

        while (!vQueue.isEmpty()) {
            int curV = vQueue.poll();
            System.out.println(" " + curV);
            Iterator<Integer> egaList = graph.getAdj()[curV].listIterator();
            //从每一个顶点进行扩散,访问过的就不要再处理了
            while (egaList.hasNext()) {
                int nextV = egaList.next();
                if (!visited[nextV]) {
                    vQueue.add(nextV);
                    visited[nextV] = true;
                }
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

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        new BFS().bfs(g, 2);
    }


}

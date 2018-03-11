package leecode.graph;

import java.util.LinkedList;

/**
 * 图
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class Graph<E> {

    private int V;//顶点编号
    private LinkedList<E> adj[]; // 邻接表

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<E>();
        }
    }

    public void addEdge(int v, E w) {
        adj[v].add(w);
    }


    public int getVSize() {
        return V;
    }

    public LinkedList<E>[] getAdj() {
        return adj;
    }
}

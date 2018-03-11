package leecode;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/description/
 * 完成课程A，必须保证课程B已经完成，是一个有向图，保证无闭环，或者入度都为0
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class Course {

    public boolean bfsFind(int[][] courses, int numCourse) {

        //整理为邻接表
        ArrayList<List<Integer>> graph_adjacency_list = new ArrayList<List<Integer>>(numCourse);
        for (int i = 0; i < numCourse; i++) {
            graph_adjacency_list.add(new ArrayList<Integer>());
        }

        int[] degree = new int[numCourse];

        for (int i = 0; i < courses.length; i++) {
            //有连接的深度+1
            degree[courses[i][1]]++;
            //邻接表
            graph_adjacency_list.get(courses[i][0]).add(courses[i][1]);
        }

        int count = 0;
        //找到顶点
        ArrayDeque<Integer> vertexs = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourse; i++) {
            if (degree[i] == 0) {
                vertexs.push(i);
                count++;
            }
        }

        //前续的课程入度-1，若全部修完，标识它没有人依赖，可以通过它来找下一个路径
        while (!vertexs.isEmpty()) {
            int course = vertexs.poll();
            for (Integer c : graph_adjacency_list.get(course)) {
                degree[c]--;
                if (degree[c] == 0) {
                    vertexs.push(c);
                    count++;
                }
            }
        }

        return count == numCourse;
    }

    public static void main(String[] args) {
        int[][] courses = {{0, 1}, {0, 6}, {0, 8}, {1, 4}, {1, 6}, {1, 9}, {2, 4}, {2, 6}, {3, 4}, {3, 5}, {3, 8}, {4, 5}, {4, 9}, {7, 8}, {7, 9}};
        Course course = new Course();
        boolean ret = course.bfsFind(courses, 10);
        System.out.println(ret);
    }
}

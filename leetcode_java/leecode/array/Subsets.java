package leecode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 求所有子序列
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @Link https://leetcode.com/problems/subsets/discuss/27279/Simple-Java-Solution-with-For-Each-loops
 * @since 1.0
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        for (int s : S
                ) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> sub : res
                    ) {
                List<Integer> a = new ArrayList<Integer>(sub);
                a.add(s);
                tmp.add(a);
            }

            res.addAll(tmp);
        }


        return res;
    }
}

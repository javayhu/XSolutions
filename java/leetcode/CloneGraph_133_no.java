import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 图
 * <p/>
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph_133_no {

    public static void main(String[] args) {

    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        return null;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}

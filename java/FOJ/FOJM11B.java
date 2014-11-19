import java.util.*;

/**
 * hujiawei - 14/11/16.
 */
public class FOJM11B {

    private static int n, m, k, x, val;
    private static Map<Integer, BNode> map;
    //private static Stack<BNode> stack;
    //private static BNode node;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int count = 1; count <= t; count++) {
            System.out.println("Case#" + count + ":");
            n = cin.nextInt();
            m = cin.nextInt();
            k = cin.nextInt();
            map = new HashMap<Integer, BNode>();

            int a, b;
            BNode nodea, nodeb;
            for (int i = 1; i <= n - 1; i++) {
                a = cin.nextInt();
                b = cin.nextInt();
                if (!map.containsKey(a)) {
                    nodea = new BNode(a);
                    map.put(a, nodea);//
                } else {
                    nodea = map.get(a);
                }
                if (!map.containsKey(b)) {
                    nodeb = new BNode(b);
                    map.put(b, nodeb);//
                } else {
                    nodeb = map.get(b);
                }
                //
                nodea.nodes.add(nodeb);
                //nodeb.pnode = nodea;
            }

            //
            //BNode root = map.get(1);
            //root.d = 0;
            ////calDepth(root);
            //stack = new Stack<BNode>();
            //stack.add(root);
            //while (!stack.isEmpty()) {
            //    node = stack.pop();
            //    node.d = node.pnode != null ? node.pnode.d + 1 : 0;
            //    for (BNode cnode : node.nodes) {
            //        stack.push(cnode);
            //    }
            //}

            //
            int s;
            BNode root, node;
            for (int i = 0; i < m; i++) {
                s = cin.nextInt();
                if (s == 2) {
                    System.out.println(map.get(cin.nextInt()).v);
                } else {
                    x = cin.nextInt();
                    val = cin.nextInt();
                    //doAction(map.get(x), map.get(x));

                    //root = map.get(x);
                    //stack = new Stack<BNode>();
                    //stack.add(root);
                    //while (!stack.isEmpty()) {
                    //    node = stack.pop();
                    //    //node.d = node.pnode != null ? node.pnode.d + 1 : 0;
                    //    node.v += ((node.d - root.d) % k + 1) * val;
                    //    for (BNode cnode : node.nodes) {
                    //        stack.push(cnode);
                    //    }
                    //}


                    int cd = 0;
                    root = map.get(x);
                    Queue<BNode> queue = new ArrayDeque<BNode>();
                    queue.add(root);
                    Queue<Integer> depths = new ArrayDeque<Integer>();
                    depths.add(cd);
                    while (!queue.isEmpty()) {
                        node = queue.poll();
                        cd = depths.poll();
                        node.v += (cd % k + 1) * val;
                        for (BNode cnode : node.nodes) {
                            queue.add(cnode);
                            depths.add(cd + 1);
                        }
                    }

                }
            }
            //
        }
    }

    //(（dep[y]-dep[x]）%k+1)*val
    //private static void doAction(BNode root, BNode current) {
    //    current.v += ((current.d - root.d) % k + 1) * val;
    //    for (BNode node : current.nodes) {
    //        doAction(root, node);
    //    }
    //}
    //
    //private static void calDepth(BNode root) {
    //    for (BNode node : root.nodes) {
    //        node.d = root.d + 1;
    //        //System.out.println(node.n + " " + node.d);
    //        calDepth(node);
    //    }
    //}

    static class BNode {

        int n = -1, /*d = -1, */
                v = 0;//number, depth, value
        List<BNode> nodes = new ArrayList<BNode>();
        //BNode pnode;

        BNode(int n) {
            this.n = n;
        }
    }

}



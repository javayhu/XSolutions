import java.util.*;

/**
 * hujiawei 15/4/24
 * <p/>
 * BFS + DFS
 * <p/>
 * https://leetcode.com/problems/word-ladder-ii/
 * 本代码有误，没有通过
 */
public class WordLadder2_126_wa {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        String beginWord = "red";
        String endWord = "tax";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("ted");
        wordDict.add("tex");
        wordDict.add("red");
        wordDict.add("tax");
        wordDict.add("tad");
        wordDict.add("den");
        wordDict.add("rex");
        wordDict.add("pee");
        System.out.println(new WordLadder2_126_wa().findLadders(beginWord, endWord, wordDict));
    }

    private static void test1() {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        System.out.println(new WordLadder2_126_wa().findLadders(beginWord, endWord, wordDict));
    }

    //超时的解决方案
    //"cat", "fin", ["ion","rev","che","ind","lie","wis","oct","ham","jag","ray","nun","ref","wig","jul","ken","mit","eel","paw","per","ola","pat","old","maj","ell","irk","ivy","beg","fan","rap","sun","yak","sat","fit","tom","fin","bug","can","hes","col","pep","tug","ump","arc","fee","lee","ohs","eli","nay","raw","lot","mat","egg","cat","pol","fat","joe","pis","dot","jaw","hat","roe","ada","mac"]
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null) return null;
        if (start.equalsIgnoreCase(end)) return null;

        List<List<String>> result = new ArrayList<List<String>>();
        LinkedList<String> path = new LinkedList<String>();

        LinkedList<String> queue = new LinkedList<String>();//队列
        queue.addLast(start);
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();//记录前驱节点
        map.put(start, null);//key是当前字符串，value是它所有的前驱字符串（但前驱又不能相同）
        Map<String, Integer> stepMap = new HashMap<String, Integer>();//记录到达每个节点的路径长度
        stepMap.put(start, 1);
        Set<String> visitedSet = new HashSet<String>();//记录访问过的节点集合

        int nextstep, minstep = 0;
        boolean reached = false;
        String current, word;
        while (!queue.isEmpty()) {
            current = queue.poll();//get and remove head of queue
            visitedSet.add(current);
            nextstep = stepMap.get(current) + 1;//下面扩展得到的字符串的step要加1

            if (reached && nextstep > minstep) {//只要当前的节点还有希望的话可以继续
                path.addFirst(end);
                getPath(result, path, map, end);
                return result;
            }

            char[] chars = current.toCharArray();
            for (int i = 0, len = current.length(); i < len; i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    if (chars[i] != j) {
                        char old = chars[i];
                        chars[i] = (char) j;
                        word = new String(chars);

                        if (word.equalsIgnoreCase(end)) {//endword不一定存在于字典中
                            reached = true;//标记到达了终点
                            minstep = stepMap.get(current) + 1;//到达终点字符串时走过的路径长度

                            //处理前驱节点 (不论是到达了目标节点还是没有到达)
                            Set<String> pres = map.get(word) != null ? map.get(word) : new HashSet<String>();
                            //存在了，表示前面已经找到过它的一个前驱节点，现在又找到一个前驱
                            pres.add(current);
                            map.put(word, pres);
                        } else if (dict.contains(word) && !visitedSet.contains(word)) {
                            //&& !stepMap.containsKey(word) 这种判断是错误的
                            //visitedSet.contains(word)是判断这个节点是否已经访问过了，而不是是否已经加入到队列中
                            //注意这里不是求最短长度，而是求所有的路径，那么这个节点即使在前面扩展过的话这里同样可以继续扩展
                            queue.addLast(word);//在字典中存在并且没有被访问过 -> 错误的
                            stepMap.put(word, nextstep);

                            //处理前驱节点 (不论是到达了目标节点还是没有到达)
                            Set<String> pres = map.get(word) != null ? map.get(word) : new HashSet<String>();
                            pres.add(current);
                            map.put(word, pres);
                        }

                        chars[i] = old;
                    }
                }
            }
        }
        if (reached) {
            path.addFirst(end);
            getPath(result, path, map, end);//如果不是从上面退出的话这里还是要操作的
        }
        return result;
    }

    // 通过回溯得到这条路径 (dfs)
    private void getPath(List<List<String>> result, LinkedList<String> path, Map<String, Set<String>> map, String word) {
        if (map.get(word) == null) {
            result.add(new LinkedList<String>(path));//renew one
            return;
        } else {
            for (String pre : map.get(word)) {
                path.addFirst((String) pre);
                getPath(result, path, map, (String) pre);
                path.removeFirst();
            }

        }
    }

    //错误的代码，因为处理不了同一个字符串有不同前驱节点的情况
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        if (start == null) return null;
        if (start.equalsIgnoreCase(end)) return null;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path;
        LinkedList<String> queue = new LinkedList<String>();
        queue.addLast(start);
        Map<String, String> map = new HashMap<String, String>();
        map.put(start, null);//key是当前字符串，value是它的前驱字符串
        Map<String, Integer> stepMap = new HashMap<String, Integer>();
        stepMap.put(start, 1);
        int nextstep, minstep = 0;
        boolean reached = false;
        String current, word;
        while (!queue.isEmpty()) {
            current = queue.poll();//get and remove head of queue
            nextstep = stepMap.get(current) + 1;//下面扩展得到的字符串的step要加1
            if (reached && nextstep > minstep) {//只要当前的节点还有希望的话可以继续
                return result;
            }
            char[] chars = current.toCharArray();
            for (int i = 0, len = current.length(); i < len; i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    if (chars[i] != j) {
                        char old = chars[i];
                        chars[i] = (char) j;
                        word = new String(chars);
                        if (word.equalsIgnoreCase(end)) {//endword不一定存在于字典中
                            reached = true;//标记到达了终点
                            minstep = stepMap.get(current) + 1;//到达终点字符串时走过的路径长度
                            System.out.println("minstep=" + minstep);
                            map.put(word, current);//
                            path = getPath2(map, word);
                            result.add(path);
                            //map.remove(word);//
                        } else if (dict.contains(word)) {//&& !map.containsKey(word)
                            //注意这里不是求最短长度，而是求所有的路径，那么这个节点即使在前面扩展过的话这里同样可以继续扩展
                            queue.addLast(word);//在字典中存在并且没有被访问过 -> 错误的
                            stepMap.put(word, nextstep);
                            map.put(word, current);
                        }
                        chars[i] = old;
                    }
                }
            }
            System.out.println("---");
            System.out.println(stepMap);
            System.out.println("---");
        }
        return result;
    }

    // 通过回溯得到这条路径
    private List<String> getPath2(Map<String, String> map, String word) {
        LinkedList<String> path = new LinkedList<String>();
        path.addFirst(word);
        while (map.get(word) != null) {
            path.addFirst(map.get(word));
            word = map.get(word);
        }
        return path;
    }

}

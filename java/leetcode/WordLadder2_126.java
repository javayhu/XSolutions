import java.util.*;

/**
 * hujiawei 15/4/24
 * <p/>
 * BFS + DFS
 * <p/>
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2_126 {

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
        System.out.println(new WordLadder2_126().findLadders(beginWord, endWord, wordDict));
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
        System.out.println(new WordLadder2_126().findLadders(beginWord, endWord, wordDict));
    }

    //参考解法：https://leetcode.com/discuss/26613/only-use-bfs-level-order-traversal-java-solution
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null) return null;
        if (start.equalsIgnoreCase(end)) return null;

        List<List<String>> result = new ArrayList<List<String>>();
        LinkedList<String> path = new LinkedList<String>();

        return result;
    }

}

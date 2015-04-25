import java.util.*;

/**
 * hujiawei 15/4/23
 * <p/>
 * BFS
 * <p/>
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder_127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");

        System.out.println(new WordLadder_127().ladderLength(beginWord, endWord, wordDict));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null) return 0;
        if (beginWord.equalsIgnoreCase(endWord)) return 0;//same word
        LinkedList<String> queue = new LinkedList<String>();
        queue.addLast(beginWord);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(beginWord, 1);//
        int nextstep;
        String current, word;
        while (!queue.isEmpty()) {
            current = queue.poll();//get and remove head of queue
            nextstep = map.get(current) + 1;//下面扩展得到的字符串的step要加1
            char[] chars = current.toCharArray();
            for (int i = 0, len = current.length(); i < len; i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    if (chars[i] != j) {
                        char old = chars[i];
                        chars[i] = (char) j;
                        word = new String(chars);
                        //注意这里，如果是采用下面的构造字符串的方式的话会超时！但是改为利用字符串数组的方式构造的话没问题
                        //word = current.substring(0, i) + (char) j + current.substring(i + 1, len);//new word
                        if (word.equalsIgnoreCase(endWord)) {//endword不一定存在于字典中
                            return nextstep;
                        }
                        if (wordDict.contains(word) && !map.containsKey(word)) {
                            queue.addLast(word);//在字典中存在并且没有被访问过
                            map.put(word, nextstep);
                        }
                        chars[i] = old;
                    }
                }
            }
        }
        return 0;
    }

}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/5/2
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses_93 {

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses_93().permutation(4));
        System.out.println(new RestoreIPAddresses_93().restoreIpAddresses("25525511135"));
    }

    //我的思路是先看对于s有哪些可能的位置加上三个点 []
    //问题变成判断对于字符串s，在a,b,c三个地方加入.之后是否是一个合法的IP地址
    //a,b,c三个位置可以通过组合求得(dfs)
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int n = s.length();

        String path;
        if (n < 4 || n > 12) {//某些特殊情况下
            return result;
        } else if (n == 4) {
            if ((path = check(s, 1, 2, 3)) != null) {
                result.add(path);
            }
        } else if (n > 4) {//n>4，先求组合情况
            List<List<Integer>> per = permutation(n);
            for (List<Integer> p : per) {
                if ((path = check(s, p.get(0), p.get(1), p.get(2))) != null) {
                    result.add(path);
                }
            }
        }
        return result;//n<4直接返回
    }

    //判断对于字符串s，在a,b,c三个地方加入.之后是否是一个合法的IP地址
    private String check(String s, int a, int b, int c) {
        //考虑一些特殊情况
        int n = s.length();//每个子部分的长度不可能超过3
        if (a > 3 || b - a > 3 || c - b > 3 || n - c > 3) return null;
        //字符串划分
        String sa = s.substring(0, a);//[0,a-1]
        String sb = s.substring(a, b);//[a,b-1]
        String sc = s.substring(b, c);//[b,c-1]
        String sd = s.substring(c);//[c,end]
        //IP检查
        if (ipcheck(sa) && ipcheck(sb) && ipcheck(sc) && ipcheck(sd)) {
            return new StringBuilder().append(sa).append(".").append(sb).append(".").append(sc).append(".").append(sd).toString();
        }
        return null;
    }

    private boolean ipcheck(String s) {
        int ip;
        if (s.length() > 0 && s.length() <= 3 && (ip = Integer.parseInt(s)) >= 0 && ip <= 255) {
            return !(s.length() > 1 && s.charAt(0) == '0');//010 不行
        }
        return false;
    }

    //从1到n中取3个数字作为一个组合，求所有的组合情况
    public List<List<Integer>> permutation(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        dfs(result, path, n, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int n, int start) {
        if (path.size() == 3) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if (start > n) {
            return;
        }

        //直接不用start这个数字
        dfs(result, path, n, start + 1);

        //先加上start这个数字
        if (path.size() < 3) {//前提是还可以加数字
            path.add(start);
            dfs(result, path, n, start + 1);
            path.removeLast();
        }
    }

}

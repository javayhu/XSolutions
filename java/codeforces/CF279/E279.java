package CF279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//http://codeforces.com/contest/490/problem/E

//tle
public class E279 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        List<String> values = new ArrayList<String>();
        int[] max = new int[n];
        int[] min = new int[n];
        String t;
        for (int i = 0; i < n; i++) {
            t = cin.next();
            values.add(t);
            max[i] = t.contains("?") ? findMax(t) : Integer.valueOf(t);
            min[i] = t.contains("?") ? findMin(t) : Integer.valueOf(t);
        }

        //just do it!
        int next;
        int last = min[0];
        List<String> results = new ArrayList<String>();
        results.add(String.valueOf(last));
        for (int i = 1; i < n; i++) {
            if (max[i] == min[i]) {//别无选择
                results.add(String.valueOf(max[i]));
                last = max[i];
            } else {//可以选择的话选择最小的可行值
                if (max[i] <= last) {//最大值都不行
                    //System.out.println("* i=" + i + " s=" + values.get(i) + " max=" + max[i] + " last=" + last);//TODO
                    System.out.println("NO");
                    return;
                } else if (min[i] > last) {//最小值可行
                    results.add(String.valueOf(min[i]));
                    last = min[i];
                } else {//检查是否有解
                    if (i + 1 < n && min[i + 1] > max[i]) {
                        next = max[i];//当前这位取最大值都没有问题的话就直接处理
                    } else {
                        next = findNext(last, values.get(i));//否则就去查找满足条件的最小值
                        //System.out.println("# i=" + i + " max=" + max[i] + " last=" + last + " s=" + values.get(i) + " next=" + next);//TODO
                    }
                    if (next < 0) {//找不到了
                        //System.out.println("# i=" + i + " s=" + values.get(i) + " max=" + max[i] + " last=" + last);//TODO
                        System.out.println("NO");
                        return;
                    } else {//找到了可以继续
                        results.add(String.valueOf(next));
                        last = next;
                    }
                }
            }
        }

        System.out.println("YES");
        for (String v : results) {
            System.out.println(v);
        }
    }

    //找到符合字符串s这种模式并且大于last值的最小数字
    private static int findNext(int last, String s) {
        //s的长度肯定和last的位数相同，因为如果不相同的话肯定s的长度更长些，满足s模式的最小值一定大于last
        int sumOfBits = 0;
        int len = s.length();
        char[] lastchars = String.valueOf(last).toCharArray();
        char[] chars = s.toCharArray();
        List<Integer> qlist = new ArrayList<Integer>();

        for (int i = 0; i < len; i++) {
            if (chars[i] == '?') {
                sumOfBits++;
                qlist.add(i);
            }
        }

        int k = 0, t = 1;//肯定存在
        StringBuilder builder = new StringBuilder();
        while ((t < sumOfBits) && qlist.get(t) - qlist.get(k) == 1) {
            builder.append(lastchars[qlist.get(k)]);
            k = t;
            t++;
        }
        Collections.reverse(qlist);//倒序存储了哪些位置上是 '?'

        int current = 0;
        if (!builder.toString().equalsIgnoreCase("")) {
            //System.out.println("builder=" + builder.toString());//01 TODO
            String temp = builder.toString();
            while (temp.length() < sumOfBits) {//后面补0
                temp = temp + "0";
            }
            while (temp.length() > 0 && temp.charAt(0) == '0') {//前面去0
                temp = temp.substring(1);
            }
            if (!temp.equalsIgnoreCase("")) {
                //while (temp.length() < sumOfBits) {//后面补0
                //    temp = temp + "0";
                //}
                current = Integer.valueOf(temp);
                //System.out.println("current=" + current); //TODO
            }
        }


        int l;
        int max = (int) Math.pow(10, sumOfBits) - 1;
        String rs, currentValue;//当前值的字符串表示
        char[] tchars;
        while ((current++) <= max) {
            tchars = new char[len];
            System.arraycopy(chars, 0, tchars, 0, len);
            currentValue = String.valueOf(current);
            l = currentValue.length();

            for (int i = 0; i < l; i++) {
                tchars[qlist.get(i)] = currentValue.charAt(l - 1 - i);
            }
            rs = String.valueOf(tchars);
            rs = rs.replace('?', '0');
            if (rs.charAt(0) == '0') {
                continue;
            }
            t = Integer.valueOf(rs);
            if (t > last) {
                return t;
            }
        }
        return -1;
    }

    //找到符合字符串t模式的最大值
    private static int findMax(String t) {
        t = t.replace('?', '9');
        return Integer.valueOf(t);
    }

    //找到符合字符串t模式的最小值
    private static int findMin(String t) {
        if (t.charAt(0) == '?') {
            //t = t.replaceFirst('?', '1');
            t = "1" + t.substring(1);
            t = t.replace('?', '0');
        } else {
            t = t.replace('?', '0');
        }
        return Integer.valueOf(t);
    }

}

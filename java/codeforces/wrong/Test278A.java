package wrong;

import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 */

//http://codeforces.com/contest/488/problem/A

//没有试过，结果是错误的

public class Test278A {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int a = cin.nextInt();

        if (a >= -8 && a <= 7) {
            System.out.println(8 - a);
        }
        //else if (a >= 8 && a <= 17) {
        //    System.out.println(18 - a);
        //}
        else if (a >= 8) {//a>0
            String s = String.valueOf(a), next;
            int c = 0, cur, b = 0, len = s.length();
            boolean f = false;
            boolean r = false;

            while (c < len) {
                cur = s.charAt(len - c - 1) - '0';
                if (cur == 8) {//遇到8
                    f = true;
                    c++;
                } else if (cur > 8) {//遇到大于8的不管
                    c++;
                } else {//find here!
                    r = true;
                    if (f) {//后面有8
                        b = (int) Math.pow(10, c);
                        break;
                    } else {//后面没有8
                        char[] chars = s.toCharArray();
                        chars[len - c - 1] = (char) (chars[len - c - 1] + 1);
                        for (int i = len - c; i < len; i++) chars[i] = '0';
                        next = String.valueOf(chars);
                        b = Integer.valueOf(next) - a;
                        break;
                    }
                }
            }
            if (r) {
                System.out.println(b);
            } else {
                next = "1";
                for (int i = 0; i < len - 1; i++) next += "0";
                next += "8";
                System.out.println(Integer.valueOf(next) - a);
            }
        }
        //else if (a >= -9 && a <= -17) {//a<0
        //    System.out.println(-8 - a);
        //}
        else {//a<0 a<=-9
            int ma = -a;
            String s = String.valueOf(ma), next;//
            int c = 0, cur, b = 0, len = s.length();
            boolean f = false;
            boolean r = false;

            while (c < len) {
                cur = s.charAt(len - c - 1) - '0';
                if (cur == 8) {//遇到8
                    f = true;
                    c++;
                } else if (cur < 8) {//遇到小于8的不管
                    c++;
                } else {//find here!
                    r = true;
                    if (f) {//后面有8
                        b = (int) Math.pow(10, c);
                        break;
                    } else {//后面没有8
                        char[] chars = s.toCharArray();
                        chars[len - c - 1] = (char) (chars[len - c - 1] - 1);
                        for (int i = len - c; i < len; i++) chars[i] = '9';
                        next = String.valueOf(chars);
                        b = Integer.valueOf(next) - a;
                        break;
                    }
                }
            }
            if (r) {
                System.out.println(b);
            } else {
                next = "1";
                for (int i = 0; i < len - 1; i++) next += "0";
                next += "8";
                System.out.println(Integer.valueOf(next) - a);
            }
        }
    }

}

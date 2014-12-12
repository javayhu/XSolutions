package CF278;

import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 */

//http://codeforces.com/contest/488/problem/A

//简单题，不要想太多！

public class GigaTower278A {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int b = 1;
        int a = cin.nextInt();
        String s = String.valueOf(++a);
        while (!s.contains("8")) {
            b++;
            s = String.valueOf(++a);
        }
        System.out.println(b);
    }

}

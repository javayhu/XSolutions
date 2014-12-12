package CF278;

import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 */

//http://codeforces.com/contest/488/problem/B

//数学题

public class CandyBox278B {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }

        if (n == 0) {
            System.out.println("YES");
            System.out.println("1");
            System.out.println("2");
            System.out.println("2");
            System.out.println("3");
        } else if (n == 1) {
            System.out.println("YES");
            System.out.println(2 * a[0]);
            System.out.println(2 * a[0]);
            System.out.println(3 * a[0]);
        } else if (n == 4) {
            Arrays.sort(a);
            if (check(a[0], a[1], a[2], a[3])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else if (n == 3) {
            Arrays.sort(a);
            int a1 = a[2] / 3;
            if (check(a1, a[0], a[1], a[2])) {
                System.out.println("YES");
                System.out.println(a1);
                return;
            }
            int a4 = a[0] * 3;
            if (check(a[0], a[1], a[2], a4)) {
                System.out.println("YES");
                System.out.println(a4);
                return;
            }
            int a2 = 4 * a[0] - a[1];
            if (check(a[0], a2, a[1], a[2])) {
                System.out.println("YES");
                System.out.println(a2);
                return;
            }
            int a3 = 4 * a[0] - a[1];
            if (check(a[0], a[1], a3, a[2])) {
                System.out.println("YES");
                System.out.println(a3);
                return;
            }
            System.out.println("NO");
        } else {
            Arrays.sort(a);
            int a1, a2, a3, a4;
            //a1,a4
            a1 = a[0];
            a4 = a[1];
            if (a4 == 3 * a1) {
                a2 = (a1 + a4) / 2;
                a3 = (a1 + a4) / 2;
                if (check(a1, a2, a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a2);
                    System.out.println(a3);
                    return;
                }
            }
            //a1,a2
            a1 = a[0];
            a2 = a[1];
            if (4 * a1 > a2) {
                a3 = 4 * a1 - a2;
                a4 = 3 * a1;
                if (check(a1, a2, a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a3);
                    System.out.println(a4);
                    return;
                }
            }
            //a1,a3
            a1 = a[0];
            a3 = a[1];
            if (4 * a1 > a3) {
                a2 = 4 * a1 - a3;
                a4 = 3 * a1;
                if (check(a1, a2, a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a2);
                    System.out.println(a4);
                    return;
                }
            }
            //a2,a3
            a2 = a[0];
            a3 = a[1];
            if ((a2 + a3) % 4 == 0) {
                a1 = (a2 + a3) / 4;
                a4 = 3 * a1;
                if (check(a1, a2, a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a1);
                    System.out.println(a4);
                    return;
                }
            }
            //a2,a4 and a3,a4
            a2 = a[0];
            a4 = a[1];
            if (a4 % 3 == 0) {
                a1 = a4 / 3;
                a3 = 4 * a1 - a2;
                if (check(a1, a2,a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a1);
                    System.out.println(a3);
                    return;
                }
            }
            //a3,a4
            a3 = a[0];
            a4 = a[1];
            if (a4 % 3 == 0) {
                a1 = a4 / 3;
                a2 = 4 * a1 - a3;
                if (check(a1, a2,a3, a4)) {
                    System.out.println("YES");
                    System.out.println(a1);
                    System.out.println(a2);
                    return;
                }
            }
            //
            System.out.println("NO");
        }
    }

    private static boolean check(int a1, int a2, int a3, int a4) {
        if (a1 <= a2 && a2 <= a3 && a3 <= a4 && (a4 - a1) == (a2 + a3) / 2 && (a4 - a1) == (a1 + a2 + a3 + a4) / 4) {
            return true;
        }
        return false;
    }

}

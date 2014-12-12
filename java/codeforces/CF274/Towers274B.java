package CF274;

import java.util.Scanner;
import java.util.Vector;

/**
 * hujiawei - 10/19/14.
 */

//http://codeforces.com/contest/479/problem/B

//简单题，贪心

public class Towers274B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sum = sum + a[i];//get sum
        }
        int d = sum / n;
        MaxMin max = getMax(a);
        MaxMin min = getMin(a);
        boolean flag = min.maxmin == d && (max.maxmin == d + 1 || max.maxmin == d);
        if (flag) {
            System.out.println(max.maxmin - min.maxmin + " 0");
            return;
        }
        int t = 1;//moves taken
        Vector<Move> moves = new Vector<Move>();
        while (!flag && t <= k) {//move
            moves.add(new Move(max.index + 1, min.index + 1));
            a[max.index] = a[max.index] - 1;
            a[min.index] = a[min.index] + 1;
            max = getMax(a);
            min = getMin(a);
            flag = min.maxmin == d && (max.maxmin == d + 1 || max.maxmin == d);
            t++;
        }
        if (t == k + 1 || flag) {
            t = t - 1;
        }
        System.out.println(max.maxmin - min.maxmin + " " + t);
        for (Move move : moves) {
            System.out.println(move.from + " " + move.to);
        }
    }

    private static MaxMin getMax(int[] a) {
        MaxMin maxMin = new MaxMin();
        maxMin.index = 0;
        maxMin.maxmin = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxMin.maxmin) {
                maxMin.maxmin = a[i];
                maxMin.index = i;
            }
        }
        return maxMin;
    }

    private static MaxMin getMin(int[] a) {
        MaxMin maxMin = new MaxMin();
        maxMin.index = 0;
        maxMin.maxmin = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < maxMin.maxmin) {
                maxMin.maxmin = a[i];
                maxMin.index = i;
            }
        }
        return maxMin;
    }

    static class MaxMin {
        int maxmin;
        int index = 0;
    }

    static class Move {
        int from;
        int to;

        Move(int from, int to) {
            this.from = from;
            this.to = to;
        }

    }

}



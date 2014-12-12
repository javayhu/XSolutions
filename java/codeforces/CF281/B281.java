package CF281;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

//http://codeforces.com/contest/493/problem/B

public class B281 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();

        int t = 0;
        for (int k = 1; k <= n; k++) {
            t = cin.nextInt();
            if (t > 0) {
                first.add(t);
            } else {
                second.add(-t);
            }
        }
        BigInteger sum1 = BigInteger.ZERO;
        for (int i = 0; i < first.size(); i++) {
            sum1 = sum1.add(new BigInteger(String.valueOf(first.get(i))));
        }
        BigInteger sum2 = BigInteger.ZERO;
        for (int i = 0; i < second.size(); i++) {
            sum2 = sum2.add(new BigInteger(String.valueOf(second.get(i))));
        }
        //总结，了解BigInteger之间如何比较大小
        //关于输出，因为输出是某个句子，为了保证不书写错误，建议独立成为一个方法，专门用于打印输出最后的结果
        if (sum1.compareTo(sum2) == 0) {//same sum
            int i = 0, j = 0;
            for (; i < first.size() && j < second.size(); i++, j++) {//比较字典序
                if (first.get(i) > second.get(j)) {
                    System.out.println("first");
                    return;
                } else if (first.get(i) < second.get(j)) {
                    System.out.println("second");
                    return;
                }
            }
            if (first.size() == second.size()) {//last
                if (t > 0) {
                    System.out.println("first");
                } else {
                    System.out.println("second");
                }
            } else {
                if (i == first.size() && j < second.size()) {//字典序之后有剩余的win
                    System.out.println("second");
                } else {
                    System.out.println("first");
                }
            }
        } else {//
            if (sum1.compareTo(sum2) > 0) {
                System.out.println("first");
            } else {
                System.out.println("second");
            }
        }
    }

}

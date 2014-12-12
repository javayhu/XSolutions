package CF2775;

import java.util.Scanner;

/**
 * hujiawei - 14/11/5.
 */

//http://codeforces.com/contest/489/problem/C

//贪心，求m位数字组成的各位数字之和为s的最大数和最小数，最小数可以通过反向求最大数，注意m=1的情况

public class GivenLengthandSumofDigits2775C {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int m = cin.nextInt();
        int s = cin.nextInt();

        if ((9 * m < s) || (s < 1 && m > 1)) {
            System.out.println("-1 -1");
            return;
        }

        String max = findMax(m, s);
        String min = "";

        //求最小值
        if (max.charAt(max.length() - 1) != '0') {
            min = new StringBuilder(max).reverse().toString();
            System.out.println(min + " " + max);
            return;
        }

        //特殊情况
        if (m == 1) {
            min = "" + s;
        } else {
            min = findMax(m - 1, s - 1);
            min = "1" + new StringBuilder(min).reverse().toString();
        }

        System.out.println(min + " " + max);
    }

    //求最大值
    static String findMax(int m, int s) {
        int k = 1;//当前第几位
        int r = s;//剩余的总和

        String max = "";
        while (k <= m) {
            if (r >= 9) {
                max = max + "9";
                r = r - 9;
            } else {
                max = max + r;
                r = 0;
            }
            k++;
        }
        return max;
    }

}

package CF274;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * hujiawei - 10/19/14.
 */

//http://codeforces.com/contest/479/problem/A

//简单题，贪心

public class Exams274C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Vector<ExamDate> dates = new Vector<ExamDate>();
        for (int i = 0; i < n; i++) {
            dates.add(new ExamDate(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(dates);//sort by a
        ExamDate date = null;
        int currentTime = 0;
        for (int i = 0; i < dates.size(); i++) {
            date = dates.get(i);
            if (date.b >= currentTime) {
                currentTime = date.b;
            } else {
                currentTime = date.a;
            }
        }
        System.out.println(currentTime);
    }

    static class ExamDate implements Comparable {

        int a;
        int b;

        ExamDate(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {//注意这里的写法
            if (o instanceof ExamDate) {
                ExamDate date = (ExamDate) o;
                if (this.a < date.a) {
                    return -1;
                } else if (this.a > date.a) {
                    return 1;
                } else {//when a is same, compare their b, put smaller one first
                    if (this.b < date.b) {
                        return -1;
                    } else if (this.b > date.b) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

}




import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

/**
 * hujiawei - 10/19/14.
 */

//http://codeforces.com/contest/479/problem/D

//中等题，题意是说尺子上已有一些刻度，还需要添加多少个刻度才能保证x和y两个数值能够被测量出来

public class LongJumps274D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        HashSet marks = new HashSet();
        for (int i = 0; i < n; i++) {
            marks.add(scanner.nextInt());
        }
        if (measure(marks, x) && measure(marks, y)) {//both x and y can be measured
            System.out.println("0");
            return;
        }
        if (measure(marks, x)) {//x can be measured
            System.out.println("1\n" + y);
            return;
        }
        if (measure(marks, y)) {//y can be measured
            System.out.println("1\n" + x);
            return;
        }
        //can add: r+x, r-x, r+y, r-y, then check whether the other (x or y) can add
        boolean flag = false;//add only one, possible?
        int r, mark = 0;
        for (Object markobj : marks) {
            r = ((Integer) markobj).intValue();//
            mark = r + x;//suppose to add mark=r+x
            if (mark <= l && (search(marks, mark + y) || search(marks, mark - y))) {
                flag = true;
                break;
            }
            mark = r - x;
            if (mark >= 0 && (search(marks, mark + y) || search(marks, mark - y))) {
                flag = true;
                break;
            }
            mark = r + y;
            if (mark <= l && (search(marks, mark + x) || search(marks, mark - x))) {
                flag = true;
                break;
            }
            mark = r - y;
            if (mark >= 0 && (search(marks, mark + x) || search(marks, mark - x))) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("1\n" + mark);
        } else {
            System.out.println("2\n" + x + " " + y);
        }
    }

    public static boolean measure(HashSet marks, int key) {//能否测量数值key
        int markint = 0;
        for (Object mark : marks) {
            markint = ((Integer) mark).intValue();//will cover 0+key=key and l-key
            if (search(marks, markint + key) || search(marks, markint - key)) {
                return true;
            }
        }
        return false;
    }

    public static boolean search(HashSet marks, int key) {//因为刻度是有序的，二叉搜索更快
        if (marks.contains(key)) {
            return true;
        }
        return false;
    }


}

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * hujiawei - 14/11/16.
 */

//http://acm.fzu.edu.cn/contest/problem.php?cid=140&sortid=8

public class FOJM11H {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- > 0) {
            String first = cin.next();
            cin.nextLine();//get the rest string of this line
            if (first.length() > 3) {
                System.out.println("Too hard!");
            } else {
                System.out.println("Too easy!");
            }
        }
    }
}

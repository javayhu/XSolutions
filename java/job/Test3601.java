import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 360笔试第一题
 */
public class Test3601 {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        while (r.hasNext()) {
            int n = r.nextInt();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    result.add(i);
                    n = n / i;
                    i--;
                }
            }
            show(result);
        }
    }

    static int col;
    static String[][] s;

    private static void show(ArrayList<Integer> result) {
        if (result.size() <= 0) return;

        int n, start = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < result.size(); i++) {
            if (i >= 1) {
                list.add(-1);
                start++;
            }
            n = result.get(i);
            if (n < 10) {
                list.add(n);
            } else {
                LinkedList<Integer> reminders = new LinkedList<Integer>();
                int k;
                while (n > 10) {
                    k = n % 10;
                    reminders.addFirst(k);
                    n = n / 10;
                }
                reminders.addFirst(n);
                while (!reminders.isEmpty()) {
                    list.add(reminders.pollFirst());
                }
            }
        }

        /*for (int k : list) {
            System.out.print(k + " ");
        }
        System.out.println();*/

        int cols = 3;
        if (list.size() > 1) {
            cols = 3 * (list.size() - start) + start;
        }

        col = 0;
        s = new String[5][cols];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == -1) {
                addStar();
            }else{
                addNumber(list.get(i));
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < cols; j++) {
                if (null == s[i][j]) {
                    System.out.print(" ");
                } else {
                    System.out.print(s[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void addNumber(int n) {
        switch (n) {
            case 0: {
                s[0][col + 1] = "_";
                s[1][col] = "|";
                s[1][col + 2] = "|";
                s[3][col] = "|";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 1: {
                s[1][col + 2] = "|";
                s[3][col + 2] = "|";
            }
            break;
            case 2: {
                s[0][col + 1] = "_";
                s[1][col + 2] = "|";
                s[2][col + 1] = "_";
                s[3][col] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 3: {
                s[0][col + 1] = "_";
                s[1][col + 2] = "|";
                s[2][col + 1] = "_";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 4: {
                s[1][col] = "|";
                s[1][col + 2] = "|";
                s[2][col + 1] = "_";
                s[3][col + 2] = "|";
            }
            break;
            case 5: {
                s[0][col + 1] = "_";
                s[1][col] = "|";
                s[2][col + 1] = "_";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 6: {
                s[0][col + 1] = "_";
                s[1][col] = "|";
                s[2][col + 1] = "_";
                s[3][col] = "|";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 7: {
                s[0][col + 1] = "_";
                s[1][col + 2] = "|";
                s[3][col + 2] = "|";
            }
            break;
            case 8: {
                s[0][col + 1] = "_";
                s[1][col] = "|";
                s[1][col + 2] = "|";
                s[2][col + 1] = "_";
                s[3][col] = "|";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
            case 9: {
                s[0][col + 1] = "_";
                s[1][col] = "|";
                s[1][col + 2] = "|";
                s[2][col + 1] = "_";
                s[3][col + 2] = "|";
                s[4][col + 1] = "_";
            }
            break;
        }
        col += 3;
    }

    private static void addStar() {
        s[2][col] = "*";
        col += 1;
    }
}
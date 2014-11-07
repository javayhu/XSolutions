import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//http://codeforces.com/problemset/problem/1/B

//not finished -> not ac

public class Spreadsheets1B {

    public static void main(String[] args) {
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("sample/test1a.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String cell = "";
        while (n-- > 0) {
            cell = scanner.next().trim();
            //System.out.println("cell: " + cell);
            if (cell.indexOf("R") >= 0) {
                convertRCtoAZ(cell);
            } else {
                convertAZtoRC(cell);
            }
        }
    }

    private static void convertAZtoRC(String cell) {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(cell);
        String col = "", row = "";
        if (matcher.find()) {
            col = cell.substring(matcher.start(), matcher.end());
            row = cell.substring(matcher.end());
        }
        int sum = 0, a = 0;
        for (int i = col.length() - 1, j = 0; i >= 0; i--, j++) {
            a = col.charAt(i) - 'A' + 1;
            sum = sum + (int) (Math.pow(26.0, j) * a);
        }
        System.out.println("R" + row + "C" + String.valueOf(sum));
    }

    private static void convertRCtoAZ(String cell) {
        int row = Integer.valueOf(cell.substring(1, cell.indexOf("C")));
        int col = Integer.valueOf(cell.substring(cell.indexOf("C") + 1));
        System.out.println(convertIntToLetter(col) + String.valueOf(row));
    }

    // 55 -> BC base=26
    private static String convertIntToLetter(int col) {
        Stack stack = new Stack();
        StringBuffer result = new StringBuffer("");
        int d=col, r=0, k=1;
        while (d >= 26) {
            r = d % 26;
            d = d / 26;
            if (r == 0) {
                d = d - 1;
                stack.push("Z");
            } else {
                stack.push(String.valueOf((char) (r + 'A' - 1)));
            }
        }
        if (d!=0){
            stack.push(String.valueOf((char) (d + 'A' - 1)));
        }
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }


}

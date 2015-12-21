import java.util.Scanner;

/**
 * 京东笔试第二题
 */
public class TestJD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int s = scanner.nextInt();
            System.out.println((int)(Math.pow(s, s) - s + 1));
        }
    }

}
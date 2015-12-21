import java.util.Scanner;

/**
 * 360笔试第二题
 */
public class Test3602 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int a, b, c, d, s;
        while (k-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();
            s = a + b + c + d;
            if (a >= 60 && b >= 60 && c >= 90 && d >= 90 && s >= 310) {
                if (s >= 350) {
                    System.out.println("Gongfei");
                } else if (s >= 310) {
                    System.out.println("Zifei");
                }
            } else {
                System.out.println("Fail");
            }
        }

    }


}

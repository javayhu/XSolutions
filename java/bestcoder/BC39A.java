import java.util.Scanner;

/**
 * hujiawei 15/4/26
 *
 */
public class BC39A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("data/in3.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i++) {
                count[scanner.nextInt()]++;
            }
            scanner.nextLine();
            //System.out.println(Arrays.toString(count));//

            int canDelete = 0, kind = 0;
            for (int i = 0; i < n + 1; i++) {
                if (count[i] > 0) {
                    kind++;//多一个数字
                    canDelete += count[i] - 1;//可以安全删除的数字个数
                }
            }
            int k = scanner.nextInt();
            if (k <= canDelete) {
                System.out.println(kind);//多余的删除够了
            } else {
                int r = k - canDelete;
                System.out.println(kind - r);
            }
        }
    }

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * hujiawei 15/4/26
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("data/in2.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        int t = scanner.nextInt();

        for (int k = 1; k <= t; k++) {
            System.out.println("Case #" + k + ":");

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            //System.out.println(n + " " + m + " " + q);
            scanner.nextLine();

            HashSet<Integer> male = new HashSet<Integer>(n);
            HashSet<Integer> female = new HashSet<Integer>(n);

            for (int i = 1; i <= n; i++) {
                int sex = scanner.nextInt();
                if (sex == 1) {//male
                    male.add(i);
                } else {
                    female.add(i);
                }
            }
            scanner.nextLine();
            //System.out.println(male.size()+" "+female.size());

            int[][] map = new int[n + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                //System.out.println(x + " " + y + " " + z);
                map[x][y] = z;
                map[y][x] = z;
                scanner.nextLine();
            }
            //System.out.println("");

            String line;
            for (int j = 1; j <= q; j++) {
                line = scanner.nextLine();
                //System.out.println(line);
                if (line.startsWith("1")) {
                    String[] arr = line.split(" ");
                    int x = Integer.parseInt(arr[1]);
                    if (male.contains(x)) {
                        male.remove(x);
                    } else {
                        male.add(x);
                    }
                    if (female.contains(x)) {
                        female.remove(x);
                    } else {
                        female.add(x);
                    }
                } else if (line.startsWith("2")) {
                    String[] arr = line.split(" ");
                    int x = Integer.parseInt(arr[1]);
                    int y = Integer.parseInt(arr[2]);
                    int z = Integer.parseInt(arr[3]);
                    map[x][y] = z;
                    map[y][x] = z;
                } else {//query
                    int sum = 0;
                    for (Integer x : male) {
                        for (Integer y : female) {
                            sum += map[x][y];
                        }
                    }
                    System.out.println(sum);
                }
            }
        }
    }


}

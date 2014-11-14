import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

//https://code.google.com/codejam/contest/6214486/dashboard#s=p1

public class ProblemB {

    private static int n, p;
    private static ArrayList<Bus> buses;
    private static ArrayList<Integer> cities;

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("data/out.txt")));
        System.setOut(out);
        System.setErr(out);
        Scanner scanner = new Scanner(new FileInputStream("data/in.txt"));

        int t = scanner.nextInt();
        int c = 1;
        while (t-- > 0) {
            buses = new ArrayList<Bus>();
            cities = new ArrayList<Integer>();
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                buses.add(new Bus(scanner.nextInt(), scanner.nextInt()));
            }
            p = scanner.nextInt();
            for (int i = 0; i < p; i++) {
                cities.add(scanner.nextInt());
            }
            System.out.print("Case #" + c + ": ");
            solve2();
            System.out.println();
            c++;
        }

        out.flush();
        out.close();
    }

    //暴力解决
    private static void solve2() {
        int key, sum;
        for (int i = 0; i < p; i++) {
            key = cities.get(i);
            sum = 0;
            for (Bus bus : buses) {
                if (key >= bus.x && key <= bus.y) {
                    sum++;
                }
            }
            System.out.print(sum + " ");
        }
    }

    //非暴力解决，但是仍然存在问题
    private static void solve() {
        Comparator<Bus> cf = new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x < o2.x) {
                    return -1;
                }
                return 0;
            }
        };
        Comparator<Bus> ct = new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                if (o1.y > o2.y) {
                    return 1;
                } else if (o1.y < o2.y) {
                    return -1;
                }
                return 0;
            }
        };

        Collections.sort(buses, cf);

        int left, right, key;
        for (int i = 0; i < p; i++) {
            key = cities.get(i);
            left = bs_f(buses, key);//从left开始都是大于key的数字
            List<Bus> flist = buses.subList(0, left);//left=0, size=0
            if (flist.size() > 0) {
                Collections.sort(flist, ct);
                right = bs_t(flist, key);//从right开始都是大于等于key的数字
                List<Bus> tlist = flist.subList(right, flist.size());
                System.out.print(tlist.size() + " ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    private static int bs_f(List<Bus> lbus, int r) {
        int len = lbus.size();
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r < lbus.get(mid).x) {
                right = mid - 1;
            } else if (r >= lbus.get(mid).x) {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int bs_t(List<Bus> lbus, int r) {
        int len = lbus.size();
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r <= lbus.get(mid).y) {
                right = mid - 1;
            } else if (r > lbus.get(mid).y) {
                left = mid + 1;
            }
        }
        return left;
    }

}

class Bus {

    int x;
    int y;

    Bus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}




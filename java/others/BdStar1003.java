import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * hujiawei 15/5/25
 * <p/>
 * 百度之星 资格赛 1003 IP聚合
 */
public class BdStar1003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("data/bdstar1003.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        int t = scanner.nextInt();
        for (int k = 1; k <= t; k++) {
            System.out.println("Case #" + k+":");
            int n = scanner.nextInt(), m = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Address> ipAddress = new ArrayList<Address>(n);
            ArrayList<Address> maskAddress = new ArrayList<Address>(m);

            for (int i = 0; i < n; i++) {
                ipAddress.add(new Address(scanner.next()));
            }
            for (int i = 0; i < m; i++) {
                maskAddress.add(new Address(scanner.next()));
            }
            for (Address maddress : maskAddress) {
                //System.out.println(maddress);
                HashSet<Address> uniqueAddress = new HashSet<Address>();
                for (Address paddress : ipAddress) {
                    //System.out.println(paddress);
                    uniqueAddress.add(new Address(maddress.a & paddress.a, maddress.b & paddress.b,
                            maddress.c & paddress.c, maddress.d & paddress.d));
                }
                System.out.println(uniqueAddress.size());
            }
        }

    }

    static class Address {
        int a, b, c, d;

        Address(String s) {
            //System.out.println("address: "+s);
            String[] strArray = s.split("\\.");//.需要转义
            a = Integer.parseInt(strArray[0]);
            b = Integer.parseInt(strArray[1]);
            c = Integer.parseInt(strArray[2]);
            d = Integer.parseInt(strArray[3]);
        }

        Address(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Address address = (Address) o;

            if (a != address.a) return false;
            if (b != address.b) return false;
            if (c != address.c) return false;
            if (d != address.d) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + d;
            return result;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

}

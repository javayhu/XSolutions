import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

//https://code.google.com/codejam/contest/6214486/dashboard#s=p2

public class ProblemC {

    private static Map<String, String> flights;
    private static Map<String, City> citymap;

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("data/out.txt")));
        System.setOut(out);
        System.setErr(out);
        Scanner scanner = new Scanner(new FileInputStream("data/in.txt"));

        int t = scanner.nextInt();
        int c = 1;
        while (t-- > 0) {
            System.out.print("Case #" + c + ": ");
            flights = new HashMap<String, String>();
            citymap = new HashMap<String, City>();
            int p = scanner.nextInt();
            String from, to;
            City cf, ct;
            for (int i = 0; i < p; i++) {
                from = scanner.next();
                to = scanner.next();

                if (citymap.containsKey(from)) {
                    cf = citymap.get(from);
                } else {
                    cf = new City();
                    citymap.put(from, cf);
                }
                cf.name = from;
                cf.out = 1;

                if (citymap.containsKey(to)) {
                    ct = citymap.get(to);
                } else {
                    ct = new City();
                    citymap.put(to, ct);
                }
                ct.name = to;
                ct.in = 1;

                flights.put(from, to);
            }
            solve();
            c++;
            System.out.println();
        }

        out.flush();
        out.close();
    }

    private static void solve() {
        String from = null;
        Set<Map.Entry<String, City>> entries = citymap.entrySet();
        for (Map.Entry<String, City> entry : entries) {
            //System.out.println("name=" + entry.getValue().name + " in=" + entry.getValue().in + " out=" + entry.getValue().out);
            if (entry.getValue().in == 0) {
                from = entry.getKey();
                break;
            }
        }

        String next;
        String current = from;
        while (current != null && flights.containsKey(current)) {
            next = flights.get(current);
            System.out.print(citymap.get(current).name + "-" + citymap.get(next).name + " ");
            current = next;
        }
    }

}

class City {

    String name;
    int in = 0;
    int out = 0;

}



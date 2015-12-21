import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 *
 *
 *
 * hujiawei 15/10/18
 */
public class PA {

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("data/out.txt")));
        System.setOut(out);
        System.setErr(out);
        Scanner scanner = new Scanner(new FileInputStream("data/in.txt"));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int numbera = o1.intValue();
                int numberb = o2.intValue();
                if (numberb > numbera) {
                    return 1;
                } else if (numberb < numbera) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        int t = scanner.nextInt();
        int[] s;
        int p, n, w, m;
        String name;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<String, PriorityQueue<Integer>>();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ":");

            p = scanner.nextInt();
            s = new int[p];
            for (int j = 0; j < p; j++) {
                s[j] = scanner.nextInt();
            }
            n = scanner.nextInt();
            for (int k = 0; k < n; k++) {
                w = scanner.nextInt();
                for (int q = 0; q < p; q++) {
                    name = scanner.next();
                    if (map.containsKey(name)) {
                        map.get(name).add(w * s[q]);
                    } else {
                        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(n, comparator);
                        priorityQueue.add(w * s[q]);
                        map.put(name, priorityQueue);
                    }
                }
            }
            m = scanner.nextInt();
            PriorityQueue<PersonScore> personScores = new PriorityQueue<PersonScore>();
            for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
                int time = 0, value = 0;
                PriorityQueue<Integer> pq = entry.getValue();
                while (time < m && !pq.isEmpty()) {
                    value += pq.poll();
                    time++;
                }

                PersonScore ps = new PersonScore(entry.getKey(), value);
                personScores.add(ps);
            }

            int k = 1, lastk = 1, lastvalue = 0;
            while (!personScores.isEmpty()) {
                PersonScore ps = personScores.poll();
                if (lastvalue == ps.score) {
                    System.out.println(lastk + ": " + ps.name);
                    k++;
                } else {
                    System.out.println(k + ": " + ps.name);
                    lastk = k;
                    lastvalue = ps.score;
                    k++;
                }
            }

        }

        out.flush();
        out.close();
    }

    static class PersonScore implements Comparable<PersonScore> {
        String name;
        int score;

        PersonScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(PersonScore o) {
            return o.score - this.score;
        }
    }

}
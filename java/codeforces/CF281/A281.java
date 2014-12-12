package CF281;

import java.util.Scanner;

//http://codeforces.com/contest/493/problem/A

public class A281 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String shome = cin.nextLine();
        String saway = cin.nextLine();
        int[] h = new int[100];
        int[] ht = new int[100];
        int[] a = new int[100];
        int[] at = new int[100];
        int[] outh = new int[100];
        int[] outa = new int[100];
        int n = Integer.parseInt(cin.nextLine());

        for (int j = 0; j < 100; j++) {//time = 100
            ht[j] = 100;
            at[j] = 100;
        }

        String[] seps;
        int time, num;
        String line, team, card;
        for (int i = 1; i <= n; i++) {
            line = cin.nextLine();
            seps = line.split(" ");
            time = Integer.parseInt(seps[0]);
            team = seps[1];
            num = Integer.parseInt(seps[2]);
            card = seps[3];

            if (team.equalsIgnoreCase("h")) {
                if (outh[num] == 1) {
                    continue;
                }
                if (card.equalsIgnoreCase("r")) {
                    System.out.println(shome + " " + num + " " + time);
                    outh[num] = 1;
                } else {//y
                    if (ht[num] == 100) {
                        ht[num] = time;
                    } else {
                        ht[num] = Math.max(ht[num], time);
                        System.out.println(shome + " " + num + " " + time);
                        outh[num] = 1;
                    }
                }
            } else {
                if (outa[num] == 1) {
                    continue;
                }
                if (card.equalsIgnoreCase("r")) {
                    System.out.println(saway + " " + num + " " + time);
                    outa[num] = 1;
                } else {//y
                    if (at[num] == 100) {
                        at[num] = time;
                    } else {
                        at[num] = Math.max(at[num], time);
                        System.out.println(saway + " " + num + " " + time);
                        outa[num] = 1;
                    }
                }
            }
        }

    }

}

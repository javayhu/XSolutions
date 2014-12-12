package CF279;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//http://codeforces.com/contest/490/problem/A

//ac
public class A279 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();

        int t;
        for (int i = 0; i < n; i++) {
            t = cin.nextInt();
            if (t == 1) {
                list1.add(i);
            } else if (t == 2) {
                list2.add(i);
            } else {
                list3.add(i);
            }
        }

        if (list1.size() <= 0 || list2.size() <= 0 || list3.size() <= 0) {
            System.out.println("0");
            return;
        }

        int i = 0, j = 0, k = 0;
        List<AItem> items = new ArrayList<AItem>();

        for (; i < list1.size() && j < list2.size() && k < list3.size(); ) {
            items.add(new AItem(list1.get(i) + 1, list2.get(j) + 1, list3.get(k) + 1));
            i++;
            j++;
            k++;
        }

        System.out.println(items.size());
        for (AItem item : items) {
            System.out.println(item.i + " " + item.j + " " + item.k);
        }

    }


    static class AItem {
        int i, j, k;

        AItem(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

}

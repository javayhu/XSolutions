import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * hujiawei - 14/11/2.
 */

//http://dsalgo.openjudge.cn/linearlists/1/

public class PMOOC5467 {

    private static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int k = cin.nextInt();
        ArrayList<Item> itemOne;
        ArrayList<Item> itemTwo;
        while (k-- > 0) {
            itemOne = new ArrayList<Item>();
            itemTwo = new ArrayList<Item>();
            fillInItems(itemOne);
            fillInItems(itemTwo);
            dealItems(itemOne, itemTwo);
        }
    }

    private static void dealItems(ArrayList<Item> itemOne, ArrayList<Item> itemTwo) {
        Collections.sort(itemOne);
        Collections.sort(itemTwo);
        Iterator<Item> itOne = itemOne.iterator();
        Iterator<Item> itTwo = itemTwo.iterator();
        ArrayList<Item> result = new ArrayList<Item>();
        Item one = null, two = null;
        if (itOne.hasNext()) one = itOne.next();
        if (itTwo.hasNext()) two = itTwo.next();
        while (one != null || two != null) {
            if (one != null && two != null) {
                if (one.b > two.b) {
                    result.add(one);
                    if (itOne.hasNext()) one = itOne.next();
                    else one = null;
                } else if (one.b < two.b) {
                    result.add(two);
                    if (itTwo.hasNext()) two = itTwo.next();
                    else two = null;
                } else {
                    result.add(new Item(one.a + two.a, one.b));
                    if (itOne.hasNext()) one = itOne.next();
                    else one = null;
                    if (itTwo.hasNext()) two = itTwo.next();
                    else two = null;
                }
            } else if (one != null) {
                result.add(one);
                if (itOne.hasNext()) one = itOne.next();
                else one = null;
            } else if (two != null) {
                result.add(two);
                if (itTwo.hasNext()) two = itTwo.next();
                else two = null;
            }
        }
        for (Item item : result) {
            if (item.a != 0)
                System.out.print("[ " + item.a + " " + item.b + " ] ");
        }
        System.out.println();
    }

    private static void fillInItems(ArrayList<Item> items) {
        int ia, ib, index;
        Item item;
        while (true) {
            ia = cin.nextInt();
            ib = cin.nextInt();
            if (ib >= 0) {
                item = new Item(ia, ib);
                index = items.indexOf(item);
                if (index >= 0) {
                    items.get(index).a += item.a;
                } else {
                    items.add(item);
                }
            } else {
                break;
            }
        }
    }

    static class Item implements Comparable {

        int a;
        int b;

        public Item(int ia, int ib) {
            this.a = ia;
            this.b = ib;
        }

        @Override
        public int compareTo(Object o) {
            if (this.b < ((Item) o).b) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return this.b == ((Item) obj).b;
        }
    }

}





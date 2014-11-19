import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * hujiawei - 14/11/5.
 */


//两种快排


public class Test277A {

    private static ArrayList<ASwap> swaps;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        swaps = new ArrayList<ASwap>();
        quickSort(a, 0, n - 1);
        System.out.println(swaps.size());
        for (ASwap swap : swaps) {
            System.out.println(swap.x + " " + swap.y);
        }
    }

    static int partition(int a[], int low, int high) {
        int tmp = a[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && a[j] >= tmp) {
                j--;
            }
            while (i < j && a[i] <= tmp) {
                i++;
            }
            swap(a, i, j);
        }
        a[low] = a[i];
        a[i] = tmp;
        if (i != low) swaps.add(new ASwap(i, low));
        return i;
    }

    static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        if (i != j) swaps.add(new ASwap(i, j));
    }

    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            if (check(a, low, high)) return;
            int pos = partition(a, low, high);
            quickSort(a, low, pos - 1);
            quickSort(a, pos + 1, high);
        }
    }

    // partition, locate the pivot value in properate position
    //static int partition(int a[], int low, int high) {
    //    int key = a[high];//pivot
    //    int i = low - 1, temp;
    //    for (int j = low; j < high; j++) {
    //        if (a[j] < key) {
    //            i++;
    //            temp = a[j];
    //            a[j] = a[i];
    //            a[i] = temp;
    //            swaps.add(new ASwap(i, j));
    //        }
    //    }
    //    temp = a[high];
    //    a[high] = a[i + 1];
    //    a[i + 1] = temp;//i+1 is the split point
    //    swaps.add(new ASwap(i + 1, high));
    //    return i + 1;
    //}
    //
    //// quick sort
    //static void quicksort(int a[], int low, int high) {
    //    if (low < high) {
    //        if (check(a, low, high)) return;
    //        int p = partition(a, low, high);
    //        quicksort(a, low, p - 1);
    //        quicksort(a, p + 1, high);
    //    }
    //}

    static boolean check(int a[], int low, int high) {
        for (int i = low; i < high; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    static class ASwap {

        int x, y;

        ASwap(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}



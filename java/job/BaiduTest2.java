import java.util.Map;
import java.util.Scanner;

/**
 * hujiawei 15/9/28
 */
public class BaiduTest2 {

    static Map<String, Integer> map;

    static {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.put("h", 8);
        map.put("i", 9);
        map.put("j", 10);
        map.put("k", 11);
        map.put("l", 12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            String sub;
            int sum = 0, v;
            for (int i = 0; i < s.length(); i++) {
                sub = s.substring(i, i + 1);
                v = map.get(sub);
                sum += (v - 1) * (11 - i);///
            }

        }
    }


    public void nextPermutation(int[] num) {
        int p = num.length - 1, k;

        while ((p > 0)) {
            if (num[p] > num[p - 1]) {//后面的元素大于前面的元素
                // 找到从p到末尾的最小的但是大于num[p-1]的元素的位置
                for (k = num.length - 1; k >= p; k--) {
                    if (num[k] > num[p - 1]) {
                        break;
                    }
                }
                // 将这个元素和p-1位置的元素进行交换
                swap(num, p - 1, k);
                // 将p-1位置之后的所有元素进行反转
                reverse(num, p, num.length - 1);
                return;
            }
            p--;
        }
        //不存在上面的情况，反转数组即可
        reverse(num, 0, num.length - 1);
    }

    // 将数组从l到r（两边都包括）进行反转
    private void reverse(int[] num, int l, int r) {
        while ((l < r)) {
            swap(num, l, r);
            l++;
            r--;
        }
    }

    // 交换数组位置i和位置j上的元素
    private void swap(int[] num, int i, int j) {
        int t = num[j];
        num[j] = num[i];
        num[i] = t;
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/20.
 */
public class AAAAAAAA {

    public static void main(String[] args) {

        System.out.println(new String("2b37ddb1972061b91f24f3e1b9d84c66ad00dd14").length());

        //System.out.println(2%6);//2
        //String str = "01234567890";
        //int start = 0;
        //String tag = str.substring(start, start + 8);
        //System.out.println(tag);
    }

    private static void test3() {
        int n = 2147395599;
        int m = n / 2;
        int m2 = m * m;
        System.out.println(m2);
    }

    private static void test2() {
        List<String> list = new ArrayList<String>();
        list.add("china");
        list.add("test");
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void test1() {
        String tmp = "ghalshdg";
        char[] chars = tmp.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }

}

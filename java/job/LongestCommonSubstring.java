public class LongestCommonSubstring {


    public static void main(String[] args) {
        String a = "www.hankcs.com";
        String b = "hankcs";

        int[] x = {1, 2, 3, 4};
        int[] y = {2, 3, 4, 5};

        System.out.println(LongestCommonSubstring.compute(x, y));
        //System.out.println(LongestCommonSubstring.compute(a.toCharArray(), b.toCharArray()));
    }

    public static int compute(int[] str1, int[] str2) {
        int size1 = str1.length;
        int size2 = str2.length;
        if (size1 == 0 || size2 == 0) return 0;

        /*// the start position of substring in original string
        int start1 = -1;
        int start2 = -1;*/
        // the longest length of common substring
        int longest = 0;

        // record how many comparisons the solution did;
        // it can be used to know which algorithm is better
        /*int comparisons = 0;*/

        for (int i = 0; i < size1; ++i) {
            int m = i;
            int n = 0;
            int length = 0;
            while (m < size1 && n < size2) {
                /*++comparisons;*/
                if (str1[m] != str2[n]) {
                    length = 0;
                } else {
                    ++length;
                    if (longest < length) {
                        longest = length;
                        /*start1 = m - longest + 1;
                        start2 = n - longest + 1;*/
                    }
                }

                ++m;
                ++n;
            }
        }

        // shift string2 to find the longest common substring
        for (int j = 1; j < size2; ++j) {
            int m = 0;
            int n = j;
            int length = 0;
            while (m < size1 && n < size2) {
                /*++comparisons;*/
                if (str1[m] != str2[n]) {
                    length = 0;
                } else {
                    ++length;
                    if (longest < length) {
                        longest = length;
                        /*start1 = m - longest + 1;
                        start2 = n - longest + 1;*/
                    }
                }

                ++m;
                ++n;
            }
        }
        //System.out.printf("from %d of str1 and %d of str2, compared for %d times\n", start1, start2, comparisons);
        return longest;
    }
}
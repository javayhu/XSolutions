

public class MaxCommonSubArrayLen {

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int[] B = {1, 2, 1, 3, 1, 2};
        System.out.println(f(A, B));
    }

    //原始解法
    public static int f(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0)
            return 0;
        if (A.length > B.length) {
            return f(B, A);
        }

        int max_Length = Integer.MIN_VALUE;
        int shortCounter = A.length;
        int longCounter = B.length;
        int count = 0;
        int current = 0;

        for (int i = 0; i <= longCounter - shortCounter; i++) {
            current = i;
            for (int j = 0; j < shortCounter; j++) {
                if (B[current] == A[j]) {
                    current++;
                    count++;
                } else {
                    current++;
                    if (count >= max_Length) {
                        max_Length = count;
                        count = 0;
                    }
                }
            }
        }
        return max_Length;
    }

}
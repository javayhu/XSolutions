


public class MaxCommonSubArrayLength {

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int[] B = {1, 2, 1, 3, 1, 2};
        System.out.println(f(A, B));
    }

    //原始解法
    public static int f(int[] A, int[] B) {
        int max_Length = Integer.MIN_VALUE;
        int longCounter;
        int shortCounter;
        int[] longArray;
        int[] shortArray;
        int count = 0;
        int current = 0;
        if (A.length == 0 || B.length == 0)
            return 0;
        if (A.length >= B.length) {
            longCounter = A.length;
            shortCounter = B.length;
            longArray = A;
            shortArray = B;
        } else {
            longCounter = B.length;
            shortCounter = A.length;
            longArray = B;
            shortArray = A;
        }
        for (int i = 0; i <= longCounter - shortCounter; i++) {
            current = i;
            for (int j = 0; j < shortCounter; j++) {
                if (longArray[current] == shortArray[j]) {
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

    public static int function(int[] A, int[] B) {
        int max_Length = Integer.MIN_VALUE;
        int longCounter;
        int shortCounter;
        int arrayLength;
        int[] longArray;
        int[] shortArray;
        int count = 0;
        int current = 0;
        if (A.length == 0 || B.length == 0)
            return 0;
        if (A.length >= B.length) {
            longCounter = A.length;
            shortCounter = B.length;
            longArray = A;
            shortArray = B;
            arrayLength = shortCounter;
        } else {
            longCounter = B.length;
            shortCounter = A.length;
            longArray = B;
            shortArray = A;
            arrayLength = shortCounter;
        }
        for (int k = arrayLength; k >= 1; k--) {
            for (int i = 0; i <= longCounter - shortCounter; i += k) {
                current = i;
                for (int j = 0; j < shortCounter; j++) {
                    if (longArray[current] == shortArray[j]) {
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
        }
        return max_Length;
    }
}
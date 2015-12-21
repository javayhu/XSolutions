/**
 * 美团编程题第一题
 */
public class TestMT1 {

    public long getNumberOfCombinations(int N) {
        int coins[] = {1, 5, 10, 20, 50, 100};
        int total = N;
        int[] matrix = new int[total + 1];
        matrix[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < matrix.length; j++) {
                matrix[j] += matrix[j - coins[i]];
            }
        }
        return matrix[N];
    }

    public static void main(String[] args) {
        System.out.println(new TestMT1().getNumberOfCombinations(10));
    }
}
/**
 * hujiawei 15/4/27
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation_134 {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int step = 0, start = -1, total = 0;
        for (int i = 0; i < gas.length; i++) {
            step += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (step < 0) {
                start = i;
                step = 0;
            }
        }
        return total >= 0 ? start + 1 : -1;//
    }

}

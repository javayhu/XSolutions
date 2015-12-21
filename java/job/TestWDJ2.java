/**
 * 豌豆荚 2：在 N 个数中 出现次数超过 N/2 的那个数
 */

public class TestWDJ2 {

    public static void main(String[] args) {
        int[] array = {1,1,2,3};
        System.out.println(search(array));
    }
    public static int search(int[] array){
        if(array.length == 0 || array == null)
            return -1;//抛出错误
        int num = 1;
        int target = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] == target)
                num++;
            else{
                num--;
                if(num == 0){
                    target = array[i];
                    num = 1;
                }
            }
        }
        return target;
    }
}
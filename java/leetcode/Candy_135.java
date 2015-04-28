/**
 * hujiawei 15/4/27
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/candy/
 */
public class Candy_135 {

    public static void main(String[] args){

    }

    public int candy(int[] ratings) {
        int cntArr[] = new int[ratings.length];
        for(int i=0; i<cntArr.length; i++) cntArr[i]=1;
        for(int i=1; i<cntArr.length; i++){
            if(ratings[i] > ratings[i-1])
                cntArr[i] = cntArr[i-1]+1;
        }
        int ans = cntArr[cntArr.length-1];
        for(int i=cntArr.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1] && cntArr[i] <= cntArr[i+1])
                cntArr[i] = cntArr[i+1]+1;
            ans += cntArr[i];
        }
        return ans;
    }

}

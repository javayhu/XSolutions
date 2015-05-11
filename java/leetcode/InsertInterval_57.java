import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * hujiawei 15/5/2
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval_57 {

    //这道题的解法直接使用了mergeInterval的内容
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);//只是添加了这一步！
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<Interval>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (prev == null || inter.start > prev.end) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end > prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return ret;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}

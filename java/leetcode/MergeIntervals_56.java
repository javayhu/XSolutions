import java.util.*;

/**
 * hujiawei 15/5/2
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals_56 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(4, 9));
        List<Interval> list = new MergeIntervals_56().merge(intervals);
        System.out.println(list.size());
    }

    //ac https://leetcode.com/discuss/33434/a-clean-java-solution
    public List<Interval> merge(List<Interval> intervals) {
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

    //超时
    public List<Interval> merge2(List<Interval> intervals) {
        LinkedList<Interval> list = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) return list;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;//按照start升序排列
            }
        });

        list.add(intervals.get(0));
        Interval last, cur;
        for (int i = 1; i < intervals.size(); i++) {
            last = intervals.get(i - 1);//每次当前区间插入时需要考虑的只有前面的区间
            cur = intervals.get(i);
            //hujiawei 超时的原因在于这里存在着太多的添加删除操作！而ac的代码只是修改数据！
            if (cur.start > last.end) {
                list.addLast(cur);
            } else {
                list.removeLast();
                list.add(new Interval(last.start, Math.max(last.end, cur.end)));
            }
        }
        return list;
    }

    static class Interval {
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

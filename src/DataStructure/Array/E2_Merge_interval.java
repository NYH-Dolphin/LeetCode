package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E2_Merge_interval {
    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{2, 6};
        intervals[2] = new int[]{8, 10};
        intervals[3] = new int[]{15, 18};

        int[][] intervals1 = new int[1][2];
        intervals[0] = new int[]{1, 3};

        int[][] intervals2 = new int[2][2];
        intervals2[0] = new int[]{1, 4};
        intervals2[1] = new int[]{1, 4};
        int[][] sol = merge(intervals2);
        for (int[] ints : sol) {
            System.out.println("[" + ints[0] + "," + ints[1] + "]");
        }
    }

    // 解法1
    public static int[][] merge(int[][] intervals) {
        // 区间长度为 1，直接返回
        if (intervals.length == 1) {
            return intervals;
        }

        // 按照区间第一个数升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();

        // 区间指针 m 和 n
        int m = intervals[0][0], n = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 不重合
            if (intervals[i][0] > n) {
                // 添加并更新
                list.add(new int[]{m, n});
                m = intervals[i][0];
                n = intervals[i][1];
                // 交叉
            } else if (intervals[i][1] > n) {
                // 扩大区间
                n = intervals[i][1];
            }
            // 包含不做任何事情

            // 最后一个的情况
            if (i == intervals.length - 1) {
                list.add(new int[]{m, n});
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    // 解法2
    public static int[][] merge1(int[][] intervals) {
        // 按照区间第一个数升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();

        // 区间指针 m 和 n
        int m = intervals[0][0], n = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 不重合
            if (intervals[i][0] > n) {
                // 添加并更新
                list.add(new int[]{m, n});
                m = intervals[i][0];
                n = intervals[i][1];
                // 交叉或包含
            } else if (intervals[i][1] > n) {
                // 选择大的那个
                n = Math.max(n,intervals[i][1]);
            }
        }

        // 最后一个
        list.add(new int[]{m, n});
        return list.toArray(new int[list.size()][]);
    }
}

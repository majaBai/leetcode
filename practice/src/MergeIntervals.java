/*
* Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
*
*
* */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals{

//    private static class IntervalCompare implements Comparator<int []>{
//        @Override
//        public int compare(int[] a, int[]b){
//            return a[0]<b[0]? -1 : a[0]==b[0]? 0 : 1;
//        }
//    }

    public static int[][] merge(int[][] intervals){
//        Collections.sort(Arrays.asList(intervals), new IntervalCompare());
        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int []> m = new LinkedList<>();
        for(int[] t : intervals){
            if(m.isEmpty() || m.getLast()[1] < t[0]) m.add(t);
            else m.getLast()[1] = Math.max(m.getLast()[1], t[1]);
        }
        return m.toArray(new int[m.size()][]);
    }

    public static void main(String[] args){

        {
            int[][] a = {
                    {1, 3},
                    {2, 6},
                    {8, 10},
                    {15, 18}
            };
            for(int[] i : merge(a)){
                System.out.println(Arrays.toString(i));
            }
        }
        System.out.println("-------------");
        {
            int[][] a = {
                    {1, 9},
                    {2, 5},
                    {19, 20},
                    {10, 11},
                    {12, 20},
                    {0, 3},
                    {0, 1},
                    {0, 2}
            };
            for(int[] i : merge(a)){
                System.out.println(Arrays.toString(i));
            }
        }
    }
}
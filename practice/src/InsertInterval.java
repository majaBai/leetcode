/*
*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*
* */

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval{

    public static int[][] merge(int[][] intervals){
        if(intervals.length == 1) return intervals;
        LinkedList<int []> merged = new LinkedList<int []>();
        for(int[] t : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < t[0]){
                merged.add(t);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],t[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static  int[][] insert(int[][] intervals, int[] newInterval){
        if(intervals.length == 0 && newInterval.length ==0) return null;
        if(intervals.length == 0 && newInterval.length != 0){
            int[][] r = new int[1][];
            r[0] = newInterval;
            return r;
        }
        int lo = 0, hi = intervals.length -1, rank = -1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(intervals[mid][0] < newInterval[0]) lo = mid +1;
            else if(intervals[mid][0] > newInterval[0]) hi = mid -1;
            else {
                rank = mid;
                break;
            }
        }
        if(rank == -1) rank = lo;
        int[][] temp = new int[intervals.length +1][];
        for(int i = 0; i <= intervals.length; i++){
            if(i < rank) temp[i] = intervals[i];
            if(i == rank) temp[i] = newInterval;
            if(i > rank) temp[i] = intervals[i-1];
        }
        return merge(temp);
    }

    public static void main(String[] args){
        {
            int[][] intervals = {
                    {1, 3},
                    {6, 9}
            };
            int[] n = {2, 5};
            for(int[] i : insert(intervals, n)) System.out.println(Arrays.toString(i));
        }
        System.out.println("---------");
        {
            int[][] intervals = {
                    {1, 2},
                    {3, 5},
                    {6, 7},
                    {8, 10},
                    {12, 16}
            };
            int[] n = {4, 8};
            for(int[] i : insert(intervals, n)) System.out.println(Arrays.toString(i));
        }
        System.out.println("---------");
        {
            int[][] intervals = new int[0][];
            int[] n = {5, 7};
            for(int[] i : insert(intervals, n)) System.out.println(Arrays.toString(i));
        }
    }
}
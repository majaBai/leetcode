/*
* Given an array of integers, find out whether there are two distinct indices i and j in the array
* such that the absolute difference between nums[i] and nums[j] is at most t (<=t)
* and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
*
Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
*
Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
* */

import java.util.Random;

public class ContainsDuplicate{

//    O(N^2) , time out
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                long diff = Math.abs(((long)nums[i] - (long)nums[j]));
                if(diff <= t && Math.abs(i - j) <= k) return true;
            }
        }
        return false;
    }

//    O(n*K)
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= Math.min(nums.length-1, i+k); j++){
                long diff = Math.abs(((long)nums[i] - (long)nums[j]));
                if(diff <= t) {
                    System.out.println("diff is: " + diff + "; " + "nums[i]: "+ nums[i] + ", " + "nums[j]: " + nums[j] + "; " + " "+ " i is: " +i +" j is: " + j);
                    return true;
                }
            }
        }
        return false;
    }


public static int random(int i){
    Random r = new Random();
    return r.nextInt(i);
}


    public static void main(String[] args){
        {
            for(int i = 50; i < 100000000; i *= 20){
                int[] nums = new int[i];
                for(int j = 0; j < i; j++){
                    nums[j] = random(2*i);
                }
                int k = random(i);
                int t = random(i);
                System.out.println("length: "+ i +" " +  " k = " + k + " t = " + t);
                StopWatch timer1 = new StopWatch();
                boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
                double time1 = timer1.elapsedTime();
                System.out.print(r);
                System.out.print(" " + " " + time1 + " ");
                StopWatch timer2 = new StopWatch();
                boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
                double time2 = timer2.elapsedTime();
                System.out.print(r1);
                System.out.print(" " + " " + time2);
                System.out.println();
                System.out.println("************");
            }
        }
//        {
//            int[] nums = {1,5,9,1,5,9};
//            int k = 2, t = 3;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//
//        }
//        System.out.println("************");
//        {
//            int[] nums = {1,5,9,1,5,9};
//            int k = 2, t = 3;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//
//        }
//        System.out.println("************");
//        {
//            int[] nums = {-1,2147483647};
//            int k = 1, t =0;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//
//        }
//        System.out.println("************");
//        {
//            int[] nums = {-2147483647,2147483647};
//            int k = 1, t =0;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//
//        }
//        System.out.println("************");
//        {
//            int[] nums = {2, 2};
//            int k = 3, t =0;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//
//        }
//        System.out.println("************");
//        {
//            int[] nums = {7,1,3};
//            int k = 2, t =0;
//            StopWatch timer1 = new StopWatch();
//            boolean r = containsNearbyAlmostDuplicate2(nums, k, t);
//            double time1 = timer1.elapsedTime();
//            System.out.print(r);
//            System.out.print(" " + " " + time1 + " ");
//            StopWatch timer2 = new StopWatch();
//            boolean r1 = containsNearbyAlmostDuplicate(nums, k, t);
//            double time2 = timer2.elapsedTime();
//            System.out.print(r1);
//            System.out.print(" " + " " + time2);
//            System.out.println();
//        }
//        System.out.println("************");
    }
}
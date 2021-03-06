/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* */


import java.util.*;

public class threeSum {

    public static List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        {
            int[] nums = {-1, 0, 1, 2, -1, -4};
            List r = threeSum(nums);
            for (Object e : r) {
                System.out.println(e.toString());
            }
        }
        System.out.println("--------");
        {
            int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
            List r = threeSum(nums);
            for (Object e : r) {
                System.out.println(e.toString());
            }
        }
        System.out.println("--------");
        {
            int[] nums = {0, 0, 0};
            List r = threeSum(nums);
            for (Object e : r) {
                System.out.println(e.toString());
            }
        }
    }
}
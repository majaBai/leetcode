/*
* Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
* Find all unique quadruplets in the array which gives the sum of target.
Note:
The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
* */

import java.util.*;

public class FourSum{

    public static  List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(start == nums.length || nums[start]*k > target || target > nums[nums.length-1]*k) return res;
        if(k == 2) return twoSum(nums, target, start);
        for(int i = start; i< nums.length; ++i){
            if(i == start || nums[i-1] != nums[i]){
                for(var set : kSum(nums, target-nums[i], i+1, k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(set);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i = start; i < nums.length; ++i){
            if(res.isEmpty() || res.get(res.size()-1).get(1) != nums[i]){
                if(s.contains(target - nums[i])) res.add(Arrays.asList(target - nums[i], nums[i]));
            }
            s.add(nums[i]);
        }
        return res;
    }
    public static void main(String[] args){
        {
            int[] nums = {1, 0, -1, 0, -2, 2};
            int t = 0;
            System.out.println(fourSum(nums, t).toString());
        }
//        System.out.println("------");
//        {
//            int[] nums = {3, 4, 3, 4, -1, -2, -2, -1};
//            int t = 4;
//            System.out.println(fourSum(nums, t).toString());
//        }
//        System.out.println("------");
//        {
//            int[] nums = {-3,3,-3,3};
//            int t = 0;
//            System.out.println(fourSum(nums, t).toString());
//        }
//        System.out.println("------");

    }
}
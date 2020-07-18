/*
* Given an array of integers and an integer k,
* find out whether there are two distinct indices i and j in the array
* such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
* */

import java.util.HashSet;
import java.util.Hashtable;

public class HasDuplicateII{

//    O(N^2), time out
    public static boolean solution(int[] nums, int k){
        if(k <= 0) return false;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= Math.min(i+k, nums.length-1); j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

//    O(N) + O(k)
    public static boolean solution2(int[] nums, int k){
        HashSet<Integer> set = new HashSet<>(k);
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - k -1]);
            if(!set.add(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
  
    public static void main(String[] args){
        {
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            boolean r =solution2(nums, k);
            System.out.println(r);
        }
        {
            int[] nums = {1, 2, 3, 1, 2, 3};
            int k = 2;
            boolean r =solution2(nums, k);
            System.out.println(r);
        }
        {
            int[] nums = {1, 2, 1, 1};
            int k = 3;
            boolean r =solution2(nums, k);
            System.out.println(r);
        }
        {
            int[] nums = {1, 2, 1, 1};
            int k = 0;
            boolean r =solution2(nums, k);
            System.out.println(r);
        }
        {
            int[] nums = {4, 1, 2, 3, 1, 5};
            int k = 3;
            boolean r =solution2(nums, k);
            System.out.println(r);
        }
    }
}
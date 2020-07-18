/*
* Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false
* */

import java.util.Arrays;
import java.util.HashSet;

public class HasDuplicate{

//    O(N) + O(N)
    public static boolean solution(int[] nums){
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>(len);
        for(int i : nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

//    O(N) + O(1)
    public static boolean solution2(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args){
        {
            int[] nums = {1, 2, 3, 1};
            boolean r = solution2(nums);
            System.out.println(r);
        }
        {
            int[] nums = {1, 2, 3};
            boolean r = solution2(nums);
            System.out.println(r);
        }
    }
}
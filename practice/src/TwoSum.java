/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
* */

import java.util.HashMap;
import java.util.Hashtable;

public class TwoSum{

// two-pass hashTable
    public static int[] solution(int[] nums, int target){
        Hashtable<Integer, Integer> ht = new Hashtable<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            ht.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            Object obj = ht.get(key);
            if(obj != null && (int)obj != i){
                   return new int[]{i, (int)obj};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

// one-pass hashTable
    public static int[] solution2(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(hm.containsKey(key)) return new int[]{i, hm.get(key)};
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args){

    }
}
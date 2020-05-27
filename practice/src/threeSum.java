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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class threeSum {

    public static List<List<Integer>> towSum(int[] nums, int target, HashMap<Integer, Integer> hm, int j) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i != j) {
                int dif = target - nums[i];
                int idx = hm.getOrDefault(dif, -1);
                if (idx != -1 && idx != j && idx != i) {
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[idx]);
                    temp.add(nums[j]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static boolean containsList(List<List<Integer>> a, ArrayList<Integer> b){
        boolean bool = false;
        for(List<Integer> arr : a){
            if(arr.containsAll(b) && b.containsAll(arr)){
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList();
        var hm = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];
            List t = towSum(nums, -f, hm, i);
            if (!t.isEmpty()) {
                if(t.size() == 1){
                    if(r.isEmpty() || !containsList(r, (ArrayList<Integer>) t.get(0))){
                        r.add((List<Integer>)t.get(0));
                    }
                } else {
                    for(int k = 0; k < t.size(); k++){
                        if(r.isEmpty() || !containsList(r, (ArrayList<Integer>)t.get(k))){
                            r.add((ArrayList<Integer>)t.get(k));
                        }
                    }
                }

            }
        }
        return r;
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
/*
* Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
* Return the sum of the three integers. You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int r = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2;i++){
            int lo = i+1, hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum > target){
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    hi--;
                } else if(sum < target){
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    lo++;
                } else {
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(r - target)) r = sum;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        {
            int[] nums = {-1, 2, 1, -4};
            int target = 1;
            int r = threeSumClosest(nums, target);
            System.out.println(r);
        }
        {
            int[] nums = {-1, 2, -4};
            int target = 1;
            int r = threeSumClosest(nums, target);
            System.out.println(r);
        }
        {
            int[] nums = {0,2,1,-3};
            int target = 1;
            int r = threeSumClosest(nums, target);
            System.out.println(r);
        }

    }
}
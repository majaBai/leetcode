/*
* Given an integer array nums, find the contiguous subarray (containing at least one number)
* which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

follow up:
* If you have figured out the O(n) solution,
* try coding another solution using the divide and conquer approach, which is more subtle.
* */

public class MaxSubarray{

    public static int solution(int[] nums){
       int maxSofar = Integer.MIN_VALUE, sumLeft = 0;
       for(int i = 0; i < nums.length; i++){
           maxSofar = Math.max(maxSofar, sumLeft+nums[i]);
           sumLeft = Math.max(0, sumLeft+nums[i]);
       }
       return maxSofar;
    }

    // divide and conquer
    public static int solution2(int[] nums){
        return maxSubArray(nums, 0, nums.length-1);
    }

    public static int maxSubArray(int[] nums, int lo, int hi){
        if(lo > hi) return Integer.MIN_VALUE;
        int mid = lo+(hi-lo)/2,ml = 0, mr = 0;
        int lmax = maxSubArray(nums, lo, mid-1);
        int rmax = maxSubArray(nums, mid+1, hi);
        for(int i = mid-1, sum =0; i >= lo; i--){
            sum += nums[i];
             ml = Math.max(sum, ml);
        }
        for(int i = mid+1, sum =0;i<=hi;i++){
            sum+=nums[i];
            mr = Math.max(sum, mr);
        }
        return Math.max(Math.max(lmax, rmax), ml+mr+nums[mid]);
    }


    public static void main(String[] args){
        {
            int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
            int r = solution(nums);
            System.out.println(r);
        }
    }
}
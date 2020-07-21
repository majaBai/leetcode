/*
* Given an integer array nums, find the contiguous subarray (containing at least one number)
* which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

* If you have figured out the O(n) solution,
* try coding another solution using the divide and conquer approach, which is more subtle.
* */

public class MaxSubarray{

    public static int solution(int[] nums){
        int maxsofar = Integer.MIN_VALUE, leftPositive = 0;
        for(int i = 0; i < nums.length; i++){
            maxsofar = Math.max(maxsofar, leftPositive + nums[i]);
            leftPositive = Math.max(0, leftPositive + nums[i]);
        }
        return maxsofar;
    }

    public static void main(String[] args){
        {
            int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
            int r = solution(nums);
            System.out.println(r);
        }
    }
}
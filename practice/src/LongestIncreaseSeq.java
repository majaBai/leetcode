/*
* Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*
Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

Follow up:
Could you improve it to O(n log n) time complexity?
* */

import java.util.Arrays;

public class LongestIncreaseSeq{

//  Recursion, O(2^n), Size of recursion tree will be 2^n
    public static int solution1(int[] nums){
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

//   1. The current element(nums[curpos]) is larger than the previous element included in the LIS.
//    In this case, we can include the current element in the LIS.
//    Thus, we find out the length of the LIS obtained by including it.
//    Further, we also find out the length of LIS possible by not including the current element in the LIS.
//    The value returned by the current function call is, thus, the maximum out of the two lengths.
//   2. nums[curpos] < prev included in the LIS.
//   we can't include the current element in the LIS.
//   Thus, we find out only the length of the LIS possible by not including the current element in the LIS,
//   which is returned by the current function call.
    public static int lengthofLIS(int[] nums, int prev, int curpos){
        if(curpos == nums.length) return 0;
        int taken = 0;
        if(nums[curpos] > prev){
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos +1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos +1);
        return Math.max(taken, nottaken);
    }

//    Recursion with Memoization, O(N^2) + O(N^2)，(recursion tree is n^2 + memo[][] size of n*n
    public static int solution2(int[] nums){
//        memo[i][j] represents the length of the LIS possible using nums[i] as the previous element
//        considered to be included/not included in the LIS,
//        with nums[j] as the current element considered to be included/not included in the LIS.
          int[][] memo = new int[nums.length + 1][nums.length];
          for(int[] l : memo){
              Arrays.fill(l, -1);
          }
          return lengthofLIS(nums, -1, 0, memo);
    }
    public static int lengthofLIS(int[] nums, int prev, int curpos, int[][] memo){
        if(curpos == nums.length) return 0;
        if(memo[prev + 1][curpos] >= 0) return memo[prev +1][curpos];
        int taken = 0;
        if(prev < 0 || nums[curpos] > nums[prev]){
            taken = 1 + lengthofLIS(nums, curpos, curpos+1, memo);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1, memo);
        memo[prev +1][curpos] = Math.max(taken, nottaken);
        return memo[prev+1][curpos];
    }


//    dynamic programming O(N^2) + O(N), two loops of n + dp array of size n is used.
    public static int solution3(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for( int i = 1; i < dp.length; i++){
            int maxval = 0;
            for(int j =0; j < i; j++){
                if(nums[i] > nums[j]) maxval = Math.max(maxval, dp[j]);
            }
            dp[i]  = maxval +1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

//    O(lgN) + O(n), Dynamic Programming with Binary Search
    public static int solution4(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num: nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) i = -(i+1);
            dp[i] = num;
            if(i == len) len++;
        }
        return len;
    }


    public static void main(String[] args){
        {
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
            int t = solution1(nums);
            System.out.println(t);
        }
        {
            int[] nums = { 10, 9, 2, 5,3, 4};
            int t = solution1(nums);
            System.out.println(t);
        }
    }
}
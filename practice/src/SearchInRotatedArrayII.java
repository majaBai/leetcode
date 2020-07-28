/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

* Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
* */

public class  SearchInRotatedArrayII{

    public static boolean solution(int[] nums, int target){
      int lo = 0, hi = nums.length-1, mid = -1;
      while(lo <= hi){
          mid = (lo + hi) / 2;
          if(nums[mid] == target) return true;
          if(nums[mid] < nums[hi] || nums[mid] < nums[lo]){
              if(target > nums[mid] && target <= nums[hi]) lo = mid +1;
              else hi = mid -1;
          } else if(nums[mid] > nums[lo] || nums[mid] > nums[hi]){
              if(target < nums[mid] && target >= nums[lo]) hi = mid -1;
              else lo = mid +1;
          } else hi--;
      }
      return false;
    }



    public static void main(String[] args){
//        {
//            int[] nums = {2,5,6,0,0,1,2};
//            int t = 0;
//            System.out.println(solution(nums, t));
//        }
//        {
//            int[] a = {4, 5, 6,6, 7, 0,1,2};
//            int t = 3;
//            System.out.println(solution(a, t));
//        }
//        {
//            int[] a = {};
//            int t = 3;
//            System.out.println(solution(a, t));
//        }
//        {
//            int[] a = {4,4,4,5,5,1,1,2,3,3};
//            int t = 3;
//            System.out.println(solution(a, t));
//        }
//        {
//            int[] a = {4,4,4,4,4,1,1,2,2,2};
//            int t = 3;
//            System.out.println(solution(a, t));
//        }
//        {
//            int[] a = {3,1,1,1,1};
//            int t = 3;
//            boolean r = solution(a, t);
//            System.out.println(r);
//        }
        {
            int[] a = {1,3,1,1,1,1};
            int t = 3;
            boolean r = solution(a, t);
            System.out.println(r);
        }

        {
            int[] a = {1,1,3,1};
            int t = 3;
            boolean r = solution(a, t);
            System.out.println(r);
        }

    }
}
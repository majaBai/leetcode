/*
*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
* */
public class SearchInRotatedArray{

    public static int search(int[] nums, int target){
        if(nums.length == 0) return -1;
        int lo = 0, hi = nums.length -1;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target) return mid;
            if(nums[lo] <= nums[mid]){
                if(target < nums[mid] && target >= nums[lo]){
                    hi = mid - 1;
                } else {
                    lo = mid +1;
                }
            } else {
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid+1;
                } else {
                    hi = mid -1;
                }
            }
        }
        return nums[lo] == target? lo : -1;
    }

    public static void main(String[] args){
        {
            int[] a = {9, 8, 7, 5, 4};
            int t = 8;
            System.out.println(search(a, t));
        }
        System.out.println("-------");
        {
            int[] a = {};
            int t = 8;
            System.out.println(search(a, t));
        }
        System.out.println("-------");
        {
            int[] a = {4, 5, 6, 7, 0,1,2};
            int t = 3;
            System.out.println(search(a, t));
        }
        System.out.println("-------");
        {
            int[] a = {4, 5, 6, 7, 0,1,2};
            int t = 0;
            System.out.println(search(a, t));
        }

    }
}
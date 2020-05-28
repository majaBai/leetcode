/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
* */

public class SearchPosition{
    public static int[] searchRange(int[] nums, int target) {
        int[] r = {-1, -1};
        int lo = 0, hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] > target){
                hi = mid - 1;
            } else if(nums[mid] < target){
                lo = mid +1;
            } else {
                int start = mid;
                int end = mid;
                while(1<=start && nums[start] == nums[start-1]) start--;
                while(end< nums.length-1 && nums[end] == nums[end+1]) end++;
                r[0] = start;
                r[1] = end;
                break;
            }
        }
        return r;
    }

    public static void main(String[] args){
        {
            int[] nums = {5,7,7,8,8,10};
            int t = 8;
            for(Integer i : searchRange(nums, t)){
                System.out.println(i);
            }
        }
        System.out.println("--------");
        {
            int[] nums = {5,7,7,8,8,10,10,10,10};
            int t = 6;
            for(Integer i : searchRange(nums, t)){
                System.out.println(i);
            }
        }
        System.out.println("--------");

        {
            int[] nums = {5};
            int t = 5;
            for(Integer i : searchRange(nums, t)){
                System.out.println(i);
            }
        }
        System.out.println("--------");

        {
            int[] nums = {};
            int t = 5;
            for(Integer i : searchRange(nums, t)){
                System.out.println(i);
            }
        }
        System.out.println("--------");
        {
            int[] nums = {5,6,6,6,6,6,6,7,7,8,8,10};
            int t = 6;
            for(Integer i : searchRange(nums, t)){
                System.out.println(i);
            }
        }
    }
}
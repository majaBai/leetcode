/*
* Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
Example 1:
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
*
Example 2:
Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
*
Note:
You may assume all input has valid answer.
Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
* */

import java.util.Arrays;

public class WiggleSort{

    public static void wiggle(int[] nums){
        if(nums.length < 2) return;
        int mid = nums.length%2==0? nums.length/2 : (nums.length+1)/2;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int firstHalfEnd = mid - 1;
        int secondHalfEnd = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = copy[firstHalfEnd];
                firstHalfEnd--;
            } else {
                nums[i] = copy[secondHalfEnd];
                secondHalfEnd--;
            }
        }
    }

    public static void main(String[] args){
        {
            int[] nums ={1, 5, 1, 1, 6, 4};
            wiggle(nums);
            for(int i : nums) System.out.print(i + " ");
            System.out.println();
        }
        {
            int[] nums ={};
            wiggle(nums);
            for(int i : nums) System.out.print(i + " ");
            System.out.println();
        }
        {
            int[] nums ={3, 2};
            wiggle(nums);
            for(int i : nums) System.out.print(i + " ");
            System.out.println();
        }
        {
            int[] nums ={1,2, 1, 2, 2, 1, 1};
            wiggle(nums);
            for(int i : nums) System.out.print(i + " ");
            System.out.println();
        }
        {
            int[] nums ={7, 1, 4, 2};
            wiggle(nums);
            for(int i : nums) System.out.print(i + " ");
            System.out.println();
        }

    }
}
/*
* Given an array nums, write a function to move all 0's to the end of it
* while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
* */

import java.util.Arrays;

public class MoveZeroes{

    public static void swap(int[] nums, int j, int i){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void solution(int[] nums){
        int len = nums.length;
        if(len <= 1) return;
        int cur = 0;
        while(cur < len-1){
            while(cur < len && nums[cur] !=0) cur+=1;
            int next = cur +1;
            while(next < len && nums[next] == 0) next += 1;
            if(next < len && cur < len) swap(nums, cur, next);
            cur+=1;
        }
    }

//    best solution
    public static void solution2(int[] nums){
        int firstZeroIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[firstZeroIdx] = nums[i];
                firstZeroIdx++;
            }
        }
        for(int i = firstZeroIdx; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args){
        {
            int[] nums={0,1,0,3,12};
            solution2(nums);
            System.out.print(Arrays.toString(nums));
            System.out.println();
        }
        {
            int[] nums={0,1};
            solution2(nums);
            System.out.print(Arrays.toString(nums));
            System.out.println();
        }
        {
            int[] nums={4,2,4,0,0,3,0,5,1,0};
            solution2(nums);
            System.out.print(Arrays.toString(nums));
            System.out.println();
        }
        {
            int[] nums={0,11,0,13,0,0,0,0,12};
            solution2(nums);
            System.out.print(Arrays.toString(nums));
            System.out.println();
        }
        {
            int[] nums={2,1};
            solution2(nums);
            System.out.print(Arrays.toString(nums));
            System.out.println();
        }
    }
}
/*
* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.
Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
* First, iterate the array counting number of 0's, 1's, and 2's,
* then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
* */


import java.util.Arrays;

public class SortColors{
//counting sort
//    public static void sortClr(int[] c){
//        if(c.length!=0){
//            int[] counting = new int[3];
//            for(int i : c){
//                counting[i]++;
//            }
//            int j = 0;
//            for(int i = 0; i < counting.length; i++){
//                int l = counting[i];
//                while(l > 0) {
//                    c[j] = i;
//                    j++;
//                    l--;
//                }
//            }
//        }
//    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortClr(int[] nums){
        if(nums.length == 0) return;
        int lt = 0, i = 0, gt = nums.length -1;
        while(i <= gt){
            if(nums[i] == 0 && i > lt){
                swap(nums, i, lt);
                lt++;
            } else if(nums[i] == 2 && i < gt){
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
    }


    public static void main(String[] args){
        {
            int[] c = {2,0,2,1,1,0};
            sortClr(c);
            System.out.println(Arrays.toString(c));
        }
        System.out.println("-------");
        {
            int[] c = {};
            sortClr(c);
            System.out.println(Arrays.toString(c));
        }
    }
}
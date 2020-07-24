/*
* A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
*
Follow up: Your solution should be in logarithmic complexity.
* */

public class PeakElement{

//    O(N)
    public static int solution1(int[] nums){
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] > nums[i+1]) return i;
        }
        return nums.length-1;
    }

//   O(lgN)
//   bs, recursion
    public static int solution2(int[] nums){
        return search(nums, 0, nums.length-1);
    }

    public static int search(int[] nums, int l, int r){
        if(l == r) return l;
        int mid = (l + r)/2;
        if(nums[mid] > nums[mid] +1) return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

//    bs, iteration
    public static int solution3(int[] nums){
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]) r = mid;
            else l = mid +1;
        }
        return l;
    }



    public static void main(String[] args){

    }
}
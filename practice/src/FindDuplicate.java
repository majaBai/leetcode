/*
* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist.
Assume that there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3
*
Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
* */

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate{

//    sorting, but changed array
    public static int solution1(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]) return nums[i];
        }
        throw new IllegalArgumentException("wrong argument");
    }

//    use set, but space complexity against rule
    public static int solution2(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        throw new IllegalArgumentException("wrong argument");
    }

//    fast and slow pointers
//    has duplicate == has cycle; so this problem equals finding out the cycle's begin
    public static int solution3(int[] nums){
        int fast = nums[0];
        int slow = nums[0];
//        find the intersection point of two pointer
        do{
            slow =nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);

//        find the entrance of cycle
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
//        fast == slow == entrance of cycle
        return fast;
    }


    public static void main(String[] args){
        {
            int[] nums = {1, 3, 4, 2, 2};
            int r = solution1(nums);
            System.out.println(r);
        }
    }

}
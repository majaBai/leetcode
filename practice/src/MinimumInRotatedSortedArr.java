/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2], [6,7,0,1,2,4,5]).

Find the minimum element.
You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1
*
* */

public class MinimumInRotatedSortedArr{

    public static int solution(int[] nums){
       if(nums.length == 1) return nums[0];
       int left = 0, right = nums.length-1;
//       no rotation
       if(nums[right] > nums[0]) return nums[0];

       while(right >= left){
           int mid = (left + right) / 2;
           if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
           if(nums[mid -1] > nums[mid]) return nums[mid];
           if(nums[mid] >nums[0]){
               left = mid +1;
           } else {
               right = mid -1;
           }
       }
       return -1;
    }

    public static int solution2(int[] nums){
        int lo = 0, hi = nums.length -1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]) hi = mid;
            else lo = mid + 1;
        }
        return nums[hi];
    }

    public static void main(String[] args){
        {
            int[] nums = {3, 4, 5, 1, 2};
            int r = solution2(nums);
            System.out.println(r);
        }
        {
            int[] nums = {7};
            int r = solution2(nums);
            System.out.println(r);
        }
        {
            int[] nums = {3,4, 5};
            int r = solution2(nums);
            System.out.println(r);
        }
    }
}
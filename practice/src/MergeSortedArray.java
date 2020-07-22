/*
* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]


Constraints:
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
* */

import java.util.Arrays;

public class MergeSortedArray{

    public static void solution(int[] nums1, int m, int[] nums2, int n){
        if(nums2 == null) return;
        int i = 0, j = 0, h = m;
        while(h < m + n){
            while(i < h && nums1[i] <= nums2[j]) i++;
            for(int k = h; k > i; k--) nums1[k] = nums1[k-1];
            nums1[i++] = nums2[j++];
            h++;
        }
    }

    public static void main(String[] args){
        {
            int[] nums1 = {1,2,3,0,0,0};
            int m = 3;
            int[] nums2 = {2, 5, 6};
            int n = 3;
            solution(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));
        }
        {
            int[] nums1 = {3, 5, 6,0,0,0};
            int m = 3;
            int[] nums2 = {2, 4, 7};
            int n = 3;
            solution(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));
        }
        {
            int[] nums1 = {3, 5, 6};
            int m = 3;
            int[] nums2 = {};
            int n = 0;
            solution(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));
        }
        {
            int[] nums1 = {9, 13, 0};
            int m = 2;
            int[] nums2 = {1};
            int n = 1;
            solution(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));
        }
    }
}
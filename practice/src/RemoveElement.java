/*
* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:
Given nums = [3,2,2,3], val = 3,
Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,1,2,2,3,0,4,2], val = 2,
Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.
It doesn't matter what values are set beyond the returned length.
* */
public class RemoveElement {

    public static int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        {
            int[] nums = {3, 2, 2, 3};
            int val = 3;
            int r = removeElement(nums, val);
            assert r == 2 : "wrong result";
        }
        {
            int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
            int val = 2;
            int r = removeElement(nums, val);
            assert r == 5 : "wrong result";
        }
        {
            int[] nums = {};
            int val = 2;
            int r = removeElement(nums, val);
            assert r == 0 : "wrong result";
        }
        {
            int[] nums = {2};
            int val = 2;
            int r = removeElement(nums, val);
            assert r == 0 : "wrong result";
        }
        {
            int[] nums = {4};
            int val = 2;
            int r = removeElement(nums, val);
            assert r == 1 : "wrong result";
        }

    }
}
import java.util.HashMap;
/*1. Two Sum
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
* */
public class towSum {

    public static int[] towSum_backup(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] towSum(int[] nums, int target) {
        int[] result = {-1, -1};
        var hm = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int idx = hm.getOrDefault(diff, -1);
            if (idx != -1 & idx != i) {
                result[0] = i;
                result[1] = hm.get(diff);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 9;

        {
            int[] test1 = {2, 7, 11, 15};
            int[] a = towSum(test1, target);
            assert a[0] == 0 && a[1] == 1 : "wrong";
        }
        {
            int[] test1 = {11, 15, 0, 9};
            int[] a = towSum(test1, target);
            assert a[0] == 2 && a[1] == 3 : "wrong";
        }
        {
            int[] test1 = {11, 7, -2, 15};
            int[] a = towSum(test1, target);
            assert a[0] == 0 && a[1] == 2 : "wrong";
        }
        {
            int[] test1 = {11};
            int[] a = towSum(test1, target);
            assert a[0] == -1 && a[1] == -1 : "wrong";
        }
        {
            int[] test1 = {};
            int[] a = towSum(test1, target);
            assert a[0] == -1 && a[1] == -1 : "wrong";
        }
        {
            int[] test1 = {2, 7, 3, 6};
            int[] a = towSum(test1, target);
            assert a[0] == 0 && a[1] == 1 : "wrong";
        }

        {
            int[] test1 = {3, 2, 4};
            int[] a = towSum(test1, 6);
            assert a[0] == 1 && a[1] == 2 : "wrong";
        }


    }
}
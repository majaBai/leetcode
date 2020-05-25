
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
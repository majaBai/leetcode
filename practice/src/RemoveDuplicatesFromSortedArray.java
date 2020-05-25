
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums){
        if(nums.length == 0) return nums.length;
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return ++j;
}

    public static void main(String[] args){
        {
            int[] nums = {1,2,2};
            int r = removeDuplicates(nums);
            assert r == 2 : "incorrect result";
        }
        {
            int[] nums = {0,0,1,1,1,2,2,3,3,4};
            int r = removeDuplicates(nums);
            assert r == 1 : "incorrect result";
        }
        {
            int[] nums = {3};
            int r = removeDuplicates(nums);
            assert r == 1: "incorrect result";
        }
        {
            int[] nums = {};
            int r = removeDuplicates(nums);
            assert r == 0: "incorrect result";
        }

    }
}
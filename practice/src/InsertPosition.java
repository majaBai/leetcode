

public class InsertPosition{

    public static int searchInsert(int[] nums, int target){
        int  lo = 0, hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > target){
                hi = mid -1;
            } else if(nums[mid] < target){
                lo = mid+1;
            } else {
               return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args){
        {
            int[] nums = {1,3,5,6};
            int t = 5;
            System.out.println(searchInsert(nums,  t));
        }
        {
            int[] nums = {1,3,5,6};
            int t = 0;
            System.out.println(searchInsert(nums,  t));

        }
        {
            int[] nums = {1,3,5,6,9,12,13};
            int t = 10;
            System.out.println(searchInsert(nums,  t));

        }
        {
            int[] nums = {1,3,5,6};
            int t = 2;
            System.out.println(searchInsert(nums,  t));

        }
        {
            int[] nums = {1,3,5,6};
            int t = 10;
            System.out.println(searchInsert(nums,  t));

        }
        {
            int[] nums = {};
            int t = 5;
            System.out.println(searchInsert(nums,  t));

        }
    }
}
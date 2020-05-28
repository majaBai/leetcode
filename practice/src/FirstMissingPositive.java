import java.util.Arrays;

public class FirstMissingPositive{

    public static int firstMissingPositive(int[] nums){
        if(nums.length == 0) return 1;
        Arrays.sort(nums);
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                idx = i;
                break;
            }
        }
        if(idx == -1 || nums[idx] != 1) return 1;
        while(idx < (nums.length-1) && (nums[idx+1] - nums[idx] <= 1) ) idx++;
        return nums[idx] +1;
    }
    public static void main(String[] args){

        {
            int[] nums = {1,2,0};
            System.out.println(firstMissingPositive(nums));
        }
        System.out.println("------");
        {
            int[] nums = {3,4,-1,1};
            System.out.println(firstMissingPositive(nums));
        }
        System.out.println("------");
        {
            int[] nums = {7,8,9,11,12};
            System.out.println(firstMissingPositive(nums));
        }
        System.out.println("------");
        {
            int[] nums = {0,2,2,1,1};
            System.out.println(firstMissingPositive(nums));
        }
        System.out.println("------");
        {
            int[] nums = {};
            System.out.println(firstMissingPositive(nums));
        }


    }
}
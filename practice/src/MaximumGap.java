import java.util.Arrays;

/*
* Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
* */
public class MaximumGap{

    public static int find_maximum_gap(int[] nums){
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int gap = -1;
        for(int i = 0; i < nums.length -1; i++){
            int j = i +1;
            gap = Math.max(gap, nums[j]-nums[i]);
        }
        return gap;
    }
    public static void main(String[] args){
        {
            int[] a = {3, 6, 9, 1};
            System.out.println(find_maximum_gap(a));
        }
        System.out.println("------");
        {
            int[] a = {};
            System.out.println(find_maximum_gap(a));
        }
    }
}
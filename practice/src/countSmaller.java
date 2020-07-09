/*
* You are given an integer array nums and you have to return a new counts array.
* The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
* */

import java.util.ArrayList;
import java.util.Arrays;

public class countSmaller{

    public static ArrayList<Integer> CountSmaller(int[] nums){
        ArrayList r = new ArrayList(nums.length);
        int i = 0;
        while(i < nums.length){
            int count = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]) count++;
            }
            r.add(count);
            i++;
        }
        return r;
    }
    
    public static void main(String[] args){
        {
            int[] nums = {5, 2, 6, 1};
            ArrayList r = CountSmaller(nums);
            for(Object i : r) System.out.print((int) i + " ");
            System.out.println();
        }

        {
            int[] nums = {5};
            ArrayList r = CountSmaller(nums);
            for(Object i : r) System.out.print((int) i + " ");
            System.out.println();
        }
        {
            int[] nums = {};
            ArrayList r = CountSmaller(nums);
            for(Object i : r) System.out.print((int) i + " ");
            System.out.println();
        }
    }
}
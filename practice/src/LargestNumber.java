/*
* 179. Given a list of non negative integers, arrange them such that they form the largest number.
Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
* */


import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber{

    private static class LargerNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
//            a = 34, b = 3; order1 = a+b = 343, order2 = b+a = 334
//            c = order2 : order1 < 0 (because 334 < 343), this means a < b;
//            the sorted array: 34,3
            String order1 = a + b;
            String order2 = b + a;
            int c = order2.compareTo(order1);
            return c;
        }
    }

    public static String findLargestNumber(int[] nums){
        if(nums.length == 0) return "";
        String[] asStrs = new String[nums.length];
        for(int i =0;i<nums.length;i++){
            asStrs[i] = String.valueOf(nums[i]);
        }
        //   Arrays.sort is in ascending order,we should change it's behavior through LargerNumberComparator()
        Arrays.sort(asStrs, new LargerNumberComparator());

        if(asStrs[0].equals("0")) return "0";
        String r = new String();
        for(String s : asStrs) r+=s;
        return r;
    }


    public static void main(String[] args){
        {
            int[] a = {3, 30, 34, 5, 9};
            String r = findLargestNumber(a);
            System.out.println(r);
        }
        System.out.println("------");
        {
            int[] a = {};
            System.out.println(findLargestNumber(a));
        }
        System.out.println("------");
    }
}
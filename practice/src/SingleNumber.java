/*
* Given a non-empty array of integers, every element appears twice except for one.
* Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4
* */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class SingleNumber{

// the 5 solutions below for case [a, b] have different result;
// but according to the formal test, this case is illegal;

// sort array, O(N) + O(1)
    public static int solution1(int[] nums){
        int len = nums.length;
        if(len <= 1) return len ==1? nums[len - 1] : 0;
        Arrays.sort(nums);
        if(len % 2 != 0 && nums[len-1] != nums[len-2]) return nums[len -1];
        int i = 0;
        while(i < len){
            if(i+1 < len && nums[i] != nums[i+1]) return nums[i];
            i += 2;
        }
        return 0;
    }

//    use hashSet, O(N) + O(N)
    public static int solution2(int[] nums){
        int len = nums.length;
        if(len <= 1) return len ==1? nums[len - 1] : 0;
        HashSet<Integer> set = new HashSet<>(len);
        for(int i : nums){
            if(set.contains(i)) set.remove(i);
            else set.add(i);
        }
        return set.size() <= 1?
                Integer.parseInt(set.toArray()[0]+"")
                : Integer.parseInt(set.toArray()[set.size()-1]+"");
    }

//    use hashTable, O(N) + O(N)
    public static int solution3(int[] nums){
        int len = nums.length;
        if(len <= 1) return len ==1? nums[len - 1] : 0;
        Hashtable<Integer, Integer> ht = new Hashtable<>(len);
        for(int i : nums){
            ht.put(i, ht.getOrDefault(i, 0)+1);
        }
        for(int i : nums){
            if(ht.get(i) == 1) return i;
        }
        return 0;
    }

//    math method, O(N) + O(N)
//    [a, b, a, b,c], b = 2*(a+b+c) - (a+b+a+b+c)
    public static int solution4(int[] nums){
        int len = nums.length;
        if(len <= 1) return len ==1? nums[len - 1] : 0;
        HashSet<Integer> set = new HashSet<>(len);
        int uniqueSum = 0, totalSum = 0;
        for(int i: nums){
            if(!set.contains(i)){
                set.add(i);
                uniqueSum += i;
            }
            totalSum += i;
        }
        return 2*uniqueSum - totalSum;
    }

// bit manipulation, O(N) + O(1)
// XOR: a XOR a = 0; 0 XOR a = a
    public static int solution5(int[] nums){
        int a = 0;
        for(int i : nums){
            a = a^i;
        }
        return a;
    }

    public static void main(String[] args){
        {
            int[] nums = {4};
            int r =solution5(nums);
            System.out.print(r);
            System.out.println();
        }
        {
            int[] nums = {4, 2};
            int r =solution5(nums);
            System.out.print(r);
            System.out.println();
        }
        {
            int[] nums = {};
            int r =solution5(nums);
            System.out.print(r);
            System.out.println();
        }
        {
            int[] nums = {4, 1, 2, 1, 2};
            int r =solution5(nums);
            System.out.print(r);
            System.out.println();
        }



    }
}
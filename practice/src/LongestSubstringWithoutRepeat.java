/*
* Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
* */

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat{

//    brute force, O(N^3)
    public static int solution0(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i +1; j < s.length();j++){
                if(allUnique(s, i, j)) ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end){
        HashSet<Character> set = new HashSet<>();
        for(int i = start; i < end;i++){
            Character c = s.charAt(i);
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

//    Sliding Window, O(N) + O(N)
    public static int solution1(String s){
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j=0;
        while( i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int better_solution1(String s){
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j = 0, i =0 ; j < n; j++){
            if(map.containsKey(s.charAt(j))) i = Math.max(map.get(s.charAt(j)), i);
            ans = Math.max(ans, j-i+1);
//            j+1 is the next possible position of i
            map.put(s.charAt(j), j+ 1);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
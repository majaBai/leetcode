/*
* Isomorphic Strings
* Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same character
but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
* */

import java.util.HashMap;

public class IsomorphicString{

    public static boolean solution(String s, String t){
        if(s.length() != t.length()) return false;
        int len = s.length();
        if(len == 1) return true;
        HashMap hm_s = new HashMap(len);
        HashMap hm_t = new HashMap(len);
        for(int i = 0; i < len ; i++){
            char b = s.charAt(i);
            char c = t.charAt(i);
            if(!hm_s.containsKey(b)) hm_s.put(b, c);
            if(!hm_t.containsKey(c)) hm_t.put(c, b);
            if(!hm_s.get(b).equals(c) || !hm_t.get(c).equals(b)) return false;
        }
        return true;
    }

//    one pass Hash map
    public static boolean solution2(String s, String t){
        if(s.length() != t.length()) return false;
        int len = s.length();
        if(len == 1) return true;
        HashMap ht = new HashMap(len);
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(ht.containsKey(c)){
                if(ht.get(c).equals(d))continue;
                else return false;
            } else{
                if(!ht.containsValue(d)) ht.put(c, d);
                else return false;
            }
        }
        return true;
    }

//  the best solution
//  limit: string must be english character only
    public static boolean solution3(String s, String t){
        if(s.length() != t.length()) return false;
        int len = s.length();
        if(len == 1) return true;
        int[] m = new int[512];
        for(int i = 0; i < len; i++){
            int a = s.charAt(i);
            int b = t.charAt(i)+256;
            if(m[a] != m[b]) return false;
//            why m[a] = m[b] = i+1, rather than i; because when initialization, all element is 0
//            if m[b] already exists, and it's value == 0 (i == 0). then if m[a] is not exists, but when initialization
//            m[a] == 0; so m[a] == m[b], but in fact them not equal， see the last test case
            m[a] = m[b] = i+1;
        }
        return true;
    }
    public static void main(String[] args){
        {
            String s = "egg", t = "add";
            boolean r = solution3(s, t);
            System.out.println(r);
        }
        {
            String s = "foo", t = "bar";
            boolean r = solution3(s, t);
            System.out.println(r);
        }
        {
            String s = "paper", t = "title";
            boolean r = solution3(s, t);
            System.out.println(r);
        }
        {
            String s = "ab", t = "aa";
            boolean r = solution3(s, t);
            System.out.println(r);
        }
    }
}
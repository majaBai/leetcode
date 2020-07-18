/*
* Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern
and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
* */

import java.util.HashMap;
import java.util.Hashtable;

public class WordPattern{

//    two hashMap
    public static boolean solution(String pattern, String str){
        String[] word = str.split(" ");
        if(word.length != pattern.length()) return false;
        int len = word.length;
        HashMap<Character, String> pHM = new HashMap<>(len);
        HashMap<String, Character> wHM = new HashMap<>(len);
        for(int i = 0; i < len; i++){
            String s = word[i];
            Character c = pattern.charAt(i);
            if(!pHM.containsKey(c)) {
                pHM.put(c, s);
            }
            if(!wHM.containsKey(s)){
                wHM.put(s, c);
            }
//           compare two Strings use "equals()"
            if(wHM.get(s) != c || !pHM.get(c).equals(s)) {
                return false;
            }
        }
        return true;
    }

//    one hashtable
    public static boolean solution2(String pattern, String str){
        String[] word = str.split(" ");
        if(pattern.length() != word.length) return false;
        int len = word.length;
        Hashtable ht = new Hashtable(len);
        for(Integer i = 0; i < len; i++){
            String s = word[i];
            char c = pattern.charAt(i);
            if(!ht.containsKey(s)) ht.put(s, i);
            if(!ht.containsKey(c)) ht.put(c, i);
//            ht.get() will return Integer, so i must be type Integer
            if(ht.get(s) != ht.get(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        {
            String p = "abba";
            String str = "dog cat cat dog";
            boolean r = solution2(p, str);
            System.out.println(r);
        }
        {
            String p = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
            String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
            boolean r = solution2(p, str);
            System.out.println(r);
        }
    }
}
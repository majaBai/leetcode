/*
* Given a string s, find the longest palindromic substring in s.
* You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
* */

public class LongestPalindromicStr{

    public static boolean isPalindromic(String s){
        int len = s.length();
        if(len <= 1) return true;
        for(int i = 0; i <= len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i)) return false;
        }
        return true;
    }
// time out
    public static String solution(String s){
        if(s.length() <= 1) return s;
        String result = s.charAt(0)+"", temp ="";
        for(int i = 0; i< s.length();i++){
            String cur = temp + s.charAt(i);
            for(int j = i + 1; j < s.length();j++){
                cur+=s.charAt(j);
                if(isPalindromic(cur)){
                    result = result.length() < cur.length()? cur : result;
                }
            }
        }
        return result;
    }

    public static String solution2(String s){
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end +1);
    }

    public static int expandAroundCenter(String s, int left, int right){
        int l = left, r = right;
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }


    public static void main(String[] args){
        {
            String s = "babad";
            String r = solution2(s);
            System.out.println(r);
        }
        {
            String s = "cbbd";
            String r = solution2(s);
            System.out.println(r);
        }
        {
            String s = "";
            String r = solution2(s);
            System.out.println(r);
        }
        {
            String s = "a";
            String r = solution2(s);
            System.out.println(r);
        }
        {
            String s = "dc";
            String r = solution2(s);
            System.out.println(r);
        }

    }
}
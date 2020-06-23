import java.util.ArrayList;
import java.util.Arrays;

public class ValidAnagram{

    public static boolean isAnagram_1(String s, String t){
       if(s.length() != t.length()) return false;
       char[] a = s.toCharArray();
       char[] b = t.toCharArray();
       Arrays.sort(a);
       Arrays.sort(b);
       return Arrays.equals(a, b);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for(int count : table){
            if(count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        {
            String a = "anagram";
            String b = "nagaram";
            System.out.println(isAnagram(a, b));
        }
        System.out.println("-----");
        {
            String a = "cat";
            String b = "rat";
            System.out.println(isAnagram(a, b));
        }
        System.out.println("-----");
    }
}
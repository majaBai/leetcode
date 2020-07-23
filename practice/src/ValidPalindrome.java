/*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Constraints:
s consists only of printable ASCII characters.
* */

public class ValidPalindrome{

    public static boolean solution(String s){
        char[] charMap = new char[256];
        for(int i = 0; i < 10; i++){
            charMap['0' + i] = (char) (i + 1);
        }
        for(int i =0; i < 26; i++){
            charMap['a' + i] = charMap['A' +i] = (char) (11+i);
        }

        char[] pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        char cS,cE;
        while(start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS!=0 && cE!=0){
                if(cS!=cE)return false;
                start++;
                end--;
            }else{
                if(cS==0)start++;
                if(cE==0)end--;
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
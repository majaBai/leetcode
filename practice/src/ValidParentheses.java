/*
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false
* */


import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses{

    public static boolean solution(String s){
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length();i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                Character topChr = st.empty()? '#' :st.pop();
                if(topChr != map.get(c)) return false;
            } else {
                st.push(c);
            }
        }
        return st.empty();
    }

    public static void main(String[] args){

    }
}
/*bulls and cows
* You are playing the following Bulls and Cows game with your friend:
You write down a number and ask your friend to guess what the number is.
Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess
match your secret number exactly in both digit and position (called "bulls")
and how many digits match the secret number but locate in the wrong position (called "cows").
Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess,
use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
*
Note: You may assume that the secret number and your friend's guess only contain digits,
and their lengths are always equal.
* */


public class BullsAndCows{

    public static String getHin(String secret, String guess){
        int len = secret.length(), bull_cnt = 0, cow_cnt = 0;
//       the range of all digits in secret and guess is [0, 9]
        int[] numbers = new int[10];
        for(int i = 0; i < len; i++){
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s == g) bull_cnt++;
            else{
                if(numbers[s] < 0) cow_cnt++;
                if(numbers[g] >0 ) cow_cnt++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bull_cnt+"A"+cow_cnt+"B";
    }

    public static void main(String[] args){
        {
            String secret = "1807";
            String guess = "7810";
            String r = getHin(secret, guess);
            System.out.println(r);
        }
        {
            String secret = "1123";
            String guess = "0111";
            String r = getHin(secret, guess);
            System.out.println(r);
        }

    }
}
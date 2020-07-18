/*
* Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:
Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */

public class HappyNumber{

    public static boolean solution(int n){
        int x = n;
        int y = n;
        while(x>1){
            x = sumOfSquaresOfDigits(x) ;
            if(x==1) return true ;
            y = sumOfSquaresOfDigits(sumOfSquaresOfDigits(y));
            if(y==1) return true ;

//          if a number is unhappy, this condition (x==y) always correct? why?
            if(x==y) return false;
        }
        return true ;
    }
    public static  int sumOfSquaresOfDigits(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }

// All numbers eventually loop through either 1 or 4 before expanding further. why??
    public static boolean solution1(int n){
        if(n == 1) return true;
        else if(n == 4) return false;
        else return solution1(sumOfSquaresOfDigits(n));
    }

    public  static void main(String[] args){
        {
            int n = 6;
            boolean r = solution1(n);
            System.out.println(r);
        }
    }
}
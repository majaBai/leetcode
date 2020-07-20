/*
* Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
* */

public class CountPrimes{

    public static boolean isPrime(int n){
        if(n == 2) return true;
        for(int i = 2; i < n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
// time out
    public static int solution(int n){
        if(n < 2) return 0;
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)) cnt++;
        }
        return cnt;
    }


    public static int solution2(int n){
        if(n < 3) return 0;
        int c = n /2;
        boolean[] s = new boolean[n];
        for(int i = 3; i*i< n;i+=2){
            if(s[i]) continue;
            for(int j =i*i; j <n; j+= 2*i){
                if(!s[j]){
                    --c;
                    s[j] = true;
                }
            }
        }
        return c;
    }



    public static void main(String[] args){
        {
            int n = 10;
            int r = solution2(n);
            System.out.println(r);
        }
        {
            int n = 2;
            int r = solution2(n);
            System.out.println(r);
        }
        {
            int n = 1;
            int r = solution2(n);
            System.out.println(r);
        }
        {
//            time out
            int n = 499979;
            int r = solution2(n);
            System.out.println(r);
        }

    }
}
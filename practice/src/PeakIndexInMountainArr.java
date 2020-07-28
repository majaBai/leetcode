/*
Let's call an array A a mountain if the following properties hold:
A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:
Input: [0,1,0]
Output: 1

Note:
3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
* */

public class PeakIndexInMountainArr{

//    O(lgN)
    public static int solution(int[] A){
        int lo = 0, hi = A.length-1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(A[mid] < A[mid +1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

//   O(N)
    public static int solution1(int[] nums){
        int i = 0;
        while(nums[i] < nums[i +1]) i++;
        return i;
    }

    public static void main(String[] args){


    }
}
/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
* */

public class VersionControl{

    public static int firstBadVersion(int n){
        return firstBad(1, n, n);
    }

    public static int firstBad(int start, int end, int n){
        if(start > end) throw new IllegalArgumentException("no bad version");
        int mid = start + (end - start)/2;
        if(isBadVersion(mid)){
            if(mid == 1) return mid;
            if(mid > 1 && !isBadVersion(mid - 1)) return mid;
            return firstBad(start, mid -1, n);
        } else {
            if(mid + 1 <=n && isBadVersion(mid+1)) return mid+1;
            return firstBad(mid+1, n, n);
        }
    }

//    function isBadVersion (in fact, given by default) her just for place holder, not right
    public static boolean isBadVersion(int n){
        return false;
    }

//    better solution
    public static int solution2(int n){
        int left = 1;
        int right = n;
//      first bad version must be in range [left, right]
        while(left< right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    public static void main(String[] args){

    }
}
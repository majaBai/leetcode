/*
4. Median of Two Sorted Arrays
* There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
* */
public class MedianOfArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        assert len1 > 0 || len2 > 0 : "wrong, the arrays can not be empty";
        int[] total = new int[len1 + len2];
        int len = total.length;
        int i = 0, j = 0;
        for (int k = 0; k < len; k++) {
            if (i < len1 && j < len2) {
                if (nums1[i] <= nums2[j]) {
                    total[k] = nums1[i];
                    i++;
                } else {
                    total[k] = nums2[j];
                    j++;
                }
            } else if (i >= len1 && j < len2) {
                total[k] = nums2[j];
                j++;
            } else if (j >= len2 && i < len1) {
                total[k] = nums1[i];
                i++;
            }
        }
        if (len % 2 == 0) return ((double) (total[len / 2] + total[len / 2 - 1])) / 2;
        else return (double) total[(len - 1) / 2];
    }

    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays3(int[] input1, int[] input2) {
//        ensure input1.length smaller than input2
        if(input1.length > input2.length){
            return findMedianSortedArrays3(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while(low<=high){
            int partitionX = (low + high) /2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxLeftX = (partitionX == 0)?Integer.MIN_VALUE : input1[partitionX -1];
            int minRightX = (partitionX == x)? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : input2[partitionY -1];
            int minRightY = (partitionY == y)? Integer.MAX_VALUE : input2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x+y)%2 == 0){
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY){
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        {
            int[] nums1 = {1, 3};
            int[] nums2 = {2};
            double median = findMedianSortedArrays(nums1, nums2);
            assert median == 2.0;
        }
        {
            int[] nums1 = {1, 2};
            int[] nums2 = {3, 4};
            double median = findMedianSortedArrays(nums1, nums2);
            assert median == 2.5;
        }
        {
            int[] nums1 = {12};
            int[] nums2 = {12};
            double median = findMedianSortedArrays(nums1, nums2);
            assert median == 12.0;
        }
        {
            int[] nums1 = {};
            int[] nums2 = {1};
            double median = findMedianSortedArrays(nums1, nums2);
        }
        {
            int[] nums1 = {1};
            int[] nums2 = {};
            double median = findMedianSortedArrays(nums1, nums2);
        }
    }
}
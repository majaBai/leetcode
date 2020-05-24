
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
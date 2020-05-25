/*
 *Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 * */
public class ContainerWithMostWater {

    public static int maxArea1(int[] height) {
        assert height.length >= 2 : "int[] height.length can not be less than 2 ";
        int max = 0;
        for (int i = 1; i <= height.length; i++) {
            int h0 = height[i - 1];
            for (int j = i + 1; j <= height.length; j++) {
                int h1 = height[j - 1];
                int w = j - i;
                int area = Math.min(h0, h1) * w;
                max = area > max ? area : max;
            }
        }
        return max;
    }

    public static int maxArea(int[] height){
        int max = 0, lo = 0, hi = height.length-1;
        while(lo < hi){
            max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
            if(height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }


    public static void main(String[] args) {
        {
          int [] h =  {1,8,6,2,5,4,8,3,7};
          int area = maxArea(h);
          assert area == 49: "wrong maxArea";
        }

        {
            int [] h =  {1};
            int area = maxArea(h);
        }

        {
            int [] h =  {};
            int area = maxArea(h);
        }

        {
            int [] h =  {1,-8};
            int area = maxArea(h);
        }

    }
}
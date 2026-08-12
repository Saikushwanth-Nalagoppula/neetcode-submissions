class Solution {
    public int maxArea(int[] heights) {

        int i = 0;
        int j = heights.length - 1;

        int max_area = 0;

        while (i < j) {

            int height = Math.min(heights[i], heights[j]);
            int width = j - i;

            int curr_area = width * height;

            max_area = Math.max(max_area, curr_area);

            // Move the shorter side
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max_area;
    }
}
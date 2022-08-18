/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        fillDfs(image, sr, sc, color, image[sr][sc]);
        for(int[] row:image){
            for(int i = 0; i < row.length; i ++){
                if(row[i] == '*') {
                    row[i] = color;
                }
            }
        }
        return image;
    }

    private void fillDfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
            || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = '*';
        fillDfs(image, sr - 1, sc, color, oldColor);
        fillDfs(image, sr + 1, sc, color, oldColor);
        fillDfs(image, sr, sc - 1, color, oldColor);
        fillDfs(image, sr, sc + 1, color, oldColor);
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        flipDiagonal(matrix);
        flipVertical(matrix);
    }

    //[9,6,3]
    //[8,5,2]
    //[7,4,1]
    private void flipDiagonal(int[][] matrix){
        //[0][0] => [2][2]
        //[0][1] => [1][2]
        //[1][0] => [2][1]
        int m = matrix.length;
        for(int i = 0; i <= m-2; i++){
            for(int j = 0; j <= m-1-i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-1-j][m-i-1];
                matrix[m-1-j][m-i-1] = tmp;
            }
        }
    }

    private void flipVertical(int[][] matrix){
        //[0][0] => [2][0]
        int m = matrix.length;
        for(int i = 0; i < m/2; i++){
            for(int j = 0; j < m; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = tmp;
            }
        }
    }
}
// @lc code=end


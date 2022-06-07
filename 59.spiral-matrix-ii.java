/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n-1, u = n-1, d = 0;
        int num = 1;
        //row 0: [0,0],[0,1],[0,2]
        //col 2: [1,2],[2,2]
        //row 2: [2,1],[2,0]
        //col 0: [1,0]
        //row 1: [1,1]
        while(true){
            for(int i = l; i <= r; i++){
                res[d][i] = num++;
            }
            d++;
            for(int i = d; i <= u; i++){
                res[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--){
                res[u][i] = num++;
            }
            u--;
            for(int i = u; i >= d; i--){
                res[i][l] = num++;
            }
            l++;
            if(l > r || u < d) {
                break;
            }
        }
        
        return res;
    }


}
// @lc code=end


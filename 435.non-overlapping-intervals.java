/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    //Greedy O(n logn)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        if(intervals == null || intervals.length <=1 )return 0;
        int res = 0;
        int prev = 0;
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] < intervals[prev][1]){
                if(intervals[prev][1] > intervals[i][1]){
                    prev = i;
                }
                res ++;
            } else{
                prev = i;
            }
        }
        return res;
    }


    // DP O(n^2)
    // fill dp with max length of non overlapping intervals
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < dp.length; i++){
            int tmpMax = 0;
            for(int j = i-1; j >= 0; j--){
                if(intervals[j][1] <= intervals[i][0]){
                    tmpMax = Math.max(tmpMax, dp[j]);
                }
            }
            dp[i] = tmpMax + 1;
            maxLength = Math.max(maxLength, tmpMax+1);
        }
        return intervals.length - maxLength;


    }
}
// @lc code=end


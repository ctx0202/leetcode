/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > right) {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                right = Math.max(right, intervals[i][1]);
            }
        }
        list.add(new int[]{left, right});
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int cnt = 0;
                while(set.contains(num)){
                    num ++;
                    cnt ++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
// @lc code=end


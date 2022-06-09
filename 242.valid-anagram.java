/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[128];
        for(char c:s.toCharArray()){
            cnt[(int)c]++;
        }
        for(char c:t.toCharArray()){
            cnt[(int)c]--;
        }
        for(int i:cnt){
            if(i != 0) return false;
        }
        return true;
    }
}
// @lc code=end


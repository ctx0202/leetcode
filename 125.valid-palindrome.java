/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for(int l = 0, r = s.length() - 1; l < r; ){
            if(!Character.isLetterOrDigit(charArray[l])) l++;
            else if(!Character.isLetterOrDigit(charArray[r])) r--;
            else if(Character.toLowerCase(charArray[l++]) != Character.toLowerCase(charArray[r--])){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end


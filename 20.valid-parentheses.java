/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(){{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) {
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char cur = stack.pop();
                if(map.get(cur) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end


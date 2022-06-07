/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        //[-4, -1, -1, -1, 0, 1, 2, 2]
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int comp = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {
                // if(j > i+1 && nums[j] == nums[j-1]) continue;
                // System.out.println("hello");
                if(set.contains(comp - nums[j])){
                    res.add(Arrays.asList(nums[i], nums[j], comp - nums[j]));
                    while(j + 1 < nums.length && nums[j+1] == nums[j]) j++;
                }
                set.add(nums[j]);
            }
        }
        return res;
    }
}
// @lc code=end


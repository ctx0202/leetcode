/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //[2,3,4,5] 
        // products of elements to the left
        //[1, 1*2 = 2, 2*3 = 6, 6*4 = 24]
        // products of elements to the right
        //[20*3=60, 5*4 = 20, 5*1 = 5, 1]
        if(nums == null || nums.length == 1) return nums;
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for(int i = 1; i < leftProduct.length; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        int[] rightProduct = new int[nums.length];
        int m = nums.length;
        rightProduct[m-1] = 1;
        for(int i = m-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int[] res = new int[m];
        for(int i = 0; i < m; i++){
            res[i] = leftProduct[i] * rightProduct[i]; 
        }
        return res;
    }
}
// @lc code=end


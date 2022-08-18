/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    // public int maxSubArray(int[] nums) {
    //     int maxSum = Integer.MIN_VALUE;
    //     int curSum = 0;
    //     for(int num:nums){
    //         curSum += num;
    //         if(curSum < num) {
    //             curSum = num;
    //         }
    //         maxSum = Math.max(maxSum, curSum);
    //     }
    //     return maxSum;
    // }

    public int maxSubArray(int[] nums) {
        return divideAndConquer(0, nums.length -1, nums);
    }

    private int divideAndConquer(int l, int r, int[] nums){
        if(l > r) {
            return Integer.MIN_VALUE;
        }
        int leftMax = 0, rightMax = 0;
        int mid = (l + r)/2;

        int cur = 0;
        for(int i = mid-1; i >= l; i--){
            cur += nums[i];
            leftMax = Math.max(leftMax, cur);
        }
        cur = 0;
        for(int i = mid + 1; i <= r; i++){
            cur += nums[i];
            rightMax = Math.max(rightMax, cur);
        }

        int maxSum = leftMax + nums[mid] + rightMax;

        int leftSubMax = divideAndConquer(l, mid-1, nums);
        int rightSubMax = divideAndConquer(mid+1, r, nums);
        
        return Math.max(maxSum, Math.max(leftSubMax, rightSubMax));
    }
}
// @lc code=end


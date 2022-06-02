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

    private int divideAndConquer(int left, int right, int[] nums){
        if(left > right) {
            return Integer.MIN_VALUE;
        }

        int leftMax = 0 ;
        int rightMax = 0;
        int cur = 0;

        int mid = (left + right) /2;
        
        for(int i = mid-1; i>=left; i--){
            cur += nums[i];
            leftMax = Math.max(leftMax, cur);
        }
        cur = 0;
        for(int i = mid+1; i<=right; i++){
            cur+=nums[i];
            rightMax = Math.max(rightMax, cur);
        }

        int bestSum = leftMax + rightMax + nums[mid];
        int leftBestSum = divideAndConquer(left, mid-1, nums);
        int rightBestSum = divideAndConquer(mid+1, right, nums);

        return Math.max(bestSum, Math.max(leftBestSum, rightBestSum));
    }
}
// @lc code=end


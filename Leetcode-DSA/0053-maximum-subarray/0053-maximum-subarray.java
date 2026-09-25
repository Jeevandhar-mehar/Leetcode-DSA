class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add to the existing subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Keep track of the highest sum we've seen so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
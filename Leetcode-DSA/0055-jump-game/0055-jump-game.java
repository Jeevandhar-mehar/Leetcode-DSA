class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If our current index is beyond what we can reach, we are stuck
            if (i > reachable) return false;
            
            // Update the furthest index we can reach from here
            reachable = Math.max(reachable, i + nums[i]);
            
            // If we can already reach or pass the last index, return true
            if (reachable >= nums.length - 1) return true;
        }
        
        return true;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }
    
    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // We found the target, record it
                index = mid;
                if (isSearchingLeft) {
                    // Keep looking toward the left for the first occurrence
                    high = mid - 1;
                } else {
                    // Keep looking toward the right for the last occurrence
                    low = mid + 1;
                }
            }
        }
        
        return index;
    }
}
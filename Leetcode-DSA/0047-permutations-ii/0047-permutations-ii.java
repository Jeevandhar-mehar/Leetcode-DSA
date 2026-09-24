import java.util.ArrayList;
import java.util.List;

class Solution {
    private void getPerms(int[] nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.length) {
            // Convert primitive int array to a List<Integer> and add to results
            List<Integer> currentPerm = new ArrayList<>();
            for (int num : nums) {
                currentPerm.add(num);
            }
            ans.add(currentPerm);
            return;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
           if (seen.contains(nums[i])) {
                continue;
            }
            seen.add(nums[i]);
            
            swap(nums, idx, i);            // idx place => ith element choice
            getPerms(nums, idx + 1, ans);
            swap(nums, idx, i);            // backtracking
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPerms(nums, 0, ans);
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
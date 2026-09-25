class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        
        // 2. Go through each interval one by one
        for (int[] interval : intervals) {
            // If our list is empty, or if the current interval does not overlap 
            // with the last one in our list, just add it.
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // If they overlap, update the end time of the previous interval 
                // to be the maximum of both end times.
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        // 3. Convert the list back to a normal 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }
}
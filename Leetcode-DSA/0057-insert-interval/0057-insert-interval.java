class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : intervals) {
            
            // 1. The current interval is completely BEFORE our new interval
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }
            
            // 2. The current interval is completely AFTER our new interval
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval); // Safely add our new interval
                newInterval = interval;  // Pick up the current interval to hold onto
            }
            
            // 3. They OVERLAP! Smash them together into one bigger interval
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        // Don't forget to add the final interval we are holding at the end!
        result.add(newInterval);
        
        // Convert the ArrayList back into a normal 2D array
        return result.toArray(new int[result.size()][]);
    }
}
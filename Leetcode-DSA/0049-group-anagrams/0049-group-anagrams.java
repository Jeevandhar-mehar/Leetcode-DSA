class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // A map to hold our groups. Key = sorted word, Value = list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Sort the letters of the current word to use as a matching key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // If this key is new, create an empty list for it
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original word into its matching group list
            map.get(key).add(s);
        }

        // Return all the grouped lists from our map
        return new ArrayList<>(map.values());
    }
}
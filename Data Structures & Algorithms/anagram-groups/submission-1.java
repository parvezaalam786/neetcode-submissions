public class Solution {
    public List<List<String>> groupAnagrams_01(String[] strs) {
        Map<String, List<String>> groupAnagrams = new HashMap<>();

        for (String s: strs) {
            char[] currWord = s.toCharArray();
            Arrays.sort(currWord);
            String newSortedString = new String(currWord);
            groupAnagrams.putIfAbsent(newSortedString, new ArrayList<>());
            groupAnagrams.get(newSortedString).add(s);
        }

        return new ArrayList<>(groupAnagrams.values());
    }

    // Approach2: Using array for storing the frequency
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s: strs) {
            int[] freq = new int[26];

            for (char ch: s.toCharArray()) {
                freq[ch - 'a']++;
            }

            String key = Arrays.toString(freq);

            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
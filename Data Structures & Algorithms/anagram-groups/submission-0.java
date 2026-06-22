public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
}
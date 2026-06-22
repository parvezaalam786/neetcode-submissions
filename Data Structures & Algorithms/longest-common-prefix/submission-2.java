class Solution {

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode currNode = root;
        for (char ch: word.toCharArray()) {
            currNode.children.putIfAbsent(ch, new TrieNode());
            currNode = currNode.children.get(ch);
        }
    }

    int getLcp(String word, int prefixLen) {
        TrieNode currNode = root;

        int i = 0;

        while (i < Math.min(prefixLen, word.length())) {
            if (!currNode.children.containsKey(word.charAt(i))){
                return i;
            }
            currNode = currNode.children.get(word.charAt(i));
            i++;
        }
        return Math.min(word.length(), prefixLen);
    }
}
    public String longestCommonPrefix_01(String[] strs) {
        int longestCommonPrefixIndex = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            int prefixIndex = -1;

            for (int j = 0; j < Math.min(strs[i].length(), strs[i - 1].length()); j++) {
                if (strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                    break;
                }
                prefixIndex = j;
            }
            longestCommonPrefixIndex = Math.min(longestCommonPrefixIndex, prefixIndex + 1);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < longestCommonPrefixIndex; i++) {
            ans.append(strs[0].charAt(i));
        }

        return ans.toString();
    }

    public String longestCommonPrefix_02(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);

        int commonLength = Math.min(strs[0].length(), strs[strs.length - 1].length());

        for (int i = 0; i < commonLength; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    // Trie Solution
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int min_idx = 0;

        for (int i = 0; i < strs.length; i++) {
            if (strs[min_idx].length() < strs[i].length()) {
                min_idx = i;
            }
        }

        Trie trie = new Trie();

        trie.insert(strs[min_idx]);

        int prefixLength = strs[min_idx].length();
        for (int i = 0; i < strs.length; i++) {
            prefixLength = Math.min(prefixLength, trie.getLcp(strs[i], prefixLength));
        }
        
        return strs[min_idx].substring(0, prefixLength);
    }
}
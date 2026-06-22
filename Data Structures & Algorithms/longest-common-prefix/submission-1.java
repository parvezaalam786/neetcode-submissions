class Solution {
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

    public String longestCommonPrefix(String[] strs) {
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
}
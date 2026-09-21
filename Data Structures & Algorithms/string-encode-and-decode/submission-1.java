class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            encodedString
                .append(strs.get(i).length())
                .append("#")
                .append(strs.get(i));
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {

        List<String> decodedString = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            decodedString.add(str.substring(i, j));
            i = j;
        }


        return decodedString;
    }
}

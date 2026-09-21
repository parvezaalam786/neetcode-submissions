class Solution {

    public String encode(List<String> strs) {

        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder encodedString = new StringBuilder();

        List<Integer> sizes = new ArrayList<>();

        int n = strs.size();

        for (int i = 0; i < n; i++) {
            sizes.add(strs.get(i).length());
        }

        for (int i = 0; i < n; i++) {
            encodedString.append(sizes.get(i)).append(",");
        }
        encodedString.append("#");

        for (int i = 0; i < n; i++) {
            encodedString.append(strs.get(i));
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {

        if (str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> decodedString = new ArrayList<>();

        List<Integer> sizes = new ArrayList<>();

        int i = 0;

        while (str.charAt(i) != '#') {

            StringBuilder currLength = new StringBuilder();

            while (str.charAt(i) != ',') {
                currLength.append(str.charAt(i));
                i++;
            }
            i++;
            sizes.add(Integer.parseInt(currLength.toString()));
        }
        i++;

        for (int size: sizes) {
            decodedString.add(str.substring(i, i + size));
            i += size;
        }

        return decodedString;
    }
}

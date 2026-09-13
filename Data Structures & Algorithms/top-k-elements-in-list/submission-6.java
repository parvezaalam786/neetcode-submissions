class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int n = nums.length; // 2

        for (int i = 0; i < n; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        } // {7: 2}

        List<Integer>[] elementsCount = new List[n + 1];

        for (Map.Entry<Integer, Integer> element: frequency.entrySet()) {
            if (elementsCount[element.getValue()] == null) {
                elementsCount[element.getValue()] = new ArrayList<>();
            }
            elementsCount[element.getValue()].add(element.getKey());
        }

        int result[] = new int[k];

        int cnt = 0;
        int i = n;
        while (i >= 0 && cnt < k) {
            if (elementsCount[i] != null) {
                int j = 0;
                while (j < elementsCount[i].size() && cnt < k) {
                    result[cnt] = elementsCount[i].get(j);
                    cnt++;
                    j++;
                }
                
            }
            i--;
        }

        return result;
    }
}

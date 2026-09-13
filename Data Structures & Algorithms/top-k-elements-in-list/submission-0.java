class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> elements = new ArrayList<>(frequency.keySet());

        elements.sort((a, b) -> frequency.get(b) - frequency.get(a));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }

        return result;
    }
}

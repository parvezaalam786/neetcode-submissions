class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> lookup = new HashSet<Integer>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            lookup.add(nums[i]);
        }

        int maxSequenceLength = 0;

        for (int i = 0; i < n; i++) {
            if (!lookup.contains(nums[i] - 1)) {
                int start = nums[i];
                int sequenceLength = 0;
                while (lookup.contains(start)) {
                    sequenceLength++;
                    maxSequenceLength = Math.max(sequenceLength, maxSequenceLength);
                    start++;
                }
            }
        }

        return maxSequenceLength;  
    }
}

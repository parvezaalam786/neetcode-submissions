class Solution {
    public int majorityElement(int[] nums) {
        int majorElement = nums[0];
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorElement) {
                freq++;
            } else {
                freq--;
                if (freq < 0) {
                    majorElement = nums[i];
                    freq = 1;
                }
            }
        }

        return majorElement;
    }
}
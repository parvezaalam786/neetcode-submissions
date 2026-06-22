class Solution {
    public int majorityElement_01(int[] nums) {
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
    
    public int majorityElement(int[] nums) {
        int[] bitsFreq = new int[32];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                bitsFreq[j] += (nums[i] >> j) & 1; // right shift bits of nums[i] by i
            }
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if (bitsFreq[i] > n / 2) {
                result |= (1 << i);
            }
        }
        return result;
    }

}
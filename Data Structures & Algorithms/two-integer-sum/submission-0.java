class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;

            if (mp.containsKey(y)) {
                ans = new int[] {mp.get(y), i};
                break;
            }

            mp.put(x, i);
        }
        return ans;
    }
}

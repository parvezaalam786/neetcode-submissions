class Solution {
    // One solution is to sort the array and check the adjacent elements.
    // Second solution is to make use of a hash set
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (!s.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
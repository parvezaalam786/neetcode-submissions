/**
 * It is a comparison-based sorting algorithm that repeatedly selects the smallest
 * (or largest) element from the unsorted part of the array and swaps it with the 
 * first unsorted element. This process continues until the array is fully sorted.
 */
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = temp;
        }
        return nums;
    }
}

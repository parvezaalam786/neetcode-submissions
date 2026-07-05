/**
 * Insertion Sort considers that the first element is already is at its correct position. 
 * We now need to put the remaining elements at their current position. 
 * We do this by shiting the elements right so that a place for the correct position for the 
 * new element can be built. 
 */

class Solution {
    public int[] sortArray(int[] nums) {

        int n = nums.length;


        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        
        return nums;
    }
}
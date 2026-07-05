/**
 * It is a non-comparison-based sorting algorithm that works efficiently when the range of input values 
 * is small relative to the number of elements. It counts the frequency of each distinct element and uses 
 * that count to place elements directly into their correct sorted positions.
 * 
 * Algorithm is:
 * 1. Find out the minimum and maximum elements. This is required for balancing the count and calculate range of frequency.
 * 2. Calculate range = max - min + 1
 * 3. Create a frequency array of size range.
 * 4. Count the frequency of each element frequencyArray[arr[i] - min]++
 * 5. Now calculate the cumulative frequence using the frequencyArray. The will denote the actual position in the output array.
 * 6. Now iterate from back
 *      for (int i = n - 1; i >= 0; i++) {
 *          output[frequencyArray[arr[i] - min] - 1] = arr[i]
 *          frequencyArray[arr[i] - min]--;
 *      }
 * 7. Return the output
 */
class Solution {
    public int[] sortArray(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums; 
        }

        int n = nums.length;

        int maxElement = nums[0];
        int minElement = nums[0];

        for (int i = 1; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            minElement = Math.min(minElement, nums[i]);
        }

        int range = maxElement - minElement + 1;

        int frequencyArray[] = new int[range];

        for (int i = 0; i < n; i++) {
            frequencyArray[nums[i] - minElement]++;
        }

        for (int i = 1; i < range; i++) {
            frequencyArray[i] += frequencyArray[i - 1];
        }

        int output[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            output[frequencyArray[nums[i] - minElement] - 1] = nums[i];
            frequencyArray[nums[i] - minElement]--;
        }

        return output;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        result[0] = nums[0];

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i];
        }

        int suffixProduct = 1;

        for (int i = n - 1; i >= 1; i--) {
            result[i] = result[i - 1] * suffixProduct;
            suffixProduct *= nums[i];
        }
        result[0] = suffixProduct;

        return result;
    }
}  

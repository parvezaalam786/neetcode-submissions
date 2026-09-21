class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        
        prefixProduct[0] = nums[0];
        suffixProduct[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
            suffixProduct[n - i - 1] = suffixProduct[n - i] * nums[n - i - 1];
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(prefixProduct[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     System.out.print(suffixProduct[i] + " ");
        // }
        // System.out.println();

        int[] result = new int[n];

        result[0] = suffixProduct[1];
        result[n - 1] = prefixProduct[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = prefixProduct[i - 1] * suffixProduct[i + 1];
        }

        return result;
    }
}  

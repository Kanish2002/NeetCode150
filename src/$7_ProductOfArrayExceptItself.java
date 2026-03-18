import java.util.Arrays;

/**
 * Problem: Product of Array Except Itself
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */

class $7_ProductOfArrayExceptItselfMain {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        \ sol = new Solution3();
        System.out.println("Result: " + Arrays.toString(sol.productExceptSelf(nums)));
    }
}

// Solution 1: Brute Force O(N^2)
// Why changed: This approach uses nested loops to calculate the product for each element, 
// which is inefficient for large arrays.
class $7_ProductOfArrayExceptItself1 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length;i++)result[i] = 1;
        for(int i = 0;i < nums.length;i++){
            for(int j = 0; j < nums.length;j++){
                if(i!=j){
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }
}
class $7_ProductOfArrayExceptItself2 {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        int j = nums.length - 2;
        for(int i = 1;i < nums.length && j>=0;i++){
            prefix[i] = prefix[i-1] * nums[i];
            suffix[j] = suffix[j+1] * nums[j];
            j--;
        }
        return result;
    }
}

// Solution 3: Space-Optimized Prefix/Suffix O(N) time, O(1) extra space
// Why changed: This is the optimal solution. It stores prefix products in the result array 
// and calculates suffix products on the fly, reducing extra space usage to O(1).
class Solution3 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for(int i = 1;i < nums.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int right = 1;
        for(int j = nums.length - 1;j >= 0;j--){
            result[j] = result[j] * right;
            right *= nums[j];
        }
        return result;
    }
}

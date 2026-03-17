import java.util.*;

/**
 * Problem: Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

class $4_TwoSumMain {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        $4_TwoSum3 sol = new $4_TwoSum3();
        System.out.println("Indices: " + Arrays.toString(sol.twoSum(nums, target)));
    }
}

// Solution 1: Brute Force O(N^2)
// Why changed: This approach checks every pair twice (i,j and j,i), which is inefficient.
class $4_TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    arr[0] = Math.min(i, j);
                    arr[1] = Math.max(i, j);
                }
            }
        }
        return arr;
    }
}

// Solution 2: Optimized Brute Force O(N^2)
// Why changed: By starting the inner loop from i + 1, we avoid checking the same pair twice 
// and avoid the i != j check. Still O(N^2).
class $4_TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}

// Solution 3: One-pass HashMap O(N)
// Why changed: This is the optimal solution. We store seen numbers in a HashMap 
// to find the complement in O(1) time, reducing the overall complexity to O(N).
class $4_TwoSum3 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

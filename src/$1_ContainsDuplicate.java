import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


// Solution 1: Using TreeMap (O(log n)) to store counts.
// Why changed: Using a Map to count is overkill if we only need to find duplicates. 
// TreeMap also has O(log n) insertion complexity.
class Solution1 {
    public boolean hasDuplicate(int[] nums) {
        TreeMap ht = new TreeMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            ht.put(nums[i],ht.getOrDefault(nums[i]++,1));
        }
        if(ht.size() != nums.length) return true;
        else return false;
    }
}

// Solution 2: Simplified to TreeSet (O(log n)).
// Why changed: We only care about uniqueness, so a Set is more appropriate than a Map.
// Still uses TreeMap under the hood (O(log n)).
class Solution2 {
    public boolean hasDuplicate(int[] nums) {
        TreeSet ht = new TreeSet<Integer>();
        for(int i = 0;i < nums.length;i++){
            ht.add(nums[i]);
        }
        if(ht.size() != nums.length) return true;
        else return false;
    }
}

// Solution 3: Optimized to HashSet (O(1) average).
// Why changed: HashSet provides faster O(1) lookups and insertions compared to TreeSet.
// Added an early exit: if a duplicate is found, return true immediately instead of processing the whole array.
class Solution3 {
    public boolean hasDuplicate(int[] nums) {
        HashSet ht = new HashSet<Integer>();
        for(int i = 0;i < nums.length;i++){
            if(ht.contains(nums[i])) return true;
            ht.add(nums[i]);
        }
        return false;
    }
}

// Solution 4: Clean idiomatic Java with enhanced for-loop.
// Why changed: Uses 'Set' interface for abstraction and the enhanced for-loop for better readability.
// This is the most standard and efficient way to solve this in Java.
class Solution4 {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> ht = new HashSet<>();
        for(int num : nums){
            if(ht.contains(num)) return true;
            ht.add(num);
        }
        return false;
    }
}
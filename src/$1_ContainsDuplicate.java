import java.util.HashSet;
import java.util.Set;

class $1_ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}
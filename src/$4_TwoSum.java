import java.util.HashMap;

class $4_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        int[] arr = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(i = 0;i < nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[] {map.get(complement),i};
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}

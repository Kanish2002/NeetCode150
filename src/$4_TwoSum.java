import java.util.HashMap;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        int[] arr = new int[2];
        for(i = 0;i < nums.length;i++){
            for(j = 0;j < nums.length;j++){
                if(i != j && nums[i]+nums[j] == target){

                    arr[0] = i > j ? j : i;
                    arr[1] = i < j ? j : i;
                }
            }
        }
        return arr;
    }
}
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        int[] arr = new int[2];
        for(i = 0;i < nums.length;i++){
            for(j = i+1;j < nums.length;j++){
                if(i != j && nums[i]+nums[j] == target){

                    arr[0] = i > j ? j : i;
                    arr[1] = i < j ? j : i;
                }
            }
        }
        return arr;
    }
}
class Solution3 {
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

import java.util.*;

class $12_ThreeSum1 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(i != j && j != k){
                        if(nums[i]+nums[j]+nums[k] == 0){
                            ArrayList<Integer> temp = new ArrayList<Integer>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}

class $12_ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(i != j && j != k){
                        if(nums[i]+nums[j]+nums[k] == 0){
                            ArrayList<Integer> temp = new ArrayList<Integer>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}

class $12_ThreeSum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right)
                        if(nums[left] == nums[left+1]) left++;
                        else break;
                    while(left < right)
                        if(nums[right] == nums[right-1]) right--;
                        else break;
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return list;
    }
}


class $12_ThreeSum4 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return list;
    }
}

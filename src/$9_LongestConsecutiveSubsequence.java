import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class $9_LongestConsecutiveSubsequence1 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxCount = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            int count = 0;
            for(int j = i+1;j < nums.length;j++){
                if(nums[j] == nums[i]+count+1){
                    count++;
                    maxCount = count > maxCount ? count : maxCount;
                }
            }
        }
        return maxCount+1;
    }
}

class $9_LongestConsecutiveSubsequence2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList(set);

        int count = 0;
        int maxCount = 0;
        for(int i = 1; i < list.size();i++){
            if(list.get(i) == list.get(i-1) + 1){
                count++;
                maxCount = maxCount > count ? maxCount : count;
            }
            else{
                count = 0;
            }

        }
        return maxCount+1;
    }
}


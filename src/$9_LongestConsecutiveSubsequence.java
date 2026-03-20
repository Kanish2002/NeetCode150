import java.util.*;

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


class $9_LongestConsecutiveSubsequence3 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }


        int maxCount = 0;
        for(int i = 0; i < nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int count = 1;
                int current = nums[i];
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
                maxCount = maxCount > count ? maxCount : count;
            }
        }
        return maxCount;
    }
}

class $9_LongestConsecutiveSubsequence4 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }


        int maxCount = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int count = 1;
                int current = num;
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
                maxCount = maxCount > count ? maxCount : count;
            }
        }
        return maxCount;
    }
}




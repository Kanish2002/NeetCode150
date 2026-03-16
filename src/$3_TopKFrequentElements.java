import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class $3_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println(map);

        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int[] arr = new int[k];
        int count = 0;
        for(int i = bucket.length-1;i>=0 && count < k;i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    arr[count++] = num;
                }
                if(count == k) break;
            }
        }
        return arr;
    }
}


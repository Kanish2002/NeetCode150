import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println(map);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        int arr[] = new int[k];
        for(int i = 0; i< k;i++){
            arr[i] = pq.poll();
        }
        System.out.println(pq);
        return arr;
    }
}

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println(map);

        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<Integer>();
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
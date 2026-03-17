import java.util.*;

/**
 * Problem: Top K Frequent Elements
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */

class $3_TopKFrequentElementsMain {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        $3_TopKFrequentElements2 sol = new $3_TopKFrequentElements2();
        System.out.println("Top " + k + " frequent: " + Arrays.toString(sol.topKFrequent(nums, k)));
    }
}

// Solution 1: Using PriorityQueue (Max-Heap) - O(N log K)
// Why changed: While efficient, the PriorityQueue still takes O(log K) for each insertion. 
// We can do better with Bucket Sort.
class $3_TopKFrequentElements1 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        int arr[] = new int[k];
        for(int i = 0; i< k;i++){
            arr[i] = pq.poll();
        }
        return arr;
    }
}

// Solution 2: Using Bucket Sort - O(N)
// Why changed: This is the optimal O(N) solution. We use the frequency as an index 
// in an array of lists (buckets) to avoid the overhead of a PriorityQueue.
class $3_TopKFrequentElements2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

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
                    if(count < k) arr[count++] = num;
                }
            }
        }
        return arr;
    }
}

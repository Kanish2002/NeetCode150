import java.util.*;

/**
 * Problem: Group Anagrams (Wait, this is in $5_ValidAnagram.java but solves grouping)
 * 
 * Given an array of strings strs, group the anagrams together. 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

class $5_ValidAnagramMain {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        $5_ValidAnagram3 sol = new $5_ValidAnagram3();
        System.out.println("Grouped Anagrams: " + sol.groupAnagrams(strs));
    }
}

// Solution 1: Grouping by sorting each string (O(N * K log K))
// Why changed: Sorting each string takes O(K log K). We can improve this to O(K) 
// by using a frequency array.
class $5_ValidAnagram1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i = 0;i < strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}

// Solution 2: Grouping by frequency array using index-based loop (O(N * K))
// Why changed: Using a frequency array avoids sorting. This version uses traditional loops.
class $5_ValidAnagram2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(int i = 0;i < strs.length;i++){
            int freqArr[] = new int[26];
            for(int j = 0;j < strs[i].length();j++){
                freqArr[strs[i].charAt(j) - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(freqArr), k -> new ArrayList<String>()).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}

// Solution 3: Grouping by frequency array with enhanced for-loop (O(N * K))
// Why changed: Cleaner, more readable code using the enhanced for-loop.
class $5_ValidAnagram3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(String s : strs){
            int freqArr[] = new int[26];
            for(char c : s.toCharArray()){
                freqArr[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(freqArr), k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList(map.values());
    }
}

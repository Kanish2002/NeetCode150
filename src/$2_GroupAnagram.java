import java.util.*;

/**
 * Problem: Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

class $2_GroupAnagramMain {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        $2_GroupAnagram4 sol = new $2_GroupAnagram4();
        System.out.println("Grouped Anagrams: " + sol.groupAnagrams(strs));
    }
}

// Solution 1: Checking anagrams using two HashMaps.
// Evolution: This only checks if two strings are anagrams. It's the building block for grouping.
class $2_GroupAnagram1 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || (!hm1.get(c1).equals(hm2.get(c1)))) return false;
        }
        return true;
    }
}

// Solution 2: Similar to Solution 1, focusing on HashMap lookups.
class $2_GroupAnagram2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || (!hm1.get(c1).equals(hm2.get(c1)))) return false;
        }
        return true;
    }
}

// Solution 3: Checking anagrams with intValue() for explicit comparison.
class $2_GroupAnagram3 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || hm1.get(c1).intValue() != hm2.get(c1).intValue() ) return false;
        }
        return true;
    }
}


// Solution 4: Grouping Anagrams using Frequency Array as Key.
// Evolution: Instead of comparing every string with every other string (O(n^2)), 
// we generate a unique key for each anagram group in O(n * k) time.
class $2_GroupAnagram4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

        for (String s : strs) {
            int freqArr[] = new int[26];
            for (char c : s.toCharArray()) {
                freqArr[c - 'a']++;
            }
            // Use the string representation of the frequency array as the key
            map.computeIfAbsent(Arrays.toString(freqArr), k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList(map.values());
    }
}

// Solution 5: Optimized isAnagram using a single frequency array.
// Evolution: Most efficient way to check if two strings are anagrams (O(n) time, O(1) space).
class $2_GroupAnagram5 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(int i = 0; i < s.length();i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < freq.length;i++) if(freq[i] != 0) return false;
        return true;
    }
}


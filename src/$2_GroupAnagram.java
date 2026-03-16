import java.util.*;

class $2_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<String,ArrayList<String>>();

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

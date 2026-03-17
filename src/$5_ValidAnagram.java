import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution1 {
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
class Solution2 {
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
class Solution3 {
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
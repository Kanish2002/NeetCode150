import java.util.*;

class Solution1 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        System.out.println(hm1);
        System.out.println(hm2);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || (!hm1.get(c1).equals(hm2.get(c1)))) return false;
        }
        return true;
    }
}

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        System.out.println(hm1);
        System.out.println(hm2);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || (!hm1.get(c1).equals(hm2.get(c1)))) return false;
        }
        return true;
    }
}

class Solution3 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hm1 = new HashMap<Character,Integer>();
        Map<Character, Integer> hm2 = new HashMap<Character,Integer>();

        for(Character c1 : s.toCharArray()) hm1.put(c1, hm1.getOrDefault(c1,0) + 1);
        for(Character c2 : t.toCharArray()) hm2.put(c2, hm2.getOrDefault(c2,0) + 1);

        System.out.println(hm1);
        System.out.println(hm2);

        for(char c1 : hm1.keySet()){
            if(!hm2.containsKey(c1) || hm1.get(c1).intValue() != hm2.get(c1).intValue() ) return false;
        }
        return true;
    }
}


class Solution4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

        for (String s : strs) {

            int freqArr[] = new int[26];

            for (char c : s.toCharArray()) {
                freqArr[c - 'a']++;
            }

            map.computeIfAbsent(Arrays.toString(freqArr), k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList(map.values());
    }
}
class Solution5 {
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


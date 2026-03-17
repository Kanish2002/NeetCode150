import java.util.*;

/**
 * Problem: Encode and Decode Strings
 * 
 * Design an algorithm to encode a list of strings to a single string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * 
 * Example 1:
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 */

class $6_EncodeDecodeStringMain {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("lint", "code", "love", "you");
        $6_EncodeDecodeString1 sol = new $6_EncodeDecodeString1();
        String encoded = sol.encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = sol.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}

// Solution 1: Length-based encoding (Chunked Transfer Encoding style)
// Why this works: By prefixing each string with its length and a delimiter (e.g., "4#"), 
// we can handle any character inside the string (including the delimiter itself).
class $6_EncodeDecodeString1 {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder("");
        for(String s: strs){
            encoded.append(s.length());
            encoded.append("#");
            encoded.append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // Find the delimiter
            while (str.charAt(j) != '#') {
                j++;
            }
            // Parse the length
            int length = Integer.parseInt(str.substring(i, j));
            // Extract the string based on the parsed length
            decoded.add(str.substring(j + 1, j + 1 + length));
            // Move to the start of the next length prefix
            i = j + 1 + length;
        }
        return decoded;
    }
}

import java.util.ArrayList;
import java.util.List;

class $6_EncodeDecodeString {

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
        int number = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) != '#'){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    number = (number * 10) + (str.charAt(i) - '0');
                }
            }
            else{
                decoded.add(str.substring(i+1, number+i+1));
                i += number;
                number = 0;
            }
        }
        return decoded;
    }
}


class $10_ValidPalindrome1 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for(char c : s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                c +=  32 ;
                sb.append(c);
            }
            else if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sb.append(c);
            else continue;
        }
        s = sb.toString();
        for(int i = 0; i < s.length() / 2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
class $10_ValidPalindrome2 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);

            boolean isLeftValid = false;
            boolean isRightValid = false;

            if(isAlphaNumeric(l)){
                l = toLower(l);
                isLeftValid = true;
            }
            if(isAlphaNumeric(r)){
                r = toLower(r);
                isRightValid = true;
            }
            if(!isLeftValid && isRightValid) {
                left++;
                continue;
            }
            if(isLeftValid && !isRightValid){
                right--;
                continue;
            }

            if(isLeftValid && isRightValid){
                if(l != r) return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public char toLower(char c) {
        if(c >= 'A' && c <= 'Z') c+=32;
        return c;
    }
    public boolean isAlphaNumeric(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}

class $10_ValidPalindrome3 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);

            boolean isLeftValid = false;
            boolean isRightValid = false;

            if(isAlphaNumeric(l)) isLeftValid = true;
            if(isAlphaNumeric(r)) isRightValid = true;

            if(!isLeftValid) {
                left++;
                continue;
            }
            if(!isRightValid){
                right--;
                continue;
            }

            if(isLeftValid && isRightValid){
                if(toLower(l) != toLower(r)) return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public char toLower(char c) {
        if(c >= 'A' && c <= 'Z') c+=32;
        return c;
    }
    public boolean isAlphaNumeric(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}

class $10_ValidPalindrome4 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!isAlphaNumeric(l)) {
                left++;
                continue;
            }
            if(!isAlphaNumeric(r)){
                right--;
                continue;
            }
            if(toLower(l) != toLower(r)) return false;
            left++;
            right--;
        }
        return true;
    }
    public char toLower(char c) {
        if(c >= 'A' && c <= 'Z') c+=32;
        return c;
    }
    public boolean isAlphaNumeric(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}
class $10_ValidPalindrome5 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && !isAlphaNumeric(s.charAt(left))) left++;
            while(left < right && !isAlphaNumeric(s.charAt(right))) right--;
            if(toLower(s.charAt(left)) != toLower(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
    public char toLower(char c) {
        if(c >= 'A' && c <= 'Z') c+=32;
        return c;
    }
    public boolean isAlphaNumeric(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}



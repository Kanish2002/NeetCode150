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

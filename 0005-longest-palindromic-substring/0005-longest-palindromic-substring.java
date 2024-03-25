class Solution {
     int maxLength = 0;

    public String longestPalindrome(String s) {
        String result = "";

        for(int i = 0; i < s.length(); i++){
            //odd length
            int left = i;
            int right = i;

            result = expand(left,right,s,result);

            //even length
            left = i;
            right = i+1;
            result = expand(left,right, s,result);

        }
        return result;
    }

    public String expand(int l, int r, String s, String result){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1) > this.maxLength){
                    this.maxLength = r-l+1;
                    result = s.substring(l,r+1);
                }
                l--;
                r++;
            }
            return result;
    }
}
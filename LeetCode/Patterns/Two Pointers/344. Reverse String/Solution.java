class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;

        while(left<right){
            s[left] = (char)(s[left] ^ s[right]);
            s[right] = (char)(s[left] ^ s[right]);
            s[left] = (char)(s[left] ^ s[right]);

            left++;
            right--;
        }
    }
}
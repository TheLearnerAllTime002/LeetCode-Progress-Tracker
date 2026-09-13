class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        if(n ==0) return result;

        result[0] = 0; // binary of 0 has 0 number of bits as 1
        for(int i = 1; i<= n; i++){
            if(i%2 != 0){
                result[i] = result[i/2] +1;
            }else{
                result[i] = result[i/2];
            }
        }
        return result;
    }
}
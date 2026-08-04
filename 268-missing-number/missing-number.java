class Solution {
    public int missingNumber(int[] nums) {
        int XOR = 0;

        for(int i = 0; i<= nums.length ; i++){
            XOR = XOR ^ i;
        }

        for(int num : nums){
            XOR = XOR ^ num;
            
        }
        return XOR;
    }
    
}
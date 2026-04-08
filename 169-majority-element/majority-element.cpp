class Solution {
public:
    int majorityElement(vector<int>& nums) {
        //     for(int val : nums){
        //         int freq = 0;
        //         for(int d : nums){
        //             if( d == val){
        //                 freq++;
        //             }
        //         }
        //         if(freq > (nums.size()/2)){
        //         return val;
        //         }
        //     }
        //     return -1;
        // }

        //     int n = nums.size();
        //     sort(nums.begin(), nums.end());

        //     int freq = 1, ans = nums[0];
        //     for(int i = 1; i < n; i++) {
        //         if(nums[i] == nums[i-1]) {
        //             freq++;
        //         } else {
        //             freq = 1;
        //             ans = nums[i];
        //         }

        //         if(freq > n/2) {
        //             return ans;
        //         }
        //     }
        //     return ans;
        // }

    int freq = 0, ans = 0;

    for (int i = 0; i < nums.size(); i++) {
        if (freq == 0) {
            ans = nums[i];
        }

        if (nums[i] == ans) {
            freq++;
        } else {
            freq--;
        }
    }

    int count = 0;
    for (int val : nums) {
        if (val == ans) {
            count++;
        }
    }

    if (count > nums.size() / 2) {
        return ans;
    }

    return -1; 
}
};
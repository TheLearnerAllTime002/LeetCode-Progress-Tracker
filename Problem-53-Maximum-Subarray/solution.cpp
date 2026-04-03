#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int currentSum = 0;
        int maxSum = INT_MIN;

        for (int val : nums) {
            currentSum += val;
            maxSum = max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
};

int main() {
    Solution sol;
    
    // Test Case
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << "Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]" << endl;
    cout << "Maximum Subarray Sum: " << sol.maxSubArray(nums) << endl;
    
    return 0;
}

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int result = 0;
        for (int val : nums) {
            result ^= val;
        }
        return result;
    }
};

int main() {
    Solution sol;
    
    // Test Case
    vector<int> nums = {4, 1, 2, 1, 2};
    cout << "Array: [4, 1, 2, 1, 2]" << endl;
    cout << "Single Number: " << sol.singleNumber(nums) << endl;
    
    return 0;
}

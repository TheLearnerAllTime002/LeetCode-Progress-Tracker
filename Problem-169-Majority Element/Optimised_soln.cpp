#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Optimised Solution to find the majority element in an array

int majorityElement(vector<int>& nums) { // Time Complexity: O(n log n), Space Complexity: O(1)
    int n = nums.size();

    sort(nums.begin(), nums.end());

    int freq = 1, ans = nums[0];
    for(int i = 1; i < n; i++) {
        if(nums[i] == nums[i-1]) {
            freq++;
        } else {
            freq = 1;
            ans = nums[i];
        }

        if(freq > n/2) {
            return ans;
        }
    }
    return ans;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> nums(n);

    cout << "Enter elements: ";
    for(int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int result = majorityElement(nums);

    if(result != -1) {
        cout << "Majority Element: " << result << endl;
    } else {
        cout << "No Majority Element found." << endl;
    }

    return 0;
}

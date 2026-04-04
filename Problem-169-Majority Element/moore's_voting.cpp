#include <iostream>
#include <vector>
using namespace std;

int majorityElement(vector<int>& nums) {
    int n = nums.size();
    if (n == 0) return -1; // edge case

    int freq = 0, ans = 0;

    // Phase 1: Find candidate
    for (int val : nums) {
        if (freq == 0) {
            ans = val;
        }

        if (val == ans) {
            freq++;
        } else {
            freq--;
        }
    }

    // Phase 2: Verify candidate
    int count = 0;
    for (int val : nums) {
        if (val == ans) {
            count++;
        }
    }

    return (count > n / 2) ? ans : -1;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    if (n <= 0) {
        cout << "Invalid input!" << endl;
        return 0;
    }

    vector<int> nums(n);

    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int result = majorityElement(nums);

    if (result != -1) {
        cout << "Majority Element: " << result << endl;
    } else {
        cout << "No Majority Element found." << endl;
    }

    return 0;
}
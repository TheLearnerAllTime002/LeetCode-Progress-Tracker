//169. Majority Element : Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. You may assume that the majority element always exists in the array.

//Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2 

#include <iostream>
#include <vector>
using namespace std;

// Brute Force Solution to find the majority element in an array

int majorityElement(vector<int>& nums) { // Time Complexity: O(n^2), Space Complexity: O(1)
    for(int val : nums) {
        int freq = 0; 

        for(int d : nums) {
            if(d == val) {
                freq++;
            }
        }

        if(freq > nums.size() / 2) { // Check if the frequency is greater than n/2
            return val;
        }
    }

    return -1; // no majority element
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
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int idx = m + n - 1; // position to fill in nums1
        int i = m - 1;       // last element in nums1's valid part
        int j = n - 1;       // last element in nums2

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }
};
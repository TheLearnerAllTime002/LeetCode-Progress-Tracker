class Solution {
public:
    int maxArea(vector<int>& height) {
        // int width, maxWater = 0;

        // for(int i = 0; i<height.size(); i++){
        //     for(int j = 0; j<height.size(); j++){
        //         width = j - i;
        //         int ht = min(height[i],height[j]);

        //         int area = width * ht;

        //         maxWater = max(maxWater, area);
        //     }

        // }
        // return maxWater;

        int n = height.size();
        int maxWater = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            int wid = right - left;
            int minHeight = min(height[left], height[right]);
            maxWater = max(maxWater, wid * minHeight);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
};
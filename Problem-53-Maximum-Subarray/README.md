<div align="center">
  <img src="https://assets.leetcode.com/users/leetcode/avatar_1568224780.png" width="80" />
  
  # [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

  <p>
    <img src="https://img.shields.io/badge/Difficulty-Medium-orange?style=for-the-badge&logo=leetcode" />
    <img src="https://img.shields.io/badge/Language-C++-%2300599C?style=for-the-badge&logo=c%2B%2B" />
  </p>
</div>

---

## 📝 Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

## 💡 Approach
We use **Kadane’s Algorithm**:
- Keep track of a `currentSum` as we iterate through the elements.
- Continuously update the `maxSum` with the highest `currentSum` seen so far.
- If `currentSum` ever becomes negative, resetting it to `0` is optimal, because any negative sum would only decrease the sum of a future contiguous subarray.

## 🔄 Flowchart
```mermaid
graph TD;
    A[Start] --> B["Init currentSum = 0, maxSum = INT_MIN"]
    B --> C{More items in array?}
    C -->|Yes| D["currentSum += element"]
    C -->|No| I[Return maxSum]
    D --> E["maxSum = max(maxSum, currentSum)"]
    E --> F{"currentSum < 0?"}
    F -->|Yes| G["currentSum = 0"]
    F -->|No| H[Continue]
    G --> C
    H --> C
```

## 🧪 Pseudocode
```cpp
currentSum = 0
maxSum = -infinity

for each number in nums:
    currentSum += number
    maxSum = max(maxSum, currentSum)

    if currentSum < 0:
        currentSum = 0

return maxSum
```

## ⏱️ Complexity Analysis
- **Time Complexity**: **O(N)** - We do a single pass through the array.
- **Space Complexity**: **O(1)** - Only two integer variables are used.

## 🧠 Key Concepts
> - <img src="https://img.shields.io/badge/Concept-Dynamic%20Programming-blue?style=flat-square" />
> - <img src="https://img.shields.io/badge/Concept-Kadane's%20Algorithm-blue?style=flat-square" />

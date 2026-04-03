# 53. Maximum Subarray

## 📝 Problem Statement
Find the contiguous subarray with the largest sum.

## 💡 Approach
We use **Kadane’s Algorithm**:
- Keep track of current sum
- Reset when it becomes negative
- Track maximum sum globally

## 🔄 Flowchart
Start  
↓  
Initialize currentSum = 0, maxSum = -∞  
↓  
Loop through array  
↓  
Add element to currentSum  
↓  
Update maxSum  
↓  
If currentSum < 0 → reset to 0  
↓  
End Loop  
↓  
Return maxSum  

## 🧪 Pseudocode
```
currentSum = 0
maxSum = -∞

for each number in nums:
    currentSum += number
    maxSum = max(maxSum, currentSum)

    if currentSum < 0:
        currentSum = 0

return maxSum
```

## ⏱️ Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

## 🧠 Key Concepts
- Dynamic Programming
- Kadane’s Algorithm

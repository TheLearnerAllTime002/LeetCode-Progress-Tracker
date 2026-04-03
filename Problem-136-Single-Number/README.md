# 136. Single Number

## 📝 Problem Statement
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

## 💡 Approach
We use **Bit Manipulation (XOR)**:
- XOR of a number with itself = 0
- XOR with 0 = number
- So all duplicates cancel out, leaving the unique number

## 🔄 Flowchart
Start → Initialize result = 0  
↓  
Loop through array  
↓  
result = result XOR element  
↓  
End Loop  
↓  
Return result  

## 🧪 Pseudocode
```
result = 0
for each number in nums:
    result = result XOR number
return result
```

## ⏱️ Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

## 🧠 Key Concepts
- Bit Manipulation
- XOR Properties

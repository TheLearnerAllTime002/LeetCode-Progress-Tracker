<div align="center">
  <img src="https://assets.leetcode.com/users/leetcode/avatar_1568224780.png" width="80" />
  
  # [136. Single Number](https://leetcode.com/problems/single-number/)

  <p>
    <img src="https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=for-the-badge&logo=leetcode" />
    <img src="https://img.shields.io/badge/Language-C++-%2300599C?style=for-the-badge&logo=c%2B%2B" />
  </p>
</div>

---

## 📝 Problem Statement
Given a **non-empty** array of integers, every element appears twice except for one. Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space.

## 💡 Approach
We use **Bit Manipulation (XOR)** properties:
1. `X ^ X = 0` (XOR of a number with itself is `0`)
2. `X ^ 0 = X` (XOR of a number with `0` is the number itself)

Since all other elements appear exactly twice, their XOR will evaluate to `0`. The only element appearing once will be XORed with `0`, resulting in itself.

## 🔄 Flowchart
```mermaid
graph TD;
    A[Start] --> B[Initialize result = 0]
    B --> C{More items in array?}
    C -->|Yes| D[result = result ^ element]
    C -->|No| E[Return result]
    D --> C
    E --> F[End]
```

## 🧪 Pseudocode
```cpp
result = 0
for each number in nums:
    result = result XOR number
return result
```

## ⏱️ Complexity Analysis
- **Time Complexity**: **O(N)** - We iterate through the array exactly once, where N is the size of the array.
- **Space Complexity**: **O(1)** - We only use a single integer variable (`result`) to compute the answer.

## 🧠 Key Concepts
> - <img src="https://img.shields.io/badge/Concept-Bit%20Manipulation-blue?style=flat-square" />
> - <img src="https://img.shields.io/badge/Concept-XOR%20Properties-blue?style=flat-square" />

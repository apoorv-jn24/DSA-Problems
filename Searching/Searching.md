# 🔍 Searching in DSA (Java)

Searching is the process of **finding a target element** in a data structure such as an array or list.
---

## 📌 Why Searching?
- Fundamental DSA concept
- Used in databases and systems
- Base for advanced algorithms
- Common in coding interviews

---

## 📌 Types of Searching

### 1️⃣ Linear Search
- Checks elements one by one
- Works on **unsorted data**
- Simple but slow for large inputs

**Time Complexity**
- Best: O(1)
- Average/Worst: O(n)

📄 Code: [LinearSearch.java](LinearSearch.java)

---

### 2️⃣ Binary Search
- Works only on **sorted data**
- Divide & Conquer approach
- Efficient for large datasets

**Time Complexity**
- Best: O(1)
- Average/Worst: O(log n)

📄 Code: [BinarySearch.java](BinarySearch.java)

---

## 📊 Comparison

| Algorithm | Sorted Required | Time | Space |
|---------|----------------|------|-------|
| Linear Search | ❌ No | O(n) | O(1) |
| Binary Search | ✅ Yes | O(log n) | O(1) |

---

## ⭐ Binary Search Variants
- First Occurrence
- Last Occurrence
- Lower Bound
- Upper Bound
- Search in Rotated Sorted Array

📄 Codes:
- [FirstOccurrence.java](FirstOccurrence.java)
- [LastOccurrence.java](LastOccurrence.java)

---

## 📌 Common Mistakes
- Using binary search on unsorted array
- Infinite loop due to wrong `low` / `high`
- Overflow in mid calculation

✅ Safe mid:
```java
mid = low + (high - low) / 2;

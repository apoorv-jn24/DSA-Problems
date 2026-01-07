
---

## 🔐 Hashing in Java – Short Notes

### 📌 What is Hashing?

**Hashing** is a technique used to **map data (keys) to a fixed-size value** using a **hash function**, enabling **fast insertion, deletion, and search** operations.

> Average Time Complexity: **O(1)**

---

### 📌 Hash Function

A **hash function** converts a key into an index of a hash table.

**Good hash function properties:**

* Deterministic (same input → same output)
* Uniform distribution
* Fast computation
* Minimizes collisions

---

### 📌 Hash Table

A **Hash Table** stores key–value pairs using a hash function.

| Operation | Average | Worst Case |
| --------- | ------- | ---------- |
| Insert    | O(1)    | O(n)       |
| Search    | O(1)    | O(n)       |
| Delete    | O(1)    | O(n)       |

Worst case occurs due to **collisions**.

---

### 📌 Collision Handling Techniques

Collision occurs when **two keys map to the same index**.

1. **Chaining**

   * Store multiple values at same index using a LinkedList
   * Used internally in Java HashMap

2. **Open Addressing**

   * Linear Probing
   * Quadratic Probing
   * Double Hashing

---

### 📌 Hashing in Java Collections

Java Collections Framework provides built-in hashing structures:

| Class           | Description                   |
| --------------- | ----------------------------- |
| `HashMap`       | Key-value storage, no order   |
| `HashSet`       | Stores unique elements        |
| `Hashtable`     | Thread-safe, legacy           |
| `LinkedHashMap` | Maintains insertion order     |
| `TreeMap`       | Sorted order (Red-Black Tree) |

---

### 📌 HashMap (Most Used)

* Stores data as **(key, value)** pairs
* Allows **one null key**, multiple null values
* Not synchronized (not thread-safe)

```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "Java");
map.put(2, "DSA");
System.out.println(map.get(1));
```

---

### 📌 HashSet

* Stores **unique elements only**
* Internally uses `HashMap`
* No duplicate values allowed

```java
HashSet<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(10); // ignored
```

---

### 📌 equals() & hashCode()

For **custom objects**, both must be overridden.

```java
@Override
public int hashCode() {
    return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    MyClass other = (MyClass) obj;
    return id == other.id;
}
```

✔ If `equals()` is true → `hashCode()` must be same
❌ Same hashCode does NOT guarantee equality

---

### 📌 Load Factor

* Default load factor = **0.75**
* When size exceeds `(capacity × load factor)`, **rehashing** occurs

---

### 📌 Advantages of Hashing

* Very fast operations
* Efficient for large datasets
* Widely used in caching, indexing, databases

---

### 📌 Disadvantages

* Poor hash function leads to collisions
* No ordering (HashMap / HashSet)
* Worst-case time can degrade to O(n)

---

### 📌 Common Interview Use-Cases

* Frequency counting
* Detect duplicates
* Two Sum problem
* Anagram checking
* Subarray problems
* Caching

---
### 📌 When to Use Hashing?
✔ Fast lookup needed
✔ Order not required
✔ Duplicate handling required

---


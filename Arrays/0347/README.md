# LeetCode #347 — Top K Frequent Elements

## 🧩 Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

### Example

```text
nums = [1,1,1,2,2,3]
k = 2

Output: [1,2]
```

Frequencies:

```text
1 → 3
2 → 2
3 → 1
```

The top 2 frequent elements are `1` and `2`.

> The order of the answer does not matter.

---

# 💡 Core Idea

First, count how many times every number appears.

```text
number → frequency
```

Then find the numbers with the highest frequencies.

This gives us three common approaches:

1. **Sorting**
2. **PriorityQueue / Min Heap**
3. **Bucket Sort**

---

# 1️⃣ Approach 1 — HashMap + Sorting

### Idea

```text
COUNT → CONVERT → SORT → TAKE K
```

### Step 1: Count frequencies

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
```

Example:

```text
1 → 3
2 → 2
3 → 1
```

### Step 2: Convert map entries to a list

```java
List<Map.Entry<Integer, Integer>> entries =
        new ArrayList<>(map.entrySet());
```

Each `Map.Entry` contains:

```text
getKey()   → number
getValue() → frequency
```

### Step 3: Sort by frequency

```java
entries.sort((a, b) -> b.getValue() - a.getValue());
```

`b.getValue() - a.getValue()` puts the **highest frequency first**.

### Step 4: Take first `k` keys

```java
int[] result = new int[k];

for (int i = 0; i < k; i++) {
    result[i] = entries.get(i).getKey();
}
```

### Complete Code

```java
import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert map entries to a list
        List<Map.Entry<Integer, Integer>> entries =
                new ArrayList<>(map.entrySet());

        // Sort by frequency: highest first
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // Take top k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(
                Arrays.toString(topKFrequent(nums, k))
        );
    }
}
```

### Complexity

Let:

* `n` = total number of elements
* `m` = number of unique elements

```text
Time  → O(n + m log m)
Space → O(m)
```

### When to remember this approach

> **Simple and easy to understand.**

---

# 2️⃣ Approach 2 — PriorityQueue / Min Heap

### Main Idea

Instead of sorting **all unique elements**, maintain only the best `k` elements.

Think of the heap as a small waiting room of size `k`.

For:

```text
1 → 3
2 → 2
3 → 1
4 → 5
5 → 4
```

and:

```text
k = 2
```

we only need:

```text
4 → 5
5 → 4
```

### Why Min Heap?

We want the **smallest frequency among our current top K** at the top.

If the heap size becomes greater than `k`, remove the smallest frequency.

### Code

```java
import java.util.*;

public class TopKFrequentHeap {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(
                        (a, b) -> a.getValue() - b.getValue()
                );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            heap.offer(entry);

            // Keep only k elements
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }
}
```

### Important Heap Pattern

```text
Add element
    ↓
Heap size > k ?
    ↓
Yes → remove smallest
```

### Complexity

```text
Time  → O(n + m log k)
Space → O(m + k)
```

### Important Point

If `k` is much smaller than the number of unique elements, a heap can avoid sorting everything.

---

# 3️⃣ Approach 3 — Bucket Sort

### Main Idea

The frequency of an element can never be greater than `n`.

So instead of sorting frequencies, create buckets based on frequency.

For:

```text
nums = [1,1,1,2,2,3]
```

we have:

```text
1 → frequency 3
2 → frequency 2
3 → frequency 1
```

Create:

```text
frequency 0 → []
frequency 1 → [3]
frequency 2 → [2]
frequency 3 → [1]
```

Then start from the **highest frequency bucket**.

```text
frequency 3 → [1]   ← take 1
frequency 2 → [2]   ← take 2
```

Now `k = 2`, so stop.

### Code

```java
import java.util.*;

public class TopKFrequentBucket {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Frequency → numbers having that frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        // Start from highest frequency
        for (int frequency = buckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (buckets[frequency] != null) {

                for (int num : buckets[frequency]) {

                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
```

### Complexity

```text
Time  → O(n)
Space → O(n)
```

under the standard bucket-sort analysis for this problem.

### Important Idea

> **Frequency becomes the bucket index.**

```text
bucket[frequency] → numbers with that frequency
```

---

# 🔥 Three Approaches Compared

| Approach    | Main Idea          | Time             | Space      |
| ----------- | ------------------ | ---------------- | ---------- |
| Sorting     | Sort by frequency  | `O(n + m log m)` | `O(m)`     |
| Min Heap    | Keep only top K    | `O(n + m log k)` | `O(m + k)` |
| Bucket Sort | Frequency → bucket | `O(n)`           | `O(n)`     |

Where:

```text
n = total elements
m = unique elements
k = required number of elements
```

---

# 🧠 Important Java Concepts

### `getOrDefault()`

```java
map.getOrDefault(num, 0)
```

Means:

> Get the current value if the key exists; otherwise use `0`.

Then:

```java
map.put(num, map.getOrDefault(num, 0) + 1);
```

means:

```text
GET → +1 → PUT
```

---

### `Map.Entry`

For:

```text
1 → 3
```

```java
entry.getKey()
```

returns:

```text
1
```

and:

```java
entry.getValue()
```

returns:

```text
3
```

Remember:

```text
getKey()   → left side
getValue() → right side
```

---

### Sorting by Value

```java
entries.sort((a, b) -> b.getValue() - a.getValue());
```

We use `getValue()` because the **frequency is the value**.

```text
number → frequency
  key   →   value
```

---

# ⚠️ Common Mistakes

* Sorting the numbers instead of their frequencies
* Forgetting to count frequencies first
* Taking the first `k` numbers without sorting/grouping by frequency
* Confusing `getKey()` and `getValue()`
* In the Heap approach, forgetting to remove when `heap.size() > k`
* In Bucket Sort, forgetting to traverse from the **highest frequency**
* Forgetting that the answer order does not matter

---

# 🔗 Connection With Previous Problems

### #242 — Valid Anagram

```text
Character → Frequency
```

### #347 — Top K Frequent Elements

```text
Number → Frequency
        ↓
Find highest frequencies
```

The frequency-counting pattern is the same:

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

---

# 📌 Quick Revision

### Sorting

> **Count → Convert → Sort → Take K**

### Heap

> **Count → Add to Min Heap → If size > K, remove smallest**

### Bucket

> **Count → Frequency becomes bucket index → Traverse from highest frequency**

### One-line memory trick

```text
SORTING → Arrange everyone
HEAP    → Keep only K
BUCKET  → Group by frequency
```

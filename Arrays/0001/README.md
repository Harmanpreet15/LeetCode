# LeetCode 0001 — Two Sum

🔗 [LeetCode Problem](https://leetcode.com/problems/two-sum/)

## Problem

Given an integer array `nums` and an integer `target`, return the indices of the two numbers whose sum is equal to `target`.

### Example

```text
nums = [2, 7, 11, 15]
target = 9

Output: [0, 1]
```

Because:

```text
nums[0] + nums[1]
= 2 + 7
= 9
```

---

## Approach

### Brute Force

Check every possible pair using two loops.

```text
Time: O(n²)
Space: O(1)
```

### Optimized — HashMap

Instead of checking every pair, store numbers we have already seen in a HashMap.

For every `nums[i]`:

```text
toFind = target - nums[i]
```

Then check whether `toFind` is already in the map.

If yes, we found the answer.

If no, store the current number and its index.

```text
Time: O(n)
Space: O(n)
```

---

## Dry Run

```text
nums = [2, 7, 11, 15]
target = 9
```

### Step 1

```text
i = 0
nums[i] = 2

toFind = 9 - 2 = 7

7 is not in map

Store:
2 → 0
```

Map:

```text
{2=0}
```

### Step 2

```text
i = 1
nums[i] = 7

toFind = 9 - 7 = 2

2 is already in map
```

We found:

```text
index of 2 = 0
current index = 1
```

Answer:

```text
[0, 1]
```

---

## Key Pattern

Remember:

```text
target - current number = number we need
```

Then:

```java
if (map.containsKey(toFind)) {
    return new int[]{map.get(toFind), i};
}
```

This is the **complement + HashMap pattern**.

---

## Common Mistake

Do **not** put the current number into the map before checking the complement.

Correct order:

```text
1. Find complement
2. Check HashMap
3. Store current number
```

---

## File

[`TwoSum.java`](./TwoSum.java)

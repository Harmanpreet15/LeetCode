# LeetCode 0217 — Contains Duplicate

🔗 [LeetCode Problem](https://leetcode.com/problems/contains-duplicate/)

## Problem

Given an integer array `nums`, return `true` if any value appears at least twice in the array.

Return `false` if every element is unique.

### Example 1

```text
nums = [1, 2, 3, 1]

Output: true
```

`1` appears twice, so there is a duplicate.

### Example 2

```text
nums = [1, 2, 3, 4]

Output: false
```

Every number appears only once.

---

## Approach

### Brute Force

Compare every element with every other element.

```text
Time: O(n²)
Space: O(1)
```

This works, but it is inefficient for large arrays.

### Optimized — HashSet

Use a `HashSet` to keep track of numbers that we have already seen.

For every number:

1. Check if it already exists in the set.
2. If it exists → duplicate found → return `true`.
3. Otherwise → add it to the set.
4. If we finish the entire array → return `false`.

```text
Time: O(n)
Space: O(n)
```

---

## Dry Run

```text
nums = [1, 2, 3, 1]
```

Start:

```text
set = {}
```

### Step 1

```text
1 → not present
```

Add `1`:

```text
{1}
```

### Step 2

```text
2 → not present
```

Add `2`:

```text
{1, 2}
```

### Step 3

```text
3 → not present
```

Add `3`:

```text
{1, 2, 3}
```

### Step 4

```text
1 → already present
```

Duplicate found:

```text
return true
```

---

## Key Pattern

### HashSet Pattern

Remember:

```text
CHECK → ADD
```

In code:

```java
if (set.contains(nums[i])) {
```

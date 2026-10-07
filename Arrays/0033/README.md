# 33. Search in Rotated Sorted Array

## Problem

Search for a target in a rotated sorted array and return its index.

If the target does not exist, return `-1`.

Example:

```text
nums = [4,5,6,7,0,1,2]
target = 0

answer = 4
```

## Approach

**Binary Search**

Even though the array is rotated, at least **one half is always sorted**.

At every step:

1. Find `mid`.
2. If `nums[mid] == target`, return `mid`.
3. Determine which half is sorted.
4. Check whether the target belongs to that sorted half.
5. Keep that half and discard the other.

## Core Logic

### Left half is sorted

```java
nums[left] <= nums[mid]
```

Check if target lies in:

```text
nums[left] <= target < nums[mid]
```

If yes:

```java
right = mid - 1;
```

Otherwise:

```java
left = mid + 1;
```

### Right half is sorted

Otherwise, right half is sorted.

Check:

```text
nums[mid] < target <= nums[right]
```

If yes:

```java
left = mid + 1;
```

Otherwise:

```java
right = mid - 1;
```

## Important Things to Remember

* At least one half is always sorted.
* First identify the sorted half.
* Then check whether the target belongs to it.
* If yes → search that half.
* If no → search the other half.
* Use:
  `while (left <= right)`
* `left <= right` allows checking the final single element.
* Safe midpoint:
  `left + (right - left) / 2`

## Why Not Normal Binary Search?

The complete array is not sorted after rotation, so simply comparing the target with `nums[mid]` is not enough.

Instead:

```text
FIND SORTED HALF
       ↓
TARGET IN THAT HALF?
    ↓          ↓
   YES         NO
    ↓           ↓
KEEP IT      DISCARD IT
```

## Complexity

Time: **O(log n)**
Space: **O(1)**

## Quick Revision

```text
LEFT + RIGHT
     ↓
   MID
     ↓
TARGET == MID?
     ↓ NO
WHICH HALF IS SORTED?
     ↓
TARGET IN SORTED HALF?
   /          \
 YES           NO
 ↓              ↓
KEEP HALF     OTHER HALF
```

**Memory Trick:**

> **Find sorted half → check target → keep one half → discard the other.**

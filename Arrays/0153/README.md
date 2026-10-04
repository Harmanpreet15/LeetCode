# 153. Find Minimum in Rotated Sorted Array

## Problem

Find the minimum element in a rotated sorted array.

Example:

```text
nums = [4,5,6,7,0,1,2]
answer = 0
```

## Approach

**Binary Search**

Use `left` and `right` pointers.

Calculate:

```java
mid = left + (right - left) / 2;
```

Compare `nums[mid]` with `nums[right]`.

### Core Logic

```text
nums[mid] > nums[right]
        ↓
Minimum is to the RIGHT
        ↓
left = mid + 1
```

```text
nums[mid] <= nums[right]
        ↓
Minimum is at MID or to the LEFT
        ↓
right = mid
```

Continue until:

```text
left == right
```

Then:

```java
return nums[left];
```

## Why Binary Search?

The array is originally sorted but rotated, so we can use its sorted structure to eliminate half of the search space at every step.

```text
O(n) linear search 
O(log n) binary search 
```

## Important Things to Remember

* Use `left < right`, not `left <= right`.
* Compare `nums[mid]` with `nums[right]`.
* `mid > right` → go right.
* `mid <= right` → keep `mid` and go left.
* Use `right = mid`, **not `mid - 1`**, because `mid` may be the minimum.
* Final answer is `nums[left]`.
* Safe midpoint:
  `left + (right - left) / 2`

## Complexity

Time: **O(log n)**
Space: **O(1)**

## Quick Revision

```text
LEFT + RIGHT
     ↓
CALCULATE MID
     ↓
mid > right → LEFT = MID + 1
mid <= right → RIGHT = MID
     ↓
LEFT == RIGHT
     ↓
RETURN nums[left]
```

**Memory Trick:**

> **mid bigger than right → minimum is right**
> **mid smaller/equal to right → keep mid**

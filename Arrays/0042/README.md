# 42. Trapping Rain Water

## Problem

Given an array of bar heights, find how much rainwater can be trapped between the bars.

Example:

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
answer = 6
```

## Approach

**Two Pointers + Left Maximum + Right Maximum**

Use:

* `left` and `right` pointers
* `leftMax` = highest wall seen from the left
* `rightMax` = highest wall seen from the right

### Core Formula

```text
water at index i =
min(leftMax, rightMax) - height[i]
```

But instead of calculating both maximums for every index, process the side with the **smaller current height**.

### Core Logic

```text
height[left] <= height[right]
        ↓
Process LEFT
        ↓
If height[left] >= leftMax
    update leftMax
Else
    water += leftMax - height[left]
        ↓
left++

Otherwise
        ↓
Process RIGHT
        ↓
If height[right] >= rightMax
    update rightMax
Else
    water += rightMax - height[right]
        ↓
right--
```

## Why Process the Smaller Side?

The smaller boundary limits the amount of water.

If:

```text
height[left] <= height[right]
```

the right side already has a wall at least as high as the left side, so the left side can safely be processed using `leftMax`.

This is the same two-pointer intuition used in **#11 Container With Most Water**.

## Why Not Brute Force?

For every index, finding the maximum wall on both sides repeatedly would take **O(n²)**.

Two pointers process each position once:

```text
O(n)
```

## Important Things to Remember

* Water needs a boundary on both sides.
* `leftMax` = highest wall seen from left.
* `rightMax` = highest wall seen from right.
* Smaller current height → process that side.
* If current height is a new maximum → update maximum.
* Otherwise:
  `water += max - currentHeight`
* Move the processed pointer.
* `water` stores the total trapped water.

## Complexity

Time: **O(n)**
Space: **O(1)**

## Quick Revision

```text
TWO POINTERS
     ↓
COMPARE LEFT & RIGHT
     ↓
PROCESS SMALLER SIDE
     ↓
UPDATE MAX OR ADD WATER
     ↓
MOVE POINTER
```

**Memory Trick:**

> Smaller side → check its max → calculate water → move that side.

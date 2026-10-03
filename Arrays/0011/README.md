# 11. Container With Most Water

## Problem

Find two lines that form a container holding the maximum amount of water.

Example:

```text
height = [1,8,6,2,5,4,8,3,7]
answer = 49
```

## Approach

**Two Pointers**

1. Start `left` at the beginning.
2. Start `right` at the end.
3. Calculate the area between them.
4. Move the pointer with the **shorter height**.
5. Continue until `left >= right`.

### Formula

```text
width = right - left

waterHeight = min(height[left], height[right])

area = width × waterHeight
```

### Core Pattern

```text
LEFT + RIGHT
     ↓
CALCULATE AREA
     ↓
MOVE SHORTER POINTER
     ↓
UPDATE MAX
```

## Why Move the Shorter Pointer?

The shorter line limits the water height.

If we move the taller pointer:

* Width decreases.
* The shorter height may remain the same.
* So we cannot improve the area.

Therefore:

```text
height[left] < height[right] → left++
otherwise                    → right--
```

## Why Not Brute Force?

Checking every pair requires two nested loops:

```text
O(n²)
```

Two pointers reduce it to:

```text
O(n)
```

## Important Things to Remember

* `width = right - left`
* Water height = **shorter line**
* Always move the **shorter pointer**
* Track maximum using `Math.max()`
* Stop when `left >= right`

## Complexity

Time: **O(n)**
Space: **O(1)**

## Quick Revision

```text
LEFT → RIGHT
↓
AREA = (RIGHT - LEFT) × MIN(LEFT HEIGHT, RIGHT HEIGHT)
↓
MOVE SHORTER SIDE
↓
UPDATE MAX
```

**Memory Trick:**

> Shorter side limits the water → move the shorter side.

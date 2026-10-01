# 238. Product of Array Except Self

## Problem

Given an integer array `nums`, return an array `answer` where `answer[i]` is the product of all elements except `nums[i]`.

**Example:**

```text
Input:  [1, 2, 3, 4]
Output: [24, 12, 8, 6]
```

## Approach: Prefix and Suffix Products

Instead of multiplying every element separately for each index, use two passes.

### 1. Left Product (Forward Pass)

* Start with `leftProduct = 1`.
* Store the product of all elements to the left of the current index in `result[i]`.
* Update `leftProduct` by multiplying it with `nums[i]`.

### 2. Right Product (Backward Pass)

* Start with `rightProduct = 1`.
* Multiply `result[i]` by the product of all elements to the right.
* Update `rightProduct` by multiplying it with `nums[i]`.

**Key Idea:**

```text
answer[i] = left product × right product
```

## Important Code Pattern

**Forward Pass:**

```java
result[i] = leftProduct;
leftProduct *= nums[i];
```

**Backward Pass:**

```java
result[i] *= rightProduct;
rightProduct *= nums[i];
```

## Dry Run

For `nums = [1, 2, 3, 4]`:

| Index | Left Product | Right Product | Answer |
| ----- | -----------: | ------------: | -----: |
| 0     |            1 |            24 |     24 |
| 1     |            1 |            12 |     12 |
| 2     |            2 |             4 |      8 |
| 3     |            6 |             1 |      6 |

**Output:** `[24, 12, 8, 6]`

## Complexity

* **Time:** O(n) — two passes through the array.
* **Extra Space:** O(1), excluding the output array.

## Common Mistakes

* Starting `leftProduct` or `rightProduct` at `0` instead of `1`.
* Updating the product before storing or multiplying it into the result.
* Using division instead of the prefix/suffix approach.

## Quick Revision

**LEFT → STORE → MOVE**

**RIGHT → MULTIPLY → MOVE**

No division is needed, and the approach naturally handles arrays containing zeros.

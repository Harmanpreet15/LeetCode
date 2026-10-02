# 15. 3Sum

## Problem

Find all unique triplets whose sum is `0`.

Example:

```text
nums = [-1, 0, 1, 2, -1, -4]

Output = [[-1, -1, 2], [-1, 0, 1]]
```

## Approach

**Sort + Two Pointers**

1. Sort the array.
2. Fix one number using `i`.
3. Use `left` and `right` to find the other two numbers.
4. Compare their sum with `0`.

### Pointer Movement

```text
sum < 0  → left++
           Need a bigger number

sum > 0  → right--
           Need a smaller number

sum == 0 → Save triplet
           left++
           right--
```

### Core Pattern

```text
SORT
  ↓
FIX i
  ↓
left = i + 1
right = last
  ↓
calculate sum
  ↓
< 0 → left++
> 0 → right--
= 0 → save + move both
```

## Why Sort?

Sorting allows us to decide which pointer to move.

Without sorting, we cannot confidently say:

```text
sum < 0 → need a bigger number → left++
sum > 0 → need a smaller number → right--
```

Sorting costs:

```text
O(n log n)
```

but the complete solution is still:

```text
O(n²)
```

which is much better than checking every possible triplet with three loops: `O(n³)`.

## Handling Duplicates

The problem asks for **unique triplets**, so duplicates must be skipped.

### Duplicate `i`

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

**Same starting number → skip.**

### Duplicate `left`

After finding a valid triplet:

```java
while (left < right && nums[left] == nums[left - 1]) {
    left++;
}
```

### Duplicate `right`

```java
while (left < right && nums[right] == nums[right + 1]) {
    right--;
}
```

## Important Things to Remember

* Sort first.
* `i` fixes the first number.
* `left = i + 1`.
* `right = nums.length - 1`.
* `sum < 0` → increase `left`.
* `sum > 0` → decrease `right`.
* `sum == 0` → store answer and move both pointers.
* Skip duplicate values to avoid duplicate triplets.
* `left < right` must remain true.
* Don't use three nested loops (`O(n³)`).

## Complexity

```text
Sorting:  O(n log n)
Two-pointer search: O(n²)

Overall: O(n²)
Space:   O(1) extra space
         (excluding the output)
```

## Quick Revision

```text
SORT
→ FIX i
→ LEFT + RIGHT
→ SUM
→ < 0 : LEFT++
→ > 0 : RIGHT--
→ = 0 : SAVE + MOVE BOTH
→ SKIP DUPLICATES
```

**Memory Trick:**
`FIX ONE → SEARCH TWO → ADJUST POINTERS → SKIP DUPLICATES`

# 128. Longest Consecutive Sequence

## Problem

Find the length of the longest sequence of consecutive numbers in an unsorted array.

Example:

```text
nums = [100, 4, 200, 1, 3, 2]
answer = 4        // 1, 2, 3, 4
```

## Approach

Use a **HashSet** for O(1) average lookup.

### Core Logic

1. Put all numbers into a `HashSet`.
2. For each number, start counting **only if it is the beginning of a sequence**:

   ```java
   !set.contains(num - 1)
   ```
3. If it is the beginning, keep checking:

   ```java
   set.contains(current + 1)
   ```
4. Track the maximum length.

### Main Pattern

```text
NO PREVIOUS → START
NEXT EXISTS → CONTINUE
```

```java
if (!set.contains(num - 1)) {

    int current = num;
    int length = 1;

    while (set.contains(current + 1)) {
        current++;
        length++;
    }

    longest = Math.max(longest, length);
}
```

## Why HashSet?

We need to quickly check whether `num - 1` or `num + 1` exists.

```text
HashSet.contains() → O(1) average
```

## Why Not Sorting?

Sorting makes the problem easier, but:

```text
Sorting → O(n log n)
Required optimal approach → O(n)
```

So use `HashSet` instead of sorting.

## Important Things to Remember

* **Do not start from every number.**
* `num - 1` not present → current number is a sequence **start**.
* `current + 1` present → continue the sequence.
* Use `Math.max()` to store the longest sequence.
* `HashSet` automatically handles duplicate numbers.
* Don't confuse **sequence** with **subarray** — consecutive numbers do not need to be adjacent in the original array.

## Complexity

```text
Time:  O(n) average
Space: O(n)
```

## Quick Revision

```text
HashSet
   ↓
Check num - 1
   ↓
No previous → START
   ↓
Check num + 1
   ↓
Keep counting
   ↓
Update MAX
```

**Memory Trick:**
`NO PREVIOUS → START → NEXT → COUNT → MAX`

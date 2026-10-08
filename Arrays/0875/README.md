# LeetCode #875 — Koko Eating Bananas

## Approach: Binary Search on Answer

Find the **minimum eating speed `k`** that allows Koko to finish within `h` hours.

### Key Idea

Search possible speeds:

```text
1 → max(piles)
```

For each `mid` speed, calculate total hours:

```java
hours += (pile + mid - 1) / mid;
```

This is `ceil(pile / mid)`.

### Binary Search

```text
hours <= h  → speed works → try smaller → right = mid
hours > h   → speed too slow → go faster → left = mid + 1
```

Use:

```java
while (left < right)
```

and return:

```java
return left;
```

### Why Binary Search?

Speeds have a monotonic property:

```text
Slower speed → more hours
Faster speed → fewer hours
```

So once a speed works, every faster speed also works.

### Complexity

* **Time:** `O(n log m)` — `n` = number of piles, `m` = maximum pile
* **Space:** `O(1)`

### Remember

**GUESS SPEED → CALCULATE HOURS → WORKS? → LEFT / RIGHT**

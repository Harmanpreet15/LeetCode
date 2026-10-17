# LeetCode #74 — Search a 2D Matrix

## Approach: Binary Search

Treat the sorted 2D matrix as a virtual 1D sorted array without actually converting it.

- `left = 0`, `right = m * n - 1`
- Find `mid` using binary search.
- Convert the 1D index into matrix coordinates:
  - `row = mid / n`
  - `col = mid % n`
- Compare `matrix[row][col]` with `target` and adjust the search range.

## Key Points

- `mid / n` gives the row index.
- `mid % n` gives the column index.
- Use `while (left <= right)` because the last remaining element must also be checked.
- The matrix must satisfy both sorted-order properties given in the problem.

## Complexity

- **Time:** `O(log(m * n))`
- **Space:** `O(1)`

## Remember

**Binary Search → Convert index → Compare → Adjust boundaries**

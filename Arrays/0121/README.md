# LeetCode 0121 — Best Time to Buy and Sell Stock

🔗 [LeetCode Problem](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## Problem

You are given an array `prices` where `prices[i]` represents the price of a stock on the `i`th day.

You can:

* Buy the stock once.
* Sell the stock once.
* You must buy before selling.

Return the **maximum profit** possible.

If no profit is possible, return `0`.

### Example

```text
prices = [7, 1, 5, 3, 6, 4]

Output: 5
```

Buy at:

```text
1
```

Sell at:

```text
6
```

Profit:

```text
6 - 1 = 5
```

---

## Approach

### Brute Force

Try every possible pair of buying and selling days.

For every buying day, check all later selling days and calculate:

```text
selling price - buying price
```

Keep the maximum profit.

```text
Time: O(n²)
Space: O(1)
```

### Optimized — One Pass

We don't need to check every pair.

While traversing the array, keep:

```text
minPrice  → lowest price seen so far
maxProfit → maximum profit found so far
```

For every current price:

```text
profit = current price - minPrice
```

Then update `maxProfit`.

If the current price is smaller than `minPrice`, update `minPrice`.

```text
Time: O(n)
Space: O(1)
```

---

## Dry Run

```text
prices = [7, 1, 5, 3, 6, 4]
```

Start:

```text
minPrice = 7
maxProfit = 0
```

| Price | Minimum Price | Current Profit | Maximum Profit |
| ----: | ------------: | -------------: | -------------: |
|     7 |             7 |              0 |              0 |
|     1 |             1 |              0 |              0 |
|     5 |             1 |              4 |              4 |
|     3 |             1 |              2 |              4 |
|     6 |             1 |              5 |              5 |
|     4 |             1 |              3 |              5 |

Final answer:

```text
5
```

---

## Key Pattern

Remember these 3 steps:

```text
1. Keep the minimum price seen so far.
2. Calculate current price - minimum price.
3. Keep the maximum profit.
```

The important formula is:

```java
int profit = prices[i] - minPrice;
```

---

## Why Does This Work?

For any day, if we want to sell today, the best possible buying price is the **lowest price from an earlier day**.

So instead of checking every possible pair, we simply remember the cheapest price we've seen.

This reduces the solution from:

```text
O(n²)
```

to:

```text
O(n)
```

---

## Common Mistake

Do not choose the lowest price in the entire array without considering the order of days.

You must:

```text
BUY → first
SELL → later
```

For example:

```text
[7, 6, 5, 4, 3]
```

There is no profit because prices keep decreasing.

Answer:

```text
0
```

---

## Revision Point

### Think:

> **"What is the cheapest price I have seen before today?"**

Then:

```text
Today's price - cheapest price = today's possible profit
```

Keep the maximum of those profits.

---

## File

[`BestTimeToBuyAndSell.java`](./BestTimeToBuyAndSell.java)

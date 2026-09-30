# LeetCode #242 — Valid Anagram

## 🧩 Problem

Given two strings `s` and `t`, determine whether `t` is an anagram of `s`.

Two strings are anagrams if they contain the **same characters with the same frequencies**, regardless of order.

### Example

```text
s = "anagram"
t = "nagaram"

Output: true
```

```text
s = "rat"
t = "car"

Output: false
```

---

## Key Idea

The **order does not matter**.
Only the **frequency of each character** matters.

We use a `HashMap<Character, Integer>` to store:

```text
character → frequency
```

### Approach

1. If lengths are different → `false`
2. Count every character in `s`
3. Traverse `t`:

   * If character is not present in the map → `false`
   * Decrease its frequency
   * If frequency becomes negative → `false`
4. If everything matches → `true`

---

## Important HashMap Pattern

### Count frequency

```java
map.put(ch, map.getOrDefault(ch, 0) + 1);
```

Think:

```text
GET old count → +1 → PUT new count
```

`getOrDefault()` **does not insert** anything.

`put()`:

* creates a key if it doesn't exist
* updates the value if the key already exists

Example:

```java
map.put('a', 1);   // {a=1}
map.put('a', 2);   // {a=2}
```

A `HashMap` cannot have duplicate keys.

### Decrease frequency

```java
map.put(ch, map.get(ch) - 1);
```

Think:

```text
GET old count → -1 → PUT new count
```

---

## Pattern to Remember

**Frequency Map**

```text
String → HashMap<Character, Integer>
        → count characters
        → compare/decrease counts
```

This pattern is useful for many problems involving:

* Anagrams
* Character frequencies
* Duplicate/count checking
* Frequency comparison

---

## Common Mistakes

* Checking only whether characters exist — **frequency also matters**
* Forgetting the length check
* Thinking `put()` always creates a new key
* Forgetting to check `containsKey()` while processing the second string
* Allowing a frequency to become negative

---

## ⏱️ Complexity

* **Time:** `O(n)`
* **Space:** `O(k)`

Where:

* `n` = length of the string
* `k` = number of distinct characters

---

## Quick Revision

> **Valid Anagram = Same characters + Same frequencies**

```text
Count s
   ↓
Process t
   ↓
Decrease counts
   ↓
Missing / negative → false
   ↓
Otherwise → true
```

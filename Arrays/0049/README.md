# LeetCode #49 — Group Anagrams

## 🧩 Problem

Given an array of strings, group the strings that are anagrams of each other.

### Example

```text
Input:
["eat", "tea", "tan", "ate", "nat", "bat"]

Output:
[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```

The order of the groups does not matter.

---

## 💡 Key Idea

Anagrams contain the **same characters with the same frequencies**.

Instead of comparing every pair of words, create a common **key** for anagrams by sorting their characters.

```text
eat → aet
tea → aet
ate → aet

tan → ant
nat → ant

bat → abt
```

Therefore:

```text
sorted word → group of original words
```

---

## 🔑 HashMap Pattern

Use:

```java
HashMap<String, ArrayList<String>> map
```

The map stores:

```text
key → list of anagram words
```

Example:

```text
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

---

## 🧠 Core Code Pattern

### 1. Create the key

```java
char[] arr = word.toCharArray();
Arrays.sort(arr);
String key = new String(arr);
```

Think:

```text
Word → Characters → Sort → String Key
```

### 2. Get existing group or create a new one

```java
ArrayList<String> values =
    map.getOrDefault(key, new ArrayList<>());
```

### 3. Add the original word

```java
values.add(word);
```

### 4. Put the updated list back

```java
map.put(key, values);
```

Remember:

> **GET → MODIFY → PUT**

---

## 🔗 Connection With #242

Both problems use frequency/grouping ideas with `HashMap`.

### #242 — Valid Anagram

```text
Character → Count
```

### #49 — Group Anagrams

```text
Sorted String → List of Words
```

---

## ⚠️ Common Mistakes

* Using the original word as the key instead of the sorted version
* Forgetting to sort the characters
* Adding the sorted word instead of the original word
* Forgetting that multiple words can have the same key
* Comparing every pair unnecessarily

---

## ⏱️ Complexity

Let:

* `n` = number of strings
* `k` = average length of a string

Sorting each string takes `O(k log k)`.

### Time

```text
O(n × k log k)
```

### Space

```text
O(n × k)
```

for storing the keys and grouped strings.

---

## 📌 Quick Revision

> **Group Anagrams = Sort each word → use sorted word as HashMap key → add original word to that group.**

```text
"eat"
  ↓
"aet"
  ↓
HashMap["aet"]
  ↓
add "eat"
```

Main pattern:

```text
SORT → KEY → GET → ADD → PUT
```

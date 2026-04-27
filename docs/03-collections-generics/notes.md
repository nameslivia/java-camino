# 03 - Collections & Generics

> Quick Cheat Notes · Come Back Anytime

---

## 1. Collections 框架概覽

```
java.util.Collection
├── List（有序、可重複）
│   ├── ArrayList
│   └── LinkedList
├── Set（無序、不可重複）
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet（排序）
└── Queue
    └── LinkedList、PriorityQueue

java.util.Map（key-value，key 不重複）
├── HashMap
├── LinkedHashMap（插入順序）
└── TreeMap（key 排序）
```

---

## 2. List

### ArrayList

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.add("Go");

System.out.println(list.get(0));   // Java
System.out.println(list.size());   // 3

list.remove("Python");             // 移除元素
list.remove(0);                    // 移除 index

// 遍歷
for (String s : list) {
    System.out.println(s);
}

// 判斷是否包含
list.contains("Go");               // true
```

**常用方法**

| 方法 | 說明                     |
|------|------------------------|
| `add(e)` | 新增元素                   |
| `add(i, e)` | 在 index i 插入元素 e       |
| `get(i)` | 取得 index i 元素          |
| `set(i, e)` | 修改 index i 元素          |
| `remove(i)` | 移除 index i             |
| `remove(obj)` | 移除第一個符合的元素             |
| `size()` | 元素數量                   |
| `contains(obj)` | 是否包含                   |
| `indexOf(obj)` | 找到的第一個 index（找不到回傳 -1） |
| `isEmpty()` | 是否為空                   |
| `clear()` | 清空                     |

### ArrayList vs LinkedList

| | ArrayList | LinkedList |
|---|-----------|------------|
| 底層結構 | 動態陣列 | 雙向鏈結串列 |
| 隨機存取（get）| ✅ 快 O(1) | ❌ 慢 O(n) |
| 插入/刪除（中間）| ❌ 慢 O(n) | ✅ 快 O(1) |
| 一般情境 | 優先選擇 | 頻繁插入/刪除中間時 |

---

## 3. Set

```java
import java.util.HashSet;
import java.util.Set;

Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");   // 重複，不會加入

System.out.println(set.size());         // 2
System.out.println(set.contains("Banana")); // true
```

### HashSet vs LinkedHashSet vs TreeSet

| | HashSet | LinkedHashSet | TreeSet |
|---|---------|---------------|---------|
| 順序 | 無順序 | 插入順序 | 自然排序 |
| 效能 | 最快 | 稍慢 | 最慢（排序成本）|
| 適用 | 只需判斷有沒有 | 需保留插入順序 | 需要排序結果 |

---

## 4. Map

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 90);
scores.put("Bob", 85);
scores.put("Alice", 95);  // 相同 key，覆蓋舊值

System.out.println(scores.get("Alice"));       // 95
System.out.println(scores.getOrDefault("Carol", 0)); // 0

// 遍歷 key
for (String key : scores.keySet()) {
    System.out.println(key + " -> " + scores.get(key));
}

// 遍歷 entry（推薦）
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

**常用方法**

| 方法 | 說明 |
|------|------|
| `put(k, v)` | 新增或更新 |
| `get(k)` | 取得值（不存在回傳 null）|
| `getOrDefault(k, d)` | 取得值，不存在回傳預設值 |
| `remove(k)` | 移除 |
| `containsKey(k)` | 是否有此 key |
| `containsValue(v)` | 是否有此 value |
| `keySet()` | 所有 key 的 Set |
| `values()` | 所有 value 的 Collection |
| `entrySet()` | 所有 key-value pair |
| `size()` | 元素數量 |

---

## 5. Collections 工具類別

```java
import java.util.Collections;

List<Integer> nums = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9));

Collections.sort(nums);               // 升冪排序
Collections.reverse(nums);           // 反轉
Collections.shuffle(nums);           // 隨機打亂
Collections.max(nums);               // 最大值
Collections.min(nums);               // 最小值
Collections.frequency(nums, 1);      // 值為 1 的個數
```

---

## 6. Generics 泛型

### 為什麼需要泛型？

```java
// 沒有泛型 → 只能用 Object → 需要強制轉型 → 執行時才發現錯誤
List list = new ArrayList();
list.add("Hello");
String s = (String) list.get(0);  // 麻煩，且不安全

// 有泛型 → 編譯期就能抓錯
List<String> list = new ArrayList<>();
list.add("Hello");
String s = list.get(0);           // 直接拿，型別安全
```

### 泛型 Class

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// 使用
Box<String> strBox = new Box<>("Hello");
Box<Integer> intBox = new Box<>(42);

System.out.println(strBox.getValue()); // Hello
System.out.println(intBox.getValue()); // 42
```

### 泛型 Method

```java
public static <T> void printArray(T[] arr) {
    for (T item : arr) {
        System.out.print(item + " ");
    }
    System.out.println();
}

// 使用
Integer[] nums = {1, 2, 3};
String[] words = {"a", "b", "c"};
printArray(nums);   // 1 2 3
printArray(words);  // a b c
```

### Wildcard（? 萬用字元）

```java
// ? 表示「不知道是什麼型別」
public static void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// 上界 wildcard：? extends T（T 或 T 的子類別）
public static double sumList(List<? extends Number> list) {
    double sum = 0;
    for (Number n : list) sum += n.doubleValue();
    return sum;
}

// 下界 wildcard：? super T（T 或 T 的父類別）
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}
```

### 常見泛型符號慣例

| 符號 | 慣用意義 |
|------|---------|
| `T` | Type，任意型別 |
| `E` | Element，集合元素 |
| `K` | Key，Map 的 key |
| `V` | Value，Map 的 value |
| `N` | Number，數字型別 |

---

## 7. 常見面試考點 / 注意事項

- `ArrayList` 底層是陣列，擴容時會複製整個陣列（容量 × 1.5）
- `HashMap` 底層是陣列 + 鏈結串列（Java 8 後鏈長 > 8 會轉成紅黑樹）
- `HashMap` key 可以是 null（最多一個）；`HashTable` key 不能是 null
- `HashMap` 非執行緒安全；多執行緒用 `ConcurrentHashMap`
- 泛型在編譯後會做 **型別抹除（Type Erasure）**，執行期沒有泛型資訊
- 泛型不支援基本型別（`int`、`double` 等），要用包裝類（`Integer`、`Double`）

---

## 8. Practice List

- [ ] 建立一個 `ArrayList<String>`，加入 5 個城市名稱，排序後印出
- [ ] 用 `HashMap` 統計一段字串中每個字元出現幾次
- [ ] 寫一個泛型方法 `findMax(List<T> list)`，回傳 List 中最大的元素（T extends Comparable）
- [ ] 用 `HashSet` 找出兩個 List 的交集（intersection）
- [ ] 比較 `HashMap` 和 `TreeMap` 遍歷時的順序差異

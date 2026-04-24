# 01 - Java 基礎語法

> Quick Cheat Notes · Come Back Anytime

---

## 1. Hello World & 程式結構

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Camino!");
    }
}
```

- 每個 Java 程式至少有一個 **class**
- 執行入口是 `public static void main(String[] args)`
- 檔案名稱必須與 class 名稱相同（`HelloWorld.java`）

---

## 2. 變數與資料型別

### 基本型別（Primitive Types）

| 型別 | 大小 | 範例                               |
|------|------|----------------------------------|
| `int` | 32-bit | `int age = 25;`                  |
| `long` | 64-bit | `long population = 8000000000L;` |
| `double` | 64-bit | `double price = 9.99;`           |
| `float` | 32-bit | `float temp = 36.5f;`            |
| `boolean` | - | `boolean isJavaFun = true;`      |
| `char` | 16-bit | `char grade = 'A';`              |
| `byte` | 8-bit | `byte level = 10;`               |
| `short` | 16-bit | `short year = 2026;`             |

### 參考型別（Reference Types）

```java
String name = "Jay";       // 字串
int[] scores = {90, 85, 92};  // 陣列
```

### `var`（Java 10+）

```java
var message = "Hello";  // 自動推斷型別為 String
var count = 42;         // 自動推斷型別為 int
```

---

## 3. 運算子

```java
// 算術
int a = 10 + 3;   // 13
int b = 10 % 3;   // 1（取餘數）
int c = 10 / 3;   // 3（整數除法，無小數）

// 比較
boolean result = (5 > 3);   // true
boolean eq = (5 == 5);      // true
boolean ne = (5 != 3);      // true

// 邏輯
boolean and = (true && false);  // false
boolean or  = (true || false);  // true
boolean not = !true;            // false

// 字串串接
String s = "Hello" + ", " + "World";  // "Hello, World"
```

---

## 4. 流程控制

### if / else if / else

```java
int score = 85;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

### switch

```java
String day = "MON";
String type = switch (day) {
    case "MON", "TUE", "WED", "THU", "FRI" -> "平日";
    case "SAT", "SUN" -> "假日";
    default -> "未知";
};
```

### 三元運算子

```java
int max = (a > b) ? a : b;
```

---

## 5. 迴圈

```java
// for 迴圈
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while 迴圈
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// for-each（用於陣列或集合）
int[] nums = {1, 2, 3, 4, 5};
for (int n : nums) {
    System.out.println(n);
}

// break / continue
for (int j = 0; j < 10; j++) {
    if (j == 5) break;     // 跳出迴圈
    if (j % 2 == 0) continue; // 跳過這次，繼續下一圈
    System.out.println(j);
}
```

---

## 6. 陣列（Array）

```java
// 宣告與初始化
int[] arr = new int[5];          // 預設值為 0
int[] arr2 = {10, 20, 30, 40};  // 直接給值

// 存取
System.out.println(arr2[0]);    // 10
System.out.println(arr2.length); // 4

// 二維陣列
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
System.out.println(matrix[1][2]); // 6
```

---

## 7. 方法（Method）

```java
// 定義方法
public static int add(int a, int b) {
    return a + b;
}

// 呼叫方法
int result = add(3, 4); // 7

// void 方法（沒有回傳值）
public static void greet(String name) {
    System.out.println("Hi, " + name + "!");
}

// 方法重載（Overloading）
public static double add(double a, double b) {
    return a + b;
}
```

---

## 8. String 常用方法

```java
String s = "Hello, Java!";

s.length();           // 12
s.toUpperCase();      // "HELLO, JAVA!"
s.toLowerCase();      // "hello, java!"
s.contains("Java");   // true
s.replace("Java", "Alpha"); // "Hello, Alpha!"
s.substring(7);       // "Java!"
s.substring(7, 11);   // "Java"
s.trim();             // 去除前後空白
s.split(", ");        // ["Hello", "Java!"]
s.charAt(0);          // 'H'
s.equals("Hello");    // false（比較內容，不用 ==）
String.valueOf(123);  // "123"（數字轉字串）
```

---

## Practice List

- [ ] 印出 1 到 100 中所有的奇數
- [ ] 寫一個方法，輸入兩個數字，回傳較大的那個
- [ ] 寫一個方法，判斷一個數字是否為質數
- [ ] 用二維陣列建立一個 3x3 的乘法表
- [ ] 寫一個方法，反轉一個字串（不用內建 reverse）

---

*上一章：（無）　｜　下一章：[02 - OOP 物件導向](../02-oop/notes.md)*

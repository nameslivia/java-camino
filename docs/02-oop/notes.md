# 02 - OOP 物件導向

> Quick Cheat Notes · Come Back Anytime

---

## 1. Class & Object 基礎

```java
// 定義一個 Class
public class Dog {
    // 欄位（Field / Instance Variable）
    String name;
    int age;

    // 方法（Method）
    public void bark() {
        System.out.println(name + " says: Woof!");
    }
}

// 建立物件（Object）
Dog myDog = new Dog();
myDog.name = "Alpha";
myDog.age = 3;
myDog.bark(); // Alpha says: Woof!
```

- **Class** = 藍圖（設計圖）
- **Object** = 根據藍圖建出的實體
- 用 `new` 關鍵字建立物件

---

## 2. 建構子（Constructor）

```java
public class Dog {
    String name;
    int age;

    // 無參數建構子（No-arg Constructor）
    public Dog() {
        this.name = "Unknown";
        this.age = 0;
    }

    // 有參數建構子
    public Dog(String name, int age) {
        this.name = name;  // this 指向「當前物件」
        this.age = age;
    }
}

// 使用
Dog d1 = new Dog();              // name=Unknown, age=0
Dog d2 = new Dog("Max", 5);     // name=Max, age=5
```

- 建構子名稱必須與 Class 相同
- 沒有回傳型別（連 void 都不寫）
- 若沒有自訂，Java 會給一個預設的無參數建構子
- `this` 用來區分「欄位」與「參數」同名的情況

---

## 3. 封裝（Encapsulation）& Access Modifier

```java
public class BankAccount {
    private double balance;  // 私有，外部無法直接存取

    public double getBalance() {       // Getter
        return balance;
    }

    public void deposit(double amount) { // Setter 概念（帶有驗證邏輯）
        if (amount > 0) {
            balance += amount;
        }
    }
}

BankAccount acc = new BankAccount();
acc.deposit(1000);
System.out.println(acc.getBalance()); // 1000.0
// acc.balance = -999;  // ❌ 編譯錯誤，private 無法直接存取
```

| 修飾詞 | 同 Class | 同 Package | 子類別 | 其他 |
|--------|---------|-----------|--------|------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| （無）default | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

> 原則：欄位盡量用 `private`，透過 getter / setter 存取。

---

## 4. 繼承（Inheritance）

```java
// 父類別（Parent / Superclass）
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

// 子類別（Child / Subclass）用 extends 繼承
public class Cat extends Animal {
    String breed;

    public Cat(String name, String breed) {
        super(name);  // 呼叫父類別建構子
        this.breed = breed;
    }

    public void meow() {
        System.out.println(name + " says: Meow~");
    }
}

Cat c = new Cat("Nabi", "Scottish Fold");
c.eat();   // 繼承自 Animal
c.meow();  // Cat 自己的方法
```

- `extends` 讓子類別繼承父類別的欄位與方法
- `super(...)` 呼叫父類別的建構子，**必須放在子類別建構子的第一行**
- Java 只支援**單一繼承**（一個 class 只能 extends 一個 class）

---

## 5. 方法覆寫（Override）& `@Override`

```java
public class Animal {
    public void makeSound() {
        System.out.println("...");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {  // 覆寫父類別的方法
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow~");
    }
}
```

- `@Override` 是 annotation，讓編譯器幫你確認這個方法真的有在父類別存在
- Override 規則：方法名稱、參數型別與數量必須相同；回傳型別相容；不能縮小 access modifier

---

## 6. 多型（Polymorphism）

```java
Animal a1 = new Dog("Buddy");  // 父類別型別，存子類別物件
Animal a2 = new Cat("Nabi");

a1.makeSound(); // Woof!  → 執行 Dog 的版本
a2.makeSound(); // Meow~  → 執行 Cat 的版本

// 放進陣列統一處理
Animal[] animals = { new Dog("Rex"), new Cat("Luna"), new Dog("Milo") };
for (Animal a : animals) {
    a.makeSound();  // 各自執行自己的實作
}
```

- 同一個介面呼叫，根據實際物件型別執行不同行為
- **編譯期**看的是「宣告型別」（Animal）；**執行期**看的是「實際型別」（Dog / Cat）
- 這叫 **動態分派（Dynamic Dispatch）**

---

## 7. 抽象類別（Abstract Class）

```java
public abstract class Shape {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    // 抽象方法：只宣告，不實作，子類別必須 Override
    public abstract double area();

    // 一般方法：可以有實作
    public void describe() {
        System.out.println("This is a " + color + " shape with area: " + area());
    }
}

public class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Shape s = new Shape("red");  // ❌ 抽象類別不能直接 new
Shape s = new Circle("blue", 5.0);
s.describe(); // This is a blue shape with area: 78.53...
```

- 有 `abstract` 關鍵字的方法 = 強制子類別實作
- 有任何 abstract 方法 → class 必須宣告為 `abstract`
- **抽象類別不能被 new**，只能透過子類別使用

---

## 8. 介面（Interface）

```java
// 定義介面：所有方法預設 public abstract
public interface Flyable {
    void fly();           // 預設 public abstract
    double MAX_HEIGHT = 10000; // 預設 public static final
}

public interface Swimmable {
    void swim();
}

// 一個 class 可以 implements 多個介面
public class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying!");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming!");
    }
}
```

- `interface` 定義「能做什麼」的規範（合約）
- `implements` 實作介面，可以同時實作多個
- Java 8 起介面可以有 `default` 方法（有實作的方法）

```java
public interface Greeting {
    default void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
```

---

## 9. Abstract Class vs Interface

| 比較項目 | Abstract Class | Interface |
|---------|---------------|-----------|
| 關鍵字 | `abstract class` | `interface` |
| 繼承/實作 | `extends`（單一） | `implements`（多個） |
| 欄位 | 可有各種欄位 | 只能有常數（`public static final`） |
| 建構子 | 有 | 沒有 |
| 方法 | 可混合 abstract 與一般方法 | 預設 abstract；Java 8+ 可有 `default` |
| 使用時機 | 共享程式碼 + 強制實作 | 定義規範、跨繼承樹共享行為 |

> 口訣：**Abstract Class = 是什麼（is-a）**，**Interface = 能做什麼（can-do）**

---

## 10. `instanceof` 與型別轉型（Casting）

```java
Animal a = new Dog("Rex");

// 向上轉型（Upcasting）：自動，安全
Animal a2 = new Dog("Max");  // Dog → Animal，OK

// 向下轉型（Downcasting）：手動，需檢查
if (a instanceof Dog) {
    Dog d = (Dog) a;   // 強制轉型
    d.bark();
}

// Java 16+ 的 Pattern Matching（更簡潔）
if (a instanceof Dog d) {
    d.bark();  // 自動轉型，直接用 d
}
```

---

## 11. `static` 關鍵字

```java
public class Counter {
    private static int count = 0;  // 類別變數（所有物件共享）
    private int id;

    public Counter() {
        count++;
        this.id = count;
    }

    public static int getCount() {  // 靜態方法：不需要物件就能呼叫
        return count;
    }
}

Counter c1 = new Counter();
Counter c2 = new Counter();
System.out.println(Counter.getCount()); // 2（用類別名稱呼叫）
```

- `static` 欄位：所有物件共享同一份資料
- `static` 方法：不需要 instance，直接用 `ClassName.method()` 呼叫
- `static` 方法裡**不能使用** `this` 或存取非 static 欄位

---

## 12. `final` 關鍵字

```java
final int MAX = 100;         // 常數，不可重新賦值
final class Singleton { }    // 不可被繼承
public final void lock() { } // 子類別不可 Override 此方法
```

---

## Practice List

- [ ] 建立 `Animal`、`Dog`、`Cat` 類別，Dog 和 Cat 各自 override `makeSound()`
- [ ] 建立 `Shape`（abstract）、`Circle`、`Rectangle`，實作 `area()` 和 `perimeter()`
- [ ] 建立 `Flyable` 和 `Swimmable` 介面，讓 `Duck` 同時實作兩者
- [ ] 建立 `BankAccount`，用 private 封裝 balance，實作存款、提款（餘額不足印出警告）
- [ ] 把 Animal 物件放進陣列，用多型統一呼叫 `makeSound()`

---

*上一章：[01 - 基礎語法](../01-basics/notes.md)　｜　下一章：[03 - Collections & Generics](../03-collections-generics/notes.md)*
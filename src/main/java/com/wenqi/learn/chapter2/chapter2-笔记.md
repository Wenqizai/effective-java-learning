## Item 1-静态工厂

静态工厂，提供方法接受一个参数并返回对应的实例。

- 单例

```java
public class SingletonClass {

  private static volatile SingletonClass instance = null;

  private SingletonClass() {
  }

  public static SingletonClass getInstance() {
    if (instance == null) {
      synchronized (SingletonClass.class) {
        if (instance == null) {
          instance = new SingletonClass();
        }
      }
    }
    return instance;
  }
}

```

- 基于反射实现静态工厂

```java
public class Factory {

    private Factory() {}

    public static Factory getInstance(String type) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName("com.wenqi.learn.chapter" + type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
```

使用静态工厂的好处: 

1. 不用重复创建实例，对外提供一个getInstance()
2. 隐藏类对象创建的API和创建的细节

## Item 6-避免创建不必要的对象

- 避免创建不必要的对象，保持对象的复用
- 避免不必要的自动装箱和拆箱操作

1. map调用`keySet()`方法每次都会创建一个新的实例Set，因此范围Map的key与value时，可以调用`entrySet()`方法，避免每次都创建新的实例。

## Item 7-内存泄漏（对象仍引用对象）

- 数组元素：获取元素后未赋null值
- 缓存
- 监听器和回调

## Item 8 - 避免使用终结器和清除器

不要被 `System.gc` 和 `System.runFinalization` 的方法所诱惑。它们可能会增加终结器或清除器被运行的几率，但它们不能保证一定运行。

> 使用**终结器和清除器会严重影响性能。**在我的机器上，创建一个简单的 `AutoCloseable` 对象，使用 `try-with-resources` 关闭它以及让垃圾收集器回收它的时间大约是 12ns。相反，使用终结器将时间增加到 550ns。换句话说，使用终结器创建和销毁对象大约要慢 50 倍。这主要是因为**终结器抑制了有效的垃圾收集**。如果使用清除器清除的所有实例（在我的机器上每个实例大约 500ns），那么清除器的速度与终结器相当，但是如果只将它们作为安全网来使用，清除器的速度要快得多，如下所述。在这种情况下，在我的机器上创建、清理和销毁一个对象需要花费 66ns 的时间，这意味着如果你不使用它，你需要多出五倍（而不是五十倍）的保障成本。

## Item 9 - 关闭资源

在使用必须关闭的资源时，**总是优先使用 `try-with-resources`，而不是 `try-finally`**。前者的代码更短、更清晰，生成的异常更有用（不会覆盖异常）。使用 try-with-resources 语句可以很容易地为必须关闭的资源编写正确的代码，而使用 try-finally 几乎是不可能的。










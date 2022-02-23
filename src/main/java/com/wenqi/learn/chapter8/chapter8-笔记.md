## item52 - 重载

- 避免使用相同数量参数的重载方法
- 考虑经过类型转换后，传递给不同的重载方法
- 考虑对现有接口进行改造，避免使用相同参数的重载方法

## item53 - 可变参

==注意：每次调用可变参数方法都会导致数组分配和初始化，如果该性能是负担不起的，可考虑多参数重载的方式，放弃使用可变参。(`EnumSet`就是采用这种方式来满足高性能的要求。)==

```java
public void foo() { }
public void foo(int a1) { }
public void foo(int a1, int a2) { }
public void foo(int a1, int a2, int a3) { }
public void foo(int a1, int a2, int a3, int... rest) { }
```

总之，当你需要定义具有不确定数量参数的方法时，可变参数是非常有用的。在可变参数之前加上任何必需的参数，并注意使用可变参数可能会引发的性能后果。
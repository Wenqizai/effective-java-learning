# 泛型

## item26

1. 永远不要使用原生类型，考虑使用泛型；
2. `Set<Object>` 是一个参数化类型，表示可以包含任何类型的对象的集合，`Set<?>` 是一个通配符类型，表示只能包含某种未知类型的对象的集合

> List 与 List<Object>的区别

- `List` 不使用泛型系统，`List<Object>`明确地告诉编译器它能够保存任何类型的对象；
- `List<String>` 传递给 `List` 类型的参数，但不能将其传递给类型 `List<Object>` 的参数；
- `List<String>` 是原始类型 `List` 的子类型，而不是参数化类型 `List<Object>` 的子类型

## item28

**List优于数组**

- 数组放入不相容的类型可以编译成功，但运行时失败；不相容类型放入List中会编译失败。

- 数组是具体化的，`String` 元素放入一个 `Long` 类型的数组中，就会抛出 异常`ArrayStoreException`；而添加泛型的`List`只在编译时执行类型约束，并在运行时丢弃（或擦除）元素类型信息。擦除允许泛型与不使用泛型的遗留代码自由交互操作，确保在 Java 5 中平稳地过渡。

- 数组运行时类型安全，而不是编译时类型安全；`List`与之相反。
- 数组与泛型不能很好混合，混合在一起并得到编译时错误或警告，那么你的第一个反应该是将数组替换为 `List`。

## item31

<u>**里氏替换原则: 派生类（子类）对象可以在程序中代替其基类（超类）对象。**</u>

`List<Object>`可以放入任何对象 ， `List<String>`只能放入字符串。故`List<String>` 不能做 `List<Object>` 能做的所有事情，所以 `List<String>`不是`List<Object>`子类型。（由里氏替换原则可以理解这点）

>  PECS 表示生产者应使用extends，消费者应使用super。

如果参数化类型表示 T 生成器，则使用 `<? extends T>`；如果它表示一个 T 消费者，则使用 `<? super T>`。在我们的 Stack 示例中，pushAll 的 src 参数生成 E 的实例供 Stack 使用，因此 src 的适当类型是 `Iterable<? extends E>`；popAll 的 dst 参数使用 Stack 中的 E 实例，因此适合 dst 的类型是 `Collection<? super E>`。PECS 助记符捕获了指导通配符类型使用的基本原则。Naftalin 和 Wadler 称之为 Get and Put 原则






















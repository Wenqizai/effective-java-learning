## Item 10 - equals

equals三原则：

- 反身性：x != null，`x.equals(x) = true`；
- 对称性：x,y != null，如果`x.equals(y) = true`，那么 `y.equals(x) = true`；
- 传递性：x,y,z != null, 如果`x.equals(y) = true` 、`y.equals(z) = true`，那么`x.equals(z) = true`； 
- 一致性：即相等的对象始终是相等的，而不等的对象始终是不等的；
- 非无效性：  `o.equals(null)`永远都返回false。

## Item 12 - toString

- 建议所有子类重写toString()方法
- 《Java开发手册》：日志打印时禁止直接用 JSON 工具将对象转换成 String。应当使用toString()方法来打印对象相关属性。

> 如果**对象里某些 get 方法被覆写**，存在**抛出异常**的情况，则可能会因为打印日志而影响正常业务流程的执行。

## Item 13 - clone

原则：

- `x.clone() != x`
- `x.clone().getClass() == x.getClass()` 返回true
- `x.clone().equals(x)` 返回true，注意：成立的前提是重写了`equals()`方法

注意：

- **不可变**（final）的类永远不要提供clone()方法
- 父类实现的clone()，必须考虑有没进行**深拷贝**的问题

## Item 14 - compare to

原则：

`sgn(expression)` 表示数学中的符号函数，它被定义为：根据传入表达式的值是负数、零或正数，对应返回 -1、0 或 1。

- 相反性：如果`sgn(x.compareTo(y)) == -sgn(y.compareTo(x))`则（`x.compareTo(y)` 当且仅当 `y.compareTo(x)` 抛出异常时才抛出异常）。
- 传递性：如果`(x.compareTo(y) > 0 && y.compareTo(z) > 0)` 则 `x.compareTo(z) > 0`。
-  `x.compareTo(y) == 0` 时，所有的 z 满足 `sgn(x.compareTo(z)) == sgn(y.compareTo(z))`

注意：

1. 论何时实现具有排序性质的值类，都应该让类实现 Comparable 接口；
2. 在 compareTo 方法的实现中比较字段值时，避免使用 < 和 > 操作符，应使用包装类中的静态比较方法或 Comparator 接口中的 comparator 构造方法








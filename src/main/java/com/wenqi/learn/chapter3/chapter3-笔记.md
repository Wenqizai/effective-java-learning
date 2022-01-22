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

## Item13 - clone

原则：

- `x.clone() != x`
- `x.clone().getClass() == x.getClass()` 返回true
- `x.clone().equals(x)` 返回true

- 不可变的类永远不要提供clone()方法










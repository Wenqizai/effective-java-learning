## Item 10 - equals

equals三原则：

- 反身性：x != null，`x.equals(x) = true`；
- 对称性：x,y != null，如果`x.equals(y) = true`，那么 `y.equals(x) = true`；
- 传递性：x,y,z != null, 如果`x.equals(y) = true` 、`y.equals(z) = true`，那么`x.equals(z) = true`； 
- 一致性：即相等的对象始终是相等的，而不等的对象始终是不等的；
- 非无效性：  `o.equals(null)`永远都返回false。
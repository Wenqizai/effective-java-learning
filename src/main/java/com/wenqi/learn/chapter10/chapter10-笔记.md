## Exception

1. 如果期望调用者能够适当地恢复，使用checked受检异常（程序没问题，但还是获取错误，如`IOException`）
2. 编程错误抛出unchecked 非受检/运行时异常
3. 不要定义任何既不是 checked 异常也不是运行时异常的自定义异常
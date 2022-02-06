package com.wenqi.learn.chapter4.item24;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Typical use of a nonstatic member class
 * 非静态成员类的典型用法
 * @author liangwenqi
 * @date 2022/2/6
 */
public class MySet<E> extends AbstractSet<E> {


    // Bulk of the class omitted

    @Override
    public int size() {
        return 0;
    }

    /**
     * 封装一个方法来访问非静态内部类(good的选择)
     *
     * 如果使用 `enclosingInstance.new MemberClass(args)` 来实例化非静态内部类是可以的。
     * 但是这种实例化方式, 关联占用了非静态成员类实例中的空间，并为其构造增加了时间。
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    /**
     * 如果声明的成员类不需要访问外部的实例，那么应始终在声明中添加 static 修饰符，使其成为静态的而不是非静态的成员类。
     * 如果省略这个修饰符，每个实例都有一个隐藏的对其外部实例的额外引用。如前所述，存储此引用需要时间和空间。
     */
    private class MyIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}

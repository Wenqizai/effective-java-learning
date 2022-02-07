package com.wenqi.learn.chapter5.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *  A first cut at making Chooser generic - won't compile
 *
 *  使选择器通用的第一步
 *
 * @author liangwenqi
 * @date 2022/2/7
 */
public class ChooserGeneric<T> {
    private final T[] choiceArray;

    public ChooserGeneric(Collection<T> choices) {
        // 不会编译成功
        //choiceArray = choices.toArray();

        // 这里会有强转警告, Object[] to T[]
        // 消除警告可考虑使用List来实现
        // 注: Collection.toArray()返回Object[]
        choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

}

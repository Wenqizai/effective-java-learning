package com.wenqi.learn.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public class ChooserGenericGood<T> {
    private final List<T> choiceList;

    public ChooserGenericGood(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

}

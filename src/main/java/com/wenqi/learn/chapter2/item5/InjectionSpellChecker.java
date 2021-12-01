package com.wenqi.learn.chapter2.item5;

import java.util.List;
import java.util.Objects;

/**
 * 在实际应用中，每种语言都有自己的字典，特殊的字典用于特殊的词汇表。
 * 静态实用工具类和单例不适用于由底层资源参数化的类。
 *
 * @author Wenqi Liang
 * @date 2021/12/1
 */
public class InjectionSpellChecker {
    private final Lexicon dictionary;

    /**
     * 依赖注入的方式, 将大大增强类的灵活性、可复用性和可测试性。
     * @param dictionary
     */
    public InjectionSpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return null;
    }

}

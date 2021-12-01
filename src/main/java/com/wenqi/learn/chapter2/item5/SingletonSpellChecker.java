package com.wenqi.learn.chapter2.item5;

import java.util.List;

/**
 * 单例模式: 拼写检查程序
 *
 * @author Wenqi Liang
 * @date 2021/12/1
 */
public class SingletonSpellChecker {
    private final Lexicon dictionary = new Lexicon();

    private SingletonSpellChecker() {
    }

    // 难以扩展, 实际情况中不止使用一个字典
    public static SingletonSpellChecker INSTANCE = new SingletonSpellChecker();

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}

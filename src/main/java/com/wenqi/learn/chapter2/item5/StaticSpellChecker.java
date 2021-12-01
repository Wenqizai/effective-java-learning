package com.wenqi.learn.chapter2.item5;

import java.util.List;

/**
 * 静态工具类: 拼写检查程序
 * @author Wenqi Liang
 * @date 2021/12/1
 */
public class StaticSpellChecker {
    // Inappropriate use of static utility - inflexible & untestable!
    // 难以扩展, 实际情况中不止使用一个字典
    private static final Lexicon dictionary = new Lexicon();

    // Noninstantiable
    private StaticSpellChecker() {
    }

    public static boolean isValid(String word){return true;}

    public static List<String> suggestions(String typo){return null;}
}

class Lexicon {

}

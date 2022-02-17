package com.wenqi.learn.chapter7.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * @author liangwenqi
 * @date 2022/2/17
 */
public class Primes {
    public static void main(String[] args) {
        primes().map(p -> BigInteger.ONE.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.ONE, BigInteger::nextProbablePrime);
    }


}

package com.czz.jdk8.function.optional;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 14:01
 */
@FunctionalInterface
public interface GenericsFunction<T> {
    public T getValue(T t);
}

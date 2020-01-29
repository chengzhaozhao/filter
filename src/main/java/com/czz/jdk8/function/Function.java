package com.czz.jdk8.function;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 13:58
 * 函数式接口
 * 只包含一个抽象方法的接口，称为函数式接口。
 *  你可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda
 * 表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方
 * 法上进行声明）。
 *  我们可以在任意函数式接口上使用 @FunctionalInterface 注解，
 * 这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包
 * 含一条声明，说明这个接口是一个函数式接口
 *
 *
 * 四大函数式接口
 * 1.消费性
 * Consumer<T>
 *  void accept(T t)
 *  BiConsumer<T, U>
 *      void accept(T t, U u)
 *
 *
 * 2.供给型接口
 * Supplier<T>
 *   T get();
 * 3.函数型接口
 * Function<T, R>
 *   R apply(T t);
 *      BiFunction<T, U, R>
 *       R apply(T t, U u);
 *      UnaryOperator<T>
 *          T apply(T t);
 *       BinaryOperator<T>
 *           T apply(T t1, T t2);
 *
 * 4.断定型接口
 * Predicate<T>
 *   boolean test(T t);
 *
 */
public class Function {
    public static void main(String[] args) {

    }
}

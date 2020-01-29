package com.czz.jdk8.Lambda;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 2:04
 */
public class Lamada {
    public static void main(String[] args) {
        // 匿名内部类 λ表达式 是基于
        Runnable runnable = new Runnable () {
            @Override
            public void run() {
                System.out.println ("匿名内部类");
            }
        };


        Runnable run = ()-> System.out.println ("匿名内部类");



        // 匿名内部类做为参数传递

        TreeSet<String> ts = new TreeSet<> (new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare (o1.length (),o2.length ());
            }
        });


        TreeSet<String> ts2 = new TreeSet<> (
                (o1,o2) ->  Integer.compare (o1.length (),o2.length ())
        );



        // lambda 表达式语法
        //1. 无参数
        Runnable r = ()->System.out.println ("");
        //2. 一个参数
        Consumer<String> consumer = (x)->System.out.println (x);
        //3.只有一个参数时 参数的() 可以省略
        Consumer<String> consume2 = x->System.out.println (x);
        //4.需要有两个参数并且需要返回值
        BinaryOperator<Long> bo = (Long x,Long y)->{
            System.out.println ("实现接口函数的方法");
            return x+y;
        };
        //5.只有一条语句时大括号可以省略
        BinaryOperator<Long> bo2 = (x,y)-> x+y;
        //6.类型推断
        BinaryOperator<Long> bo3 = ( x, y)->{
            System.out.println ("实现接口函数的方法");
            return x+y;
        };


    }
}

package com.czz.jdk8.function.handler;

import com.czz.jdk8.function.optional.GenericsFunction;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 14:03
 */
public class FunctionHandler {

    /**
     * 1 作为参数传递
     * 作为参数传递 Lambda 表达式：为了将 Lambda 表达式作为参数传递，接
     * 收Lambda 表达式的参数类型必须是与该 Lambda 表达式兼容的函数式接口
     * 的类型。
     * @param handler 函数式接口
     * @param str 操作对象
     * @return
     */
    public static String toUpperCase(GenericsFunction<String> handler,String str){
        return handler.getValue (str);
    }

    public static void main(String[] args) {
        String newStr = toUpperCase(str-> str.toUpperCase (),"abc");
        System.out.println (newStr);
    }
}

package com.czz.optimization.dto;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 18:05
 */
public interface DTOConvert<S,T> {
    T convert(S s);
}

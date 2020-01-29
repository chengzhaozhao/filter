package com.czz.optimization.dto;

import org.springframework.beans.BeanUtils;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 18:06
 */
public class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
    @Override
    public User  convert(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO,user);
        return user;
    }
}

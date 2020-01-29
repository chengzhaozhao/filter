package com.czz.optimization.dto;

import org.springframework.beans.BeanUtils;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 18:06
 */
public class UserOutputDTOConvert implements DTOConvert<UserOutputDTO,User> {
    @Override
    public User  convert(UserOutputDTO userOutputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userOutputDTO,user);
        return user;
    }

}

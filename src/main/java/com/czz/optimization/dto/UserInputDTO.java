package com.czz.optimization.dto;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 17:22
 */
@Data
public class UserInputDTO {
    private String username;
    private Integer age;

    public User convertToUser(){
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        User convert = userInputDTOConvert.convert(this);
        return convert;
    }

    private static class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
        @Override
        public User convert(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO,user);
            return user;
        }
    }
}

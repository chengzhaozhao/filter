package com.czz.optimization.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 17:22
 */
@Controller
public class UserApi {
    @Autowired
    private UserService userService;

    public UserOutputDTO addUser(UserInputDTO userInputDTO){
        User user = new User();
        user.setUsername(userInputDTO.getUsername());
        user.setAge(userInputDTO.getAge());

        return userService.addUser(user);
    }

    public UserOutputDTO addUser2(UserInputDTO userInputDTO){
        User user = new User();
        // 把 user 对象的 资源对象赋值到目标对象上
        BeanUtils.copyProperties(userInputDTO,user);

        return userService.addUser(user);
    }

    public UserOutputDTO addUser3(UserInputDTO userInputDTO){
        User user = convertFor(userInputDTO);

        return userService.addUser(user);
    }

    private User convertFor(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO,user);
        return user;
    }

    public UserOutputDTO addUser4(UserInputDTO userInputDTO){
        User user = new UserInputDTOConvert().convert(userInputDTO);
        UserOutputDTO result =  userService.addUser(user);
        return result;
    }

    public UserOutputDTO addUser5(UserInputDTO userInputDTO){
        User user = userInputDTO.convertToUser();
        UserOutputDTO saveUserResult = userService.addUser(user);
        return saveUserResult;
    }


}

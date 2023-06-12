package com.example.validate;

import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidate implements Validator {
    @Autowired
    IUserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof User)) {
            return;
        }

        User user = (User) target;
        if (userService.findById(user.getId()) != null) {
            errors.rejectValue("id", "Duplicate",
                    null, "ID bị trùng lặp");
        }
    }
}

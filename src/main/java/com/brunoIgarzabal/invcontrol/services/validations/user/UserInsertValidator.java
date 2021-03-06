package com.brunoIgarzabal.invcontrol.services.validations.user;

import com.brunoIgarzabal.invcontrol.domain.users.dto.CreateUserDTO;
import com.brunoIgarzabal.invcontrol.repositories.UserRepository;
import com.brunoIgarzabal.invcontrol.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsert, CreateUserDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateUserDTO userDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            list.add(new FieldMessage("email", "E-mail pertence a outro usuário"));
        }

        if (userRepository.findByUserName(userDTO.getUserName()) != null) {
            list.add(new FieldMessage("userName", "Nome de usuário pertence a outro usuário"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}

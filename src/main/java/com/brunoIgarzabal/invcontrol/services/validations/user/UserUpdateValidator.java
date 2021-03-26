package com.brunoIgarzabal.invcontrol.services.validations.user;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.dto.UpdateUserDTO;
import com.brunoIgarzabal.invcontrol.repositories.UserRepository;
import com.brunoIgarzabal.invcontrol.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdate, UpdateUserDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateUserDTO updateUserDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long uriId = Long.parseLong(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        User userEmailAux = userRepository.findByEmail(updateUserDTO.getEmail());
        if (userEmailAux != null && !userEmailAux.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "E-mail pertence a outro usuário"));
        }

        User userUserName = userRepository.findByUserName(updateUserDTO.getUserName());
        if (userUserName != null && !userUserName.getId().equals(uriId)) {
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

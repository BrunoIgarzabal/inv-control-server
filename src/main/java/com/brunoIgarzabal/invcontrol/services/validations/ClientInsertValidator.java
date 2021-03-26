package com.brunoIgarzabal.invcontrol.services.validations;

import com.brunoIgarzabal.invcontrol.domain.clients.dto.CreateClientDTO;
import com.brunoIgarzabal.invcontrol.domain.clients.enums.ClientType;
import com.brunoIgarzabal.invcontrol.resources.exceptions.FieldMessage;
import com.brunoIgarzabal.invcontrol.services.validations.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, CreateClientDTO> {

    @Override
    public void initialize(ClientInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateClientDTO clientDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (clientDTO.getClientType().equals(ClientType.NATURALPERSON) && !BR.isValidCPF(clientDTO.getCpfCnpj())) {
            list.add(new FieldMessage("cpfCnpj", "CPF inválido"));
        }

        if (clientDTO.getClientType().equals(ClientType.LEGALENTITY) && !BR.isValidCNPJ(clientDTO.getCpfCnpj())) {
            list.add(new FieldMessage("cpfCnpj", "CNPJ inválido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}

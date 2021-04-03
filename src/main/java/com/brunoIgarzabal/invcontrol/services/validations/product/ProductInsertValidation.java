package com.brunoIgarzabal.invcontrol.services.validations.product;

import com.brunoIgarzabal.invcontrol.domain.products.dto.FormProductDTO;
import com.brunoIgarzabal.invcontrol.repositories.ProductRepository;
import com.brunoIgarzabal.invcontrol.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductInsertValidation implements ConstraintValidator<ProductInsert, FormProductDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProductRepository repository;

    @Override
    public void initialize(ProductInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(FormProductDTO formProductDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long uriId = Long.parseLong(map.get("id") != null ? map.get("id") : "0");

        List<FieldMessage> list = new ArrayList<>();

        if (uriId == 0 && repository.findByProductCode(formProductDTO.getProductCode()) != null) {
            list.add(new FieldMessage("productCode", "Código do produto pertence a outro produto"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}

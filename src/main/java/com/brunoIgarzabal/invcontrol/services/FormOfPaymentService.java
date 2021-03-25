package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.FormOfPayment;
import org.springframework.stereotype.Service;

@Service
public class FormOfPaymentService extends BaseService<FormOfPayment> {

    @Override
    protected void updateData(FormOfPayment newObj, FormOfPayment oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
        newObj.setCanParcel(oldObj.getCanParcel());
    }
}

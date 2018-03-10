package com.budgete.validators;

import java.time.LocalDate;
import java.time.Period;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author imuliar
 * 22.02.2018
 */

@FacesValidator("dateOfBirthValidator")
public class DateOfBirthValidator extends BaseValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || !(value instanceof LocalDate)) {
            return;
        }
        LocalDate inputDate = (LocalDate) value;
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(inputDate, currentDate);
        if (period.isNegative() || period.getYears() < 18){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    resourceBundle.getString("error.tooYoung")));
        }
        if (period.getYears() > 100){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    resourceBundle.getString("error.tooOld")));
        }
    }
}

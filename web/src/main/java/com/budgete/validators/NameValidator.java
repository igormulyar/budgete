package com.budgete.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author imuliar
 * 07.02.2018
 */
@FacesValidator("nameValidator")
public class NameValidator extends BaseValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        String inputString = String.valueOf(value);
        String emailValidationRegex = "[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$";
        if (!inputString.matches(emailValidationRegex)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    resourceBundle.getString("error.wrongNameFormat")));
        }
    }
}

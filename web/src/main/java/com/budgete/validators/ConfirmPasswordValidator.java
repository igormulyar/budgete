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
@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator extends BaseValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        String password = context.getExternalContext().getRequestParameterMap().get("input_signUpForm:passwordInput");
        String confPassword = String.valueOf(value);
        if (!confPassword.trim().equals(password.trim())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    resourceBundle.getString("error.confirmedPasswordDoesntMatch")));
        }
    }
}

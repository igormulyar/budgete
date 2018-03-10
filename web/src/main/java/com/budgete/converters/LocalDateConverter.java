package com.budgete.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 * @author imuliar
 * 09.01.2018
 */

@Component
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("en_bundle");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate date;
        try {
            date = LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    resourceBundle.getString("error.dateFormat")));
        }
        return date;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value.getClass().equals(LocalDate.class)) {
            LocalDate date = (LocalDate) value;
            return date.format(formatter);
        }
        return null;
    }
}

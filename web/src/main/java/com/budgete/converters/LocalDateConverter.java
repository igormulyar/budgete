package com.budgete.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.stereotype.Component;

/**
 * @author imuliar
 * 09.01.2018
 */

@Component
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDate.parse(value, formatter);
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

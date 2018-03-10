package com.budgete.converters;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author imuliar
 * 07.01.2018
 */

@Component
@FacesConverter("localeConverter")
public class LocaleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Locale locale = new Locale(value);
        return locale;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("en_bundle");
        if (value instanceof String) {
            if (StringUtils.isEmpty(value)) {
                return null;
            }
            return (String) value;
        }
        throw new IllegalArgumentException(String.format(resourceBundle.getString("error.localeConverterMessage"), value));
    }
}

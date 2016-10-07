/*
 * TODO Copyright
 */

package com.company.accumed.web.validators;

import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.ValidationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Naqi on 18/09/2016.
 */
public class DateValidator implements Field.Validator {
    private static SimpleDateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public void validate(Object value) throws ValidationException {
            try {
                if (value != null)
                    sourceFormat.parse(value.toString());
            } catch(ParseException e) {
                throw new ValidationException("Malformed Date");
            }
    }
}

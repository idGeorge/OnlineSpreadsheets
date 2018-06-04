package ua.remzsolutions.onlinespreadsheets.web.validation.validators;

import ua.remzsolutions.onlinespreadsheets.web.validation.constraints.PastTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class PastValidator implements ConstraintValidator<PastTime, Date> {
    public void initialize(PastTime constraint) {
    }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
        return date.before(new Date());
    }
}

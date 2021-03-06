package ua.remzsolutions.onlinespreadsheets.validation.constraints;

import ua.remzsolutions.onlinespreadsheets.validation.validators.PastValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  PastValidator.class)
@Documented
public @interface PastTime {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

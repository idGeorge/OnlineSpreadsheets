package ua.remzsolutions.onlinespreadsheets.validation.constraints;

import ua.remzsolutions.onlinespreadsheets.validation.validators.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({METHOD, FIELD, PARAMETER, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface UniqueUsername {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}

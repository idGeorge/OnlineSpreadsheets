package ua.remzsolutions.onlinespreadsheets.web.validation.constraints;


import ua.remzsolutions.onlinespreadsheets.web.validation.validators.StringEnumerationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringEnumerationValidator.class)
@Target({METHOD, FIELD, PARAMETER, CONSTRUCTOR})
public @interface StringEnumeration {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();
}

package ua.remzsolutions.onlinespreadsheets.web.validation.validators;

import ua.remzsolutions.onlinespreadsheets.web.validation.constraints.StringEnumeration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringEnumerationValidator implements ConstraintValidator<StringEnumeration, String> {

    private Set<String> availableEnumNames;

    @Override
    public void initialize(StringEnumeration stringEnumeration) {
        Class<? extends Enum<?>> enumSelected = stringEnumeration.enumClass();
        availableEnumNames = getNamesSet(enumSelected);
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return availableEnumNames.contains(value);
    }

    private Set<String> getNamesSet(Class<? extends Enum<?>> e) {
        Enum<?>[] enums = e.getEnumConstants();
        String[] names = new String[enums.length];
        for (int i = 0; i < enums.length; i++) {
            names[i] = enums[i].name();
        }

        return new HashSet<>(Arrays.asList(names));
    }
}

package de.timmi6790.mpstats.api.versions.v1.bedrock.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BedrockPlayerNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBedrockPlayerName {
    String message() default "Invalid bedrock player name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

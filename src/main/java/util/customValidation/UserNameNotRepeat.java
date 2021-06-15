package util.customValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserNameRepeatValidation.class)
@Target({ ElementType.METHOD,ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME) //indica el momento en el que se va a evaluar la anotacion
public @interface UserNameNotRepeat {
	String message() default "el nombre de usuario ya se encuentra registrado";
	
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

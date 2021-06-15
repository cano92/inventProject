package util.customValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//se crea una nueva anotacion .. para validacion
//revisa que el mail ingresado no se encuentre registrado

@Constraint(validatedBy = MailRepeatValidation.class) //Clase que implementa la anotacion de la validacion
@Target({ ElementType.METHOD,ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME) //indica el momento en el que se va a evaluar la anotacion
public @interface MailNotRepeat {

	//valor por default opcional
//	public String value() default 28;
	
	String message() default "el mail ya se encuentra registrado";
	
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

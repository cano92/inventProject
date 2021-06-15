package util.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import services.IUserService;
import util.exception.ServiceException;

public class MailRepeatValidation implements ConstraintValidator<MailNotRepeat, String> {
	
	@Autowired
	private IUserService userService;
	
	@Override
	public boolean isValid(String mail, ConstraintValidatorContext context) { 
		try { //si el mail existe la validacion debe fallar
			return !this.userService.isExistMail(mail);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//opcional sobre escribir el initilizer
	// se puede crear una variable y inicializarla con el valor por defecto creado en la anotacion
	
//	@Override
//    public void initialize(MailRepeat mail) {
//    }

}

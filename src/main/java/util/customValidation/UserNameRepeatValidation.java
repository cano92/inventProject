package util.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import services.IUserService;
import util.exception.ServiceException;

public class UserNameRepeatValidation implements ConstraintValidator<UserNameNotRepeat, String>{

	@Autowired
	private IUserService userService;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		try { //si el username existe la validacion debe fallar
			return !this.userService.isExistUser(username);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return false;
	}

}

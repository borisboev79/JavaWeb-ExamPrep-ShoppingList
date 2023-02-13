package examprep.shoppinglist.validations.validateLoginForm;

import examprep.shoppinglist.domain.models.UserModel;
import examprep.shoppinglist.domain.models.binding.UserLoginModel;
import examprep.shoppinglist.services.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());

        return user.getId() != null && user.getPassword().equals(userLoginModel.getPassword());
    }
}

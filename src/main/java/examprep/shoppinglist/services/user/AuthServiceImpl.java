package examprep.shoppinglist.services.user;


import examprep.shoppinglist.domain.entities.User;
import examprep.shoppinglist.domain.helpers.LoggedUser;
import examprep.shoppinglist.domain.models.binding.UserLoginModel;
import examprep.shoppinglist.domain.models.binding.UserRegisterModel;
import examprep.shoppinglist.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, ModelMapper mapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;

        this.mapper = mapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void registerUser(UserRegisterModel userRegisterModel) {
        this.userRepository.saveAndFlush(this.mapper.map(userRegisterModel, User.class));
    }

    @Override
    public void loginUser(UserLoginModel userLoginModel) {
        User user = this.userRepository.findByUsername(userLoginModel.getUsername()).get();

        this.loggedUser.setId(user.getId());
    }

    @Override
    public void logoutUser() {
        this.loggedUser.clearUser();
    }
}

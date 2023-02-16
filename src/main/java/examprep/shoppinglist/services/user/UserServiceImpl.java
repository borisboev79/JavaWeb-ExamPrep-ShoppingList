package examprep.shoppinglist.services.user;

import examprep.shoppinglist.domain.entities.User;
import examprep.shoppinglist.domain.models.UserModel;
import examprep.shoppinglist.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserModel findByUsername(String username) {
        return this.mapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserModel.class);
    }
}

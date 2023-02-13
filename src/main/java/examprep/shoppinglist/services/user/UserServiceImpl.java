package examprep.shoppinglist.services.user;

import examprep.shoppinglist.domain.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserModel findByUsername(String username) {
        return null;
    }
}

package examprep.shoppinglist.services.user;


import examprep.shoppinglist.domain.models.UserModel;

public interface UserService {
    UserModel findByUsername(String username);
}

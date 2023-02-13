package examprep.shoppinglist.web;

import examprep.shoppinglist.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){
    return "/home";
    }
}

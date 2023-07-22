package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserLogic userLogic;

    @GetMapping("/info")
    public List<UserInfo> getUser() {
        return userLogic.getUser();
    }

    //constructors
    @Autowired
    public UserController(UserLogic userLogic) {
        this.userLogic = userLogic;
    }
}

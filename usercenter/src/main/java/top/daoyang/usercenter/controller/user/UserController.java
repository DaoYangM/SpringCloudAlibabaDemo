package top.daoyang.usercenter.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.daoyang.usercenter.domain.user.User;
import top.daoyang.usercenter.service.user.UserService;

@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }
}

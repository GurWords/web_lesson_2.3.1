package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.ImplUsersService;
import java.util.List;

@Controller
@RequestMapping(name = "/")
public class UsersController {

    ImplUsersService implUsersService;

    @Autowired
    public void setImplUsersService(ImplUsersService implUsersService) {
        this.implUsersService = implUsersService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    String indexUsers(Model model){
        List<User> userList = implUsersService.getAllUsers();
        model.addAttribute("userList",userList);
        return "users";
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    String insertUsers(@RequestParam String name, String password, int age, String role){
        User user = new User.Builder()
                .withName(name)
                .withAge(age)
                .withPassword(password)
                .withRole(role)
                .build();
        implUsersService.insertUser(user);
        return "redirect:users";
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String deleteUsers(@RequestParam int idDelete){
        implUsersService.deleteUser(idDelete);
        return "redirect:users";
    }
    @RequestMapping(value = "update", method = RequestMethod.GET)
    String updateUser(Model model, @RequestParam int idUpdate){
        User user = implUsersService.getUserByID(idUpdate);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    String updateUserPost(@RequestParam int id,String name, String password, String role, int age){
        User user = new User.Builder()
                .withId(id)
                .withName(name)
                .withAge(age)
                .withPassword(password)
                .withRole(role)
                .build();
        implUsersService.updateUser(user);
        return "redirect:users";
    }
}

package crud.controller;

import crud.model.UserEntity;
import crud.service.UserJPAService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserJPAService usServ;
    private final String firstPage = "redirect:/";

    @Autowired
    public UsersController(UserJPAService usServ) {
        this.usServ = usServ;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", usServ.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserEntity user) {
        return "user/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "user/new";
        usServ.createUser(user);
        return firstPage;
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usServ.getUserById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "user/edit";
        usServ.update(id, user);
        return firstPage;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usServ.delete(id);
        return firstPage;
    }
}

package ru.leontev.springboot.PP312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leontev.springboot.PP312.model.User;
import ru.leontev.springboot.PP312.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {



    @GetMapping
    public String show(Model model) {
        return getUsersView(model);
    }

    @PostMapping
    public String show2(Model model) {
        return getUsersView(model);
    }

    private String getUsersView(Model model) {
        model.addAttribute("message", "Список пользователей");
        model.addAttribute("url", "/users");
        return "index";
    }

    private final UserService userService;


    public UsersController(UserService userService) {
        this.userService = userService;
        addUsers();
    }

    // Добавляем пользователей в базу пользователей
    private void addUsers() {
        userService.create(new User("Денис", "Леонтьев","1@mail.ru"));
        userService.create(new User("Ян", "Леонтьев","2@mail.ru"));
        userService.create(new User("Катя", "Леонтьева","3@mail.ru"));
        userService.create(new User("Maша", "Леонтьева","4@mail.ru"));
        userService.create(new User("Артем", "Леонтьев","5@mail.ru"));
    }

    //CREATE

    @GetMapping("users/new")
    public String createForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping ("users")
    public String create(@ModelAttribute("user") User user) {
         userService.create(user);
        return "redirect:users";
    }

    //READ

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getList());
        return "all";
    }

    @GetMapping("users/{id}")
    public String read(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    //UPDATE

    @GetMapping("users/{id}/edit")
    public String editForm(Model model, @PathVariable() long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    //DELETE

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}


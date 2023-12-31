package com.gini.rest.controller;

import com.gini.rest.dto.UserRequest;
import com.gini.rest.dto.UserSearch;
import com.gini.security.Role;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * https://www.wimdeblauwe.com/blog/2021/10/04/todomvc-with-thymeleaf-and-htmx/
 */

@Controller
public record HtmxController() {

    @ResponseBody
    @DeleteMapping(value = "/delete", produces = MediaType.TEXT_HTML_VALUE)
    public String delete() {
        return "";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

//    @PostMapping("/logout")
//    public String logout() {
//        return "redirect:loginPage?logout";
//    }

    @GetMapping(value = "/home", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "homePage";
    }

    @GetMapping(value = "/create", produces = MediaType.TEXT_HTML_VALUE)
    public String createPage(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        model.addAttribute("roles", Role.values());
        return "components/home/right/create/createUser";
    }

    @GetMapping(value = "/home-right", produces = MediaType.TEXT_HTML_VALUE)
    public String homeContainer(Model model) {
        model.addAttribute("userSearch", new UserSearch());
        return "components/home/home";
    }

    @GetMapping(value = "/left", produces = MediaType.TEXT_HTML_VALUE)
    public String leftContainer() {
        return "components/home/left/left";
    }


}

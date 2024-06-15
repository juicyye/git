package test.test.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.test.domain.dto.JoinDto;
import test.test.domain.entity.Role;
import test.test.domain.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ModelAttribute("roles")
    public Role[] roles(){
        return Role.values();
    }

    @GetMapping("/signup")
    public String singUpForm(Model model){
        model.addAttribute("user", new JoinDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String singUp(@Validated @ModelAttribute("user") JoinDto user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "signup";
        }

        userService.join(user);
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/";
    }

}

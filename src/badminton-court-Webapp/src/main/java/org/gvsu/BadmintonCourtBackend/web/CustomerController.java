package org.gvsu.BadmintonCourtBackend.web;

import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.gvsu.BadmintonCourtBackend.service.SecurityService;
import org.gvsu.BadmintonCourtBackend.service.CustomerService;
import org.gvsu.BadmintonCourtBackend.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CustomerValidator customerValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customerForm", new Customer());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("customerForm") Customer customerForm, BindingResult bindingResult, Model model) {
        customerValidator.validate(customerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        customerService.save(customerForm);
        securityService.login(customerForm.getUserName(), customerForm.getPasswordConfirm());
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String isLogout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (isLogout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
}

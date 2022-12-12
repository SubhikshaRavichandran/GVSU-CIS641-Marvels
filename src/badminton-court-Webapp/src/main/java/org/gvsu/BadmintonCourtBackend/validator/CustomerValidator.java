package org.gvsu.BadmintonCourtBackend.validator;

import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.gvsu.BadmintonCourtBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component

public class CustomerValidator implements Validator {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        if (!Pattern.compile("^(.+)@(.+)$").matcher(customer.getEmail()).matches()) {
            errors.rejectValue("email", "Format.customerForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required");
        if (!Pattern.compile("^\\d{10}$").matcher(customer.getPhone()).matches()) {
            errors.rejectValue("phone", "Size.customerForm.phone");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");
        if (customer.getUserName().length() < 6 || customer.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.customerForm.userName");
        }
        if (customerService.findByUsername(customer.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.customerForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        if (customer.getPassword().length() < 8 || customer.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.customerForm.password");
        }

        if (!customer.getPasswordConfirm().equals(customer.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.customerForm.passwordConfirm");
        }
    }
}

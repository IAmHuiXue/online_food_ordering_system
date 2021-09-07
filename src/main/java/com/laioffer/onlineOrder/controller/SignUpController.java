package com.laioffer.onlineOrder.controller;


import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

// Use @Controller to mark a class its role as a web component,
// so the spring mvc will register the methods which annotated the @RequestMapping
@Controller
public class SignUpController {
    @Autowired
    private CustomerService customerService;

    // Use the @RequestMapping to define REST API, such as HTTP URL pattern, method, etc.
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    // Use the @RequestBody to convert the request body in the http request to a backend object.
    public void signUp(@RequestBody Customer customer) {
        customerService.signUp(customer);
    }
}

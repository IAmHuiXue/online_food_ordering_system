package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import com.laioffer.onlineOrder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    // @PathVariable: can be used to handle template variables in the request URI mapping.
    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItems(restaurantId);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    // Use the @ResponseBody annotation on a method to indicate that the return value should be written
    // straight to the HTTP response body, and it will be automatically convert to json format
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getAllRestaurants();
    }
}


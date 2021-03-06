package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.MenuInfoDao;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;


    public List<Restaurant> getAllRestaurants() {
        return menuInfoDao.getAllRestaurants();
    }

    public List<MenuItem> getAllMenuItems(int restaurantId) {
        return menuInfoDao.getAllMenuItems(restaurantId);
    }

    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}

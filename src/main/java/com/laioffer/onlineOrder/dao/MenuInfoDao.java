package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
// to get menu and restaurant-related info from DB
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getAllRestaurants() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Restaurant.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }


    public List<MenuItem> getAllMenuItems(int restaurantId) {
        try (Session session = sessionFactory.openSession()) {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

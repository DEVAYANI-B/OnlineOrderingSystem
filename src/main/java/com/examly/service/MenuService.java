package main.java.com.examly.service;

import main.java.com.examly.entity.Menu;
import java.util.List;

public interface MenuService{
    boolean addMenuItem(Menu item);
    List<Menu> searchMenuItemsByCategory(String category);
    Menu getItemById(String itemId);
}
package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dinnerMenu;

    public DinnerConstructor() {
        this.dinnerMenu = new HashMap<>();
    }

    public void addDishToMenu(String dishType, String dishName) {
        var dishes = dinnerMenu.get(dishType);
        if (dishes != null) {
            dishes.add(dishName);
        } else {
            dinnerMenu.put(dishType, new ArrayList<>());
            addDishToMenu(dishType, dishName);
        }
    }
}

package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dinnerMenu;
    private final Random random;

    public DinnerConstructor() {
        this.dinnerMenu = new HashMap<>();
        this.random = new Random();
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

    public boolean contains(String requestedDishType) {
        for (var existingDishType : dinnerMenu.keySet()) {
            if (requestedDishType.equals(existingDishType)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> generateDinner(ArrayList<String> dishTypes) {
        ArrayList<String> dinner = new ArrayList<>();
        for (String dishType : dishTypes) {
            var dishes = dinnerMenu.get(dishType);
            if (!dishes.isEmpty()) {
                dinner.add(dishes.get(random.nextInt(dishes.size())));
            }
        }
        return dinner;
    }
}

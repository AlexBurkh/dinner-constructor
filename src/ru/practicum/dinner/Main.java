package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc = new DinnerConstructor();
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        System.out.print("> ");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDishToMenu(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.isEmpty()) {
            System.out.println("В меню пока нет ни одной позиции. Пожалуйста, добавьте их.");
            return;
        }
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения " +
                "ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("Такого типа блюд нет, введите другой тип");
            }
            nextItem = scanner.nextLine();
        }
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо 1");
            System.out.println(dc.generateDinner(dishTypes));
        }
    }
}

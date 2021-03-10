package com.pastuh.Everyone.in.zoo;
/**
 * Класс животных зоопарка
 * */

public class Animal {
    /**
     * Поле имя
     * */
    private String name;
    /**
     * Поле вид
     * */
    private String kind;
    /**
     * Поле состояние
     * */
    private String condition;

    /**
     * Конструктор
     * */
    public Animal(String name, String kind, String condition) {
        this.name = name;
        this.kind = kind;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }
    /**
     * Метод смены состояния на плохое
     * */
    protected void changeConditionToBad() {
        condition = "Bad";
    }
    /**
     * Метод добавления болезни животному
     * */
    protected void ItIsSick(){
        this.changeConditionToBad();
        System.out.println("Ooop, I got sick");
    }

}

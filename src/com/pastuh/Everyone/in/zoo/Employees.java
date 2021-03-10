package com.pastuh.Everyone.in.zoo;


/**
 * Класс Работников зоопарка
 * */
public class Employees {
/**
 * Поле имя
 * */
    private String name;

    /**
     * Конструктор
     * @param name - имя
     * */
    public Employees(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
/**
 * Метод для чистки вольера
 * @param aviary - номер вольера
 * */
    protected void cleanUpTheAviary(Integer aviary){
        System.out.println("OK, I will do it in aviary №" + aviary.toString());
    }

    /**
     * Метод для кормления животных
     * @param nameOfAnimal - имя животного
     * */
    protected void feedTheAnimal(String nameOfAnimal){
        System.out.println("Of course, I will feed the " + nameOfAnimal);
    }

}

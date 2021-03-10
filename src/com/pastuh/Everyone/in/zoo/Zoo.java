package com.pastuh.Everyone.in.zoo;

import java.util.Arrays;
/**
 * Класс зоопарка
 * */
public class Zoo {
    /**
    *  Поле массив для животных
    * */
    private Animal[] animals = {};
    /**
     * Поле массив работников
     * */
    private Employees[] employees = {};

    /**
     * Конструктор
     * @param arrayOfNames - массив имен для работников
     * @param arrayOfNamesForAnimals - массив имен животных
     * @param arrayOfKinds - массив с видами животных
     * @param arrayOfConditions - массив для состояний животных
     * */
    public Zoo(String[] arrayOfNames, String[] arrayOfNamesForAnimals,
               String[] arrayOfKinds, String[] arrayOfConditions) {
        this.creatEmployees(arrayOfNames);
        this.createAnimals(arrayOfNamesForAnimals, arrayOfKinds, arrayOfConditions);
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public Employees[] getEmployees() {
        return employees;
    }


    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public void setEmployees(Employees[] employees) {
        this.employees = employees;
    }

    /**
     * Метод добавления нового работника
     * @param name - имя
     * */
    protected void addNewEmployee(String name){
        Employees employee = new Employees(name);
        Employees[] newEmployees = Arrays.copyOf(getEmployees(), (getEmployees().length + 1));
        newEmployees[getEmployees().length] = employee;
        employees = newEmployees;
    }

    /**
     * Удаление работника с конкретным именем
     * @param name - имя
     * Находится нужный работник
     * меняется местами с последним
     * копируется старый массив, но на один элемент меньше
     * */
    protected void removeEmployee(String name){
        int length = employees.length;
        if(length == 0){
            System.out.println("You don't have employees");
        } else {
            for(int i = 0; i < length; i++){
                if(employees[i].getName() == name){
                    Employees temp = new Employees("");
                    temp = getEmployees()[length - 1];
                    employees[length - 1] = employees[i];
                    employees[i] = temp;
                    employees = Arrays.copyOf(employees, length - 1);
                    System.out.println("Employee, whose name is " + name + " was removed");
                    break;
                }
                if (i == length - 1)
                    System.out.println("You don't have an employee, whose name is " + name);
            }
        }

    }

    /**
     * Метод создания первых работников
     * @param arrayOfName - массив имен
     * */
    protected void creatEmployees(String[] arrayOfName){
        for (int i = 0; i < arrayOfName.length; i++){
            addNewEmployee(arrayOfName[i]);
        }
    }

    /**
     * Метод добавления животного
     * @param name - имя животного
     * @param condition - состояние животного
     * @param kind - вид животного
     * */
    protected void addNewAnimal(String name, String kind, String condition){
        Animal animal = new Animal(name, kind, condition);
        int length = getAnimals().length;
        Animal[] newAnimals = Arrays.copyOf(getAnimals(), length + 1);
        newAnimals[length] = animal;
        setAnimals(newAnimals);
    }

    /**
     * Метод создания первых животных
     *@param arrayOfName - массив имен животных
     *@param arrayOfKind - массив с видами животных
     *@param arrayOfCondition - массив для состояний животных
     * */
    protected void createAnimals(String[] arrayOfName, String[] arrayOfKind, String[] arrayOfCondition){
        for (int i = 0; i < arrayOfName.length; i++){
            addNewAnimal(arrayOfName[i], arrayOfKind[i], arrayOfCondition[i]);
        }
    }

    /**
     * Метод удаления конкретного животного
     * @param name - имя
     * Находится нужный работник
     * меняется местами с последним
     * копируется старый массив, но на один элемент меньше
     * */
    protected void removeAnimal(String name){
        int length = animals.length;
        if(length == 0){
            System.out.println("You don't have animals");
        } else {
            for(int i = 0; i < length; i++){
                if(animals[i].getName() == name){
                    Animal temp = new Animal("", "", "");
                    temp = animals[length - 1];
                    animals[length - 1] = animals[i];
                    animals[i] = temp;
                    animals = Arrays.copyOf(animals, length - 1);
                    System.out.println("Animal, whose name is " + name + " was removed");
                    break;
                }
                if (i == length - 1)
                    System.out.println("You don't have an animal, whose name is " + name);
            }
        }
    }

    /**
     * Метод отправляет работника кормить животное
     * @param name - имя
     * @param nameOfAnimal - имя животного
     * */
    protected void sendToFeed(String name, String nameOfAnimal){
        for(Employees employee : getEmployees()){
            if (employee.getName() == name){
                employee.feedTheAnimal(nameOfAnimal);
            }
        }
    }
    /**
     * Метод отправляет работника чистить вольер
     * @param name - имя
     * @param aviary - номер вольера
     * */
    protected void sendToClean(String name, int aviary){
        for(Employees employee : getEmployees()){
            if (employee.getName() == name){
                employee.cleanUpTheAviary(aviary);
            }
        }
    }
    /**
     * Метод добавления болезни
     * @param name - имя
     * */
    protected void ItWasSick(String name){
        for(Animal animal : getAnimals()){
            if (animal.getName() == name)
                animal.ItIsSick();
        }
    }

    public static void main(String[] args){

        String[] namesOfEmployees = {"Ваня", "Илья", "Петя","Сергей", "Коля"};
        String[] namesOfAnimals = {"Зюзя", "Валя" ,"Снежок", "Колобок", "Берта"};
        String[] arrayOfKinds = {"Лев", "Тигр", "Морж" , "Волк", "Медведь"};
        String[] arrayOfConditions = {"Здоров", "Здоров", "Здоров" , "Здоров", "Здоров"};
        Zoo zoo = new Zoo(namesOfEmployees,namesOfAnimals, arrayOfKinds, arrayOfConditions);

        zoo.sendToClean(namesOfEmployees[3], 2);

        zoo.sendToFeed(namesOfEmployees[2], namesOfAnimals[3]);

        zoo.addNewEmployee("Родион");

        zoo.addNewAnimal("Дамбо", "Слон", "Здоров");

        zoo.ItWasSick("Дамбо");

        zoo.removeEmployee("Сергей");

        zoo.removeAnimal("Зюзя");
    }
}

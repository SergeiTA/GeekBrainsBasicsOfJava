package advancedOop;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    protected String name;
    protected int maxRunRange;
    protected int maxSwimRange;
    //Изящное решение подсчета экземпляров позаимствовано со stackoverflow
    //, принципе можно было бы решить и итеррацией целочесленной переменной
    public static List<java.lang.ref.WeakReference<Animal>> instancesOfAnimals = new ArrayList<>();

    public Animal() {
        instancesOfAnimals.add(new java.lang.ref.WeakReference<Animal>(this));
    }

    public Animal(String name, int maxRunRange, int maxSwimRange) {
        instancesOfAnimals.add(new java.lang.ref.WeakReference<Animal>(this));
        this.name = name;
        this.maxRunRange = maxRunRange;
        this.maxSwimRange = maxSwimRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunRange() {
        return maxRunRange;
    }

    public void setMaxRunRange(int maxRunRange) {
        this.maxRunRange = maxRunRange;
    }

    public int getMaxSwimRange() {
        return maxSwimRange;
    }

    public void setMaxSwimRange(int maxSwimRange) {
        this.maxSwimRange = maxSwimRange;
    }

    public abstract void run(int runRange);

    public void swim(int swimRange) {
        if (maxSwimRange <= 0 ) {
            System.out.println(name + " не умеет плавать");
            return;
        }
        if (swimRange <= maxSwimRange) { System.out.println(name + " проплыл " + swimRange + " м");
        } else { System.out.println(name + " проплыл обратно при достижении расстояния " + (maxSwimRange / 2) + " м"); }
    }


}

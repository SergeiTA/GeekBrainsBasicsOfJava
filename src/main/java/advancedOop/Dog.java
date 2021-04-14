package advancedOop;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal{

    public static List<WeakReference<Dog>> instancesOfDogs = new ArrayList<>();

    public Dog(String name) {
        instancesOfDogs.add(new java.lang.ref.WeakReference<Dog>(this));
        this.name = name;
        this.maxRunRange = 500;
        this.maxSwimRange = 10;
    }

    @Override
    public void run(int runRange) {
        if (runRange <= maxRunRange) { System.out.println(name + " пробежал " + runRange + " м");
        } else { System.out.println(name + " пробежал всего лишь " + runRange + " м. Больше не получилось"); }
    }

}

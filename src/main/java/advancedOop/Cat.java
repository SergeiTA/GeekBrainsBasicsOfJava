package advancedOop;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal{

    public static List<WeakReference<Cat>> instancesOfCats = new ArrayList<>();

    public Cat(String name) {
        instancesOfCats.add(new java.lang.ref.WeakReference<Cat>(this));
        this.name = name;
        this.maxRunRange = 200;
        this.maxSwimRange = 0;
    }

    @Override
    public void run(int runRange) {
        if (runRange <= maxRunRange) { System.out.println(name + " пробежал " + runRange + " м");
        } else { System.out.println(name + " пробежал всего лишь " + runRange + " м. Больше не получилось"); }
    }

}

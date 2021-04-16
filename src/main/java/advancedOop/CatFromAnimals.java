package advancedOop;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class CatFromAnimals extends Animal{

    public static List<WeakReference<CatFromAnimals>> instancesOfCats = new ArrayList<>();

    public CatFromAnimals(String name) {
        instancesOfCats.add(new java.lang.ref.WeakReference<CatFromAnimals>(this));
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

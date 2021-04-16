package advancedOop;

//Заведем ранер, что бы не придумывать что то вроде "выставки животных")
public class AnimalRunner {

    public static void main(String[] args) {
        Dog Buddy = new Dog("Buddy");
        Dog Toby = new Dog("Toby");
        Dog Rex = new Dog("Rex");

        CatFromAnimals Garfield = new CatFromAnimals("Garfield");
        CatFromAnimals Fluffy = new CatFromAnimals("Fluffy");

        System.out.println("-------");
        Buddy.run(100);
        Buddy.swim(50);

        System.out.println("-------");
        Toby.run(700);
        Toby.swim(5);

        System.out.println("-------");
        Rex.run(500);
        Rex.swim(10);

        System.out.println("-------");
        Garfield.run(150);
        Garfield.swim(50);

        System.out.println("-------");
        Fluffy.run(500);
        Fluffy.swim(1);

        System.out.println("-------");
        System.out.println("Всего собак : " + Dog.instancesOfDogs.size());
        System.out.println("Всего кошек/котов : " + CatFromAnimals.instancesOfCats.size());
        System.out.println("Всего животных : " + Animal.instancesOfAnimals.size());
    }

}

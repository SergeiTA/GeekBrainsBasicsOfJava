package catsAndPlates;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }


    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }


}

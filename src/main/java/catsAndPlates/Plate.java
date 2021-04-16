package catsAndPlates;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    //сменим тип возвращаемого значения для реализации простой логики с сытостью котов
    public boolean decreaseFood(int n) {
        if (food < n) {
            System.out.println("В тарелке не достаточно еды. Кот передумал кушать.");
            return false;
        }
        food -= n;
        return true;
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

    //Меод для добавления еды
    public void addFood(int newFood) {
        food =+ Math.abs(newFood);
        System.out.println("Теперь в тарелке " + food + " еды");
    }

}

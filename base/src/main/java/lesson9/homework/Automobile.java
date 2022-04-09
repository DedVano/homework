package lesson9.homework;

public abstract class Automobile {

    int index;

    abstract void move(int distance);
    abstract int getDistance();
    abstract int getMaxDistance();
    abstract int getIndex();

    public Automobile(int index) {
        this.index = index;
    }
}

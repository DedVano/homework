package lesson9.homework;

public class Truck extends Automobile {

    private int distance = 0;
    private final int maxDistance = 1200;

    public Truck(int index) {
        super(index);
    }

    @Override
    void move(int distance) {
        if (this.distance == this.maxDistance) {
            System.out.println("Грузовой автомобиль " + index + " должен был проехать " + distance + "км, но у него " +
                    "закончился бензин, поэтому он никуда не поехал.");
        } else if (this.distance + distance > this.maxDistance) {
            System.out.println("Грузовой автомобиль " + index + " должен был проехать " + distance + "км, но проехал " +
                    "всего " + (this.maxDistance - this.distance) + "км, и у него закончился бензин.");
            this.distance = this.maxDistance;
        } else {
            this.distance += distance;
            System.out.println("Грузовой автомобиль " + index + " проехал " + distance + "км, всего пробег составил " +
                    this.distance + "км");
        }
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int getIndex() {
        return index;
    }
}
